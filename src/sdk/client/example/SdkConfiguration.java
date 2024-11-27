// Payment SDK Configuration

package sdk.client.example;

import java.util.*;
import sdk.*;
import sdk.client.base.*;
import sdk.client.model.*;
import sdk.core.delegate.*;

public class SdkConfiguration {
    private PaymentMode paymentMode;
    private PaymentRequirement paymentRequirement;
    private final PaymentDelegate paymentDelegate;
    private static SdkConfiguration instance;

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

    private PaymentMode getPaymentMode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please choose your mode of Payment:\n1. Debit Card\n2. Credit Card\n3. Net Banking\n\n> ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                return PaymentMode.DEBIT_CARD;
            case 2:
                return PaymentMode.CREDIT_CARD;
            case 3:
                return PaymentMode.NET_BANKING;
            default:
                throw new AssertionError();
        }
    }

    private PaymentRequirement getRequirements(PaymentMode mode) {
        Scanner sc = new Scanner(System.in);
        switch (mode) {
            case DEBIT_CARD -> {
                String cardNumber;
                String expDate;
                String cvv;
                System.out.print("Enter below Debit card requirements:");
                System.out.print("\n- Card Number: ");
                cardNumber = sc.nextLine();
                System.out.print("- Exp Date: ");
                expDate = sc.nextLine();
                System.out.print("- CVV: ");
                cvv = sc.nextLine();
                PaymentRequirement requirement = new CardRequirement(cardNumber, expDate, cvv);

                return requirement;
            }
            case CREDIT_CARD -> {
                String cardNumber;
                String expDate;
                String cvv;
                System.out.print("Enter below Credit card requirements:");
                System.out.print("\n- Card Number: ");
                cardNumber = sc.nextLine();
                System.out.print("- Exp Date: ");
                expDate = sc.nextLine();
                System.out.print("- CVV: ");
                cvv = sc.nextLine();
                PaymentRequirement requirement = new CardRequirement(cardNumber, expDate, cvv);

                return requirement;
            }
            case NET_BANKING -> {
                String accountHolder;
                String bankAccountNo;
                String ifscCode;
                System.out.print("Enter below Net Banking requirements:");
                System.out.print("\n- Account Holder: ");
                accountHolder = sc.nextLine();
                System.out.print("- Account No.: ");
                bankAccountNo = sc.nextLine();
                System.out.print("- IFSC Code: ");
                ifscCode = sc.nextLine();
                PaymentRequirement requirement = new NetBankingRequirement(accountHolder, bankAccountNo, ifscCode);
                
                return requirement;
            }
            default -> throw new IllegalArgumentException("Please select a valid Payment mode.");
        }
    }

    private void initiatePayment(PaymentMode paymentMode, PaymentRequirement paymentRequirement) {
        paymentDelegate.initialise(paymentMode, paymentRequirement).pay(245.67).onResult(new TransactionResult() {
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