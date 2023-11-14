public class DessinEtoile {
    
    public static void main(String[] args) {
        
        Tortue tortue = new Tortue();

        tortue.accelerer();

        for (int i = 0; i < 3; i++) {
            tortue.definirCouleur("ROUGE");
            tortue.avancer(100);
            tortue.tournerADroite(120);
        }
        
        tortue.definirCouleur("NOIR");
        tortue.tournerADroite(90);
        tortue.avancer(60);
        tortue.tournerAGauche(90);

        for (int i = 0; i < 3; i++) {
            tortue.definirCouleur("BLEU");
            tortue.avancer(100);
            tortue.tournerAGauche(120);
            
        }
    }
}
