package com.pluralsight.deli;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final LocalDateTime orderDate;
    private final List<Sandwich> sandwiches = new ArrayList<>();
    private final List<OtherProducts> others = new ArrayList<>();

    public Order() {
        this.orderId = UUID.randomUUID().toString();
        this.orderDate = LocalDateTime.now();
    }

    public void addSandwich(Sandwich s) { if (s != null) sandwiches.add(s); }
    public void addOther(OtherProducts o)        { if (o != null) others.add(o); }

    public double calculateTotal() {
        double total = 0.0;
        for (Sandwich s : sandwiches) total += s.calculatePrice();
        for (OtherProducts o : others) total += o.getPrice();
        return total;
    }

    public String toReceiptString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderId).append("\n");
        sb.append("Date: ").append(orderDate).append("\n\n");

        sb.append("Sandwiches:\n");
        if (sandwiches.isEmpty()) sb.append("  (none)\n");
        for (int i = sandwiches.size() - 1; i >= 0; i--) { // newest first
            sb.append("  - ").append(sandwiches.get(i).displaySandwich()).append("\n");
        }

        sb.append("\nOther Items:\n");
        if (others.isEmpty()) sb.append("  (none)\n");
        for (int i = others.size() - 1; i >= 0; i--) {
            sb.append("  - ").append(others.get(i)).append("\n");
        }

        sb.append("\nTOTAL: $").append(String.format("%.2f", calculateTotal())).append("\n");
        return sb.toString();
    }

    // Getters
    public String getOrderId() { return orderId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public List<Sandwich> getSandwiches() { return List.copyOf(sandwiches); }
    public List<OtherProducts> getOthers() { return List.copyOf(others); }
}