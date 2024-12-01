// Payment SDK Configuration

package sdk.client.example;

import sdk.PaymentSDK;
import sdk.client.base.PaymentRequirement;
import sdk.client.base.TransactionResult;
import sdk.client.model.CardRequirement;
import sdk.client.model.NetBankingRequirement;
import sdk.client.model.PaymentMode;
import sdk.core.delegate.PaymentDelegate;
import sdk.core.utility.Utility;

public class SdkConfiguration {
    private PaymentMode paymentMode;
    private PaymentRequirement paymentRequirement;
    private final PaymentDelegate paymentDelegate;
    private static SdkConfiguration instance;
    private double amount;

    private SdkConfiguration() {
        paymentDelegate = PaymentSDK.getInstance().init();
    }

    public static SdkConfiguration getInstance() {
        if (instance == null) {
            instance = new SdkConfiguration();
        }
        
        return instance;
    }

    public void init() {
        System.out.println();
        paymentMode = getPaymentMode();
        System.out.println();
        paymentRequirement = getRequirements(paymentMode);
        System.out.println();
        initiatePayment(paymentMode, paymentRequirement);
        System.out.println();
    }

    // Setup Payment Mode
    private PaymentMode getPaymentMode() {
        int option = Utility.getUserInputInt("Please choose your mode of Payment:\n1. Debit Card\n2. Credit Card\n3. Net Banking\n\n> ");
        switch (option) {
            case 1: return PaymentMode.DEBIT_CARD;
            case 2: return PaymentMode.CREDIT_CARD;
            case 3: return PaymentMode.NET_BANKING;
            default: throw new AssertionError();
        }
    }

    // Setup Payment Requirements
    private PaymentRequirement getRequirements(PaymentMode mode) {
        switch (mode) {
            case DEBIT_CARD -> {
                String cardNumber,expDate, cvv;
                System.out.print("Enter below Debit Card requirements:");
                cardNumber = Utility.getUserInputString("\n- Card Number: ");
                expDate = Utility.getUserInputString("\n- Exp Date: ");
                cvv = Utility.getUserInputString("\n- CVV: ");
                amount = Utility.getUserInputInt("\n- Amount: ");
                PaymentRequirement requirement = new CardRequirement(cardNumber, expDate, cvv);

                return requirement;
            }
            case CREDIT_CARD -> {
                String cardNumber, expDate, cvv;
                System.out.print("Enter below Credit Card requirements:");
                cardNumber = Utility.getUserInputString("\n- Card Number: ");
                expDate = Utility.getUserInputString("\n- Exp Date: ");
                cvv = Utility.getUserInputString("\n- CVV: ");
                amount = Utility.getUserInputInt("\n- Amount: ");
                PaymentRequirement requirement = new CardRequirement(cardNumber, expDate, cvv);

                return requirement;
            }
            case NET_BANKING -> {
                String accountHolder, bankAccountNo, ifscCode;
                System.out.print("Enter below Net Banking requirements:");
                accountHolder = Utility.getUserInputString("\n- Account Holder: ");
                bankAccountNo = Utility.getUserInputString("\n- Account No.: ");
                ifscCode = Utility.getUserInputString("\n- IFSC Code: ");
                amount = Utility.getUserInputInt("\n- Amount: ");
                PaymentRequirement requirement = new NetBankingRequirement(accountHolder, bankAccountNo, ifscCode);
                
                return requirement;
            }
            default -> throw new IllegalArgumentException("Please select a valid Payment mode.");
        }
    }

    // Initiate Payment SDK Transaction
    private void initiatePayment(PaymentMode paymentMode, PaymentRequirement paymentRequirement) {
        paymentDelegate.initialise(paymentMode, paymentRequirement).pay(amount).onResult(new TransactionResult() {
            @Override
            public void onSuccess(String msg) {
                System.out.println(msg);
            }
            
            @Override
            public void onFailure(String msg) {
                System.out.println(msg);
            }
        });
    }
}