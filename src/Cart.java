import java.util.ArrayList;
import java.util.Iterator;

public class Cart implements CartInterface {
    private ArrayList<CartItem> mCartList = new ArrayList<>();
    private int mCartTotalPrice;

    public ArrayList<CartItem> getMCart() {
        return this.mCartList;
    }


    @Override
    public boolean printCartList() {
        if (this.mCartList.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return false;
        }
        System.out.println("=============================");
        System.out.println("도서 ID\t | 수량 | 총가격");
        for (int i = 0; i < this.mCartList.size(); i++) {
            System.out.println(i + 1 + " " + mCartList.get(i).getItem().getItemId() + " | " + mCartList.get(i).getCount() + " | " + mCartList.get(i).getTotalPrice());
        }
        System.out.println("=============================");
        return true;
    }
    @Override
    public boolean isCartInItem(String bookId) {
        for (CartItem c : this.mCartList) {
            if (bookId.equals(c.getItem().getItemId())) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void appendItem(Item book) {
        this.mCartList.add(new CartItem(book));
    }
    @Override
    public Item increaseItemCount(String bookId) {
        Iterator<CartItem> iterator = this.mCartList.iterator();
        while (iterator.hasNext()){
            CartItem item = iterator.next();
            if(item.getItem().getItemId().equals(bookId)){
                item.setCount(item.getCount()+1);
                return item.getItem();
            }
        }
        return null;
    }
    @Override
    public Item decreaseItemCount(String bookId) {
        Iterator<CartItem> iterator = this.mCartList.iterator();
        while (iterator.hasNext()){
            CartItem item = iterator.next();
            if(item.getItem().getItemId().equals(bookId)){
                item.setCount(item.getCount()-1);
                if(item.getCount()==0){
                    iterator.remove();
                    return item.getItem();
                }
            }
        }
        return null;
    }

    @Override
    public Item deleteCartItem(String id){
        Iterator<CartItem> iterator = this.mCartList.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next().getItem();
            if (item.getItemId().equals(id)) {
                iterator.remove();
                return item;
            }
        }
        return null;
    }

    @Override
    public void clearCart() {
        this.mCartList = new ArrayList<CartItem>();
    }
    @Override
    public int cartBill() {
        this.mCartTotalPrice = 0;
        for (CartItem c : this.mCartList) {
            this.mCartTotalPrice += c.getTotalPrice();
        }
        return this.mCartTotalPrice;
    }
}
