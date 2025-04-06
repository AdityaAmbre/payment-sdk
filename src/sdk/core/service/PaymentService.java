// Payment Service

package sdk.core.service;

import java.util.HashMap;
import java.util.Map;

import sdk.client.base.*;
import sdk.client.model.*;

import sdk.core.base.*;
import sdk.core.constant.*;
import sdk.core.validator.*;

public class PaymentService {
    private String status;
    private String message;
    private final Map<String, String> result = new HashMap<>();

    public PaymentService() {}

    // Debit Card Implementation
    private class DebitCard implements Payment {
        private final CardRequirement cardRequirement;

        public DebitCard(PaymentRequirement paymentRequirement) {
            if (paymentRequirement instanceof CardRequirement) {
                this.cardRequirement = (CardRequirement) paymentRequirement;
            } else {
                throw new IllegalArgumentException("Expected CardRequirement but got: " + paymentRequirement.getClass().getName());
            }
        }

        private boolean validateRequirements() {
            boolean isValidCardNumber = Validator.validateCardNumber(cardRequirement.getCardNumber());
            boolean isValidExpDate = Validator.validateExpDate(cardRequirement.getExpDate());
            boolean isValidCvv = Validator.validateCvv(cardRequirement.getCvv());

            return isValidCardNumber && isValidExpDate && isValidCvv;
        }

        @Override
        public Map<String, String> pay(double amount) {
            if (validateRequirements()) {
                status = Constant.SUCCESS;
                message = "Payment of Rs. " + amount + " with Transaction ID: " + cardRequirement.getTransactionId() + " was successful using Debit Card on " + cardRequirement.getTransactionDate() + ". Thank You!";

                result.put(status, message);
            } else {
                status = Constant.FAILURE;
                message = "Payment of Rs. " + amount + " was unsuccessful using Debit Card on " + cardRequirement.getTransactionDate() + ". Please Re-try!";

                result.put(status, message);
            }

            return result;
        }
    }

    // Credit Card Implementation
    private class CreditCard implements Payment {
        private final CardRequirement cardRequirement;

        public CreditCard(PaymentRequirement paymentRequirement) {
            if (paymentRequirement instanceof CardRequirement) {
                this.cardRequirement = (CardRequirement) paymentRequirement;
            } else {
                throw new IllegalArgumentException("Expected CardRequirement but got: " + paymentRequirement.getClass().getName());
            }
        }


        private boolean validateRequirements() {
            boolean isValidCardNumber = Validator.validateCardNumber(cardRequirement.getCardNumber());
            boolean isValidExpDate = Validator.validateExpDate(cardRequirement.getExpDate());
            boolean isValidCvv = Validator.validateCvv(cardRequirement.getCvv());

            return isValidCardNumber && isValidExpDate && isValidCvv;
        }


        @Override
        public Map<String, String> pay(double amount) {
            if (validateRequirements()) {
                status = Constant.SUCCESS;
                message = "Payment of Rs. " + amount + " with Transaction ID: " + cardRequirement.getTransactionId() + " was successful using Credit Card on " + cardRequirement.getTransactionDate() + ". Thank You!";

                result.put(status, message);
            } else {
                status = Constant.FAILURE;
                message = "Payment of Rs. " + amount + " was unsuccessful using Credit Card on " + cardRequirement.getTransactionDate() + ". Please Re-try!";

                result.put(status, message);
            }

            return result;
        }
    }

    // Net Banking Implementation
    private class NetBanking implements Payment {
        private final NetBankingRequirement netBankingRequirement;

        public NetBanking(PaymentRequirement paymentRequirement) {
            if (paymentRequirement instanceof NetBankingRequirement) {
                this.netBankingRequirement = (NetBankingRequirement) paymentRequirement;
            } else {
                throw new IllegalArgumentException("Expected NetBankingRequirement but got: " + paymentRequirement.getClass().getName());
            }
        }

        private boolean validateRequirements() {
            boolean isValidAccountHolder = Validator.validateAccountHolder(netBankingRequirement.getAccountHolder());
            boolean isValidBankAccountNo = Validator.validateBankAccountNo(netBankingRequirement.getBankAccountNo());
            boolean isValidIfsc = Validator.validateIfscCode(netBankingRequirement.getIfscCode());

            return isValidAccountHolder && isValidBankAccountNo && isValidIfsc;
        }

        @Override
        public Map<String, String> pay(double amount) {
            if (validateRequirements()) {
                status = Constant.SUCCESS;
                message = "Payment of Rs. " + amount + " with Transaction ID: " + netBankingRequirement.getTransactionId() + " was successful using Net Banking on " + netBankingRequirement.getTransactionDate() + ". Thank You!";

                result.put(status, message);
            } else {
                status = Constant.FAILURE;
                message = "Payment of Rs. " + amount + " was unsuccessful using Net Banking on " + netBankingRequirement.getTransactionDate() + ". Please Re-try!";

                result.put(status, message);
            }

            return result;
        }
    }

    @SuppressWarnings("ClassEscapesDefinedScope")
    public DebitCard payUsingDebitCard(PaymentRequirement paymentRequirement) {
        return new DebitCard(paymentRequirement);
    }

    @SuppressWarnings("ClassEscapesDefinedScope")
    public CreditCard payUsingCreditCard(PaymentRequirement paymentRequirement) {
        return new CreditCard(paymentRequirement);
    }


    @SuppressWarnings("ClassEscapesDefinedScope")
    public NetBanking payUsingNetBanking(PaymentRequirement paymentRequirement) {
        return new NetBanking(paymentRequirement);
    }
}