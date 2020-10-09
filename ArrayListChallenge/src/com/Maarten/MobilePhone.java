package com.Maarten;


import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {

    private ArrayList<Contact> contacts;
    private Scanner scanner = new Scanner(System.in);

    public MobilePhone() {
        this.contacts = new ArrayList<Contact>();
    }

    public void phoneMenu() {
        boolean quit = false;

        printMenu();


        while(!quit) {
            System.out.println("Please enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 0:
                        printMenu();
                        break;
                    case 1:
                        storeContact();
                        break;
                    case 2:
                        queryContact();
                        break;
                    case 3:
                        modifyContact();
                        break;
                    case 4:
                        removeContact();
                        break;
                    case 5:
                        listAllContacts();
                        break;
                    case 6:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");

                }
            } catch (Exception e){
                System.out.println("Invalid input, please enter a number.");
                scanner.nextLine();
            }
        }

    }



    private void printMenu() {

        System.out.println("Menu");
        System.out.println("Press 0 to view Menu.");
        System.out.println("Press 1 to add Contact.");
        System.out.println("Press 2 to find Contact.");
        System.out.println("Press 3 to modify Contact.");
        System.out.println("Press 4 to delete Contact.");
        System.out.println("Press 5 to list all Contacts.");
        System.out.println("Press 6 to quit.");
    }

    private void storeContact() {

        System.out.println("Please enter new contact name:");
        String  name = scanner.nextLine();

        if (!contactExists(name)) {
            System.out.println("Please enter new contact number:");
            int number = scanner.nextInt();
            scanner.nextLine();

            Contact contact = Contact.createContact(name, number);
            contacts.add(contact);

            System.out.println("New contact added.");

        } else {

            System.out.println("Contact already exists.");
        }
    }

    private void queryContact() {
        String name;
        Contact contact;

        System.out.println("Enter name to query:");
        name = scanner.nextLine();


            if (contactExists(name)) {
                contact = findContact(name);

                System.out.println("Contact found.");
                System.out.println("Name " + contact.getName());
                System.out.println("Number " + contact.getNumber());
            } else {
                System.out.println("Contact not found.");
            }


    }

    private void modifyContact() {

        System.out.println("Please enter name of contact to modify: ");
        String oldName = scanner.nextLine();

         if (contactExists(oldName)) {

             int position = findContactPosition(oldName);

             System.out.println("Please enter new name: ");
             String newName = scanner.nextLine();

             if (contactExists(newName)) {
                 System.out.println("Contact already exists");
             } else {

                 System.out.println("Please enter new number: ");
                 int newNumber = scanner.nextInt();
                 scanner.nextLine();

                 Contact newContact = Contact.createContact(newName, newNumber);
                 contacts.set(position, newContact);
                 System.out.println("The contact has been modified.");
             }
         } else {
             System.out.println("Contact not found.");
         }

    }

    private void removeContact() {
        String name;
        Contact contact;
        int position;

        System.out.println("Please enter name of contact to remove: ");
        name = scanner.nextLine();

        if (contactExists(name)) {
            contact = findContact(name);
            position = contacts.indexOf(contact);
            contacts.remove(position);

            System.out.println("Contact " + contact.getName() + " removed.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private void listAllContacts() {
        System.out.println("List of all contacts: ");
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Number: " + contact.getNumber());
        }
    }


    private boolean contactExists(String name) {
        boolean exists = false;

        if (findContact(name) != null) {
            exists = true;
        }

        return exists;
    }

    private int findContactPosition(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name))
                return contacts.indexOf(contact);
        }
        return -1;
    }

    private Contact findContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name))
                return contact;
        }
        return null;
    }

}
