public class Personne {

    String identite;
    int jour;
    int mois;
    int annee;
    String rue;
    int choixAnnee;

    Personne(String nIdentite, int nJour, int nMois, int nAnnee, String nRue, int nChoixAnnee) {

        identite = nIdentite;
        jour = nJour;
        mois = nMois;
        annee = nAnnee;
        rue = nRue;
        choixAnnee = nChoixAnnee;

    }
    int AgeFinAnnee() {
        return 2023 - annee;
    }
    int AgeFinAnneeX() {
        return choixAnnee - annee;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "identite='" + identite + '\'' +
                ", jour=" + jour +
                ", mois=" + mois +
                ", annee=" + annee +
                ", rue='" + rue + '\'' +
                ", choixAnnee=" + choixAnnee +
                '}';
    }
}

