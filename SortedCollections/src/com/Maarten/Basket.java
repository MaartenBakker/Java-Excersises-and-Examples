package com.Maarten;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, quantity + inBasket);
            return quantity;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, -quantity + inBasket);
            return quantity;
        }
        return 0;
    }


    public void checkOut() {
        System.out.println("\n\tChecking out basket");
        double totalAmount = 0.0;

        for (Map.Entry<StockItem, Integer> item : list.entrySet()){
            double itemsTotalPrice = (item.getKey().getPrice() * item.getValue());

            System.out.println(item.getKey().getName() + " quantity " + item.getKey().quantityReserved());
            System.out.println("\tTotal amount: " + itemsTotalPrice);

            totalAmount += itemsTotalPrice;

//            removeFromBasket(item.getKey(), item.getValue());
        }

        System.out.println("Total :" + String.format("%.2f", totalAmount));
        list.clear();
    }

    public Map<StockItem, Integer> items (){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\n" + "Shopping basket " + name + " contains " + list.size() + (list.size() == 1 ? " item." : " items.") + "\n";
        double totalCost = 0.0;

        for (Map.Entry<StockItem, Integer> item: list.entrySet()) {
            s += item.getKey().getName() + ": " + item.getValue() + " reserved\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }

        return s + "Total cost " + String.format("%.2f", totalCost) + "\n";
    }
}
