package se.lexicon.model;

public class Doughnut extends Product {

    private final boolean isSyrupUsed;
    private final DoughnutSize size;

    public Doughnut(DoughnutSize size, boolean isSyrupUsed) {
        super(size.getLabel(), size.getPrice());
        this.isSyrupUsed = isSyrupUsed;
        this.size = size;
    }

    public boolean isSyrupUsed() {
        return isSyrupUsed;
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