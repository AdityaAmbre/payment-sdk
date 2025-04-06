// Payment Delegate

package sdk.core.delegate;

import java.util.HashMap;
import java.util.Map;

import sdk.client.base.*;
import sdk.client.model.*;

import sdk.core.base.*;
import sdk.core.constant.*;
import sdk.core.service.*;

public class PaymentDelegate {
    private final PaymentService paymentService;
    private PaymentProcessor paymentProcessor;
    private Map<String, String> result = new HashMap<>();

    public PaymentDelegate() {
        paymentService = new PaymentService();
    }

    public PaymentDelegate initialise(PaymentMode paymentMode, PaymentRequirement paymentRequirement) {
        Payment payment = getPaymentType(paymentMode, paymentRequirement);
        paymentProcessor = new PaymentProcessor(payment);

        return this;
    }

    public PaymentDelegate pay(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Please, enter a valid amount.");
        } else {
            result = paymentProcessor.pay(amount);

            return this;
        }
    }

    public void onResult(TransactionResult transactionResult) {
        String status = result.keySet().iterator().next();
        String message = result.values().iterator().next();

        if (status.equals(Constant.SUCCESS)) {
            transactionResult.onSuccess(message);
        } else {
            transactionResult.onFailure(message);
        }
    }

    @SuppressWarnings("InnerClassMayBeStatic")
    private class PaymentProcessor {
        public final Payment payment;

        public PaymentProcessor(Payment payment) {
            this.payment = payment;
        }

        public Map<String, String> pay(double amount) {
            return payment.pay(amount);
        }
    }

    private Payment getPaymentType(PaymentMode paymentMode, PaymentRequirement paymentRequirement) {
        return switch (paymentMode) {
            case DEBIT_CARD -> paymentService.payUsingDebitCard(paymentRequirement);
            case CREDIT_CARD -> paymentService.payUsingCreditCard(paymentRequirement);
            case NET_BANKING -> paymentService.payUsingNetBanking(paymentRequirement);
        };
    }
}