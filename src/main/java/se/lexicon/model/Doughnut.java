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
        return "";
    }

    @Override
    public String use() {
        return "";
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " IsSyrupUsed: " + isSyrupUsed();
    }
}