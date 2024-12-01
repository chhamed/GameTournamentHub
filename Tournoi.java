import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Tournoi implements Serializable {
  private static final long serialVersionUID = 1L; // Bonne pratique : ajouter un serialVersionUID

  private String nom;
  private String date;
  private List<String> participants = new ArrayList<>();
  private static final int MAX_PARTICIPANTS = 10;

  public Tournoi(String nom, String date) {
    this.nom = nom;
    this.date = date;
  }

  public String getNom() {
    return nom;
  }

  public String getDate() {
    return date;
  }

  public void addParticipant(String joueurNom) {
    if (participants.size() < MAX_PARTICIPANTS) {
      participants.add(joueurNom);
    }
  }

  public boolean isComplet() {
    return participants.size() >= MAX_PARTICIPANTS;
  }

  public List<String> getClassements() {
    return participants; // Simple classement (ordre d'inscription)
  }
}
