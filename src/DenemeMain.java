import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// kodların çalışıp çalışmadığını maini bozmadan denemek için oluşturulmuş class
public class DenemeMain {
    public static void main(String[] args) {
        Statics.customerAccounts.add(new CustomerAccount(
                "yusuf","218921",5387406279L,
                "yusuf@gmail.com","yusuf","sönmez"));
        System.out.println(Statics.customerAccounts.get(Statics.loginId).cards[0].isEmpty());
    }
}
