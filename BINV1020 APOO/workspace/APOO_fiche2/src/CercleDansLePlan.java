public class CercleDansLePlan {
    private double rayon;
    private Point centre;

    public CercleDansLePlan(double rayon, Point centre) {
        this.rayon = rayon;
        this.centre = centre;
    }

    public double getRayon() {
        return rayon;
    }

    public void setRayon(double rayon) {
        this.rayon = rayon;
    }

    public Point getCentre() {
        return centre;
    }

    public void setCentre(Point centre) {
        this.centre = centre;
    }

    @Override
    public String toString() {
        return "Cercle de rayon " + rayon + " avec le centre situé à " + centre;
    }

    public static void main(String[] args) {
        Point centre = new Point(4, 2.5);
        CercleDansLePlan cercle = new CercleDansLePlan(4, centre);

        System.out.println("Cercle d'origine : " + cercle);

        cercle.setRayon(3.0);
        Point nouveauCentre = new Point(8, 2.5);
        cercle.setCentre(nouveauCentre);

        System.out.println("Cercle modifié : " + cercle);
    }
}
