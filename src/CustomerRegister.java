import java.util.Scanner;

public class CustomerRegister {
    public static void register() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String userName;
            String password;
            System.out.print("Kullanıcı adı : ");
            userName = scanner.next();
            if (registerQuery(userName)) {
                System.out.print("Şifre : ");
                password = scanner.next();
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
                Statics.customerAccounts.add(
                        new CustomerAccount(userName, password, tel, email, firstName, lastName));
                System.out.println("Kayıt başarıyla gerçekleşti ana menüye yönlendiriliyorsunuz");
                InputThings.pressENTERToContunie();
                break;
            } else {
                System.out.println("Girmiş olduğunuz kullanıcı adı daha önce alınmış...");
                if (InputThings.yesOrNo()) {

                } else {
                    break;
                }
            }
        }
    }

    public static boolean registerQuery(String userName) {
        for (CustomerAccount account : Statics.customerAccounts) {
            if (userName.equalsIgnoreCase(account.getUserName())) {
                return false;
            }
        }
        return true;

    }
}
