package edu.mum.cs.cs472wap.lab13.model;

public class Payment {

    private String cardNumber;
    private String cardDueDate;
    private String cardCVC;
    private String cardNomeHolder;

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

    public String getCardNomeHolder() {
        return cardNomeHolder;
    }

    public void setCardNomeHolder(String cardNomeHolder) {
        this.cardNomeHolder = cardNomeHolder;
    }
}
