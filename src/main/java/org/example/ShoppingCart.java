package org.example;


import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        items.put(product, items.getOrDefault(product, 0) + quantity);
    }

    public void removeProduct(Product product) {
        items.remove(product);
    }

    public double getTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            sb.append(entry.getKey().toString())
                    .append(" - Quantity: ")
                    .append(entry.getValue())
                    .append("\n");
        }
        sb.append("Total: $").append(getTotal()).append("\n");
        return sb.toString();
    }
}
