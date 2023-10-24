public class DessinVentilateur {
    public static void main(String[] args) {
        Tortue t = new Tortue();
        t.accelerer();
        for (int i = 0; i < 3; i++) {
            t.dessinerUnCarre(100);
            t.tournerAGauche(120);
            
        }
    }
}
