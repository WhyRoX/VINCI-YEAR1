public class Joueur {

    private String matricule;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private Club club;
    private int partiesJouees;
    private int eloJ;

    public Joueur(String matricule, String nom, String prenom, Date dateDeNaissance,
                  Club club, int partiesJouees, int eloJ) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.club = club;
        this.partiesJouees = 0;
        this.eloJ = 0;
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

    public int getEloJ() {
        return eloJ;
    }
    public void incrementerNbrDePartie(int nbrDeParties) {
        partiesJouees += nbrDeParties;

    }
    public boolean modifierElo(int elo) {
        if (partiesJouees == 10 && eloJ >= 1150){
            eloJ += elo;
            return true;
        }
        else return false;
    }
    public boolean changerClub(Club club){
        if (this.club == club){
            return false;
        }
        else {
            this.club = club;
            return true;
        }
    }
    public String getInfoJoueur() {
        return "Matricule: " + matricule +
                "\nNom: " + nom +
                "\nPrenom: " + prenom +
                "\nDate de naissance: " + dateDeNaissance +
                "\nClub: " + (club != null ? club.getNom() : "Aucun club") +
                "\nParties jouées: " + partiesJouees +
                "\nElo: " + eloJ;
    }
}

