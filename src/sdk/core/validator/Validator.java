// Validator

package sdk.core.validator;

public class Validator {
    private Validator() {}

    public static boolean validateCardNumber(String cardNumber) {
        boolean isValidCardNumber = false;
        if (cardNumber != null || cardNumber != "") {
            if (cardNumber.length() > 0 && cardNumber.length() == 16) {
                isValidCardNumber = true;
            }
        }
        return isValidCardNumber;
    }

    public static boolean validateExpDate(String expDate) {
        boolean isValidExpDate = false;
        if (expDate != null || expDate != "") {
            if (expDate.length() > 0 && expDate.length() == 5) {
                isValidExpDate = true;
            }
        }
        return isValidExpDate;
    }

    public static boolean validateCvv(String cvv) {
        boolean isValidCVV = false;
        if (cvv != null || cvv != "") {
            if (cvv.length() > 0 && cvv.length() == 3) {
                isValidCVV = true;
            }
        }
        return isValidCVV;
    }

    public static boolean validateAccountHolder(String accountHolder) {
        boolean isValidAccountHolder = false;
        if (accountHolder != null || accountHolder != "") {
            if (accountHolder.length() > 0 && accountHolder.length() <= 40) {
                isValidAccountHolder = true;
            }
        }
        return isValidAccountHolder;
    }

    public static boolean validateBankAccountNo(String bankAccountNo) {
        boolean isValidBankAccountNo = false;
        if (bankAccountNo != null || bankAccountNo != "") {
            if (bankAccountNo.length() > 0 && bankAccountNo.length() <= 20) {
                isValidBankAccountNo = true;
            }
        }
        return isValidBankAccountNo;
    }

    public static boolean validateIfscCode(String ifscCode) {
        boolean isValidIfscCode = false;
        if (ifscCode != null || ifscCode != "") {
            if (ifscCode.length() > 0 && ifscCode.length() == 11) {
                isValidIfscCode = true;
            }
        }
        return isValidIfscCode;
    }
}