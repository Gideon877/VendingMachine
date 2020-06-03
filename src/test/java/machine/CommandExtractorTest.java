package machine;

import machine.products.ProductType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandExtractorTest {

    @DisplayName("Add product without qty")
    @Nested
    class AddProduct {
        CommandExtractor commandExtractor = new CommandExtractor("Add SaltySnack");

        @Test
        void getCommand() {
            assertEquals("add", commandExtractor.getCommand());
        }

        @Test
        void getQty() {
            assertEquals(1, commandExtractor.getQty());
        }

        @Test
        void getProductType() {
            assertEquals(ProductType.saltysnack, commandExtractor.getProductType());
        }
    }

    @DisplayName("Add product with qty")
    @Nested
    class AddProduct__2 {
        CommandExtractor commandExtractor = new CommandExtractor("Add Chocolate 2");

        @Test
        void getCommand() {
            assertEquals("add", commandExtractor.getCommand());
        }

        @Test
        void getQty() {
            assertEquals(2, commandExtractor.getQty());
        }

        @Test
        void getProductType() {
            assertEquals(ProductType.chocolate, commandExtractor.getProductType());
        }
    }
}