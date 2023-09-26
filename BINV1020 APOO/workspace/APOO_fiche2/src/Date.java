public class Date {
    private int annee;
    private int mois;
    private int jour;

    public Date(int nAnnee, int nMois, int nJour) {
        annee = nAnnee;
        mois = nMois;
        jour = nJour;
    }

    public int getAnnee() {
        return annee;
    }

    public int getMois() {
        return mois;
    }

    public int getJour() {
        return jour;
    }
    public String toString() {
        return jour + "/" + mois + "/" + annee;
    }

}
