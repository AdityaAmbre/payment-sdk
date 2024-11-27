// Payment SDK

package sdk;

import sdk.core.delegate.*;

public class PaymentSDK {
    private static PaymentSDK instance;

    private PaymentSDK() {
        System.out.println("Payment SDK Initiated!");
    }

    public static PaymentSDK getInstance() {
        if (instance == null) {
            instance = new PaymentSDK();
        }

        return instance;
    }

    public PaymentDelegate init() {
        return new PaymentDelegate();
    }
}