package Client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.Scanner;

import Server.NoteManager;

public class Client extends UnicastRemoteObject implements ClientCallback {
    private final NoteManager noteManager;

    public Client(NoteManager noteManager) throws RemoteException {
        this.noteManager = noteManager;
        this.noteManager.registerClient(this);
    }

    @Override
    public void notifyChange(String message) throws RemoteException {
        System.out.println("Notification: " + message);
    }

    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Add note");
                System.out.println("2. Edit note");
                System.out.println("3. Remove note");
                System.out.println("4. View notes");
                System.out.println("5. Exit");
                System.out.print("Choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter note content: ");
                        String content = scanner.nextLine();
                        noteManager.addNote(content);
                    }
                    case 2 -> {
                        System.out.print("Enter note ID to edit: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new content: ");
                        String newContent = scanner.nextLine();
                        noteManager.editNote(id, newContent);
                    }
                    case 3 -> {
                        System.out.print("Enter note ID to remove: ");
                        int id = scanner.nextInt();
                        noteManager.removeNote(id);
                    }
                    case 4 -> {
                        List<String> notes = noteManager.getNotes();
                        System.out.println("Notes:");
                        for (int i = 0; i < notes.size(); i++) {
                            System.out.println(i + ": " + notes.get(i));
                        }
                    }
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            NoteManager noteManager = (NoteManager) Naming.lookup("rmi://localhost/NoteManager");
            Client client = new Client(noteManager);
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
