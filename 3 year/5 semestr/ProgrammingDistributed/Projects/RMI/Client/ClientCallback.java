package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote {
    void notifyChange(String message) throws RemoteException;
}
