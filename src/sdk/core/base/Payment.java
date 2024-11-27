// Payment Interface

package sdk.core.base;

import java.util.Map;

public interface Payment {
    public Map<String, String> pay(double amount);
}