public class DessinU {
    
    public static void main(String[] args) {

        Tortue tortue = new Tortue();
        
        tortue.definirCouleur("ROUGE");

        tortue.tournerADroite(90);
        tortue.avancer(100);
        tortue.tournerAGauche(90);
        tortue.avancer(50);
        tortue.tournerAGauche(90);
        tortue.avancer(100);

    }
}
