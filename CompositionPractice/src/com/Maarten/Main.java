package com.Maarten;

public class Main {

    public static void main(String[] args) {

        Couch brownCouch = new Couch(5, "brown");
        Closet theCloset = new Closet(new Cup(), new Plate());
        Table theTable = new Table();
        Room theRoom = new Room(theTable, new Door(), brownCouch, new Window(), theCloset);

        System.out.println(theRoom.getCouch().getColor());
        theRoom.openCloset(theCloset);
        System.out.println(theRoom.isClosetClosed());
        theRoom.getCloset().getPlate().Clean();
        theRoom.flipTable();
    }
}
