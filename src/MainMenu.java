import java.util.Scanner;

public class MainMenu extends ATM implements IMenu {
    @Override
    public void menu() {
        while (true) {
            String selection;
            Scanner scanner = new Scanner(System.in);

            System.out.println("**************************************************************\n\n");
            System.out.println("**************HerDerdeDeva ATM'sine hoş geldiniz**************\n\n");
            System.out.println("[1] Giriş Yap");
            System.out.println("[2] Kayıt Ol");
            System.out.println("[3]Müşteri Temsilcisine Bağlan");
            System.out.println("[q] Çıkış Yap");
            System.out.println("\n\n");
            System.out.println("**************************************************************\n\n");

            System.out.print("Yapılacak işlem -> ");
            selection = scanner.next();

            if (selection.toLowerCase().equals("q")) {
                System.out.println("Sistem kapanıyor lütfen bekleyiniz");
                ThreadOperations.thread_sleep(250);
                System.out.println("3");
                ThreadOperations.thread_sleep(250);
                System.out.println("2");
                ThreadOperations.thread_sleep(250);
                System.out.println("1");
                ThreadOperations.thread_sleep(250);
                System.out.println("0");
                System.exit(0);
            } else if (selection.equals("1")) {
                ClearConsole.clrUp();
                while (true) {
                    if (new CustomerLogin().login()) {
                        System.out.println("Giriş işlemi başarılı sisteme yönlendiriliyorsunuz ");
                        ThreadOperations.thread_sleep(1000);
                        break;
                    } else {
                        System.out.println("Hatalı şifre veya kullanıcı adı!");
                        if (InputThings.yesOrNo()) {
                        } else {
                            break;
                        }
                    }
                }

            } else if (selection.equals("2")) {
                ClearConsole.clrUp();
                System.out.println("********************************************************\n\n");
                System.out.println("********************KAYIT EKRANI************************\n\n");
                CustomerRegister.register();
            } else if (selection.equals("3")) {
                ClearConsole.clrUp();
                System.out.println("Müşteri temsilcimize bağlanıyorsunuz lütfen bekleyiniz");
                ThreadOperations.thread_sleep(1000);
                Statics.customerRepresentative = true;
                break;
            } else {
                System.out.println("Yanlış değer girildi!");
                InputThings.pressENTERToContunie();
            }
            if (Statics.customerLogin) {
                break;
            }
        }
    }
}
