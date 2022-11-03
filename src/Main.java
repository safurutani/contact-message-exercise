import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    public static void main(String[] args) {
        contacts = new ArrayList<>();
        System.out.println("Greetings");
        showOptions();
        
    }

    private static void showOptions(){
        System.out.println(
            "Select one of the following:" +
            "\n\t1. Manage Contacts" +
            "\n\t2. Messages" +
            "\n\t3. Quit");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                manageContacts();
                break;
            case 2:
                manageMessages();
                break;
            default:
                break;
        }
    }

    private static void manageContacts(){
        System.out.println("Please Select One:" +
            "\n\t1. Show all contacts" +
            "\n\t2. Add a new contact" +
            "\n\t3. Search for a contact" +
            "\n\t4. Delete a contact" +
            "\n\t5. Go back"
        );
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                showAllContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                searchContact();
                break;
            case 4:
                deleteContact();
                break;
            default:
                showOptions();
                break;
        }
    }

    private static void showAllContacts() {
        for(Contact c: contacts){
            c.getInfo();
        }
        showOptions();
    }
    
    private static void addContact() {
        System.out.println("Please enter the contact's name:");
        String name = scanner.next();
        System.out.println("Please enter the contact's number:");
        String number = scanner.next();
        System.out.println("Please enter the contact's email:");
        String email = scanner.next();

        if (name.equals("") || number.equals("")){
            System.out.println("Please enter both a name and number for the contact");
            addContact();
        }
        else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if (doesExist){
                System.out.println("A contact for" + name + " already exists");
                addContact();
            }
            else{
                Contact contact = new Contact(name,number,email);
                contacts.add(contact);
                System.out.println("Contact for " + name + "has been created");
            }
        }
        showOptions();
    }

    private static void searchContact() {
        System.out.println("Please enter the name of the contact:");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("A name was not entered");
            searchContact();
        }
        else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if (c.getName().equals(name)) {
                    doesExist = true;
                    c.getInfo();
                }
            }
            if(!doesExist) {
                System.out.println("No contact found");
            }
        }
        showOptions();
    }

    private static void deleteContact() {
        System.out.println("Please enter the full name of the contact:");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("A name was not entered");
            deleteContact();
        }
        else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if (c.getName().equals(name)) {
                    doesExist = true;
                    contacts.remove(c);
                }
            }
            if(!doesExist) {
                System.out.println("No contact found");
            }
        }
        showOptions();
    }

    private static void manageMessages(){

    }
}