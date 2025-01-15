public class Personne1 {

    String identite;
    int jour;
    int mois;
    int annee;
    String rue;
    String numero;
    String codePostal;
    String ville;
    int choixAnnee;

    Personne1(String nIdentite, int nJour, int nMois, int nAnnee, String nRue, String nNumero, String nCodePostal, String nVille, int nChoixAnnee) {

        identite = nIdentite;
        jour = nJour;
        mois = nMois;
        annee = nAnnee;
        rue = nRue;
        numero = nNumero;
        codePostal = nCodePostal;
        ville = nVille;
        choixAnnee = nChoixAnnee;

    }
    int AgeFinAnnee() {
        return 2023 - annee;
    }
    int AgeFinAnneeX() {
        return choixAnnee - annee;
    }
    String Adresse() { return rue + " " + numero + ", " + codePostal + " " + ville; }

    @Override
    public String toString() {
        return "Cette personne s'appelle " + identite +
                " est né(e) le " + jour + " " + mois + " " + annee + " et habite au " + Adresse();
    }
}

