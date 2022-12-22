import java.util.Scanner;

public class InputThings {

    public static void pressENTERToContunie() {
        try {
            System.out.print("Devam etmek için lütfen ENTER tuşuna basınız...");
            System.in.read();
        } catch (Exception ex) {
        }
    }

    public static boolean yesOrNo() {
        Scanner scanner = new Scanner(System.in);
        String yesOrNo;
        while (true) {
            System.out.print("Devam etmek istiyor musunuz evet/hayır -> ");
            yesOrNo = scanner.next();
            if (yesOrNo.toLowerCase().equals("evet")) {
                return true;
            } else if (yesOrNo.toLowerCase().equals("hayır")) {
                return false;
            } else {
                System.out.println("Yanlış değer girildi lütfen tekrar deneyiniz...");
            }
        }
    }
}
