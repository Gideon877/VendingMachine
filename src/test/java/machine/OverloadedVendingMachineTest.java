package machine;

import machine.products.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class OverloadedVendingMachineTest {
    OverloadedVendingMachine overloadedVendingMachine = new OverloadedVendingMachine(2, 2,2);
    Chocolate chocolate = new Chocolate(ProductType.chocolate);
    SoftDrink softDrink = new SoftDrink(ProductType.softdrink);
    SaltySnack saltySnack = new SaltySnack(ProductType.saltysnack);
    Product product = new Product(ProductType.snacks);

    @Nested
    @DisplayName("Buy Method")
    class Buy {
        @Test
        @DisplayName("Buy soft-drink")
        void testBuySoftDrink() {
            assertEquals(2, overloadedVendingMachine.getStock(softDrink));
            overloadedVendingMachine.buy(softDrink);
            assertEquals(1, overloadedVendingMachine.getStock(softDrink));
        }

        @Test
        @DisplayName("Buy chocolate")
        void testBuyChocolate() {
            assertEquals(2, overloadedVendingMachine.getStock(chocolate));
            overloadedVendingMachine.buy(chocolate);

            assertEquals(1, overloadedVendingMachine.getStock(chocolate));
        }

        @Test
        @DisplayName("Buy salty snack")
        void testBuySaltySnack() {
            assertEquals(2, overloadedVendingMachine.getStock(saltySnack));
            overloadedVendingMachine.buy(saltySnack);
            assertEquals(1, overloadedVendingMachine.getStock(saltySnack));
        }

        @Test
        @DisplayName("Buy all products")
        void testBuyProduct() {
            assertEquals(6, overloadedVendingMachine.getStock(product));
            overloadedVendingMachine.buy(product);
            assertEquals(3, overloadedVendingMachine.getStock(product));
        }

        @Test
        @DisplayName("Buy more than one product")
        void testBuyProduct_2() {
            assertEquals(6, overloadedVendingMachine.getStock(product));
            overloadedVendingMachine.buy(product);
            assertEquals(3, overloadedVendingMachine.getStock(product));

            overloadedVendingMachine.buy(product);
            assertEquals(0, overloadedVendingMachine.getStock(product));

//            if stock level is zero, it should not buy any product
            overloadedVendingMachine.buy(product);
            assertEquals(0, overloadedVendingMachine.getStock(product));

        }
    }

    @Nested
    @DisplayName("Add Method")
    class Add {
        @Test
        @DisplayName("Add soft-drink")
        void testBuySoftDrink() {
            assertEquals(2, overloadedVendingMachine.getStock(softDrink));
            overloadedVendingMachine.add(softDrink);
            assertEquals(3, overloadedVendingMachine.getStock(softDrink));
        }

        @Test
        @DisplayName("Add chocolate")
        void testBuyChocolate() {
            assertEquals(2, overloadedVendingMachine.getStock(chocolate));
            overloadedVendingMachine.add(chocolate);
            assertEquals(3, overloadedVendingMachine.getStock(chocolate));
        }

        @Test
        @DisplayName("Add salty snack")
        void testBuySaltySnack() {
            assertEquals(2, overloadedVendingMachine.getStock(saltySnack));
            overloadedVendingMachine.add(saltySnack);
            assertEquals(3, overloadedVendingMachine.getStock(saltySnack));
        }

        @Test
        @DisplayName("Add all products")
        void testBuyProduct() {
            assertEquals(6, overloadedVendingMachine.getStock(product));
            overloadedVendingMachine.add(product);
            assertEquals(3, overloadedVendingMachine.getStock(saltySnack));
            assertEquals(3, overloadedVendingMachine.getStock(chocolate));
            assertEquals(3, overloadedVendingMachine.getStock(softDrink));
            assertEquals(9, overloadedVendingMachine.getStock(product));
        }
    }
}