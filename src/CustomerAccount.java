public class CustomerAccount extends BaseAccount {
    private int id;
    private long tel;
    private String email;
    private String firstName;
    private String lastName;

    //Constructor

    public CustomerAccount(int id, String userName, String password, long tel, String email, String firstName, String lastName) {
        super(userName, password);
        this.id = Statics.registerId;
        Statics.registerId++;
        this.tel = tel;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }


    public long getTel() {
        return tel;
    }

    public void setTel(long tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
