package se.lexicon.model;

public class IceCream extends Product {

    private final IceCreamFlavour flavour;
    private final IceCreamType type;
    private final boolean isToppingsAdded;

    public IceCream(IceCreamFlavour flavour, IceCreamType type, boolean isToppingsAdded) {
        super(flavour.getLabel().concat("-").concat(type.getLabel()),//Chocolate-Cup
                flavour.getFlavourPrice()+type.getBasePrice());//15+10
        this.flavour = flavour;
        this.type = type;
        this.isToppingsAdded = isToppingsAdded;
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
