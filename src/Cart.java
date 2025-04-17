public class Cart {
    private CartItem[] mCart = new CartItem[3];
    private int mCartItemCount;

    public CartItem[] getmCart (){
        return this.mCart;
    }

    public int getmCartItemCount(){
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

    public void appendBook(Book book){
        this.mCart[this.mCartItemCount++] = new CartItem(book);
    }

    public void increaseBookCount(String bookId){
        for (int i = 0; i < this.mCartItemCount; i++){
            if(this.mCart[i].getBook().getId().equals(bookId)){
                this.mCart[i].setCount(this.mCart[i].getCount()+1);
                return;
            }
        }
    }

    public void decreaseBookCount(String bookId){
        for (int i = 0; i < this.mCartItemCount; i++){
            if(this.mCart[i].getBook().getId().equals(bookId)){
                this.mCart[i].setCount(this.mCart[i].getCount()-1);
                if(this.mCart[i].getCount()==0){
                    mCart[i]=null;
                    for (int j = i; j < mCartItemCount -1; j++){
                        mCart[j]=mCart[j+1];
                    }
                }
                return;
            }
        }
    }

}
