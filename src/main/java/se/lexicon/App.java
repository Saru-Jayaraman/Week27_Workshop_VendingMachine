package se.lexicon;

import se.lexicon.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Candy candy1 = new Candy(1, "Kit Kat", 20, "Bar");
        Candy candy2 = new Candy(2, "Ferraro", 20, "Toffee");
        IceCream iceCream1 = new IceCream(3, IceCreamFlavour.MANGO, IceCreamType.CUP, true);
        IceCream iceCream2 = new IceCream(4, IceCreamFlavour.CHOCOLATE, IceCreamType.STICK, false);
        IceCream iceCream3 = new IceCream(5, IceCreamFlavour.PISTA, IceCreamType.CONE, false);
        Doughnut doughnut1 = new Doughnut(6, DoughnutSize.MAX, true);
        Doughnut doughnut2 = new Doughnut(7, DoughnutSize.MINI, false);

        Product[] products = new Product[]{candy1, candy2, iceCream1, iceCream2, iceCream3, doughnut1, doughnut2};
        System.out.println("List of Products:");
        System.out.println("=================");
        for (Product product : products) {
            System.out.println(product.getDescription());
        }

        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);
        int currency = 200;
        vendingMachine.addCurrency(currency);
        System.out.println("======================================");
        System.out.println("Deposit pool after adding currency: " + vendingMachine.getDepositPool());

        System.out.println("======================================");
        System.out.println("Deposit pool value(Remaining amount) after buying: " + vendingMachine.getBalance());

        System.out.println("======================================");
        String[] productDescriptionArray = vendingMachine.getProducts();

        System.out.println("Bought product details:");
        System.out.println("-----------------------");
        for (String productDescription : productDescriptionArray) {
            System.out.println(productDescription);
        }

        vendingMachine.endSession();
        vendingMachine.setDepositPool(0);
    }
}
