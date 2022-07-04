# Coffee_shop_management

Design classes having attributes and methods (only skeleton) for a coffee shop. There are three different actors in  
our scenario and I have listed the different actions they do also below

* Customer
  - Pays the cash to the cashier and places his order, get a token number back
  - Waits for the intimation that order for his token is ready
  - Upon intimation/notification he collects the coffee and enjoys his drink
  ( Assumption:  Customer waits till the coffee is done, he won’t timeout and cancel the order. 
  The customer always likes the drink served. Exceptions like he not liking his coffee, he got 
  wrong coffee are not considered to keep the design simple.)

* Cashier
  - Takes order and payment from the customer
  - Upon payment, creates an order and places it into the order queue
  - Intimates the customer that he has to wait for his token and gives him his token
  ( Assumption: Token returned to the customer is the order id. Order queue is unlimited. With 
  a simple modification, we can design for a limited queue size)

* Barista
 - Gets the next order from the queue
 - Prepares the coffee
 - Places the coffee in the completed order queue
 - Places a notification that order for token is ready
 
 ![image](https://user-images.githubusercontent.com/46570973/177171634-5fb8d7bd-6ac6-4393-89c9-b9e68a52933a.png)
