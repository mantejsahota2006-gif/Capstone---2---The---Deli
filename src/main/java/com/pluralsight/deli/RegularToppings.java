package com.pluralsight.deli;

public class RegularToppings extends Topping {
    public RegularToppings(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sizeInches) {
        // Regular toppings are included
        return 0.0;
    }
}
