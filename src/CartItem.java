public class CartItem {
    private Book book;
    private int count;
    private int totalPrice;
//생성자
    public CartItem(Book book, int count){
        this.book = book;
        this.count = count;
        this.updateTotalPrice();
    }
    public CartItem(Book book){
        this.book = book;
        this.count = 1;
        this.updateTotalPrice();
    }

    public void updateTotalPrice() {
        this.totalPrice = this.count * this.book.getPrice();
    }

// 읽기 접근자
    public Book getBook() {
        return this.book;
    }
    public int getCount() {
        return count;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
// 쓰기 접근자
    public void setCount(int count){
        this.count = count;
        this.updateTotalPrice();
    }
}
