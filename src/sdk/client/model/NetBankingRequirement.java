// Net Banking Requirement Model

package sdk.client.model;

import sdk.client.base.*;
import sdk.core.utility.*;

public class NetBankingRequirement implements PaymentRequirement {
    private final String accountHolder;
    private final String bankAccountNo;
    private final String ifscCode;

    private final String transactionId;
    private final String transactionDate;

    public NetBankingRequirement(String accountHolder, String bankAccountNo, String ifscCode) {
        this.accountHolder = accountHolder;
        this.bankAccountNo = bankAccountNo;
        this.ifscCode = ifscCode;
        this.transactionId = Utility.generateTransactionID();
        this.transactionDate = Utility.generateCurrentTimestamp();
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public String getIfscCode() {
        return ifscCode;
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