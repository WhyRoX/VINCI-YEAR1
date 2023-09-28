public class Personne {
    private String nom;
    private String prenom;
    private Adresse domicile;
    private Date dateDeNaissance;

    public Personne(String nNom,
                    String nPrenom,
                    Date nDateDeNaissance,
                    Adresse nDomicile) {
        if (!estJourMoisValide(nDateDeNaissance)) {
            throw new IllegalArgumentException("Date de naissance invalide.");
        }
        nom = nNom;
        prenom = nPrenom;
        domicile = nDomicile;
        dateDeNaissance = nDateDeNaissance;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public Adresse getDomicile() {
        return domicile;
    }
    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public int calculerAge() {
        return 2023 - dateDeNaissance.getAnnee();
    }
    public int calculerAgeEn(int an) {
        return an - dateDeNaissance.getAnnee();
    }


    public void demenager(String nRue, String nNumero, String nCodePostal, String nVille) {
        if (nRue != null && nNumero != null && nCodePostal != null && nVille != null) {
            domicile = new Adresse(nRue, nNumero, nCodePostal, nVille);
        } else {
            throw new IllegalArgumentException("Informations d'adresse invalides.");
        }
    }
    // Essaie en traduisant code python similaire, voir qqpart dans mooc.
    public boolean estJourMoisValide(Date date) {
        int jour = date.getJour();
        int mois = date.getMois();
        int annee = date.getAnnee();

        // Matrice jours
        int[] joursMax = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // Vérifier si le mois est valide (entre 1 et 12)
        if (mois < 1 || mois > 12) {
            return false;
        }
        // Vérif jour valide?
        if (jour < 1 || jour > joursMax[mois - 1]) {
            return false;
        }

        // fevrier bissextile
        if (mois == 2 && (annee % 4 == 0 && (annee % 100 != 0 || annee % 400 == 0))) {
            return jour <= 29;
        }
        return true;
    }


    @Override
    public String toString() {
        return prenom + " " + nom + " né le " + dateDeNaissance.toString() + " " + domicile.toString();

    }
    //@Override
    //public String toString() {
    //    StringBuilder sb = new StringBuilder();
    //    sb.append(prenom).append(" ").append(nom).append(" né le ").append(dateDeNaissance.toString()).append(" ").append(domicile.toString());
    //    return sb.toString();
    //}
}
