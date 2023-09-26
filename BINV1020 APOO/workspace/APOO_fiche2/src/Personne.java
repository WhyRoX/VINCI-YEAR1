public class Personne {
    private String nom, prenom;
    // private String prenom;
    private Adresse domicile;

    private Date dateDeNaissance;

    public Personne(String nNom,
                    String nPrenom,
                    Date nDateDeNaissance,
                    Adresse nDomicile) {
        nom = nNom;
        prenom = nPrenom;
        domicile = nDomicile;
        dateDeNaissance = nDateDeNaissance;
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

    public Adresse getDomicile() {
        return domicile;
    }
    public void demenager(String nRue, String nNumero, String nCodePostal, String nVille) {
        domicile = new Adresse(nRue, nNumero, nCodePostal, nVille);
    }


    //public String fournirDateNaissance() {
    //    return jourNaissance + "/" + moisNaissance + "/" + anneeNaissance;
    //}
    //public Adresse fournirDomicile() {
    //    return domicile;
    //}

    public String toString() {
        return prenom + " " + nom + " né le " + dateDeNaissance.toString() + " " + domicile.toString();

    }
}
