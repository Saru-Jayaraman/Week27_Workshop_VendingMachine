package se.lexicon;

import se.lexicon.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Candy candy1 = new Candy("Kit Kat", 20, "Bar");
        Candy candy2 = new Candy("Ferraro", 20, "Toffee");
        IceCream iceCream1 = new IceCream(IceCreamFlavour.MANGO, IceCreamType.CUP, true);
        IceCream iceCream2 = new IceCream(IceCreamFlavour.CHOCOLATE, IceCreamType.STICK, false);
        IceCream iceCream3 = new IceCream(IceCreamFlavour.PISTA, IceCreamType.CONE, false);
        Doughnut doughnut1 = new Doughnut(DoughnutSize.MAX, true);
        Doughnut doughnut2 = new Doughnut(DoughnutSize.MINI, false);

        Product[] products = new Product[]{candy1, candy2, iceCream1, iceCream2, iceCream3, doughnut1, doughnut2};
        System.out.println("List of Products:");
        System.out.println("=================");
        for (Product product : products) {
            System.out.println(product.getDescription());
        }

        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);
        int currency = 100;
        vendingMachine.addCurrency(currency);
        System.out.println("======================================");
        System.out.println("Deposit pool after adding currency: " + vendingMachine.getDepositPool());

        System.out.println("======================================");
        System.out.println("Deposit pool value(Remaining amount) after buying: " + vendingMachine.getBalance());

        System.out.println("======================================");
        String[] productDescriptionArray = vendingMachine.getProducts();

        System.out.println("Bought and not bought product details:");
        System.out.println("--------------------------------------");
        for (String productDescription : productDescriptionArray) {
            System.out.println(productDescription);
        }

        vendingMachine.endSession();
        vendingMachine.setDepositPool(0);
    }
}
