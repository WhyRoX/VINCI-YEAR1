import java.time.LocalDate;

public class CompteEnBanque {
    private PersonneCp titulaire;
    private LocalDate dateValiditeIDCard;
    private String numero;
    private LocalDate dateOuverture;
    private double solde;

    public CompteEnBanque(PersonneCp titulaire, LocalDate dateValiditeIDCard, String numero, LocalDate dateOuverture, double solde) {
        this.titulaire = titulaire;
        this.dateValiditeIDCard = dateValiditeIDCard;
        this.numero = numero;
        this.dateOuverture = dateOuverture;
        this.solde = solde;
    }

    public boolean modifierDateValiditeCarte(LocalDate nouvelleDate) {
        LocalDate aujourdhui = LocalDate.now();
        if (nouvelleDate.isAfter(aujourdhui)) {
            this.dateValiditeIDCard = nouvelleDate;
            return true;
        }
        return false;
    }

    public boolean retirerArgent(double montant) {
        if (montant > 0 && montant <= this.solde) {
            this.solde -= montant;
            return true;
        }
        return false;
    }

    public boolean deposerArgent(double montant) {
        if (montant > 0) {
            this.solde += montant;
            return true;
        }
        return false;
    }

    public boolean effectuerVirement(CompteEnBanque destinataire, double montant) {
        if (montant > 0 && montant <= this.solde) {
            this.solde -= montant;
            destinataire.solde += montant;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Numéro du compte : " + numero + "\nTitulaire : " + titulaire.getPrenom() + " " + titulaire.getNom()
                + "\nDate d'ouverture : " + dateOuverture + "\nSolde : " + solde;
    }
}
