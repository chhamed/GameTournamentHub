import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
  public static void main(String[] args) {
    try {
      LocateRegistry.createRegistry(1099);
      TournamentService tournamentService = new TournamentServiceImpl();
      Naming.rebind("rmi://localhost/TournamentService", tournamentService);
      System.out.println("Serveur RMI démarré...");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
