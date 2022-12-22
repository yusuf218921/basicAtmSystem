public class List {
    public static void listATMCard() {
        if (Statics.customerAccounts.get(Statics.loginId).cards[0].isEmpty()) {
            System.out.println("Hesabınızda Kayıtlı Banka Kartı Bulunmamaktadır");
        } else {
            for (BaseCard card:Statics.customerAccounts.get(Statics.loginId).cards[0]) {
                card.list();
            }
        }
    }
    public static void listCreditCard() {
        if (Statics.customerAccounts.get(Statics.loginId).cards[1].isEmpty()) {
            System.out.println("Hesabınızda Kayıtlı Banka Kartı Bulunmamaktadır");
        } else {
            for (BaseCard card:Statics.customerAccounts.get(Statics.loginId).cards[1]) {
                card.list();
            }
        }
    }
}
