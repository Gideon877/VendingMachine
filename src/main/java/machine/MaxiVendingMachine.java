package machine;

import machine.exceptions.*;
import machine.products.*;

public abstract class MaxiVendingMachine extends VendingMachine {

    static int softDrinks;
    static int saltySnacks;
    static int chocolates;

    public static void buy(Product product) throws InvalidProductException {
        throw new InvalidProductException();
    }

    public static void buy(SoftDrink softDrink) throws SoftDrinksOutOfStockException {
        if(softDrinks <= 0) throw new SoftDrinksOutOfStockException(softDrink);
        else softDrinks --;
    }

    public static void buy(SaltySnack saltySnack) throws SaltyCracksAllEatenException {
        if(saltySnacks <= 0) throw new SaltyCracksAllEatenException(saltySnack);
        else saltySnacks --;
    }

    public static void buy(Chocolate chocolate) throws ChocolatesAllGoneException {
        if(chocolates <= 0) throw new ChocolatesAllGoneException(chocolate);
        else chocolates --;
    }

    public static void addStock(SoftDrink softDrink) {
        softDrinks ++;
    }

    public static void addStock(SaltySnack saltySnack) {
        saltySnacks ++;
    }

    public static void addStock(Chocolate chocolate) {
        chocolates ++;
    }

    public static void addStock(Product product) throws InvalidProductException {
        throw new InvalidProductException();
    }
}
