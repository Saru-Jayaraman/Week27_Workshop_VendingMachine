package se.lexicon.model;

public class Candy implements Product {

    private final int id;
    private double price;
    private String productName;
    private final String type; //Toffee or bar or jelly

    public Candy(int id, String productName, double price, String type) {
        setProductName(productName);
        setPrice(price);
        this.type = type;
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.trim().isEmpty()) {
            throw new IllegalArgumentException("ProductName is either null or empty");
        }
        this.productName = productName;
    }

    public String examine() {
        return "";
    }

    public String use() {
        return "";
    }

    public String getDescription() {
        return "Product Id: " + getId() + " Product Name: " + getProductName() + " Price: " + getPrice() +
                " Candy type: " + getType();
    }
}
