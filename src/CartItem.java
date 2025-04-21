public class CartItem {
    private Item item;
    private int count;
    private int totalPrice;
//생성자
    public CartItem(Item item, int count){
        this.item = item;
        this.count = count;
        this.updateTotalPrice();
    }
    public CartItem(Item item){
        this.item = item;
        this.count = 1;
        this.updateTotalPrice();
    }

    public void updateTotalPrice() {
        this.totalPrice = this.count * this.item.getPrice();
    }

// 읽기 접근자
    public Item getItem() {
        return this.item;
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
