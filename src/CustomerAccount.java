import java.util.ArrayList;

public class CustomerAccount extends BaseAccount {
    private int id;
    private long tel;
    private String email;
    private String firstName;
    private String lastName;
    ArrayList<BaseCard>[] cards = new ArrayList[]{new ArrayList<DebitCard>(), new ArrayList<CreditCard>()};

    //Constructor

    public CustomerAccount(String userName, String password, long tel, String email, String firstName, String lastName) {
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

    public void setInfo(String firstName, String lastName, String email, long tel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tel = tel;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }


    @Override
    public void list() {
        System.out.println("İsim : " + firstName);
        System.out.println("Soyisim : " + lastName);
        System.out.println("Telefon Numarası : " + tel);
        System.out.println("E-posta : " + email);
    }
}
