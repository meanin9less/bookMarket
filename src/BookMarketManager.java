import java.util.Scanner;

public class BookMarketManager {

    private Book[] mBook = new Book[3]; //문자열 객체의 참조값이 들어감 int 였으면 int 정수 자체가 들어감
    private Cart mCart = new Cart();
    private Person currentUser = null;

    public BookMarketManager() {
        mBook[0] = new Book("ISBN1234", "쉽게 배우는 JSP 웹 프로그래밍", 27000, "송미영", "단계별로 쇼핑몰을 구현하며 배우는 JSP 웹 프로그래밍", "IT전문서", "2018/10/08");
        mBook[1] = new Book("ISBN1235", "안드로이드 프로그래밍", 33000, "유재남", "실습 단계별 명쾌한 멘토링!", "IT전문서", "2022/01/22");
        mBook[2] = new Book("ISBN1236", "스크래치", 22000, "고광일", "컴퓨팅 사고력을 키우는 블록 코딩", "컴퓨터입문", "2019/06/10");
    }

    public void menuGuestInfo(Person user) {
        System.out.println("현재 고객 정보 : ");
        System.out.println("이름 : " + user.getName() + "\t" + "연락처 : " + user.getContact());
    }

    public void menuCartItemList() {
        System.out.println("장바구니 상품 목록 보기 : ");
        mCart.printCartList();
    }

    public void menuCartClear() {
        System.out.println("장바구니 비우기");
        System.out.println("장바구니를 비우시겠습니까?");
        Scanner s = new Scanner(System.in);
        String decision = s.nextLine();
        if(decision.toUpperCase().trim().equals("Y")){
            mCart.clearCart();
            System.out.println("장비구니를 비웠습니다.");
        }
    }

    public void menuCartAddItem() {
        printBookList();
        Scanner s = new Scanner(System.in);
        while (true) {
            boolean exit = false;
            System.out.print("장바구니에 추가할 도서의 ID를 입력하세요 : ");
            String bookId = s.nextLine();

            int index = -1;
            for (int i = 0; i < this.mBook.length; i++) {
                if (this.mBook[i].getItemId().trim().equals(bookId.trim())) {
                    index = i;
                    break;
                }
            }
            if (index != -1) {
                System.out.println("장바구니에 추가하시겠습니까? Y | N ");
                String decision = s.nextLine();
                if (decision.equalsIgnoreCase("Y")) {
                    if (this.mCart.isCartInItem(bookId)) {
                        this.mCart.increaseItemCount(bookId);
                    } else {
                        this.mCart.appendItem(this.mBook[index]);
                    }
                    System.out.println(this.mBook[index].getName() + "가 장바구니에 1권 추가되었습니다.");
                    break;
                }
                exit = true;
            } else {
                System.out.println("ID를 찾을 수 없습니다.");
            }
            if (exit) {
                break;
            }
        }
    }

    public void menuCartRemoveItemCount() {
        System.out.println("장바구니 상품 목록 보기 : ");
        while (this.mCart.printCartList()){
            System.out.print("수량을 줄이실 도서ID를 입력하세요.");
            Scanner input = new Scanner(System.in);
            String bookId = input.nextLine();

            if (!mCart.isCartInItem(bookId)) {
                System.out.println("없는 도서입니다.");
                continue;
            }
            System.out.println(bookId + "의 수량을 줄이시겠습니까? Y | N");
            String decision = input.nextLine();
            if (decision.toUpperCase().trim().equals("Y")) {
                Item item = this.mCart.decreaseItemCount(bookId);
                if(item instanceof Book){ // instanceof 원래 객체가 뭐였냐 물어보는거
                    Book book = (Book)item;
                    System.out.println("장바구니에서 " + book.getName() + "의 수량을 줄였습니다.");
                }
                break;
            }
            break;
        }
    }

