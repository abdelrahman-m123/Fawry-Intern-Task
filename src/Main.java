import java.time.LocalDate;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        LocalDate manufactureDate = LocalDate.of(2023, 10, 1);
        LocalDate expirationDate = LocalDate.of(2023, 12, 1);
        FoodProduct foodProduct = new FoodProduct(1, "Apple", 1.50, 50,  manufactureDate , expirationDate, 150);

        TechProduct techProduct = new TechProduct(2, "Smartphone", 800.00, 500, 200);
        techProduct.setQuantity(10);

        DigitalProduct digitalProduct = new DigitalProduct(3, "Scratch card", 15.00, 2);
        digitalProduct.setQuantity(100);


        Customer customer = new Customer(1, "John Doe", "john.doe@example.com", "123 St", 5000);


        Cart cart = new Cart();
        cart.addProduct(foodProduct, 5);
        cart.addProduct(techProduct, 1);
        cart.addProduct(digitalProduct, 2);
        Checkout checkout = new Checkout(customer, cart);

    }
}