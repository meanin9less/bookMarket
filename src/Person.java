public class Person {
    private String name;
    private String contact;

    public Person(String name, String contact){
        this.name = name;
        this.contact = contact;
    }
    public String getName(){
        return this.name;
    }
    public String getContact(){
        return this.contact;
    }

    public void setName(String name){
        this.name = name;
    }
    public  void setContact(String contact){
        this.contact = contact;
    }

}
