public class CombatAMort {

    public static void main(String[] args) {
        System.out.println("Bienvenue au combat entre CogneDur et FrappeFort !");
        int pointsDeVieCogneDur = 9;
        int pointsDeVieFrappeFort = 12;

        while (true) {
            // CogneDur frappe FrappeFort
            int degatDeCogneDur = lancerDe();
            System.out.println("CogneDur inflige " + degatDeCogneDur + " points de degats � FrappeFort.");
            pointsDeVieFrappeFort -= degatDeCogneDur;

            // V�rification si FrappeFort est mort
            if (pointsDeVieFrappeFort <= 0) {
                System.out.println("FrappeFort est mort. Paix � son �me, il est mort en brave.");
                System.out.println("CogneDur est victorieux!");
                break;
            }

            // FrappeFort frappe CogneDur
            int degatDeFrappeFort = lancerDe();
            System.out.println("FrappeFort inflige " + degatDeFrappeFort + " points de degats � CogneDur.");
            pointsDeVieCogneDur -= degatDeFrappeFort;

            // V�rification si CogneDur est mort
            if (pointsDeVieCogneDur <= 0) {
                System.out.println("CogneDur est mort. Paix � son �me, il est mort en brave.");
                System.out.println("FrappeFort est victorieux!");
                break;
            }

            // Affichage des points de vie restants
            System.out.println("Il reste " + pointsDeVieFrappeFort + " points de vie � FrappeFort.");
            System.out.println("Il reste " + pointsDeVieCogneDur + " points de vie � CogneDur.");
        }
    }

    public static int lancerDe() {
        return (int) ((Math.random() * 6) + 1);
    }
}
