public class DessinFleur {
    
    public static void main(String[] args) {
        
        Tortue t = new Tortue();

        t.accelerer();

        for (int i = 0; i < 4; i++) {
            t.tournerADroite(90);
            for (int j = 0; j < 3; j++) {
                t.definirCouleur("BLEU");
                t.avancer(100);
                t.tournerADroite(120);
                
            }
            
        }
    }
}
