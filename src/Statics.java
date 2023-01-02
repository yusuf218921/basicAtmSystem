import java.util.ArrayList;

/* class ismiyle newlenmeden direkt erişilenleri ortak bi yerde tutmak için
oluşturulmuş sınıf, bu sınıftaki değişkenlerin direkt olarak
erişebilmesi gerekmektedir bu yüzden static olarak tanımlanmışlardır*/
public class Statics {

    //kayıt yapılırken hesaplara doğru id atamasını yapmak için oluşturulmuş değişşken
    static int registerId = 0;

    //giriş yapan kullanıcının id'sini tutmak için oluşturulmuş değişken
    static int loginId;

    //kart oluşturulurken id ataması doğru bir şekilde gerçekleştirilebilmesi için oluşturulmuş değişken
    static int cardId = 0;

    // kullanıcının giriş yapıp yapmadığını tutan değişken
    static boolean customerLogin = false;

    //müşteri hizmetlerine bağlanılıp bağlanmadığı tutan değişken
    static boolean customerRepresentative = false;

    //kullanıcı hesapları tutan bir arraylist
    static ArrayList<CustomerAccount> customerAccounts = new ArrayList<>();

    //Kullanıcının yapmış olduğu işlemleri tutan bir arraylist
    static ArrayList<CardTransactions> transactions = new ArrayList<>();

}
