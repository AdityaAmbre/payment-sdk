# Payment SDK - JAVA

A demonstration of Payment SDK in JAVA

## Description

The 'PaymentSDK.jar' file provides you with the ability to make payment through the available payment modes in SDK.

## Integration

Include **PaymentSDK.jar** in your project lib/ folder & ensure that the lib/ folder's JAR is included in _settings.json_ configuration file.

- Add the *PaymentSDK.jar* file in your project _lib/_ folder
```
project/src/lib/PaymentSDK.jar
```

- Navigate to the _settings.json_ file located in .vscode/ folder
```
project/.vscode/settings.json
```

- Include the *.jar* files within in your project _lib/_ folder in _settings.json_
```json
{
    "java.project.sourcePaths": ["src"],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

## Configuration

#### Step 1 - Import necessary SDK packages
```java
 import sdk.PaymentSDK;
 import sdk.client.model.PaymentMode;
 import sdk.client.model.CardRequirement;
 import sdk.client.model.NetBankingRequirement;
 import sdk.client.base.TransactionResult;
 import sdk.client.base.PaymentRequirement;
 import sdk.core.delegate.PaymentDelegate;
```

#### Step 2 - Declare SDK references
```java
 PaymentMode paymentMode;
 PaymentDelgate paymentDelegate;
 PaymentRequirement paymentRequirement;
```

#### Step 3 - Setup Payment Mode & Payment Requirements according to the selected Mode of Payment
 - Debit Card:
 ```java
    paymentMode = PaymentMode.DEBIT_CARD
    paymentRequirement = new CardRequirement(cardNumber, expDate, cvv);
```
 - Credit Card:
 ```java
    paymentMode = PaymentMode.CREDIT_CARD
    paymentRequirement = new CardRequirement(cardNumber, expDate, cvv);
```
 - Net Banking:
 ```java
    paymentMode = PaymentMode.NET_BANKING
    paymentRequirement = new NetBankingRequirement(accountHolder, bankAccountNo, ifscCode);
```

#### Step 4 - Initialise Payment SDK
```java
 paymentDelegate = PaymentSDK.getInstance().init();
```

 #### Step 5 - Finally, Inject the Payment Mode & Payment Requirement with payable amount and Handle the callback of the SDK Transaction result accordingly!
```java
 paymentDelegate.initialise(paymentMode, paymentRequirement).pay(amount).onResult(new TransactionResult() {
    @Override
    onSuccess(String message) {
      // Hanlde success case scenario
      System.out.println(message);
    }

    @Override
    onFailure(String message) {
      // Hanlde failure case scenario
      System.out.println(message);
    }
 });
```

## Sample Configuration Example

#### Access the _**SdkConfiguration**_ class which demonstrate a sample code for _**PaymentSDK**_ Integration and usage
```java
 import sdk.client.example.SdkConfiguration;

 SdkConfiguration.getInstance().init();
```

## Author

- **Aditya Ambre**

## License

This project is licensed under the Apache-2.0 License - see the [LICENSE.md](LICENSE) file for details.

Copyrights © - 2024 Aditya Ambre. │ All Rights Reserved.