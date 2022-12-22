import java.util.Scanner;

public class AccountMenu implements Menu {
    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String selection;
        System.out.println("**************************************************************\n");
        System.out.println("HOŞ GELDİNİZ SAYIN "
                + Statics.customerAccounts.get(Statics.loginId).getFirstName() + " "
                + Statics.customerAccounts.get(Statics.loginId).getLastName());
        System.out.println("\n[1] Kart İşlemleri");
        System.out.println("[2] Hesap İşlemleri");
        System.out.println("[3] Para Yükle");
        System.out.println("[4] Kredi Kartı Borcu Öde");
        System.out.println("[5] Para Çek");
        System.out.println("[6] Kredi Çek");
        System.out.println("[7] Kredi Öde");
        System.out.println("[8] Başka Hesaba Para Gönder");
        System.out.println("[b] Geri Dön");
        System.out.println("[q] Uygulamadan Çık");
        System.out.println("**************************************************************\n");

        System.out.print("Yapılacak işlem -> ");
        selection=scanner.next();

    }
}
