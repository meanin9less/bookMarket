import java.util.Scanner;

public class MenuManager {
    public final static int MENUGUESTINFO = 1;
    public final static int MENUCARTITEMLIST = 2;
    public final static int MENUCARTCLEAR = 3;
    public final static int MENUCARTADDITEM = 4;
    public final static int MENUCARTREMOVEITEMCOUNT = 5;
    public final static int MENUCARTREMOVEITEM = 6;
    public final static int MENUCARTBILL = 7;
    public final static int EXIT = 8;
    public final static int ADMINLOGIN = 9;

    public static void menuIntroduce() {
        String ln = "*************************************************************";
        System.out.println(ln);
        System.out.println("\t\t\t\tWelcome to Shopping Mall");
        System.out.println("\t\t\t\tWelcome to Book Market");
        System.out.println(ln);
        System.out.print("\t" + "1. 고객 정보 확인하기" + "\t\t\t" + "4. 장바구니 항목 추가하기" + "\t\t\n");
        System.out.print("\t" + "2. 장바구니 상품 목록 보기" + "\t\t" + "5. 장바구니의 항목 수량 줄이기" + "\t\t\n");
        System.out.print("\t" + "3. 장바구니 비우기" + "\t\t\t\t" + "6. 장바구니의 항목 삭제하기" + "\t\t\n");
        System.out.print("\t" + "7. 영수증 표시하기" + "\t\t\t\t" + "8. 종료" + "\t\t\n");
        System.out.print("\t" + "9. 관리자 로그인" + "\t\t\t\t" + "" + "\t\t\n");
        System.out.println(ln);
        System.out.print("메뉴 번호를 입력하세요. : ");
    }

    public static int selectMenu(){
        Scanner s = new Scanner(System.in);
        int menuId = s.nextInt();
        System.out.println(menuId + "번을 선택했습니다.");
        s.nextLine();
        return menuId;
    }


}

