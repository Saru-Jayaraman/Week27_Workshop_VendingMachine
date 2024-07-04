package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class VendingMachineImplTest {
    private Product[] products;
    private VendingMachineImpl vendingMachine;

    @BeforeEach
    void seUp() {
        vendingMachine = new VendingMachineImpl(products);
        products = new Product[] {
                new Candy(1,"Kit Kat", 20, "Bar"),
                new Candy(2,"Ferraro", 20, "Toffee")
        };
        vendingMachine = new VendingMachineImpl(products);
    }

    @Test
    @Order(1)
    void testAddCurrency() {
        vendingMachine.addCurrency(50);
        assertEquals(50, vendingMachine.getDepositPool());
    }

    @Test
    @Order(2)
    void testAddCurrencyInvalidAmount() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> vendingMachine.addCurrency(55));
        assertTrue(thrown.getMessage().contains("Enter correct denomination"));
    }

    @Test
    @Order(4)
    void testGetBalanceInvalidId() {
        vendingMachine.addCurrency(100);
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> vendingMachine.getBalance());
        assertTrue(thrown.getMessage().contains("not available"));
    }

    @Test
    @Order(5)
    void testGetProducts() {
        vendingMachine.addCurrency(100);
        vendingMachine.getBalance();
        assertEquals(Arrays.toString(vendingMachine.getProducts()),
                "[Product Id: 1 Product Name: Kit Kat Price: 20.0 Candy type: Bar------------------Bought]");
    }

    @Test
    @Order(6)
    void testEndSession() {
        vendingMachine.addCurrency(50);
        assertEquals(0, vendingMachine.endSession());
    }
}