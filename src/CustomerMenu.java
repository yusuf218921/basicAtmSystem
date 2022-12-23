import java.util.Scanner;

public class CustomerMenu implements Menu {
    @Override
    public void menu() {
        while (true) {
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
            System.out.println("[6] Başka Hesaba Para Gönder");
            System.out.println("[b] Geri Dön");
            System.out.println("[q] Uygulamadan Çık");
            System.out.println("**************************************************************\n");

            System.out.print("Yapılacak işlem -> ");
            selection = scanner.next();

            if (selection.equalsIgnoreCase("q")) {
                System.out.println("Sistem kapanıyor lütfen bekleyiniz");
                ThreadOperations.thread_sleep(100);
                System.out.println("3");
                ThreadOperations.thread_sleep(100);
                System.out.println("2");
                ThreadOperations.thread_sleep(100);
                System.out.println("1");
                ThreadOperations.thread_sleep(100);
                System.out.println("0");
                System.exit(0);
            } else if (selection.equals("1")) {
                new CardMenu().menu();
            } else if (selection.equals("2")) {
                new AccountMenu().menu();
            } else if (selection.equals("3")) {
                System.out.print("Yükleme yapılacak tutar : ");
                int amount = InputControls.isItInt();
                String cardNum;
                scanner.nextLine();
                while (true) {
                    System.out.print("Yükleme yapılacak kartın numarasını giriniz : ");
                    cardNum = scanner.nextLine();
                    if(Statics.transactions.get(Statics.loginId).donation(amount,cardNum)) {
                        InputThings.pressENTERToContunie();
                        break;
                    } else {
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }
            } else if (selection.equals("4")) {
                while (true) {
                    System.out.print("Ödenecek Borç Miktarı : ");
                    int amount = InputControls.isItInt();
                    String cardNum;
                    scanner.nextLine();
                    System.out.print("Borç ödenecek kartın numarasını giriniz : ");
                    cardNum = scanner.nextLine();
                    if(Statics.transactions.get(Statics.loginId).payOffCreditCardDebt(amount,cardNum)) {
                        InputThings.pressENTERToContunie();
                        break;
                    } else {
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }
            } else if (selection.equals("5")) {
                while (true) {
                    System.out.print("Karttan çekilecek tutar : ");
                    int amount = InputControls.isItInt();
                    String cardNum;
                    scanner.nextLine();
                    System.out.print("Para çekilecek kartın numarasını giriniz : ");
                    cardNum = scanner.nextLine();
                    if(Statics.transactions.get(Statics.loginId).cashWithdrawal(amount,cardNum)) {
                        InputThings.pressENTERToContunie();
                        break;
                    } else {
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }
            } else if (selection.equals("6")) {
                while (true) {
                    System.out.print("Gönderilecek miktar : ");
                    int amount = InputControls.isItInt();
                    String cardNum,cardIBAN;
                    scanner.nextLine();
                    System.out.print("Gönderen kartın numarasını giriniz :  ");
                    cardNum = scanner.nextLine();
                    System.out.print("Gönderilecek kartın IBAN numarasını giriniz : ");
                    cardIBAN = scanner.nextLine();
                    if(Statics.transactions.get(Statics.loginId).transfer(amount,cardNum,cardIBAN)) {
                        InputThings.pressENTERToContunie();
                        break;
                    } else {
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }
            } else if (selection.equalsIgnoreCase("b")) {
                System.out.println("Geri gönderiliyorsunuz lütfen bekleyiniz...");
                ThreadOperations.thread_sleep(1000);
                break;
            } else {
                System.out.println("Hatalı karakter girildi, lütfen tekrar deneyiniz");
            }
        }
    }
}
