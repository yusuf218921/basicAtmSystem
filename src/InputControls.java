import java.util.Scanner;

/*Girilen inputların kullanıcı tarafından doğru girilmediği taktirde oluşacak durumların kontrol altına alınması için
    oluşturulmuş kontrol sınıfı
     */
public class InputControls {

    // girilen string ifadede int olup olmadığının kontrolü
    public static boolean stringHasNotIntControl(String str) {
        char character;
        int isInt;
        boolean control = true;
        for (int i = 0; i < str.length(); i++) {
            character = str.charAt(0);
            try {
                // girilen string ifade harf harf int dönüşümü kontrol edilir
                isInt = Integer.parseInt(String.valueOf(character));
                // eğer hata alınmazsa girilen string ifadede integer vardır control=false olur
                // eğer girilen ifadede integer yoksa sürekli hata alınır ve control=true olur
                control = false;
            } catch (Exception ex) {
            }
        }
        if (control) {
            // girilen string ifadede integer yok
            return true;
        } else {
            // girilen string ifadede en az bir adet integer var
            return false;
        }
    }

    // sadece @gmail.com ile bitenleri kabul etmek için kontrol
    public static boolean emailControl(String str) {
        String subStr;
        int last = str.length(); // @gmail.com'daki son harfin bulunduğu indexi tutmak için
        int begin = last - 10; // @gmail.com'daki ilk harfin bulunduğu indexi tutmak için
        subStr = str.substring(begin);
        if (subStr.equals("@gmail.com")) {
            // email @gmail.com ile bitiyorsa true değer döndürülecek
            return true;
        } else {
            // email @gmail.com ile bitmiyorsa false değer döndürülecek
            return false;
        }
    }

    // 10 haneli telefon numarası alabilmek için kontrol
    public static boolean isTelTrue(long tel) {

        int digits = 0; // girilen numaranın basamak sayısını tutmak için

        /*tel=0 olana kadar her seferinde basamak sayısını 10'a bölerek azaltıp digits'i arttırarak telin kaç basamaklı
        olduğunu bulma
         */
        while (tel > 0) {
            tel = tel / 10;
            digits++;
        }
        // basamak sayısı 10sa true değilse false döndürmek için
        if (digits == 10) {
            return true;
        } else {
            return false;
        }
    }

    /* int değer girilmesi istenirken string değer girilmesi durumunda hata alınmaması ve programa devam edilebilmesi için
    yapılan kontrol*/

    public static int isItInt() {

        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) try {
            num = scanner.nextInt();
            return num;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.print("Hatalı tür girdisi, lütfen sadece tam sayı girerek tekrar deneyiniz -> ");
        }
    }
}
