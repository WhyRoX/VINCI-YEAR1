public class Tournoi {
    private String nom;
    private Date dateDebut;
    private Date dateFin;
    private Club organisateur;

    public Tournoi(String nom, Date dateDebut, Date dateFin) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public Tournoi(String nom, Date dateDebut, Date dateFin, Club organisateur) {
        this.nom = nom;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.organisateur = organisateur;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public Club getOrganisateur() {
        return organisateur;
    }

    @Override
    public String toString() {
        return "Tournoi{" +
                "nom='" + nom + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", organisateur=" + organisateur +
                '}';
    }
}
