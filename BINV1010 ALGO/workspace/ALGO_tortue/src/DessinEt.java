public class DessinEt {
    public static void main(String[] args) {

        Tortue t = new Tortue();

        t.accelerer();

        for (int i = 0; i < 6; i++) {
            t.avancer(60);
            t.tournerAGauche(60);
            t.avancer(60);
            t.tournerADroite(120);
        }
    }
}
