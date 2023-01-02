import java.util.Scanner;

public class CustomerLogin implements Login {
    Scanner scanner = new Scanner(System.in);

    @Override
    public boolean login() {
        String userName;
        String password;
        System.out.println("**************************************************************\n\n");
        System.out.println("**************Giriş Ekranı**************\n\n\n\n");
        System.out.print("Kullanıcı adı : ");
        userName = scanner.next();
        System.out.print("Şifre : ");
        password = scanner.next();
        /* Metoda parametre olarak gönderilen arraylistin içinde kullanıcıdan girdi olarak alınan kullanıcı adı ve şifre eşleşirse
            true, herhangi bir eşlenme olmazsa false dönüşü
         */
        for (CustomerAccount account : Statics.customerAccounts) {
            if (account.getUserName().equalsIgnoreCase(userName) && account.getPassword().equals(password)) {
                Statics.loginId = account.getId();
                Statics.customerLogin = true;
                return true;
            }
        }
        return false;
    }
}
