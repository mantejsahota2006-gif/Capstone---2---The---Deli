package com.pluralsight.deli;

public class Drink extends OtherProducts {
    private final String size;   // Small, Medium, Large
    private final String flavor; // Different flavors

    public Drink(String size, String flavor) {
        super("Drink", PriceList.drinkPrice(size));
        this.size = size;
        this.flavor = flavor;
        this.name = "Drink (" + size + " " + flavor + ")";
    }

    public String getSize() { return size; }
    public String getFlavor() { return flavor; }
}
