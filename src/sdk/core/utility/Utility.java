// Utility

package sdk.core.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility {
    private Utility() {}

    public static String generateTransactionID() {
        String transactionID;
        String prefix = "TID";
        Random random = new Random();

        int numberPart = random.nextInt(9000) + 1000;
        char letter1 = (char) ('A' + random.nextInt(26));
        char letter2 = (char) ('A' + random.nextInt(26));
        transactionID = prefix + numberPart + letter1 + letter2;

        return transactionID;
    }

    public static String generateCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        return timestamp;
    }
}