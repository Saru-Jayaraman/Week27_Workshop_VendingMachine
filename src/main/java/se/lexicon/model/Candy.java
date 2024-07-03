package se.lexicon.model;

public class Candy extends Product {

    private final String type; //Toffee or bar or jelly

    public Candy(String productName, double price, String type) {
        super(productName, price);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String examine() {
        return "";
    }

    @Override
    public String use() {
        return "";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Candy type: " + getType();
    }
}
