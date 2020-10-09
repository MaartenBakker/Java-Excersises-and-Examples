package com.Maarten;

import java.util.*;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);

            if (inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int reserveStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);

        int quantityAlreadyReserved = inStock.quantityReserved();

        if((inStock != null) && ((inStock.quantityInStock()) >= (quantity + quantityAlreadyReserved)) && (quantity > 0)) {
            inStock.adjustReserved(quantity);
            return quantity;
        }

        if ((inStock !=null) && (inStock.quantityInStock() < quantity)) {
            int maxAmountToReserve = (inStock.quantityInStock() - inStock.quantityReserved());
            System.out.println("Not enough " + inStock.getName() + " in stock, you can't add " + quantity + " items.");
            System.out.println("You can add a maximum of " + maxAmountToReserve + " items.");
            return 0;
        }

        return 0;
    }

    public int unReserveStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.quantityReserved() >= quantity) && (quantity > 0)) {
            inStock.adjustReserved(-quantity);
            return quantity;
        }
        return 0;
    }



    public int sellStock(String item, int quantity){
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity > 0))
        {
            inStock.adjustStock(-quantity);
            System.out.println(item + " " + quantity + " removed from stock");

            return quantity;
        }
        System.out.println(item + " Not sold" + " quantity: " + quantity);
        return 0;
    }


    public StockItem get(String key) {
            return list.get(key);
    }

    public Map<String, Double> priceList(){
        Map<String, Double> priceList = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item: list.entrySet()) {
            priceList.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(priceList);
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap(list);
    }





    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;

        for (Map.Entry<String,StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem.getName() + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f", itemValue) +  "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }


}
