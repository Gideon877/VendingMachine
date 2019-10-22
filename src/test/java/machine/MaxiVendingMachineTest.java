package machine;

import machine.exceptions.*;
import machine.products.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MaxiVendingMachineTest {

    Chocolate chocolate;
    SoftDrink softDrink;
    SaltySnack saltySnack;

    @DisplayName("Buy Invalid Product")
    @Nested
    public class BuyProduct {
        @Test
        void buyProduct() {
            assertThrows(InvalidProductException.class,() -> MaxiVendingMachine.buy(new Product("", "", 0)));
        }

    }

    @DisplayName("Buy Salty Snack Product")
    @Nested
    public class BuySaltySnackProduct {
        @BeforeEach
        void setUp() {
            saltySnack = new SaltySnack("Peanuts", "Peanuts and Raisins", 9);
            MaxiVendingMachine.addStock(saltySnack);
        }

        @Test
        void buySaltySnack() throws SaltyCracksAllEatenException {
            MaxiVendingMachine.buy(saltySnack);

            assertEquals(MaxiVendingMachine.getStock(saltySnack), 0);
            assertThrows(SaltyCracksAllEatenException.class, () -> MaxiVendingMachine.buy(saltySnack));
        }

    }

    @DisplayName("Buy Soft Drink Product")
    @Nested
    public class BuySoftDrinkProduct {
        @BeforeEach
        void setUp() {
            softDrink = new SoftDrink("Coke", "Coke Zero 500ml", 10);
            MaxiVendingMachine.addStock(softDrink);
        }

        @Test
        void buySoftDrink() throws SoftDrinksOutOfStockException {
            MaxiVendingMachine.buy(softDrink);

            assertEquals(MaxiVendingMachine.getStock(softDrink), 0);
            assertThrows(SoftDrinksOutOfStockException.class, () -> MaxiVendingMachine.buy(softDrink));
        }
    }

    @DisplayName("Buy Chocolate Product")
    @Nested
    public class BuyChocolateProduct {
        @BeforeEach
        void setUp() {
            chocolate = new Chocolate("Bar-One", "50g", 6);
            MaxiVendingMachine.addStock(chocolate);
        }

        @Test
        void buyChocolate() throws ChocolatesAllGoneException {
            MaxiVendingMachine.buy(chocolate);
            assertEquals(MaxiVendingMachine.getStock(chocolate), 0);
            assertThrows(ChocolatesAllGoneException.class,() -> MaxiVendingMachine.buy(chocolate));
        }
    }
}