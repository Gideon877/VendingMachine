//package machine;
//
//import machine.exceptions.*;
//import machine.products.*;
//
//public class VendingMachine {
//
//    static int softDrinks;
//    static int saltySnacks;
//    static int chocolates;
//
//    public static void buy(Product product) throws ProductNotFoundException {
//
//        if(product instanceof SoftDrink) {
//            if(softDrinks <= 0) throw new SoftDrinksOutOfStockException(product);
//            else softDrinks --;
//
//        } else if(product instanceof SaltySnack) {
//            if(saltySnacks <= 0) throw new SaltyCracksAllEatenException(product);
//            else saltySnacks --;
//        } else if(product instanceof Chocolate) {
//            if(chocolates <= 0) throw new ChocolatesAllGoneException(product);
//            else chocolates --;
//        } else {
//            throw new InvalidProductException();
//        }
//    }
//
//    public static void addStock(Product product, int newStock) {
//        if(newStock < 0) return;
//
//        if(product instanceof SoftDrink) {
//            softDrinks += newStock;
//        }
//        if(product instanceof SaltySnack) {
//            saltySnacks += newStock;
//        }
//        if(product instanceof Chocolate) {
//            chocolates += newStock;
//        }
//    }
//
//    public static int getStock(Product product)  {
//        if(product instanceof SoftDrink) {
//            return softDrinks;
//        }
//        if(product instanceof SaltySnack) {
//            return saltySnacks;
//        }
//        if(product instanceof Chocolate) {
//            return chocolates;
//        }
//        return 0;
//    }
//
//    public static int getStock() {
//        return chocolates + softDrinks + saltySnacks;
//    }
//}
