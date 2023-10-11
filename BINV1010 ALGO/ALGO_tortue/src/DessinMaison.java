public class DessinMaison {
    
    public static void main(String[] args) {
        
        Tortue tortue = new Tortue();

        for (int i = 0; i < 4; i++) {
            tortue.avancer(100);
            tortue.tournerADroite(90);
            
        }
        for (int j = 0; j < 3; j++) {
            tortue.avancer(100);
            tortue.tournerAGauche(120);
            
        }
    }
}
