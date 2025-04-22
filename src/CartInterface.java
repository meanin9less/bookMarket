public interface CartInterface {
    boolean isCartInItem(String id);
    void clearCart();
    void appendItem(Item item);
    Item increaseItemCount(String id);
    Item decreaseItemCount(String id);
    Item deleteCartItem(String id);
    boolean printCartList();
    int cartBill();
}
