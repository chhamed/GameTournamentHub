import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NotificationCallback extends Remote {
    void notify(String message) throws RemoteException;
}
