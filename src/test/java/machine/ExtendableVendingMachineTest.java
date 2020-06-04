package machine;

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
            ProductType product = ProductType.chocolate;
            assertEquals(0, extendableVendingMachine.getStock(product));

            extendableVendingMachine.addStock(product, 5);
            assertEquals(5, extendableVendingMachine.getStock(product));
        }
    }

    @DisplayName("Buy Method")
    @Nested
    class Buy {
        @DisplayName("Buying two Products")
        @Test
        void buy__product_1 () {
            ExtendableVendingMachine extendableVM = new ExtendableVendingMachine();
            ProductType product = ProductType.saltysnack;
            assertEquals(0, extendableVM.getStock(product));

            extendableVM.addStock(product, 5);
            assertEquals(5, extendableVM.getStock(product));

            extendableVM.buy(product, 3);
            assertEquals(2, extendableVM.getStock(product));

            // new instance don't affect old one
//            extendableVM.buy(new product("Bar One", "100g", 11), 1);
//            assertEquals(2, extendableVM.getStock(product));

//            buying over qty
            extendableVM.buy(product, 10);
            assertEquals(2, extendableVM.getStock(product));

        }
    }
}