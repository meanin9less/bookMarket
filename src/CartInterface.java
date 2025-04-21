public interface CartInterface {
    boolean isCartInItem(String id);
    void clearCart();
    Item removeCartItem(String id);
    void appendItem(Item item);
    void increaseItemCount(String id);
    Item decreaseItemCount(String id);
    void removeCartItem(int index);
    boolean printCartList();
    int cartBill();
}
