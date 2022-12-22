public class ATM {
    public void run() {
        Menu menu;
        while (true) {
            menu = new MainMenu();
            menu.menu();
            if (Statics.customerLogin) {
                menu = new CustomerMenu();
                menu.menu();
                Statics.customerLogin = false;
            } else if (Statics.adminLogin) {
                break;
            } else if (Statics.customerRepresentative) {
                System.out.println("sa");
                break;
            }
        }
    }
}
