package com.pluralsight.deli;

public class Meat extends Topping {
    public Meat(String name, boolean isExtra) {
        super(name, isExtra);
    }

    @Override
    public double getPrice(int sizeInches) {
        // Meat is premium: base meat add-on (+ extra add-on if extra)
        double price = PriceList.meatAddon(sizeInches);
        if (isExtra) price += PriceList.extraMeatAddon(sizeInches);
        return price;
    }
}