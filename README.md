# Fawry-Intern-Task

## Assumtions
The ecommerce system only deals with:
- Tech Products that are shipable but cannot expire
- Food Products that are both shippable and expirable
- Digital products like promo codes that is neither expirable or shippable.



## Test Cases

### 1. Successful Checkout
![Successful Checkout](./test_outputs/test%201%20no%20errors.png)  
Explanation: This is the normal case in the main class given.

### 2. Expired Product Handling
![Expired Product](./test_outputs/test%202%20expired.png)  
**Input**: ![Test 2 Input](./test_outputs/test%202%20input.png)  
Explanation: The item is not added, and an Error is given, and the rest of the order is processed.

### 3. Insufficient Balance
![Insufficient Balance](./test_outputs/test%203%20insufficient%20balance.png)  
**Input**: ![Test 3 Input](./test_outputs/test%203%20input.png)  
Explanation: Nothing is processed, and an Error is given.


### 4. Empty Cart 
![Empty Cart](./test_outputs/test%204%20empty%20cart.png)  
**Input**: ![Test 4 Input](./test_outputs/test%204%20input.png)  
