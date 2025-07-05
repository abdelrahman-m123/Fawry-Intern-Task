import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();
    private double totalPrice = 0.0;
    private int totalWeight = 0;

    public void addProduct(Product product, int quantity) {
        if (product.getQuantity() < quantity) {
            System.out.println("Error: there is only " + product.getQuantity() + "left of " + product.getName());
            return;
        }
        if (product instanceof Expirable){
            if(((Expirable) product).isExpired()) {
                System.out.println("Error: " + product.getName() + " is expired and cannot be added to the cart.");
                return;
            }
        }
        if (products.get(product) != null) {
            int existingQuantity = products.get(product);
            quantity += existingQuantity;
        }
        products.put(product, quantity);
        product.setQuantity(product.getQuantity() - quantity);
        totalPrice += product.getPrice() * quantity;
        if (product instanceof Shippable) {
            totalWeight += ((Shippable) product).getWeight() * quantity;
        }
    }

    public void removeProduct(Product product) {
        if (products.get(product) != null) {
            int quantity = products.get(product);
            totalPrice -= product.getPrice() * quantity;
            if (product instanceof Shippable) {
                totalWeight -= ((Shippable) product).getWeight() * quantity;
            }
            product.setQuantity(product.getQuantity() + quantity);
            products.remove(product);
        } else {
            System.out.println("Error: Product not found in cart.");
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void clearCart() {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.setQuantity(product.getQuantity() + quantity);
        }
        products.clear();
        totalPrice = 0.0;
        totalWeight = 0;
    }
}
