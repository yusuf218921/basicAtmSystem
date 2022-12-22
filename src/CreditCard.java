public class CreditCard extends BaseCard {
    private int debit = 0;
    private int availableLimit;

    public CreditCard(int limit) {
        this.availableLimit = limit;
    }

    public int getDebit() {
        return debit;
    }

    public void setDebit(int debit) {
        this.debit = debit;
        this.availableLimit -= debit;
    }

    public int getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(int amount) {
        this.availableLimit = amount;
        this.debit -= amount;
    }

    @Override
    public void list() {
        System.out.println("Kart Numarası : " + getCardNum());
        System.out.println("Son Kullanma Tarihi : " + getCardExpiryDate());
        System.out.println("CVV : " + getCardCVV());
        System.out.println("Kullanılabilir Limit : " + availableLimit);
        System.out.println("Kalan Borç : " + debit);
    }
}
