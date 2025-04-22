import java.util.ArrayList;

public class Book extends Item {
    String author;
    String description;
    String category;
    String publicationDate;

    public Book(String id, String title, int price, String author, String description, String category, String publicationDate){
        super(id, title, price);
        this.author = author;
        this.description = description;
        this.category = category;
        this.publicationDate = publicationDate;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getDescription(){
        return this.description;
    }

    public String getCategory(){
        return this.category;
    }

    public String getPublicationDate(){
        return this.publicationDate;
    }


}
