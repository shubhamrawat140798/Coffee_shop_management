/*
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
*/
import java.util.LinkedList;
import java.util.Queue;
public class Main {
 public static void main(String[] args) {
     System.out.println("\nCompile by Shubham Singh Rawat");
     Customer customer = new Customer();
     Customer customer2 = new Customer();
     Customer customer3 = new Customer();
    
     customer.addMoney(100);
     customer.balance();
     customer.placeOrder();
     customer.displayPreparedOrderTokken();
    
     customer2.addMoney(70);
     customer2.balance();
     customer2.placeOrder();
     customer2.displayPreparedOrderTokken();
    
     customer3.addMoney(180);
     customer3.balance();
     customer3.placeOrder();
     customer3.displayPreparedOrderTokken();
    
    }   
}
class Customer{
    int cash=0;
    Cashier c1 = new Cashier();
    Barista barista1 = new Barista();
    void addMoney(int n){
        cash = n;
    }

    void deductedAmount(int n){
        cash =n;
        balance();
    }

    void balance(){
        System.out.println("Your Balance is: "+cash);
    }
    
    void placeOrder(){
       System.out.println( c1.placeOrderRequest(cash,this));
    }
    void displayPreparedOrderTokken(){
        System.out.println(""+barista1.coffeePrepared());
    }
    
}
class Cashier{
    int minOrderPrice=80;
    Barista barista = new Barista();
    String placeOrderRequest(int cash, Customer customer){
        String res = "demo";
        System.out.println("Coffee price: Rs. 80/-");
        if(cash >= minOrderPrice){
            cash-=minOrderPrice;
            customer.deductedAmount(cash);
           res="Your tokken no: "+ barista.addInQueue(customer)+"\n";

        }
        else
            res="funds is not sufficient";
        return res;
    }

}
class Barista{
    static  Queue<Customer> q = new LinkedList<>();
    static  Queue<Integer> tokken = new LinkedList<>();
    static int tokenSeq =1;
    int addInQueue(Customer customer){
        q.add(customer);
        tokken.add(tokenSeq);
        return tokenSeq++;
    }
    
    String coffeePrepared(){
        String res;
        if(!tokken.isEmpty()){
            int result;
            result=tokken.remove();
            q.remove();
            res= "Tokken No. "+result+" Prepared";
            
        }
        else
         res="All tokkens are processed";
        return res; 
        
    }
}
