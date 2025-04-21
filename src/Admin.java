public class Admin extends Person{
    private String adminId = "Admin";
    private String adminPw = "Admin1234";

    public Admin(String name, String contact){
        super(name, contact);
    }

    public String getAdminId(){
        return this.adminId;
    }
    public String getAdminPw(){
        return this.adminPw;
    }

    public boolean isCollectId(String id){
        return this.adminId.equals(id);
    }
    public boolean isCollectPw(String pw){
        return this.adminPw.equals(pw);
    }
}
