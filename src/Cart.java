
public class Cart implements CartInterface {
    private CartItem[] mCart = new CartItem[3];
    private int mCartItemCount;
    private int mCartTotalPrice;

    public CartItem[] getMCart() {
        return this.mCart;
    }

    public int getMCartItemCount() {
        return this.mCartItemCount;
    }

    @Override
    public boolean printCartList() {
        if (mCartItemCount == 0) {
            System.out.println("장바구니가 비어있습니다.");
            return false;
        }
        System.out.println("=============================");
        System.out.println("도서 ID\t | 수량 | 총가격");
        for (int i = 0; i < mCartItemCount; i++) {
            System.out.println(i + 1 + " " + mCart[i].getBook().getItemId() + " | " + mCart[i].getCount() + " | " + mCart[i].getTotalPrice());
        }
        System.out.println("=============================");
        return true;
    }
    @Override
    public boolean isCartInItem(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (bookId.equals(mCart[i].getBook().getItemId())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void appendItem(Item book) {
        this.mCart[this.mCartItemCount++] = new CartItem((Book) book); //Up캐스팅 된 book을 down 캐스팅
    }
    @Override
    public void increaseItemCount(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getItemId().equals(bookId)) {
                this.mCart[i].setCount(this.mCart[i].getCount() + 1);
                return;
            }
        }
    }
    @Override
    public Item decreaseItemCount(String bookId) {
        Book book = null; //지역변수는 값이 안들어가도 반드시 초기값을 넣어줘야함 stack메모리에서는 뭐가 들어갈지 모름
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getItemId().equals(bookId)) {
                book = this.mCart[i].getBook();
                this.mCart[i].setCount(this.mCart[i].getCount() - 1);
                if (this.mCart[i].getCount() == 0) {
                    System.out.println("수량이 0이 되어 장바구니에서 삭제되었습니다.");
                    this.removeCartItem(i);
                    break;
                }
            }
        }
        return book;
    }
    @Override
    public Item removeCartItem(String bookId){
        Book book = null;
        for(int i = 0; i < this.mCartItemCount; i++){
            if(this.mCart[i].getBook().getItemId().equals(bookId)){
                book = mCart[i].getBook();
                this.removeCartItem(i);
                break;
            }
        }
        return book;
    }
    @Override
    public void removeCartItem(int index) {
        CartItem[] newCartItemList = new CartItem[3];
        int number = 0;
        for (int i = 0; i <mCartItemCount; i++){
            if(i!=index){
                newCartItemList[number++] = this.mCart[i];
            }
        }
        this.mCart = newCartItemList;
        mCartItemCount--;
//        for (int i = index; i < this.mCartItemCount - 1; i++) {
//            this.mCart[i] = this.mCart[i + 1];
//        }
//        this.mCart[--this.mCartItemCount] = null;
    }
    @Override
    public void clearCart() {
        this.mCart = new CartItem[3];
        this.mCartItemCount = 0;
    }
    @Override
    public int cartBill() {
        this.mCartTotalPrice = 0;
        for (int i = 0; i < this.mCartItemCount; i++) {
            this.mCartTotalPrice += this.mCart[i].getTotalPrice();
        }
        return this.mCartTotalPrice;
    }
}
