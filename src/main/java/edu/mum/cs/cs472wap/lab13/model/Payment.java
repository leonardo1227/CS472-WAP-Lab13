package edu.mum.cs.cs472wap.lab13.model;

public class Payment {

    private String cardNumber;
    private String cardDueDate;
    private String cardCVC;
    private String cardHolderName;
    private String cardType;

    public Payment(String cardNumber, String cardDueDate, String cardCVC, String cardHolderName, String cardType) {
        this.cardNumber = cardNumber;
        this.cardDueDate = cardDueDate;
        this.cardCVC = cardCVC;
        this.cardHolderName = cardHolderName;
        this.cardType = cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardDueDate() {
        return cardDueDate;
    }

    public void setCardDueDate(String cardDueDate) {
        this.cardDueDate = cardDueDate;
    }

    public String getCardCVC() {
        return cardCVC;
    }

    public void setCardCVC(String cardCVC) {
        this.cardCVC = cardCVC;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }
}
