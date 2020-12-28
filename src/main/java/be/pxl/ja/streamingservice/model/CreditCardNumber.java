package be.pxl.ja.streamingservice.model;

public class CreditCardNumber {
    private static final int LENGTH = 16;
    private static final int CVC_LENGTH = 3;
    private CreditCardType type;
    private String number;
    private String cvc;

    public CreditCardNumber(String number, String cvc) {
        this.number = number;
        this.cvc = cvc;
    }

    public CreditCardType getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String getCvc() {
        return cvc;
    }

    public String removeBlanks(String text) {
        return text.replaceAll("\\s", "");
    }

    public boolean isNumeric(String text) {
        if (text == null || text.length() == 0) {
            return false;
        }
        try {
            Long.parseLong(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public CreditCardType getCreditCardType(String text) {
        for (CreditCardType cardType : CreditCardType.values()) {
            if (cardType.getFirstNumber() == Integer.parseInt(number.substring(0, 1))) {
                return cardType;
            }
        }
        return null;
    }
}
