package machine;

import machine.exceptions.ProductNotFoundException;
import machine.products.Chocolate;
import machine.products.Product;
import machine.products.SaltySnack;
import machine.products.SoftDrink;
import org.junit.jupiter.api.Test;

class VendingMachineTest {

    @Test
    void buy() throws ProductNotFoundException {
        VendingMachine vendingMachine = new VendingMachine();

        Product coke = new SoftDrink("Coke", "500ml", 9);
        Chocolate barOne = new Chocolate("Bar One", "100g", 11);
        SaltySnack peanuts = new SaltySnack("Peanuts", "500g", 34);

        vendingMachine.buy(barOne);
    }
}