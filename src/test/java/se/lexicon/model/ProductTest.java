package se.lexicon.model;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    @Order(1)
    void testGetDescription() {
        Candy candy1 = new Candy("Kit Kat", 20, "Bar");
        assertEquals("Product Id: 4 Product Name: Kit Kat Price: 20.0 Candy type: Bar", candy1.getDescription());
    }

    @Test
    @Order(2)
    void testExamine() {
        Product iceCream1 = new IceCream(IceCreamFlavour.MANGO, IceCreamType.CUP, true);
        assertEquals("Product Id: 1 Product Name: Mango-Cup Price: 32.0", iceCream1.examine());
    }

    @Test
    @Order(3)
    void testUse() {
        Product doughnut1 = new Doughnut(DoughnutSize.MAX, true);
        assertEquals(" IsSyrupUsed: true", doughnut1.use());
    }

    @Test
    @Order(4)
    void testSetProductName() {
        Candy candy2 = new Candy("Ferraro", 20, "Toffee");
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> candy2.setProductName(null));
        assertTrue(thrown.getMessage().contains("null"));
    }
}