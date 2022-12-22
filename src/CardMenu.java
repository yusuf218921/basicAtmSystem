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
                Statics.customerAccounts.get(Statics.loginId).cards[0].add(new ATMCard());
                System.out.println("Yeni banka kartınız oluşturuldu...");
                InputThings.pressENTERToContunie();
            } else if (selection.equals("4")) {
                int limit;
                System.out.println("Lütfen bir limit belirleyiniz");
                System.out.println("5000");
                System.out.println("10000");
                System.out.println("20000");
                while (true) {
                    System.out.print("-> ");
                    limit = InputControls.isItInt();
                    if (limit == 5000 || limit == 10000 || limit == 20000) {
                        Statics.customerAccounts.get(Statics.loginId).cards[1].add(new CreditCard(limit));
                        System.out.println("Yeni kredi kartınız oluşturuldu...");
                        InputThings.pressENTERToContunie();
                        break;
                    } else {
                        System.out.println("Hatalı limit değeri girildi lütfen tekrar deneyiniz");
                    }
                }
            } else {
                System.out.println("Hatalı işlem girdiniz Lütfen tekrar deneyiniz...");
            }
        }
    }
}
