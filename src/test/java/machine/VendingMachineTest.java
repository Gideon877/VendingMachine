package machine;

import machine.exceptions.*;
import machine.products.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VendingMachineTest {
    VendingMachine vendingMachine;

    @BeforeEach
    void setUp() {
        vendingMachine = new VendingMachine();
    }

    @Test
    void buyChocolate() throws ProductNotFoundException {
        final Chocolate barOne = new Chocolate("Bar One", "100g", 11);
        vendingMachine.addStock(barOne, 1);
        vendingMachine.buy(barOne);

        assertEquals(vendingMachine.getStock(barOne), 0);
        assertThrows(ChocolatesAllGoneException.class, () -> vendingMachine.buy(barOne));
        assertThrows(InvalidProductException.class, () -> vendingMachine.buy(new Product("Beer", "340ml", 14)));
    }
    @Test
    void buySoftDrink() throws ProductNotFoundException {
        SoftDrink coke = new SoftDrink("Coke", "500ml", 9);
        vendingMachine.addStock(coke, 1);
        vendingMachine.buy(coke);

        assertEquals(vendingMachine.getStock(coke), 0);
        assertThrows(SoftDrinksOutOfStockException.class, () -> vendingMachine.buy(coke));
        assertThrows(InvalidProductException.class, () -> vendingMachine.buy(new Product("Beer", "340ml", 14)));
    }
    @Test
    void buySaltySnack() throws ProductNotFoundException {
        SaltySnack peanuts = new SaltySnack("Peanuts", "500g", 34);
        vendingMachine.addStock(peanuts, 1);
        vendingMachine.buy(peanuts);

        assertEquals(vendingMachine.getStock(peanuts), 0);
        assertThrows(SaltyCracksAllEatenException.class, () -> vendingMachine.buy(peanuts));
        assertThrows(InvalidProductException.class, () -> vendingMachine.buy(new Product("Beer", "340ml", 14)));
    }
}