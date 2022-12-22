public class ATM {
    public void run() {
        Menu menu;
        while (true) {
            menu = new MainMenu();
            menu.menu();
            if (Statics.customerLogin) {


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
