package com.Maarten;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
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
                        return true;
                    }
                } else if (comparison > 0) {
                    if (currentItem.nextLeft() != null) {
                        currentItem = currentItem.nextLeft();
                    } else {
                        currentItem.setLeftItem(newItem);
                        return true;
                    }
                } else {
                    System.out.println(newItem.getValue() + " is already present, not added.");
                    return false;
                }
            }

            return false;

    }


    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root != null) {
            traverse(root.nextLeft());
            System.out.println(root.getValue());
            traverse(root.nextRight());
        }
    }
}
