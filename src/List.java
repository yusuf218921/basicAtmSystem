public class List {
    public static void listDebitCard() {
        if (Statics.customerAccounts.get(Statics.loginId).cards[0].isEmpty()) {
            System.out.println("Hesabınızda Kayıtlı Banka Kartı Bulunmamaktadır");
        } else {
            for (BaseCard card : Statics.customerAccounts.get(Statics.loginId).cards[0]) {
                card.list();
                System.out.println();
            }
        }
    }

    public static void listCreditCard() {
        if (Statics.customerAccounts.get(Statics.loginId).cards[1].isEmpty()) {
            System.out.println("Hesabınızda Kayıtlı Banka Kartı Bulunmamaktadır");
        } else {
            for (BaseCard card : Statics.customerAccounts.get(Statics.loginId).cards[1]) {
                card.list();
                System.out.println();
            }
        }
    }

    public static void listCustomerInfo() {
        Statics.customerAccounts.get(Statics.loginId).list();
    }
}
