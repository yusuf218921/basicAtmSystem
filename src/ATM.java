public class ATM {
    IMenu menu;
    public void run() {
        Statics.customerAccounts.add(new CustomerAccount(
                "yusuf", "218921", 5387406279L,
                "yusuf@gmail.com", "yusuf", "sönmez"));
        Statics.transactions.add(new CardTransactions());
        while (true) {
            menu = new MainMenu();
            menu.menu();
            if (Statics.customerLogin) {
                menu = new CustomerMenu();
                menu.menu();
                Statics.customerLogin = false;
            } else if (Statics.customerRepresentative) {
                menu = new CustomerRepresentativeMenu();
                menu.menu();
                Statics.customerLogin = false;
            }
        }
    }
}
