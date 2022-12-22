import java.util.Scanner;

public class CardMenu implements Menu {
    @Override
    public void menu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String selection;
            System.out.println("**************************************************************\n");
            System.out.println("*********************KART İŞLEMLERİ***************************\n");
            System.out.println("[1] Banka Kartlarımı Görüntüle");
            System.out.println("[2] Kredi Kartlarımı Görüntüle");
            System.out.println("[3] Yeni Banka Kartı Oluştur");
            System.out.println("[4] Yeni Kredi Kartı Oluştur");
            System.out.println("[b] Geri Dön");
            System.out.println("**************************************************************\n");

            System.out.print("Yapılacak işlem -> ");
            selection = scanner.next();

            if (selection.toLowerCase().equals("b")) {
                System.out.println("Geri gönderiliyorsunuz lütfen bekleyiniz...");
                ThreadOperations.thread_sleep(1000);
                break;
            } else if (selection.equals("1")) {
                List.listATMCard();
                InputThings.pressENTERToContunie();
            } else if (selection.equals("2")) {
                List.listCreditCard();
                InputThings.pressENTERToContunie();
            } else if (selection.equals("3")) {

            } else if (selection.equals("4")) {

            } else {
                System.out.println("Hatalı işlem girdiniz Lütfen tekrar deneyiniz...");
            }
        }
    }
}
