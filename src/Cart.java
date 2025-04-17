public class Cart {
    private CartItem[] mCart = new CartItem[3];
    private int mCartItemCount;
    private int mCartTotalPrice;

    public CartItem[] getMCart() {
        return this.mCart;
    }

    public int getMCartItemCount() {
        return this.mCartItemCount;
    }

    public boolean isCartInBook(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (bookId.equals(mCart[i].getBook().getId())) {
                return true;
            }
        }
        return false;
    }

    public void appendBook(Book book) {
        this.mCart[this.mCartItemCount++] = new CartItem(book);
    }

    public void increaseBookCount(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getId().equals(bookId)) {
                this.mCart[i].setCount(this.mCart[i].getCount() + 1);
                return;
            }
        }
    }

    public void decreaseBookCount(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getId().equals(bookId)) {
                this.mCart[i].setCount(this.mCart[i].getCount() - 1);
                if (this.mCart[i].getCount() == 0) {
                    this.mCart[i] = null;
                    for (int j = i; j < this.mCartItemCount - 1; j++) {
                        this.mCart[j] = this.mCart[j + 1];
                    }
                    this.mCart[--this.mCartItemCount] = null;
                }
                return;
            }
        }
    }

    public void removeBook(String bookId) {
        for (int i = 0; i < this.mCartItemCount; i++) {
            if (this.mCart[i].getBook().getId().equals(bookId)) {
                this.mCart[i] = null;
                for (int j = i; j < this.mCartItemCount - 1; j++) {
                    this.mCart[j] = this.mCart[j + 1];
                }
                this.mCart[--this.mCartItemCount] = null;
                return;
            }
        }
    }

    public void clearCart(){
        for (int i = 0; i < this.mCartItemCount-1; i++) {
            this.mCart[i] = null;
        }
        this.mCartItemCount = 0;
        return;
    }

    public int cartBill(){
        for (int i = 0; i < this.mCartItemCount; i++){
            this.mCartTotalPrice += this.mCart[i].getTotalPrice();
        }
        return this.mCartTotalPrice;
    }
}
