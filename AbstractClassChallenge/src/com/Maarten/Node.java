package com.Maarten;

public class Node extends ListItem {


    public Node(Object value) {
        super(value);
    }

    @Override
    ListItem nextRight() {
        return this.rightLink;
    }

    @Override
    ListItem setRightItem(ListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    ListItem nextLeft() {
        return this.leftLink;
    }

    @Override
    ListItem setLeftItem(ListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(ListItem item) {
        if (item != null) {
            return ((String) super.getValue()).compareTo((String) item.getValue());
        } else {
            return -1;
        }
    }
}
