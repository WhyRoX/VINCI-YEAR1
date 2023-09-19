public class DessinYY {
    
    public static void main(String[] args) {
        
        Tortue t = new Tortue();
        t.accelerer();

        for (int i = 0; i < 360; i++) {
            t.avancer(2);
            t.tournerADroite(1);
        }
        t.tournerADroite(160);
        for (int i = 0; i < 160; i++) {
            t.avancer(1);
            t.tournerAGauche(1);

        }
        //t.tournerADroite(240);
        for (int i = 0; i < 175; i++) {
            t.avancer(1);
            t.tournerADroite(1);
            
        }

    }

}
