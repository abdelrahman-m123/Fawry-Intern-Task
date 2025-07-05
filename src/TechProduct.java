public class TechProduct extends Product implements Shippable {
    private double weight;
    public static final String category = "Tech";

    public TechProduct(int id, String name, double price, int quantity, double weight) {
        super(id, name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
