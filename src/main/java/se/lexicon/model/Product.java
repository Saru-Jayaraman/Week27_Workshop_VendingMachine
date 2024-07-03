package se.lexicon.model;

public abstract class Product {
    private static int lastId = 0;
    private int id;
    private final double price;
    private String productName;

    public Product(String productName, double price) {
        this.id = ++lastId;
        setProductName(productName);
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("ProductName is either null or empty");
        }
        this.productName = productName;
    }

    public abstract String examine();
    public abstract String use();

    public String getDescription() {
        return "Product Id: " + getId() + " Product Name: " + getProductName() + " Price: " + getPrice();
    }
}
