public class DessinSprirographe {
    
    public static void main(String[] args) {
        
        Tortue t = new Tortue();

        t.accelerer();
        t.accelerer();

        for (int i = 0; i < 50; i++) {
            t.tournerADroite(10);

            for (int j = 0; j < 360; j++) {
                t.avancer(1);
                t.tournerADroite(1);
            }
        }
    }
}
