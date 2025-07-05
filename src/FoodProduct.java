import java.time.LocalDate;

public class FoodProduct extends Product implements Expirable, Shippable {
    private LocalDate manufactureDate;
    private LocalDate expirationDate;
    private double weight;
    public static final String category = "Food";

    public FoodProduct(int id, String name, double price, int quantity,
                       LocalDate manufactureDate, LocalDate expirationDate, double weight) {
        super(id, name, price, quantity);
        this.manufactureDate = manufactureDate;
        this.expirationDate = expirationDate;
        this.weight = weight;
    }

    public String getManufactureDate() {
        return manufactureDate.toString();
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpirationDate() {
        return expirationDate.toString();
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(expirationDate);
    }

}