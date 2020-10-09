package com.Maarten;

public abstract class ListItem {
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    protected Object value;

    public ListItem (Object value){
        this.value = value;
    }

    abstract ListItem nextRight();
    abstract ListItem setRightItem(ListItem item);
    abstract ListItem nextLeft();
    abstract ListItem setLeftItem(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