    public void menuCartRemoveItem() {
        System.out.println("장바구니의 항목 삭제하기");
        if(!mCart.printCartList()){
            return;
        }
        System.out.print("삭제할 도서ID를 입력하세요.");
        Scanner s = new Scanner(System.in);
        String bookId = s.nextLine();
        if(!this.mCart.isCartInItem(bookId)){
            System.out.println("도서를 찾을 수 없습니다.");
            return;
        }
        System.out.println("삭제하시겠습니까? Y | N");
        String decision = s.nextLine();
        if(decision.toUpperCase().trim().equals("Y")){
            System.out.println(this.mCart.removeCartItem(bookId).getName() + "이 장바구니에서 삭제되었습니다.");
        } else {
            System.out.println("취소하였습니다..");
        }
    }

    public void menuCartBill() {
        System.out.println("영수증 표시하기");
        if (!this.mCart.printCartList()) {
            return;
        }
        System.out.println("합계 : " + this.mCart.cartBill()+"원");
    }

    public void menuAdminLogin(Person user){
        Scanner s = new Scanner(System.in);
        System.out.println("관리자 로그인");
        System.out.println("관리자 정보를 입력하세요.");
        Admin admin = new Admin(user.getName(), user.getContact());
        System.out.print("아이디 : ");
        String inputId = s.nextLine();
        if(!admin.isCollectId(inputId)){
            System.out.println("아이디가 잘못되었습니다.");
            return;
        }
        System.out.print("비밀번호 : ");
        String inputPw = s.nextLine();
        if(!admin.isCollectPw(inputPw)){
            System.out.println("비밀번호가 잘못되었습니다.");
            return;
        }
        this.currentUser = admin;
        System.out.println("이름 : " + admin.getName() + "\t" + "연락처 : " + admin.getContact());
        System.out.println("아이디 : " + admin.getAdminId() + "\t" + "비밀번호 : " + admin.getAdminPw());
    }


    public void run() {
        this.login();
        while (true) {
            boolean endFlag = false;
            MenuManager.menuIntroduce();
            int menuId = MenuManager.selectMenu();
            switch (menuId) {
                case MenuManager.MENUGUESTINFO:
                    this.menuGuestInfo(this.currentUser);
                    break;
                case MenuManager.MENUCARTITEMLIST:
                    this.menuCartItemList();
                    break;
                case MenuManager.MENUCARTCLEAR:
                    this.menuCartClear();
                    break;
                case MenuManager.MENUCARTADDITEM:
                    this.menuCartAddItem();
                    break;
                case MenuManager.MENUCARTREMOVEITEMCOUNT:
                    this.menuCartRemoveItemCount();
                    break;
                case MenuManager.MENUCARTREMOVEITEM:
                    this.menuCartRemoveItem();
                    break;
                case MenuManager.MENUCARTBILL:
                    this.menuCartBill();
                    break;
                case MenuManager.EXIT:
                    endFlag = true;
                    System.out.println("종료되었습니다.");
                    break;
                case MenuManager.ADMINLOGIN:
                    this.menuAdminLogin(this.currentUser);
                    break;
                default:
                    System.out.println("잘못입력하였습니다.");
                    break;
            }
            if (endFlag) {
                break;
            }
        }
    }

    public void login() {
        Scanner s1 = new Scanner(System.in);
        System.out.print("당신의 이름을 입력하세요. : ");
        String name = s1.nextLine();
        System.out.print("연락처를 입력하세요. : ");
        String contact = s1.nextLine();
        this.currentUser = new User(name, contact);
    }

    public void printBookList(){
        for (int i = 0; i < this.mBook.length; i++) {
            System.out.print(this.mBook[i].getItemId() + " | ");
            System.out.print(this.mBook[i].getName() + " | ");
            System.out.print(this.mBook[i].getPrice() + " | ");
            System.out.print(this.mBook[i].getAuthor() + " | ");
            System.out.print(this.mBook[i].getDescription() + " | ");
            System.out.print(this.mBook[i].getCategory() + " | ");
            System.out.print(this.mBook[i].getPublicationDate() + " | ");
            System.out.println();
        }
    }

}