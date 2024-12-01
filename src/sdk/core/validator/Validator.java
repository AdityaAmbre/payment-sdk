// Validator

package sdk.core.validator;

public class Validator {
    private Validator() {}

    public static boolean validateCardNumber(String cardNumber) {
        boolean isValidCardNumber = false;

        if (cardNumber != null ) {
            if (!cardNumber.trim().isEmpty()) {
                if (cardNumber.length() > 0 && cardNumber.length() == 16) {
                    isValidCardNumber = true;
                }   
            }
        }

        return isValidCardNumber;
    }

    public static boolean validateExpDate(String expDate) {
        boolean isValidExpDate = false;

        if (expDate != null ) {
            if (!expDate.trim().isEmpty()) {
                if (expDate.length() > 0 && expDate.length() == 5) {
                    isValidExpDate = true;
                }   
            }
        }

        return isValidExpDate;
    }

    public static boolean validateCvv(String cvv) {
        boolean isValidCVV = false;

        if (cvv != null ) {
            if (!cvv.trim().isEmpty()) {
                if (cvv.length() > 0 && cvv.length() == 3) {
                    isValidCVV = true;
                }   
            }
        }

        return isValidCVV;
    }

    public static boolean validateAccountHolder(String accountHolder) {
        boolean isValidAccountHolder = false;

        if (accountHolder != null ) {
            if (!accountHolder.trim().isEmpty()) {
                if (accountHolder.length() > 0 && accountHolder.length() <= 40) {
                    isValidAccountHolder = true;
                }
            }
        }

        return isValidAccountHolder;
    }

    public static boolean validateBankAccountNo(String bankAccountNo) {
        boolean isValidBankAccountNo = false;

        if (bankAccountNo != null ) {
            if (!bankAccountNo.trim().isEmpty()) {
                if (bankAccountNo.length() > 0 && bankAccountNo.length() <= 20) {
                    isValidBankAccountNo = true;
                }
            }
        }

        return isValidBankAccountNo;
    }

    public static boolean validateIfscCode(String ifscCode) {
        boolean isValidIfscCode = false;
        
        if (ifscCode != null ) {
            if (!ifscCode.trim().isEmpty()) {
                if (ifscCode.length() > 0 && ifscCode.length() == 11) {
                    isValidIfscCode = true;
                }
            }
        }
        
        return isValidIfscCode;
    }
}