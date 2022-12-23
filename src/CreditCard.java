public class CreditCard extends BaseCard {
    private int debit = 0;
    private int availableLimit;

    public CreditCard(int limit) {
        this.availableLimit = limit;
    }

    @Override
    public int getDebit() {
        return debit;
    }

    @Override
    public void setDebit(int debit) {
        int availableLimit = debit - this.debit;
        this.debit = debit;
        this.availableLimit += availableLimit;
    }

    @Override
    public int getAvailableLimit() {
        return availableLimit;
    }

    @Override
    public void setAvailableLimit(int availableLimit) {
        int debit = this.availableLimit - availableLimit;
        this.availableLimit = availableLimit;
        this.debit -= debit;
    }

    @Override
    public void list() {
        System.out.println("Kart Numarası : " + getCardNum());
        System.out.println("Son Kullanma Tarihi : " + getCardExpiryDate());
        System.out.println("CVV : " + getCardCVV());
        System.out.println("Kullanılabilir Limit : " + availableLimit);
        System.out.println("Kalan Borç : " + debit);
        System.out.println("IBAN : " + getIBAN());
    }

    @Override
    public void setBalance(int balance) {
    }

    @Override
    public int getBalance() {
        return 0;
    }
}
