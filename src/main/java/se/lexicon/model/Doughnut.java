package se.lexicon.model;

public class Doughnut extends Product {

    private final boolean isSyrupUsed;
    private DoughnutSize size;

    public Doughnut(DoughnutSize size, boolean isSyrupUsed) {
        super(size.getLabel(), size.getPrice());
        this.isSyrupUsed = isSyrupUsed;
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