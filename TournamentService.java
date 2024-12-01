import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface TournamentService extends Remote {
  boolean inscrireJoueur(String joueurNom, String tournoiNom) throws RemoteException;

  List<Tournoi> getTournoisDisponibles() throws RemoteException;

  List<String> getClassements(String tournoiNom) throws RemoteException;

  boolean creerTournoi(String nom, String date) throws RemoteException;

  void registerCallback(NotificationCallback callback) throws RemoteException;
}
