public class DessinFleur {
    public static void main(String[] args) {
        Tortue t = new Tortue();
        t.accelerer();
        for (int i = 0; i < 4; i++) {
        t.dessinerUnTriangle(100);
        t.tournerAGauche(90);
        }
    }
}
