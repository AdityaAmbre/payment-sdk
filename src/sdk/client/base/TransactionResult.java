// Transaction Result Interface

package sdk.client.base;

public interface TransactionResult {
    void onSuccess(String message);
    void onFailure(String message);
}