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
    void buyProduct() throws ProductNotFoundException {
        Product beer = new Product(ProductType.softdrink);
        vendingMachine.addStock(beer, 1);

        assertEquals(vendingMachine.getStock(beer), 0);
        assertThrows(InvalidProductException.class, () -> vendingMachine.buy(beer));
    }

    @Test
    void buyChocolate() throws ProductNotFoundException {
        final Chocolate barOne = new Chocolate(ProductType.chocolate);
        vendingMachine.addStock(barOne, 1);
        vendingMachine.buy(barOne);

        assertEquals(vendingMachine.getStock(barOne), 0);
        assertThrows(ChocolatesAllGoneException.class, () -> vendingMachine.buy(barOne));
        assertThrows(InvalidProductException.class, () -> vendingMachine.buy(new Product(ProductType.softdrink)));
    }
    @Test
    void buySoftDrink() throws ProductNotFoundException {
        SoftDrink coke = new SoftDrink(ProductType.softdrink);
        vendingMachine.addStock(coke, 1);
        vendingMachine.buy(coke);

        assertEquals(vendingMachine.getStock(coke), 0);
        assertThrows(SoftDrinksOutOfStockException.class, () -> vendingMachine.buy(coke));
        assertThrows(InvalidProductException.class, () -> vendingMachine.buy(new Product(ProductType.softdrink)));
    }
    @Test
    void buySaltySnack() throws ProductNotFoundException {
        SaltySnack peanuts = new SaltySnack(ProductType.saltysnack);
        vendingMachine.addStock(peanuts, 1);
        vendingMachine.buy(peanuts);

        assertEquals(vendingMachine.getStock(peanuts), 0);
        assertThrows(SaltyCracksAllEatenException.class, () -> vendingMachine.buy(peanuts));
        assertThrows(InvalidProductException.class, () -> vendingMachine.buy(new Product(ProductType.softdrink)));
    }
}