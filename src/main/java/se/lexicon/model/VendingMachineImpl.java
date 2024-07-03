package se.lexicon.model;

public class VendingMachineImpl implements IVendingMachine{
    private final Product[] products;
    private final int[] choices;
    private Product[] boughtProducts;
    private Product[] notBoughtProducts;
    private final int[] acceptedAmount = new int[]{1, 2, 5, 10, 20, 50, 100, 200, 500, 1000};
    private int depositPool;

    public VendingMachineImpl(Product[] products) {
        this.products = products;
        this.choices = new int[]{1,6};
        this.depositPool = 0;
    }

    public int getDepositPool() {
        return depositPool;
    }

    public void setDepositPool(int depositPool) {
        this.depositPool = depositPool;
    }

    public Product[] getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(Product[] boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    @Override
    public void addCurrency(int amount) {
        boolean isMatchingCurrency = false;
        for (int amt : acceptedAmount) {
            if (amt == amount) {
                depositPool = amount;
                isMatchingCurrency = true;
                break;
            }
        }
        if(!isMatchingCurrency) {
            throw new IllegalArgumentException("Entered amount cannot be added to the deposit pool... Enter correct denomination");
        }
    }

    @Override
    public int getBalance() {
        boughtProducts = new Product[0];
        notBoughtProducts = new Product[0];
        for(int choice : choices) {
            Product requestedProduct = request(choice);
            if(requestedProduct.getPrice() <= getDepositPool()) {
                Product[] newArray = new Product[boughtProducts.length + 1];
                System.arraycopy(products, 0, newArray, 0, boughtProducts.length);
                newArray[newArray.length - 1] = requestedProduct;
                boughtProducts = newArray;
                setBoughtProducts(boughtProducts);

                setDepositPool((int) (getDepositPool() - requestedProduct.getPrice()));
            } else {
                Product[] newArray1 = new Product[notBoughtProducts.length + 1];
                System.arraycopy(products, 0, newArray1, 0, notBoughtProducts.length);
                newArray1[newArray1.length - 1] = requestedProduct;
                notBoughtProducts = newArray1;
            }
        }
        return depositPool;
    }

    @Override
    public Product request(int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public int endSession() {
        return depositPool;
    }

    @Override
    public String getDescription(int id) {
        String description = "";
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getDescription();
            }
        }
        return description;
    }

    @Override
    public String[] getProducts() {
        String[] productDescriptionArray = new String[getBoughtProducts().length];
        for(int i=0; i<boughtProducts.length; i++) {
            productDescriptionArray[i] = getDescription(boughtProducts[i].getId());
        }
        return productDescriptionArray;
    }
}