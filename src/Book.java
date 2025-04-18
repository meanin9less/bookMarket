public class Book {

    private String id;
    private String title;
    private int price;
    private String author;
    private String description;
    private String category;
    private String publicationDate;

    public Book(String id, String title, int price, String author, String description, String category, String publicationDate){
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
        this.description = description;
        this.category = category;
        this.publicationDate = publicationDate;
    }

    public String getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public int getPrice(){
        return this.price;
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
