import java.util.ArrayList;

public class Statics {
    static int registerId = 0;
    static int loginId;
    static boolean adminLogin = false;
    static boolean customerLogin = false;
    static boolean customerRepresentative = false;
    static ArrayList<CustomerAccount> customerAccounts = new ArrayList<>();
    static ArrayList<AdminAccount> adminAccounts = new ArrayList<>();
    ArrayList<BaseCard>[] cards = new ArrayList[]{new ArrayList<ATMCard>()};

}
