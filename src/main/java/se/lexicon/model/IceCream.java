package se.lexicon.model;

public class IceCream implements Product {

    private final int id;
    private double price;
    private String productName;
    private final IceCreamFlavour flavour;
    private final IceCreamType type;
    private final boolean isToppingsAdded;

    public IceCream(int id, IceCreamFlavour flavour, IceCreamType type, boolean isToppingsAdded) {
        this.flavour = flavour;
        this.type = type;
        this.id = id;
        setProductName(flavour.getLabel().concat("-").concat(type.getLabel()));
        setPrice(flavour.getFlavourPrice() + type.getBasePrice());
        this.isToppingsAdded = isToppingsAdded;
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
        return " IceCream{" +
                "flavour=" + flavour +
                ", type=" + type +
                ", isToppingsAdded=" + isToppingsAdded +
                '}';
    }

    @Override
    public String getDescription() {
        return examine() + use();
    }
}
