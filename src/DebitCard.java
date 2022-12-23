public class DebitCard extends BaseCard {
    private int balance;

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int getDebit() {return 0;}

    @Override
    public void setDebit(int debit) {}

    @Override
    public int getAvailableLimit() {return 0;}

    @Override
    public void setAvailableLimit(int availableLimit) {}

    @Override
    public void list() {
        System.out.println("Kart Numarası : " + getCardNum());
        System.out.println("Son Kullanma Tarihi : " + getCardExpiryDate());
        System.out.println("CVV : " + getCardCVV());
        System.out.println("Bakiye : " + balance);
        System.out.println("IBAN : " + getIBAN());
    }
}
