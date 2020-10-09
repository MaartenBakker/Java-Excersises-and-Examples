package com.Maarten;

public class Room {
    // Fields


    private Table table;
    private Door door;
    private Couch couch;
    private Window window;
    private Closet closet;


    // Constructors


    public Room(Table table, Door door, Couch couch, Window window, Closet closet) {
        this.table = table;
        this.door = door;
        this.couch = couch;
        this.window = window;
        this.closet = closet;
    }

    // Methods

    public void openCloset(Closet closet) {
        closet.open();
    }

    public void flipTable() {
        table.Throw("unghhh");
    }

    public void setCloset(Closet closet) {
        closet.close();
    }

    public Closet getCloset() {

        return this.closet;
    }

    public boolean isClosetClosed() {
        return closet.isClosed();
    }

    public Couch getCouch() {
        return couch;
    }

    private Table getTable() {
        return table;
    }
}
