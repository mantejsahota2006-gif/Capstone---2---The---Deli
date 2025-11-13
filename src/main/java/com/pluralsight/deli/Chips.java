package com.pluralsight.deli;

public class Chips extends OtherProducts {
    private final boolean isIncluded;

    // If you add Chips to the order, pass isIncluded=true.
    public Chips(boolean isIncluded) {
        super("Chips", isIncluded ? PriceList.CHIPS_PRICE : 0.0);
        this.isIncluded = isIncluded;
        this.name = "Chips" + (isIncluded ? "" : " (not added)");
    }

    public boolean isIncluded() { return isIncluded; }

    @Override
    public String toString() {
        return isIncluded ? "Chips $" + String.format("%.2f", price) : "Chips (not added)";
    }
}