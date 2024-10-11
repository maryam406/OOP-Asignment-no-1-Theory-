import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {

        Sender send = new Sender();
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean running = true;
        do {
            System.out.println("Menu");
            System.out.println("Choose the function u want to do");
            System.out.println("1.Add to Contacts");
            System.out.println("2.Display Contacts");
            System.out.println("3.Send messages");
            System.out.println("4.Delete a contact");
            System.out.println("5.Delete a message");
            System.out.println("6.Display all messages");
            System.out.println("7.Display specific messages");
            System.out.println("8.Display all messages in arranged way");
            System.out.println("9.Unsend messages");
            System.out.println("10.Display unseen messages");
            System.out.println("11.Display seen messages");
            System.out.println("12.Display unsent messages");
            System.out.println("13.Exit the program");
            System.out.println("Enter the number of your function u want to do(1-12):");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("You selected to add to contacts.");
                    send.addcontacts();
                    break;
                case "2":
                    System.out.println("You selected to display contacts.");
                    send.displaycontacts();
                    break;
                case "3":
                    System.out.println("You selected to send a message.");
                    send.sendmessage();
                    break;

                case "4":
                    System.out.println("You selected to delete contacts.");
                    send.deletecontact();
                    break;

                case "5":
                    System.out.println("You selected to delete a message.");
                    send.deletemessage();
                    break;
                case "6":
                    System.out.println("You selected to display all  messages.");
                    send.displaymessages();
                    break;

                case "7":
                    System.out.println("You selected to display specific messages.");
                    send.specificmessages();
                    break;
                case "8":
                    System.out.println("You selected to display the contacts in arranged way.");
                    send.sortmessages();
                    break;
                case "9":
                    System.out.println("You selected to unsend messages.");
                    send.unsendmessage();
                    break;
                case "10":
                    System.out.println("You selected to view unseen messages.");
                    send.unseenmessages();
                    break;
                case "11":
                    System.out.println("You selected to view seen messages.");
                    send.seenmessages();
                    break;
                case "12":
                    System.out.println("You selected to display unsend messages.");
                    send.displayunsend();
                    break;
                case "13":
                    System.out.println("Exiting the program");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select a number between 1 and 12.");
            }

        } while (running);
        scanner.close();
    }
}
