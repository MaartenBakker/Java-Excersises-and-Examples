package com.Maarten;

public class MyLinkedList implements NodeList {

    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0) {
                if (currentItem.nextRight() != null) {
                    currentItem = currentItem.nextRight();
                } else {
                    currentItem.setRightItem(newItem);
                    newItem.setLeftItem(currentItem);
                    return true;
                }
            } else if (comparison > 0) {
                if (currentItem.nextLeft() != null) {
                    currentItem.nextLeft().setRightItem(newItem);
                    newItem.setLeftItem(currentItem.nextLeft());
                    newItem.setRightItem(currentItem);
                    currentItem.setLeftItem(newItem);
                } else {
                    newItem.setRightItem(currentItem);
                    currentItem.setLeftItem(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }

        return false;

    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);

            if (comparison == 0) {
                if (currentItem.nextLeft() == null) {
                    currentItem.nextRight().setLeftItem(null);
                    this.root = currentItem.nextRight();
                } else {
                    currentItem.nextLeft().setRightItem(currentItem.nextRight());
                    if (currentItem.nextRight() != null) {
                        currentItem.nextRight().setLeftItem(currentItem.nextLeft());
                    }
                }
                return true;
            } else if (comparison <0){
                currentItem = currentItem.nextRight();
            } else {
                System.out.println("Item to delete not found");
                return false;
            }
        }

        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty.");
        } else {

            while (root != null) {
                System.out.println(root.getValue());
                root = (root.nextRight());
            }
        }
    }
}
