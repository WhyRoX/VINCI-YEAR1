public class Joueur {

    private String matricule;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private Club club;
    private int partiesJouees;
    private int elo;

    public Joueur(String matricule, String nom, String prenom, Date dateDeNaissance,
                  Club club, int partiesJouees, int elo) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.club = club;
        this.partiesJouees = 0;
        this.elo = 0;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public Club getClub() {
        return club;
    }

    public int getPartiesJouees() {
        return partiesJouees;
    }

    public int getElo() {
        return elo;
    }
    public void incrementerNbrDePartie(int nbrDeParties) {
        partiesJouees += nbrDeParties;

    }

}

