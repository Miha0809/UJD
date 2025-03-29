package Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import Client.ClientCallback;

public class NoteManagerImpl extends UnicastRemoteObject implements NoteManager {
    private final List<String> notes = new ArrayList<>();
    private final List<ClientCallback> clients = new ArrayList<>();

    public NoteManagerImpl() throws RemoteException {
        super();
    }

    @Override
    public synchronized void addNote(String note) throws RemoteException {
        notes.add(note);
        notifyClients("Added note: " + note);
    }

    @Override
    public synchronized void editNote(int id, String newContent) throws RemoteException {
        if (id >= 0 && id < notes.size()) {
            String oldNote = notes.get(id);
            notes.set(id, newContent);
            notifyClients("Edited note: " + oldNote + " -> " + newContent);
        } else {
            throw new RemoteException("Invalid note ID");
        }
    }

    @Override
    public synchronized void removeNote(int id) throws RemoteException {
        if (id >= 0 && id < notes.size()) {
            String removedNote = notes.remove(id);
            notifyClients("Removed note: " + removedNote);
        } else {
            throw new RemoteException("Invalid note ID");
        }
    }

    @Override
    public synchronized List<String> getNotes() throws RemoteException {
        return new ArrayList<>(notes);
    }

    @Override
    public synchronized void registerClient(ClientCallback client) throws RemoteException {
        clients.add(client);
        client.notifyChange("Connected to the server.");
    }

    private void notifyClients(String message) {
        for (ClientCallback client : clients) {
            try {
                client.notifyChange(message);
            } catch (RemoteException e) {
                clients.remove(client);
            }
        }
    }
}
