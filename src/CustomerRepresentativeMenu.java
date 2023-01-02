import java.util.Scanner;

public class CustomerRepresentativeMenu extends MainMenu implements IMenu {
    @Override
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n\n***********Müşteri temsilcisine hoş geldiniz***************\n\n");
            System.out.println("[1] Kullanıcı adımı unuttum");
            System.out.println("[2] Şifremi unuttum");
            System.out.println("[3] Banka kartı kayıp ihbarı yapmak istiyorum");
            System.out.println("[4] Kredi kartı kayıp ihbarı yapmak istiyorum");
            System.out.println("[b] Geri Dön");

            System.out.print("\n\n Lütfen yapmak istediğiniz işlemi seçiniz -> ");
            String selection = scanner.next();
            if (selection.equalsIgnoreCase("b")) {
                System.out.println("Ana menüye gönderiliyorsunuz lütfen bekleyiniz...");
                ThreadOperations.thread_sleep(1000);
                break;
            } else if (selection.equals("1")) {
                long tel;
                String email;
                ClearConsole.clrUp();
                while (true) {
                    System.out.println("Kulanıcı adınızi öğrenmek için aşağıdaki bilgileri doldurunuz");
                    while (true) {
                        System.out.print("E-posta : ");
                        email = scanner.next();
                        if (InputControls.emailControl(email)) {
                            break;
                        } else {
                            System.out.println("Lütfen e-postanızı doğru bir şekilde giriniz...");
                        }
                    }
                    while (true) {
                        System.out.print("Telefon Numarası : ");
                        tel = scanner.nextLong();
                        if (InputControls.isTelTrue(tel)) {
                            break;
                        } else {
                            System.out.println("Lütfen telefon numaranızı doğru girdiğinizden emin olunuz...");
                        }
                    }
                    boolean control = false;
                    for (CustomerAccount account : Statics.customerAccounts) {
                        if (account.getTel() == tel && account.getEmail().equals(email)) {
                            System.out.println("\nKullanıcı adınız : " + account.getUserName());
                            InputThings.pressENTERToContunie();
                            control = true;
                        }
                    }
                    if (control) {
                        break;
                    } else {
                        System.out.println("Girmiş olduğunuz bilgiler herhangi " +
                                "bir hesapla eşleşmedi lütfen bilgilerinizi doğru bir şekilde girdiğinizden emin olunuz...");
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }
            } else if (selection.equals("2")) {
                ClearConsole.clrUp();
                while (true) {
                    long tel;
                    String email;
                    String userName;
                    System.out.println("Şifrenizi yenilemek için aşağıdaki bilgileri doldurunuz");
                    while (true) {
                        System.out.print("Kullanıcı adı : ");
                        userName = scanner.next();
                        if (InputControls.stringHasNotIntControl(userName)) {
                            break;
                        } else {
                            System.out.println("Lütfen kullanıcı adını doğru bir şekilde giriniz...");
                        }
                    }
                    while (true) {
                        System.out.print("E-posta : ");
                        email = scanner.next();
                        if (InputControls.emailControl(email)) {
                            break;
                        } else {
                            System.out.println("Lütfen e-postanızı doğru bir şekilde giriniz...");
                        }
                    }
                    while (true) {
                        System.out.print("Telefon Numarası : ");
                        tel = scanner.nextLong();
                        if (InputControls.isTelTrue(tel)) {
                            break;
                        } else {
                            System.out.println("Lütfen telefon numaranızı doğru girdiğinizden emin olunuz...");
                        }
                    }
                    boolean control = false;
                    for (CustomerAccount account : Statics.customerAccounts) {
                        if (account.getTel() == tel && account.getEmail().equals(email) && account.getUserName().equals(userName)) {
                            String password;
                            System.out.print("\nYeni şifrenizi giriniz :  ");
                            password = scanner.next();
                            account.setPassword(password);
                            System.out.println("Şifreniz yenilendi...");
                            InputThings.pressENTERToContunie();
                            control = true;
                        }
                    }
                    if (control) {
                        break;
                    } else {
                        System.out.println("Girmiş olduğunuz bilgiler herhangi " +
                                "bir hesapla eşleşmedi lütfen bilgilerinizi doğru bir şekilde girdiğinizden emin olunuz...");
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }

            } else if (selection.equals("3")) {
                ClearConsole.clrUp();
                System.out.println("Öncelikle hesap bilgilerinizi giriniz...");
                int customerId = -1;
                boolean control = false;
                while (true) {
                    String userName;
                    String password;
                    System.out.print("Kullanıcı adı : ");
                    userName = scanner.next();
                    System.out.print("Şifre : ");
                    password = scanner.next();
                    for (CustomerAccount account : Statics.customerAccounts) {
                        if (account.getUserName().equalsIgnoreCase(userName) && account.getPassword().equals(password)) {
                            customerId = account.getId();
                            control = true;
                        }
                    }
                    if (control) {
                        break;
                    } else {
                        System.out.println("Hesap bilgilerinizi yanlış girdiniz...");
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }
                while (control) {
                    String cardNum;
                    int balance;
                    scanner.nextLine();
                    System.out.print("Kayıp Kartınızın Kart Numarasını Giriniz : ");
                    cardNum = scanner.nextLine();
                    for (int i = 0; i < Statics.customerAccounts.get(customerId).cards[0].size(); i++) {
                        if (Statics.customerAccounts.get(customerId).cards[0].get(i).getCardNum().equals(cardNum)) {
                            balance = Statics.customerAccounts.get(customerId).cards[0].get(i).getBalance();
                            Statics.customerAccounts.get(customerId).cards[0].remove(i);
                            Statics.customerAccounts.get(customerId).cards[0].add(new DebitCard());
                            Statics.customerAccounts.get(customerId).cards[0].get(Statics.customerAccounts.get(customerId).cards[0].size() - 1).setBalance(balance);
                            System.out.println("Banka kartınız başarıyla silindi ve yerine yeni bir kart oluşturup hesap bakiyeniz yeni karta aktarıldı...");
                            InputThings.pressENTERToContunie();
                            control = false;
                            break;
                        }
                    }
                    if (control) {
                        System.out.println("Girmiş olduğunuz kart numarasıyla hesabınızdaki herhangi bir kart eşleşmemektedir...");
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }

                }
            } else if (selection.equals("4")) {
                ClearConsole.clrUp();
                System.out.println("Öncelikle hesap bilgilerinizi giriniz...");
                int customerId = -1;
                boolean control = false;
                while (true) {
                    String userName;
                    String password;
                    System.out.print("Kullanıcı adı : ");
                    userName = scanner.next();
                    System.out.print("Şifre : ");
                    password = scanner.next();
                    for (CustomerAccount account : Statics.customerAccounts) {
                        if (account.getUserName().equalsIgnoreCase(userName) && account.getPassword().equals(password)) {
                            customerId = account.getId();
                            control = true;
                        }
                    }
                    if (control) {
                        break;
                    } else {
                        System.out.println("Hesap bilgilerinizi yanlış girdiniz...");
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }
                }

                while (control) {
                    String cardNum;
                    int avaliableLimit, debit;
                    scanner.nextLine();
                    System.out.print("Kayıp Kartınızın Kart Numarasını Giriniz : ");
                    cardNum = scanner.nextLine();
                    for (int i = 0; i < Statics.customerAccounts.get(customerId).cards[1].size(); i++) {
                        if (Statics.customerAccounts.get(customerId).cards[1].get(i).getCardNum().equals(cardNum)) {
                            avaliableLimit = Statics.customerAccounts.get(customerId).cards[1].get(i).getAvailableLimit();
                            debit = Statics.customerAccounts.get(customerId).cards[1].get(i).getDebit();
                            Statics.customerAccounts.get(customerId).cards[1].remove(i);
                            Statics.customerAccounts.get(customerId).cards[1].add(new CreditCard(-debit + avaliableLimit));
                            Statics.customerAccounts.get(customerId).cards[1].get(Statics.customerAccounts.get(customerId).cards[1].size() - 1).setAvailableLimit(avaliableLimit);
                            Statics.customerAccounts.get(customerId).cards[1].get(Statics.customerAccounts.get(customerId).cards[1].size() - 1).setDebit(debit);
                            System.out.println("Kredi kartınız başarıyla silinmiştir ve yerine yenisi oluşturulup kullanılabilir limitiniz ve kart borcunuz tanınmıştır...");
                            InputThings.pressENTERToContunie();
                            control = false;
                            break;
                        }
                    }
                    if (control) {
                        System.out.println("Girmiş olduğunuz kart numarasıyla hesabınızdaki herhangi bir kart eşleşmemektedir...");
                        if (!InputThings.yesOrNo()) {
                            break;
                        }
                    }

                }

            } else {
                System.out.println("Hatalı giriş yaptınız lütfen tekrar deneyiniz...");
            }
        }
    }
}
