abstract public class Product {
    private int id;
    private String Name;
    private double price;
    private int quantity;


    public Product(int id, String Name, double price, int quantity) {
        this.id = id;
        this.Name = Name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}

interface Shippable {
    double getWeight();
    String getName();

}

interface Expirable {
    String getManufactureDate();
    String getExpirationDate();
    boolean isExpired();
}


