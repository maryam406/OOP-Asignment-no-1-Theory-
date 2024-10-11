import java.util.Scanner;

public class Sender {
    public Message[] messages;
    public static int countercount = 0;
    public Contacts[][] proContacts;
    public static int index = 0;

    public Sender() {
        proContacts = new Contacts[20][2];
        messages = new Message[20];
    }

    public void addcontacts() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Adding the contacts");
        System.out.println("How many contacts u want to add:");
        int num = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name u want to add:");
            String name = scanner.nextLine();
            System.out.println("Enter the number u want to add:");
            String number = scanner.nextLine();
            Contacts contacts = new Contacts(name, number);
            proContacts[countercount][0] = contacts;
            countercount++;
        }
    }

    public void deletecontact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deleting the contact");
        System.out.println("Enter the name of contact u wanted to delete");
        String name = scanner.nextLine();

        for (int i = 0; i < countercount; i++) {
            if (proContacts[i][0].getName().equals(name)) {

                proContacts[i][0] = null;

                System.out.println("The contact has been removed");
                break;
            }
        }

    }

    public void displaycontacts() {
        for (int i = 0; i < countercount; i++) {
            if (proContacts[i][0] != null && proContacts[i][0] != null) {

                System.out.println("Name:" + proContacts[i][0].getName() + "\tNumber:" + proContacts[i][0].getNumber());
            } else {
                System.out.println("This contact was deleted or is empty.");
            }
        }

    }

    public void sendmessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of reciver:");
        String name = scanner.nextLine();
        System.out.println("Enter the content u want to add");
        String content = scanner.nextLine();
        boolean contactFound = false;
        for (int i = 0; i < countercount; i++) {
            if (proContacts[i][0] != null && proContacts[i][0].getName().equals(name)) {
                contactFound = true;
                System.out.println("Current index: " + index);
                System.out.println("Messages array length: " + messages.length);
                if (index < messages.length) {
                    Message message = new Message(name, content);
                    messages[index] = message;
                    messages[index].setSend(true);
                    messages[index].setSeen(false);
                    index++;
                    System.out.println("Message sent to " + name);
                } else {
                    System.out.println("Message limit reached. Cannot send more messages.");
                }

                break;
            }
        }

        if (!contactFound) {
            System.out.println("There is no contact with the name: " + name);

        }

    }

    public void displaymessages() {
        for (int i = 0; i < index; i++) {
            if (messages[i] != null) {
                System.out.println(messages[i].getContent());

            }
        }

    }

    public void specificmessages() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of reciver u wanna see messages of:");
        String name = scanner.nextLine();

        for (int i = 0; i < countercount; i++) {
            if (proContacts[i][0] != null && proContacts[i][0].getName().equals(name)) {
                for (int j = 0; j < index; j++)
                    if (messages[j] != null && messages[j].getReciever().equals(name)) {
                        messages[j].setSeen(true);
                        System.out.println(messages[j].getContent());

                    }
            }
        }

    }

    public void deletemessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the messge u want to delete:");
        String content = scanner.nextLine();

        for (int i = 0; i < index; i++) {
            if (messages[i].getContent().compareTo(content) == 0) {

                messages[i] = null;
                System.out.println("The message is deleted.");
            }
        }

    }

    public void sortmessages() {
        for (int i = 0; i < index - 1; i++) {
            for (int j = 0; j < index - 1; j++) {
                if (messages[j].getTime().compareTo(messages[j + 1].getTime()) < 0) {
                    Message temp = messages[j];
                    messages[j] = messages[j + 1];
                    messages[j + 1] = temp;
                }
            }

        }
        for (int i = 0; i < index; i++) {
            if (messages[i] != null) {
                System.out.println(messages[i].getContent());
            } else {
                System.out.println("there are no messages.please send some messages");

            }
        }
    }

    public void seenmessages() {

        for (int i = 0; i < index; i++) {
            if (messages[i].isSend() == true) {
                if (messages[i].isSeen() == true) {
                    System.out.println(messages[i].getContent());

                }
            }
        }

    }

    public void unseenmessages() {

        for (int i = 0; i < index; i++) {
            if (messages[i].isSend() == true) {
                if (messages[i].isSeen() == false) {
                    System.out.println(messages[i].getContent());

                }
            }
        }

    }

     public void unsendmessage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of reciver:");
        String name = scanner.nextLine();
        System.out.println("Enter the content u want to add");
        String content = scanner.nextLine();
        boolean messageFound = false;
        for (int i = 0; i < index; i++) {
            if (messages[i].getReciever().equals(name)) {
                if (messages[i].getContent().compareTo(content) == 0) {
                    messages[i].setSend(false);
                    System.out.println(
                            "The message to " + name + " with content '" + content + "' has been marked as unsent.");
                    messageFound = true;

                    break;
                }
            }
        }
        if (!messageFound) {
            System.out.println("Message not found or already unsent.");
        }

    }

    public void displayunsend() {

        for (int i = 0; i < index; i++) {
            if (messages[i].isSend() == false) {
                System.out.println(messages[i].getContent());

            }
        }

    }
}
