public class Partie {
    private Date date;
    private Joueur joueurBlanc;
    private Joueur joueurNoir;
    private Tournoi tournoi;
    private double pointBlanc;
    private double pointNoir;

    public Partie(Date date, Joueur joueurBlanc, Joueur joueurNoir, Tournoi tournoi) {
        this.date = date;
        this.joueurBlanc = joueurBlanc;
        this.joueurNoir = joueurNoir;
        this.tournoi = tournoi;
    }

    public Date getDate() {
        return date;
    }

    public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }

    public Joueur getJoueurNoir() {
        return joueurNoir;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }

    public double getPointBlanc() {
        return pointBlanc;
    }

    public double getPointNoir() {
        return pointNoir;
    }
    public boolean enregistrerResultat(double pointBlanc){
        if (pointBlanc == 1){
            this.pointBlanc = 1;
        }
        if (pointBlanc == 0){
            this.pointNoir = 1;
        }
        return false;

    }
    public Joueur recupererGagnant(){
        if (pointBlanc > pointNoir){
            return joueurBlanc;
        }
        else return joueurNoir;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "date=" + date +
                ", joueurBlanc=" + joueurBlanc +
                ", joueurNoir=" + joueurNoir +
                ", tournoi=" + tournoi +
                ", pointBlanc=" + pointBlanc +
                ", pointNoir=" + pointNoir +
                '}';
    }
}
