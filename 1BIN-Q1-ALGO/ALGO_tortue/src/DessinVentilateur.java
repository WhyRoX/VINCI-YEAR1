public class DessinVentilateur {
    
    public static void main(String[] args) {
        
        Tortue t = new Tortue();

        t.accelerer();

        for (int i = 0; i < 3; i++) {
            t.tournerADroite(120);

            for (int j = 0; j < 4; j++) {
                t.avancer(100);
                t.tournerADroite(90);
            }
        }
    }
}
