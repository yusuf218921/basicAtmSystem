import java.util.ArrayList;

public class CardTransactions {
    ArrayList<String> transactions = new ArrayList<>();

    public boolean donation(int amount, String cardNum) {
        for (BaseCard card : Statics.customerAccounts.get(Statics.loginId).cards[0]) {
            if (cardNum.equals(card.getCardNum())) {
                card.setBalance(amount + card.getBalance());
                System.out.println("Kartınıza " + amount + " TL yüklendi");
                transactions.add(cardNum + " numaralı kartınıza " + amount + " TL yüklendi");
                return true;
            }
        }
        System.out.println("Kart Numarası yanlış girildi...");
        return false;
    }

    public boolean cashWithdrawal(int amount, String cardNum) {
        for (BaseCard card : Statics.customerAccounts.get(Statics.loginId).cards[0]) {
            if (cardNum.equals(card.getCardNum())) {
                if (card.getBalance() >= amount) {
                    card.setBalance(card.getBalance() - amount);
                    System.out.println("Kartınızdan " + amount + " TL çekildi");
                    transactions.add(cardNum + " numaralı kartınızdan " + amount + " TL çekildi");
                    return true;
                } else {
                    System.out.println("Hesabınızda yeterli tutar bulunamadı...");
                }

            }
        }
        for (BaseCard card : Statics.customerAccounts.get(Statics.loginId).cards[1]) {
            if (cardNum.equals(card.getCardNum())) {
                if (card.getAvailableLimit() >= amount) {
                    card.setAvailableLimit(card.getAvailableLimit() - amount);
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

    public boolean payOffCreditCardDebt(int amount, String cardNum) {
        for (BaseCard card : Statics.customerAccounts.get(Statics.loginId).cards[1]) {
            if (cardNum.equals(card.getCardNum())) {
                if (card.getDebit() == 0) {
                    System.out.println("Kredi kartınızın borcu bulunmamaktadır...");
                    return false;
                } else if (-card.getDebit() >= amount) {
                    card.setDebit(card.getDebit() + amount);
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

    public boolean transfer(int amount, String cardNum, String cardIBAN) {
        int control=0;
        for (BaseCard card : Statics.customerAccounts.get(Statics.loginId).cards[0]) {
            if (cardNum.equals(card.getCardNum())) {
                control++;
                for (int i=0;i<Statics.customerAccounts.size();i++)
                for (BaseCard card2 : Statics.customerAccounts.get(i).cards[0]) {
                    if (cardIBAN.equals(card2.getIBAN())) {
                        control++;
                        if (card.getBalance() >= amount) {
                            card.setBalance(card.getBalance() - amount);
                            System.out.println("Kartınızdan " + amount + " TL gönderildi");
                            transactions.add(cardNum + " numaralı kartınızdan " + cardIBAN + " iban numaralı karta " + amount + " TL gönderildi");
                            card2.setBalance(card2.getBalance() + amount);
                            Statics.transactions.get(card2.getCustomerId()).transactions.add(
                                    card.getCardNum() + " numaralı karttan " + card2.getCardNum() + " numaralı kartınıza " + amount + " TL gönderildi");
                            return true;
                        } else {
                            System.out.println("Kartınızda yeterli miktar bulunamadı...");
                            return false;
                        }
                    }
                }
            }
        }
        if (control==1) {
            System.out.println("Kart numarası doğru iban yanlış...");
            return false;
        }
        else if (control==2) {
            System.out.println("ikisi de doğru");
            return true;
        } else {
            System.out.println("Kart numarası ve iban yanlış...");
            return false;
        }
    }
}
