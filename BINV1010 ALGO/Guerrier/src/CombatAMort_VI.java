public class CombatAMort_VI {

    public static void main(String[] args) {

        FenetreCombatGuerriers jeu = new FenetreCombatGuerriers();

        int pointsDeVieCogneDur = 9;
        int pointsDeVieFrappeFort = 12;

        jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);
        jeu.afficherEpee(1);

        jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);
        jeu.afficherBouclier(2);

        while (true) {
            // CogneDur frappe FrappeFort
            int degatDeCogneDur = jeu.lancerDe();
            jeu.afficherInformation("CogneDur inflige " + degatDeCogneDur + " points de degats � FrappeFort.");
            jeu.afficherEpee(1);
            jeu.afficherBouclier(2);
            pointsDeVieFrappeFort -= degatDeCogneDur;
            jeu.afficherPointsDeVie(2, pointsDeVieFrappeFort);

            // V�rification si FrappeFort est mort
            if (pointsDeVieFrappeFort <= 0) {
                jeu.afficherInformation("FrappeFort est mort. Paix � son �me, il est mort en brave.");
                jeu.afficherCoupeOr(1);
                jeu.afficherCroix(2);
                break;
            }

            // FrappeFort frappe CogneDur
            int degatDeFrappeFort = jeu.lancerDe();
            jeu.afficherInformation("FrappeFort inflige " + degatDeFrappeFort + " points de degats � CogneDur.");
            jeu.afficherEpee(2);
            jeu.afficherBouclier(1);
            pointsDeVieCogneDur -= degatDeFrappeFort;
            jeu.afficherPointsDeVie(1, pointsDeVieCogneDur);

            // V�rification si CogneDur est mort
            if (pointsDeVieCogneDur <= 0) {
                jeu.afficherInformation("CogneDur est mort. Paix � son �me, il est mort en brave.");
                jeu.afficherCoupeOr(2);
                jeu.afficherCroix(1);
                break;
            }

            // Affichage des points de vie restants
            jeu.afficherInformation("Il reste " + pointsDeVieFrappeFort + " points de vie � FrappeFort.");
            jeu.afficherInformation("Il reste " + pointsDeVieCogneDur + " points de vie � CogneDur.");
        }
    }
}
