public class ATM {
    public void run() {
        Menu menu;
        while (true) {
            menu = new MainMenu();
            menu.menu();
            if (Statics.customerLogin) {
                System.out.println("Giriş yapıldı giriş yapılan id : " + Statics.customerAccounts.get(Statics.loginId).getId());
                //TODO
                break;
            } else if (Statics.adminLogin) {
                break;
            } else {
                System.out.println("sa");
                break;
            }
        }
    }
}
