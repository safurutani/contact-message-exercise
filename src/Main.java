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
        
    }
    
    private static void addContact() {
        
    }

    private static void searchContact() {
        
    }

    private static void deleteContact() {
        
    }

    private static void manageMessages(){

    }
}