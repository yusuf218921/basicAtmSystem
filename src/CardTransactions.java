import java.util.ArrayList;

public class CardTransactions {
    ArrayList<String> transactions=new ArrayList<>();

    public boolean donation(int amount,String cardNum) {
        for (BaseCard card:Statics.customerAccounts.get(Statics.loginId).cards[0]) {
            if (cardNum.equals(card.getCardNum())) {
                card.setBalance(amount+card.getBalance());
                System.out.println("Kartınıza " + amount + " TL yüklendi");
                transactions.add(cardNum + " numaralı kartınıza " + amount + " TL yüklendi");
                return true;
            }
        }
        System.out.println("Kart Numarası yanlış girildi...");
        return false;
    }

    public boolean cashWithdrawal(int amount,String cardNum) {
        for (BaseCard card:Statics.customerAccounts.get(Statics.loginId).cards[0]) {
            if (cardNum.equals(card.getCardNum())) {
                if (card.getBalance()>=amount) {
                    card.setBalance(card.getBalance()-amount);
                    System.out.println("Kartınızdan " + amount + " TL çekildi");
                    transactions.add(cardNum + " numaralı kartınızdan " + amount + " TL çekildi");
                    return true;
                } else {
                    System.out.println("Hesabınızda yeterli tutar bulunamadı...");
                }

            }
        }
        for (BaseCard card:Statics.customerAccounts.get(Statics.loginId).cards[1]) {
            if (cardNum.equals(card.getCardNum())) {
                if (card.getAvailableLimit()>=amount) {
                    card.setAvailableLimit(card.getAvailableLimit()-amount);
                    System.out.println("Kartınızdan " + amount + " TL çekildi");
                    transactions.add(cardNum + " numaralı kartınızdan " + amount + " TL çekildi");
                    return true;
                } else {
                    System.out.println("Hesabınızda yeterli tutar bulunamadı...");
                    return false;
                }
            }
        }
        System.out.println("Kart Numarası yanlış girildi...");
        return false;
    }

    public boolean payOffCreditCardDebt(int amount,String cardNum) {
        for (BaseCard card:Statics.customerAccounts.get(Statics.loginId).cards[1]) {
            if (cardNum.equals(card.getCardNum())) {
                if (card.getDebit()==0) {
                    System.out.println("Kredi kartınızın borcu bulunmamaktadır...");
                    return false;
                }
                else if (-card.getDebit()>=amount) {
                    card.setDebit(card.getDebit()+amount);
                    System.out.println("Kredi kartınıza " + amount + " TL yüklendi");
                    transactions.add(cardNum + " numaralı kredi kartınıza " + amount + " TL yüklendi");
                    return true;
                } else {
                    System.out.println("Borcunuzdan fazla yükleme yapılamaz...");
                    return false;
                }
            }
        }
        System.out.println("Kart Numarası yanlış girildi...");
        return false;
    }
}
