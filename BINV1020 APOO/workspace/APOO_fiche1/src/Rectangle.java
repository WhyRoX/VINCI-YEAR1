public class Rectangle {

    double longueur;
    double largeur;
    Rectangle(double nouveauLongueur, double nouveauLargeur) {
        largeur = nouveauLargeur;
        longueur = nouveauLongueur;
    }
    double calculerPerimetre() {
        return 2 * (largeur + longueur);
    }
    double calculerAire() {
        return largeur * longueur;
    }
    public String toString() {
        return "Rectangle{" +
                "longueur=" + longueur +
                ", largeur=" + largeur +
                '}';
    }
}
