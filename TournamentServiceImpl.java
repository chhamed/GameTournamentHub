import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TournamentServiceImpl extends UnicastRemoteObject implements TournamentService {
  private List<Tournoi> tournois = new ArrayList<>();
  private List<NotificationCallback> callbacks = new ArrayList<>();

  public TournamentServiceImpl() throws RemoteException {
    super();
  }

  @Override
  public synchronized boolean inscrireJoueur(String joueurNom, String tournoiNom) throws RemoteException {
    for (Tournoi tournoi : tournois) {
      if (tournoi.getNom().equals(tournoiNom)) {
        if (!tournoi.isComplet()) {
          tournoi.addParticipant(joueurNom);
          notifyClients("Nouveau joueur inscrit : " + joueurNom + " au tournoi " + tournoiNom);
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public List<Tournoi> getTournoisDisponibles() throws RemoteException {
    return tournois;
  }

  @Override
  public List<String> getClassements(String tournoiNom) throws RemoteException {
    for (Tournoi tournoi : tournois) {
      if (tournoi.getNom().equals(tournoiNom)) {
        return tournoi.getClassements();
      }
    }
    return null;
  }

  @Override
  public synchronized boolean creerTournoi(String nom, String date) throws RemoteException {
    Tournoi tournoi = new Tournoi(nom, date);
    tournois.add(tournoi);
    notifyClients("Nouveau tournoi créé : " + nom + " le " + date);
    return true;
  }

  @Override
  public synchronized void registerCallback(NotificationCallback callback) throws RemoteException {
    callbacks.add(callback);
  }

  private void notifyClients(String message) throws RemoteException {
    for (NotificationCallback callback : callbacks) {
      callback.notify(message);
    }
  }
}
