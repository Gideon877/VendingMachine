package machine;

import machine.exceptions.ProductNotFoundException;
import machine.products.Chocolate;
import machine.products.Product;
import machine.products.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtendableVendingMachineTest {

    @DisplayName("Add Method")
    @Nested
    class AddStock {
        @DisplayName("Adding two Products")
        @Test
        void add__product_1 () {
            ExtendableVendingMachine extendableVendingMachine = new ExtendableVendingMachine();
            Product chocolate = new Chocolate(ProductType.chocolate);
            assertEquals(0, extendableVendingMachine.getStock(chocolate));

            extendableVendingMachine.addStock(chocolate, 5);
            assertEquals(5, extendableVendingMachine.getStock(chocolate));
        }
    }

    @DisplayName("Buy Method")
    @Nested
    class Buy {
        @DisplayName("Buying two Products")
        @Test
        void buy__product_1 () {
            ExtendableVendingMachine extendableVM = new ExtendableVendingMachine();
            Product chocolate = new Chocolate(ProductType.saltysnack);
            assertEquals(0, extendableVM.getStock(chocolate));

            extendableVM.addStock(chocolate, 5);
            assertEquals(5, extendableVM.getStock(chocolate));

            extendableVM.buy(chocolate, 3);
            assertEquals(2, extendableVM.getStock(chocolate));

            // new instance don't affect old one
//            extendableVM.buy(new Chocolate("Bar One", "100g", 11), 1);
//            assertEquals(2, extendableVM.getStock(chocolate));

//            buying over qty
            extendableVM.buy(chocolate, 10);
            assertEquals(2, extendableVM.getStock(chocolate));

        }
    }
}