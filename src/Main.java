import java.time.LocalDate;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        TechProduct smartphone = new TechProduct(2, "Smartphone", 800.00, 500, 200);
        smartphone.setQuantity(10);

        DigitalProduct scratchCard = new DigitalProduct(3, "Scratch card", 15.00, 2);
        scratchCard.setQuantity(100);




        LocalDate manufactureDate = LocalDate.of(2023, 10, 1);
        LocalDate expirationDate = LocalDate.of(2025, 12, 1);
        FoodProduct apple = new FoodProduct(1, "Apple", 1.50, 50,  manufactureDate , expirationDate, 150);

        Customer customer = new Customer(1, "John Doe", "john.doe@example.com", "123 St", 0);
        Cart cart = new Cart();
        cart.addProduct(apple, 5);
        cart.addProduct(smartphone, 1);
        cart.addProduct(scratchCard, 2);
        Checkout checkout = new Checkout(customer, cart);

    }
}