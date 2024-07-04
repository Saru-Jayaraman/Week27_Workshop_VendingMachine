package se.lexicon.model;

public class Doughnut implements Product {

    private final int id;
    private double price;
    private String productName;
    private final DoughnutSize size;
    private final boolean isSyrupUsed;

    public Doughnut(int id, DoughnutSize size, boolean isSyrupUsed) {
        this.size = size;
        this.id = id;
        setProductName(size.getLabel());
        setPrice(size.getPrice());
        this.isSyrupUsed = isSyrupUsed;
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

    public boolean isSyrupUsed() {
        return isSyrupUsed;
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

    @Override
    public String examine() {
        return "Product Id: " + getId() + " Product Name: " + getProductName() + " Price: " + getPrice();
    }

    @Override
    public String use() {
        return " IsSyrupUsed: " + isSyrupUsed();
    }

    @Override
    public String getDescription() {
        return examine() + use();
    }

}