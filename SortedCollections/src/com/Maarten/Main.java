package com.Maarten;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 4);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 200);
        stockList.addStock(temp);


        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket timsBasket = new Basket("Tim");
        reserveItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        reserveItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        System.out.println(stockList);

        reserveItem(timsBasket, "car", 1);
        reserveItem(timsBasket, "spanner", 5);
        System.out.println(timsBasket);

        reserveItem(timsBasket, "juice", 4);
        reserveItem(timsBasket, "cup", 5);
        reserveItem(timsBasket, "bread", 3);
        reserveItem(timsBasket, "vase", 20);
        reserveItem(timsBasket, "cake", 5);
        System.out.println(timsBasket);

        unReserveItem(timsBasket, "cake", 4);
        unReserveItem(timsBasket, "car", 1);
        System.out.println(timsBasket);

        reserveItem(timsBasket, "cup", 1000);
        reserveItem(timsBasket, "cup", 7);
        reserveItem(timsBasket, "cup", 2);
        System.out.println(timsBasket);
        System.out.println();

        checkOutBasket(timsBasket);


        System.out.println(stockList);

        System.out.println(timsBasket);

        reserveItem(timsBasket, "cake", 1);
        System.out.println(timsBasket);


        System.out.println();
        System.out.println("\tPricelist");

        for (Map.Entry<String, Double> price: stockList.priceList().entrySet()){
            System.out.println(price.getKey() + " costs " + price.getValue());
        }



    }

    public static void checkOutBasket(Basket basket) {
        System.out.println("\nCheckout Started");
        for (Map.Entry<StockItem, Integer> item : basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(), item.getValue());

        }
        basket.checkOut();
    }

    public static int reserveItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }
        if(stockList.reserveStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }

    public static int unReserveItem(Basket basket, String item, int quantity){
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("You can't unreserve " + item);
            return 0;
        }
        if(stockList.unReserveStock(item, quantity) != 0) {
            basket.removeFromBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }





}
