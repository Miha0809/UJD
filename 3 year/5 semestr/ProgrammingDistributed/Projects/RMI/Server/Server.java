package Server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            NoteManagerImpl noteManager = new NoteManagerImpl();
            LocateRegistry.createRegistry(1099);
            Naming.rebind("NoteManager", noteManager);
            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
