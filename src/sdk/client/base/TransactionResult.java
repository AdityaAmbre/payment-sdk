// Transaction Result Interface

package sdk.client.base;

public interface TransactionResult {
    public void onSuccess(String message);
    public void onFailure(String message);
}