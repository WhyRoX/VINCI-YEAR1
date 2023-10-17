import javax.print.event.PrintJobEvent;

public class Club {

    private String matricule;
    private String nom;
    private Adresse adresse;
    private Joueur directeur;

    public Club(String matricule, String nom, Adresse adresse) {
        this.matricule = matricule;
        this.nom = nom;
        this.adresse = adresse;
    }

    public String getMatricule() {
        return matricule;
    }

    public Joueur getDirecteur() {
        return directeur;
    }

    public String getNom() {
        return nom;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    public boolean initialiserDirecteur(Joueur directeur) {
        if (this.directeur != null || this.directeur == directeur) {
            return false;
        }
        this.directeur = directeur;
        return true;
    }
    public boolean supprimerDirecteur(Joueur directeur) {
        if (this.directeur == directeur) {
            this.directeur = null;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (directeur != null) {
            return matricule + " " + nom + ", " + adresse +
                    ", Directeur: " + directeur;
        }
        else return matricule + " " + nom + ", " + adresse;
    }
}
