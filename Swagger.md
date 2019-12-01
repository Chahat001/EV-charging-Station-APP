##Scenario: Add credit/debit card 
##Mockup : #18-Payment page

```bash
POST https://localhost:8080/api/v1/payment-method 
Request
{
“userId”: 123,
“cardNumber”: 1234 5678 456,
“expiryYear”: 2020,
“expiryMonth”: “Dec”, 
 “nameOnCard”: “Kumar Swamy”
}
Response
Success response
{
“success”: “true”,
 “message”: ”Added successfully”
}
Fail response
{
“success”: “false”,
“message”: “Failed creating payment method. Please try after some time”
}
```

##Scenario: Get single card details
##Mockup: TBA

```bash
GET https://localhost:8080/api/v1/payment-method/{paymentMethodId}
Response:
Success Response:
{
“paymentMethodId”: 444123, 
 “userId”: 123,
“cardNumber”: 1234 5678 456,
“expiryYear”: 2020,
“expiryMonth”: “Dec”, 
 “nameOnCard”: “Kumar Swamy”
}
Fail response
{
“success”: “false”,
“message”: “Failed fetching card details. Please try after some time”
}
```

##Scenario: Get multiple card details 
Mockup: TBA

```bash
GET https://localhost:8080/api/v1/payment-methods/{userId}
Response:
Success Response:
{
“userId”: 123,
“paymentMethods”:
[{
“paymentMethodId”: 444123, 
 “cardNumber”: 1234 5678 456,
“expiryYear”: 2020,
“expiryMonth”: “Dec”, 
 “nameOnCard”: “Kumar Swamy”
},
{
“paymentMethodId”: 466366, 
 “cardNumber”: 5555 7575 5757,
“expiryYear”: 2021,
“expiryMonth”: “Dec”, 
 “nameOnCard”: “Amit Dandawate”
}]
}
Fail response
{
“success”: “false”,
“message”: “Failed fetching payment methods. Please try after some time”,
}
```
