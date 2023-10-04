public class DuelGuerriers_VI {

    public static void main(String[] args) {

        FenetreCombatGuerriers jeu = new FenetreCombatGuerriers();
        jeu.afficherInformation("A CogneDur");
        int pointsDeVieCogneDur = jeu.lancerDe();
        jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);

        jeu.afficherInformation("A FrappeFort");
        int pointsDeVieFrappeFort = jeu.lancerDe();
        jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);

        jeu.afficherEpee(1);
        jeu.afficherBouclier(2);

        /*int degatDeCogneDur = lancerDe();
        int degatDeFrappeFort = lancerDe();

        System.out.println("CogneDur a " + pointsDeVieCogneDur + " points de vie.");
        System.out.println("FrappeFort a " + pointsDeVieFrappeFort + " points de vie.");

        System.out.println("CogneDur inflige " + degatDeCogneDur + " points de degats a FrappeFort.");
        pointsDeVieFrappeFort -= degatDeCogneDur;

        if (pointsDeVieFrappeFort <= 0) {
            System.out.println("FrappeFort est mort. Paix à son âme, il est mort en brave.");
            System.out.println("CogneDur remporte une coupe en or.");
        } else {
            System.out.println("FrappeFort a " + pointsDeVieFrappeFort + " points de vie.");
            System.out.println("FrappeFort inflige " + degatDeFrappeFort + " points de degats a CogneDur.");
            pointsDeVieCogneDur -= degatDeFrappeFort;
            System.out.println("CogneDur a " + pointsDeVieCogneDur + " points de vie.");

            if (pointsDeVieCogneDur <= 0) {
                System.out.println("CogneDur est mort. Paix à son âme, il est mort en brave.");
                System.out.println("FrappeFort remporte une coupe en or.");
            } else {
                System.out.println("Les deux guerriers sont toujours en vie. C'est un match nul.");
                if (pointsDeVieFrappeFort > pointsDeVieCogneDur) {
                    System.out.println("FrappeFort remporte une coupe en or.");
                    System.out.println("CogneDur remporte une coupe en argent.");
                } else if (pointsDeVieCogneDur > pointsDeVieFrappeFort) {
                    System.out.println("CogneDur remporte une coupe en or.");
                    System.out.println("FrappeFort remporte une coupe en argent.");
                } else {
                    System.out.println("Les deux guerriers ont le même nombre de points de vie.");
                }
            }
        }*/
    }
    public static int lancerDe() {
        return (int) ((Math.random() * 6) + 1);
    }
}
