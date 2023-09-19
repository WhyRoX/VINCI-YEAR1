public class DessinEtCh {
    
    public static void main(String[] args) {

        Tortue t = new Tortue();
        
        t.accelerer();
        
        for (int i = 0; i < 12; i++) {
            t.tournerADroite(30);
            for (int j = 0; j < 4; j++) {
                t.avancer(90);
                t.tournerADroite(90);

            }

        }
    }
}
