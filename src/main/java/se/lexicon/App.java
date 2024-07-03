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

//        System.out.println(candy1.getDescription());
//        String iceCreamDescription = iceCream1.toString();
//        System.out.println(iceCreamDescription);
//        iceCreamDescription = iceCream2.toString();
//        System.out.println(iceCreamDescription);
//        System.out.println(doughnut1.getDescription());

        Product[] products = new Product[]{candy1, candy2, iceCream1, iceCream2,iceCream3, doughnut1, doughnut2};
        VendingMachineImpl vendingMachine = new VendingMachineImpl(products);
        //        vendingMachine.addCurrency(111); // throws error
        int currency = 200;
        vendingMachine.addCurrency(currency);
        System.out.println("======================================");
        System.out.println("Deposit pool after adding currency: " + vendingMachine.getDepositPool());//100
        System.out.println("======================================");
        System.out.println("Deposit pool value(Remaining amount) after buying: " + vendingMachine.getBalance());//18
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
