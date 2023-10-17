public class DessinCarresEmboités {
    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();
        int pixels = 150;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 4; j++) {
                tortue.avancer(pixels);
                tortue.tournerADroite(90);

            }

            pixels -= 10;
        }
    }
}
