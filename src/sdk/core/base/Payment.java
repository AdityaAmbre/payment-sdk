// Payment Interface

package sdk.core.base;

import java.util.Map;

public interface Payment {
    Map<String, String> pay(double amount);
}