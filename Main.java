import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private static LinkedList<Contact> contacts = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char option;

        do { //main method to run the program
            System.out.print("******************************");
            System.out.println("\n(A)dd\n(D)elete\n(E)mail Search\n(P)rint List\n(S)earch\n(Q)uit");
            System.out.print("******************************");
            System.out.print("\nPlease Enter a command: ");
            option = scanner.nextLine().toUpperCase().charAt(0);

            if (option == 'A') { //if else conditions
                addContact(scanner);
            } else if (option == 'D') {
                deleteContact(scanner);
            } else if (option == 'E') {
                searchByEmail(scanner);
            } else if (option == 'P') {
                printContacts();
            } else if (option == 'S') {
                searchByName(scanner);
            } else if (option == 'Q') {
                System.out.println("Exiting the program...");
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (option != 'Q'); //quit the program
        scanner.close();
    }

    private static void addContact(Scanner scanner) { //add contact method
        System.out.print("Enter name: "); //inputs the information
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        Contact newContact = new Contact(name, phoneNumber, email);
        contacts.add(newContact);
        System.out.println("Contact added successfully.");
    }

    private static void deleteContact(Scanner scanner) { //delete contact method
        System.out.print("Enter name to delete: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) { //if there's a contact, it deletes it
                contacts.remove(contact);
                found = true;
                System.out.println("Contact deleted successfully.");
                break;
            }
        }
        if (!found) { //if not print contact not found
            System.out.println("Contact not found.");
        }
    }

    private static void searchByEmail(Scanner scanner) { //search contact email
        System.out.print("Enter email to search: ");
        String email = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getEmail().equals(email)) {
                System.out.println("Name: " + contact.getName() + ", " + contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }

    private static void printContacts() { //show the list if user had input any contacts
        if (contacts.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Contacts:");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    private static void searchByName(Scanner scanner) { //search the name of contact
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Contact not found.");
        }
    }
}

class Contact { //contact properties
    private String name;
    private String phoneNumber;
    private String email;
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
