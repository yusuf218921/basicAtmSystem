public class Main {
    public static void main(String[] args) {
        Statics.customerAccounts.add(new CustomerAccount(
                "yusuf", "218921", 5387406279L,
                "yusuf@gmail.com", "yusuf", "sönmez"));
        ATM atm = new ATM();
        atm.run();
    }
}