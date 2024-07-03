package se.lexicon.model;

import java.security.PublicKey;

import static se.lexicon.model.ConstantPrice.*;

public enum DoughnutSize {
    MINI("Mini Doughnuts", MINI_DOUGHNUT_PRICE), MAX("Max Doughnuts", MAX_DOUGHNUT_PRICE);

    private final String label;
    private final double price;

    DoughnutSize(String label, double price) {
        this.label = label;
        this.price = price;
    }

    public String getLabel() {
        return label;
    }

    public double getPrice() {
        return price;
    }
}
