import java.util.Scanner;

public class AccountMenu implements Menu {
    @Override
    public void menu() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String selection;
            System.out.println("**************************************************************\n");
            System.out.println("*********************HESAP İŞLEMLERİ**************************\n");
            System.out.println("[1] Hesap Bilgilerimi Görüntüle");
            System.out.println("[2] Hesap Bilgilerimi Düzenle");
            System.out.println("[3] Kullanıcı Adı Değiştir");
            System.out.println("[4] Şifre Değiştir");
            System.out.println("[5] Son İşlemler");
            System.out.println("[b] Geri Dön");
            System.out.println("**************************************************************\n");

            System.out.print("Yapılacak işlem -> ");
            selection = scanner.next();
            if (selection.equalsIgnoreCase("b")) {
                System.out.println("Geri gönderiliyorsunuz lütfen bekleyiniz...");
                ThreadOperations.thread_sleep(1000);
                break;
            } else if (selection.equals("1")) {
                List.listCustomerInfo();
                InputThings.pressENTERToContunie();
            } else if (selection.equals("2")) {
                System.out.print("\n\nKullanıcı bilgileri\n\n");
                String firstName, lastName, email;
                long tel;
                while (true) {
                    System.out.print("İsim : ");
                    firstName = scanner.next();
                    if (InputControls.stringHasNotIntControl(firstName)) {
                        while (true) {
                            System.out.print("Soyisim : ");
                            lastName = scanner.next();
                            if (InputControls.stringHasNotIntControl(lastName)) {
                                break;
                            } else {
                                System.out.println("Hatalı karakter girildi lütfen sadece harf giriniz...");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Hatalı karakter girildi lütfen sadece harf giriniz...");
                    }
                }
                while (true) {
                    System.out.print("E-posta(Sadece gmail kabul edilir lütfen buna dikkat ederek giriniz) : ");
                    email = scanner.next();
                    if (email.length() > 10 && InputControls.emailControl(email)) {
                        break;
                    } else {
                        System.out.println("Hatalı e-posta girildi lütfen tekrar deneyiniz");
                    }
                }
                while (true) {
                    System.out.print("Telefon numarası : +90");
                    tel = scanner.nextLong();
                    if (InputControls.isTelTrue(tel)) {
                        break;
                    } else {
                        System.out.println("Yanlış telefon numarası lütfen tekrar deneyiniz...");
                    }
                }
                Statics.customerAccounts.get(Statics.loginId).setInfo(firstName, lastName, email, tel);
                System.out.println("Hesap bilgileri güncellendi...");
                InputThings.pressENTERToContunie();
            } else if (selection.equals("3")) {
                String userName;
                System.out.print("Yeni Kullanıcı adı : ");
                userName = scanner.next();
                if (CustomerRegister.registerQuery(userName)) {
                    Statics.customerAccounts.get(Statics.loginId).setUserName(userName);
                    System.out.println("Kullanıcı adı başarıyla değiştirildi...");
                } else {
                    System.out.println("Kullanıcı adı daha önce alınmış...");
                }
                InputThings.pressENTERToContunie();
            } else if (selection.equals("4")) {
                String password;
                System.out.print("Yeni Şifre : ");
                password = scanner.next();
                Statics.customerAccounts.get(Statics.loginId).setPassword(password);
                System.out.println("Şifre Başarıyla değiştirildi");
                InputThings.pressENTERToContunie();
            } else if (selection.equals("5")) {
                if (Statics.transactions.get(Statics.loginId).transactions.isEmpty()) {
                    System.out.println("Hesabınızda herhangi bir işlem bulunmamaktadır...");
                } else {
                    for (String transaction : Statics.transactions.get(Statics.loginId).transactions) {
                        System.out.println(transaction);
                    }
                }
                InputThings.pressENTERToContunie();
            } else {
                System.out.println("Hatalı işlem numarası girildi");
                InputThings.pressENTERToContunie();
            }
        }

    }
}
