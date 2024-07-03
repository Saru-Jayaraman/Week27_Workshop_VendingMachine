package se.lexicon.model;

import static se.lexicon.model.ConstantPrice.*;

public enum IceCreamType {
    CONE("Cone", CONE_PRICE), CUP("Cup", CUP_PRICE), STICK("Stick", STICK_PRICE);

    private final String label;
    private final double basePrice;

    IceCreamType(String label, double basePrice) {
        this.label = label;
        this.basePrice = basePrice;
    }

    public String getLabel() {
        return label;
    }

    public double getBasePrice() {
        return basePrice;
    }
}
