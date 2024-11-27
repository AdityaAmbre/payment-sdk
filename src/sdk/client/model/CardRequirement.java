// Card Requirement Model

package sdk.client.model;

import sdk.client.base.*;
import sdk.core.utility.*;

public class CardRequirement implements PaymentRequirement {
    private final String cardNumber;
    private final String expDate;
    private final String cvv;
    private final String transactionId;
    private final String transactionDate;

    public CardRequirement(String cardNumber, String expDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.transactionId = Utility.generateTransactionID();
        this.transactionDate = Utility.generateCurrentTimestamp();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpDate() {
        return expDate;
    }

    public String getCvv() {
        return cvv;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String getTransactionDate() {
        return transactionDate;
    }
}