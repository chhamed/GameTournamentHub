
import java.io.Serializable;

public class Joueur implements Serializable {
  private String id;
  private String nom;

  public Joueur(String id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public String getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }
}
