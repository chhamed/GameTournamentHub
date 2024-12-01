import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NotificationClient extends UnicastRemoteObject implements NotificationCallback {
  public NotificationClient() throws RemoteException {
    super();
  }

  @Override
  public void notify(String message) {
    System.out.println("Notification : " + message);
  }
}
