package se.lexicon.model;

import static se.lexicon.model.ConstantPrice.*;

public enum IceCreamFlavour {
    CHOCOLATE("Chocolate", CHOCOLATE_PRICE), VANILLA("Vanilla", VANILLA_PRICE),
    MANGO("Mango", MANGO_PRICE), ORANGE("Orange", ORANGE_PRICE), PISTA("Pista", PISTA_PRICE);

    private final String label;
    private final double flavourPrice;

    IceCreamFlavour(String label, double flavourPrice) {
        this.label = label;
        this.flavourPrice = flavourPrice;
    }

    public String getLabel() {
        return label;
    }

    public double getFlavourPrice() {
        return flavourPrice;
    }
}
