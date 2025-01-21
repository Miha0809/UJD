package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import Client.ClientCallback;

public interface NoteManager extends Remote {
    void addNote(String note) throws RemoteException;
    void editNote(int id, String newContent) throws RemoteException;
    void removeNote(int id) throws RemoteException;
    List<String> getNotes() throws RemoteException;
    void registerClient(ClientCallback client) throws RemoteException;
}
