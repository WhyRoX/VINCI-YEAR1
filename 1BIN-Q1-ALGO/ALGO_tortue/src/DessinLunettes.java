public class DessinLunettes {
    
    public static void main(String[] args) {
        
        Tortue tortue = new Tortue();

        tortue.definirCouleur("VERT");
        tortue.accelerer();

        for (int i = 0; i < 4; i++) {
            tortue.avancer(100);
            tortue.tournerADroite(90);

        }

        tortue.avancer(150);

        for (int i = 0; i < 4; i++) {
            tortue.avancer(100);
            tortue.tournerADroite(90);
            
        }
    }
}
