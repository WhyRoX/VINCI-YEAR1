/**
 * @author Coded by Enes Yumer
 * @Date 11-01-24
 */
public class Developpeur {

    private String nom;
    private String specialite;
    private double salaire;
    private int nbProjetsEnCours;
    public static final String SPECIALITE_PAR_DEFAUT = "full-stack";

    public Developpeur(String nom, String specialite, double salaire) {
        if (nom == null || nom.isEmpty())
            throw new IllegalArgumentException("le nom ne peut pas être null ou vide");
        nbProjetsEnCours = 0;
        this.nom = nom;
        setSpecialite(specialite);
        this.salaire = salaire;
    }

    public Developpeur(String nom, double salaire) {
        this.nom = nom;
        this.salaire = salaire;
        this.specialite = SPECIALITE_PAR_DEFAUT;
    }
    public String getNom() {
        return nom;
    }

    public String getSpecialite() {
        return specialite;
    }

    public double getSalaire() {
        return salaire;
    }

    public int getNbProjetsEnCours() {
        return nbProjetsEnCours;
    }

    public void setSpecialite(String specialite) {
        if (specialite == null || specialite.isEmpty())
            throw new IllegalArgumentException("la specialite ne peut pas être null ou vide");
        this.specialite = specialite;
    }

    public void signalerNouveauProjet() {
        nbProjetsEnCours++;
    }
    public void signalerFinDuProjet() {
        nbProjetsEnCours--;
    }
    @Override
    public String toString() {
        return "Developpeur : " + nom + ", " +
                "Specialite : " + specialite + ", " + "Salaire : " + salaire +
                ", " + "Nombre de projets en cours : " + nbProjetsEnCours;
    }
}
