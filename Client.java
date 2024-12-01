import java.rmi.Naming;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    try {
      TournamentService service = (TournamentService) Naming.lookup("rmi://localhost/TournamentService");
      NotificationCallback callback = new NotificationClient();
      service.registerCallback(callback);

      Scanner scanner = new Scanner(System.in);
      int choix;

      do {
        showMenu();
        choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
          case 1:
            System.out.print("Nom du joueur : ");
            String joueur = scanner.nextLine();
            System.out.print("Nom du tournoi : ");
            String tournoi = scanner.nextLine();
            if (service.inscrireJoueur(joueur, tournoi)) {
              System.out.println("Inscription réussie !");
            } else {
              System.out.println("Inscription échouée !");
            }
            break;
          case 2:
            System.out.println("Tournois disponibles :");
            for (Tournoi t : service.getTournoisDisponibles()) {
              System.out.println("- " + t.getNom() + " (Date : " + t.getDate() + ")");
            }
            break;
          case 3:
            System.out.print("Nom du tournoi : ");
            String tournoiClassement = scanner.nextLine();
            System.out.println("Classement : " + service.getClassements(tournoiClassement));
            break;
          case 4:
            System.out.print("Nom du tournoi : ");
            String nouveauTournoi = scanner.nextLine();
            System.out.print("Date du tournoi : ");
            String date = scanner.nextLine();
            service.creerTournoi(nouveauTournoi, date);
            break;
          case 5:
            System.out.println("Au revoir !");
            break;
          default:
            System.out.println("Choix invalide !");
        }
      } while (choix != 5);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static void showMenu() {
    System.out.println("1. Inscrire un joueur");
    System.out.println("2. Voir les tournois disponibles");
    System.out.println("3. Consulter les classements");
    System.out.println("4. Créer un tournoi");
    System.out.println("5. Quitter");
    System.out.print("Votre choix : ");
  }
}
