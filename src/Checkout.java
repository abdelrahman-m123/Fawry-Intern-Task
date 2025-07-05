import java.util.HashMap;
import java.util.Map;

public class Checkout {
    private Customer customer;
    private Cart cart;
    private double totalamount;
    private Map<Product, Integer> toBeShipped = new HashMap<>();


    public Checkout(Customer customer, Cart cart){
        this.customer = customer;
        this.cart = cart;
        this.totalamount = cart.getTotalPrice() + (cart.getTotalWeight() * 0.1);
        if (customer.getBalance()< totalamount){
            System.out.println("ERROR: Insufficient balance for checkout " + customer.getBalance() + " is not enough to pay " + totalamount);
            return;
        }
        if (cart.isEmpty()){
            System.out.println("ERROR: Cart is empty. Please add items to the cart before checking out.");
            return;
        }

        printShippingNotice();
        printReceipt();
    }

    public void printShippingNotice(){
        if(cart.getTotalWeight() != 0){
            System.out.println("** shipping notice **");
            for (Product key : cart.getProducts().keySet()) {
                if (key instanceof Shippable) {
                    Integer value = cart.getProducts().get(key);
                    System.out.println(value + "x " + key.getName()+ calculateSpaces(value + "x " + key.getName()  + printWeight(((Shippable)key).getWeight() * value))  + printWeight(((Shippable)key).getWeight() * value));
                    toBeShipped.put(key, value);
                }

            }
            System.out.println("Total weight: "+ calculateSpaces("Total weight: " + printWeight(cart.getTotalWeight())) + printWeight(cart.getTotalWeight()));
        }
    }

    public String printWeight(double weight){
        if (weight < 1000) {
            return weight + "g";


        }else{
            double weightInKg = weight / 1000;
            return weightInKg + "kg";
        }

    }

    public void printReceipt() {
        System.out.println();

        if (cart.getProducts().size() > 0) {
            System.out.println("** Checkout reciept **");
            for (Product key : cart.getProducts().keySet()) {

                Integer value = cart.getProducts().get(key);
                System.out.println(value + "x " + key.getName() + calculateSpaces(value + "x " + key.getName()  + key.getPrice() * value)+ key.getPrice() * value);


            }
            System.out.println("----------------------");
            System.out.println("SubTotal" + calculateSpaces("Subtotal" +cart.getTotalPrice()) +cart.getTotalPrice());
            System.out.println("Shipping" + calculateSpaces("Shipping" + cart.getTotalWeight() * 0.1)+ cart.getTotalWeight() * 0.1);
            System.out.println("Amount"+ calculateSpaces("Amount"+ (cart.getTotalPrice() + (cart.getTotalWeight() * 0.1)))+ (cart.getTotalPrice() + (cart.getTotalWeight() * 0.1)));

        }
    }

    public String calculateSpaces(String Text){
        int spaces = 22 - Text.length();
        String x = "";
        for (int i = 0; i < spaces; i++) {
            x += " ";
        }
        return x ;
    }

    public Customer getCustomer() {
        return customer;
    }
    public Cart getCart() {
        return cart;
    }
    public double getTotalamount() {
        return totalamount;
    }
    public Map<Product, Integer> getToBeShipped() {
        return toBeShipped;

    }
}
