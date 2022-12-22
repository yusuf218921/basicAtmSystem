public class ATMCard extends BaseCard {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public void list() {
        System.out.println("Kart Numarası : " + getCardNum());
        System.out.println("Son Kullanma Tarihi : " + getCardExpiryDate());
        System.out.println("CVV : " + getCardCVV());
        System.out.println("Bakiye : " + balance);
    }
}
