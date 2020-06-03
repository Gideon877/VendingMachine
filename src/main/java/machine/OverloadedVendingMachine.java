package machine;

import machine.products.Chocolate;
import machine.products.Product;
import machine.products.SaltySnack;
import machine.products.SoftDrink;

public class OverloadedVendingMachine {
    private int softDrinkQty;
    private int saltySnacksQty;
    private int chocolatesQty;

    OverloadedVendingMachine(int softDrinkQty, int saltySnacksQty, int chocolatesQty){
        this.softDrinkQty = softDrinkQty;
        this.saltySnacksQty = saltySnacksQty;
        this.chocolatesQty = chocolatesQty;
    }

    void buy(SoftDrink softdrink) {
        if (softDrinkQty > 0) softDrinkQty--;
    }

    void buy(SaltySnack saltySnack) {
        if(saltySnacksQty > 0) saltySnacksQty--;
    }

    void buy(Chocolate chocolate) {
        if(chocolatesQty > 0) chocolatesQty--;
    }

    void buy(Product product) {
        if(chocolatesQty > 0) chocolatesQty--;
        if(saltySnacksQty > 0) saltySnacksQty--;
        if (softDrinkQty > 0) softDrinkQty--;
    }

    void add(SoftDrink softdrink) {
        softDrinkQty++;
    }

    void add(SaltySnack saltySnack) {
        saltySnacksQty++;
    }

    void add(Chocolate chocolate) {
        chocolatesQty++;
    }

    void add(Product product) {
        softDrinkQty++;
        chocolatesQty++;
        saltySnacksQty++;
    }

    public int getStock(Chocolate chocolate) { return chocolatesQty;}
    public int getStock(SaltySnack saltySnack) { return saltySnacksQty;}
    public int getStock(SoftDrink softDrink) { return softDrinkQty;}
    public int getStock(Product product) { return (softDrinkQty + saltySnacksQty + chocolatesQty); }
}
