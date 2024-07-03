package se.lexicon.model;

public interface Product {

    int getId();

    double getPrice();

    String getProductName();

    void setPrice(double price);

    void setProductName(String productName);

    String examine();

    String use();

    String getDescription();
}