import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    private static ArrayList<Contact> contacts;
    private static Scanner scanner;
    private static int id = 0;
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
        System.out.println("Please Select One:" +
            "\n\t1. Show all messages" +
            "\n\t2. Send a new message" +
            "\n\t3. Go back"
        );
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                showAllMessages();
                break;
            case 2:
                sendMessage();
                break;
            default:
                showOptions();
                break;
        }
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for(Contact c: contacts){
            allMessages.addAll(c.getMessages());
        }
        if(allMessages.size()>0){
            for(Message m: allMessages){
                m.getInfo();
                System.out.println("______________");
            }
        }
        else{
            System.out.println("No messages found");
        }
        showOptions();
    }

    private static void sendMessage() {
        System.out.println("Who would you like to send a message?");
        String name = scanner.next();
        if (name.equals("")){
            System.out.println("A name was not entered");
            sendMessage();
        }
        else {
            boolean doesExist = false;
            for(Contact c: contacts){
                if (c.getName().equals(name)) {
                    doesExist = true;
                }
            }
            if(!doesExist) {
                System.out.println("No contact found");
            }
            else {
                System.out.println("Type your message");
                String text = scanner.next();
                if (text.equals("")){
                    System.out.print("Please enter a message");
                    sendMessage();
                }
                else{
                    id++;
                    Message newMessage = (new Message(text, name, id));
                    for (Contact c: contacts){
                        ArrayList<Message> newMessages = c.getMessages();
                        newMessages.add(newMessage);
                        Contact currentContact = c;
                        currentContact.setMessages((newMessages));
                        contacts.remove(c);
                        contacts.add(currentContact);
                    }
                }
                showOptions();
            }
        }
    }
}