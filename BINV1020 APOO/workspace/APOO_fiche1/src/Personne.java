public class Personne {

    String identite;
    int jour;
    int mois;
    int annee;
    String rue;

    Personne(String nIdentite, int nJour, int nMois, int nAnnee, String nRue) {

        identite = nIdentite;
        jour = nJour;
        mois = nMois;
        annee = nAnnee;
        rue = nRue;
    }
    int AgeFinAnnee() {
        return 2023 - annee;
    }
    int AgeFin2025() {
        return AgeFinAnnee() + 2;
    }

    public String toString() {
        return "Personne{" +
                "identite='" + identite + '\'' +
                ", jour=" + jour +
                ", mois=" + mois +
                ", annee=" + annee +
                ", rue='" + rue + '\'' +
                '}';
    }
}

