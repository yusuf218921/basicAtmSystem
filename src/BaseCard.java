public abstract class BaseCard {
    private String cardNum;
    private String cardExpiryDate = "";
    private final int cardCVV;
    private String IBAN;
    private int customerId = Statics.loginId;

    public int getCustomerId() {
        return customerId;
    }

    //Constructor
    public BaseCard() {
        int last4CardNum = (int) (Math.random() * (9999 - 1000)) + (1000);
        cardNum = "4345 0000 0000 ";
        cardNum += String.valueOf(last4CardNum);
        cardCVV = (int) (Math.random() * (999 - 100)) + (100);
        IBAN = "TR ";
        long ibanNum = (long) (Math.random() * (9_999_999_999_999_999L - 1_000_000_000_000_000L)) + (1_000_000_000_000_000L);
        IBAN += String.valueOf(ibanNum);
        int month = (int) (Math.random() * (12 - 1)) + (1);
        int day = (int) (Math.random() * (30 - 1)) + (1);
        int year = (int) (Math.random() * (2030 - 2027)) + (2027);
        cardExpiryDate += "" + day + "/" + month + "/" + year;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getCardExpiryDate() {
        return cardExpiryDate;
    }

    public int getCardCVV() {
        return cardCVV;
    }

    public String getIBAN() {
        return IBAN;
    }

    public abstract void list();

    public abstract void setBalance(int balance);

    public abstract int getBalance();

    public abstract int getDebit();


    public abstract void setDebit(int debit);

    public abstract int getAvailableLimit();

    public abstract void setAvailableLimit(int availableLimit);
}
