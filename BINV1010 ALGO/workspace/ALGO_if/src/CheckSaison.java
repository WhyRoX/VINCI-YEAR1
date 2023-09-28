public class CheckSaison {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Entrez le jour : ");
        int jour = scanner.nextInt();
        System.out.print("Entrez le mois : ");
        int mois = scanner.nextInt();

        if (estDateValide(mois, jour)) {
            String saison = trvSaison(mois, jour);
            System.out.println("La saison est : " + saison);
        } else {
            System.out.println("Date invalide !");
        }
    }

    public static String trvSaison(int mois, int jour) {
        if ((mois == 12 && jour >= 21) || (mois >= 1 && mois <= 2) || (mois == 3 && jour <= 20)) {
            return "Hiver";
        } else if (mois == 3 || mois >= 4 && mois <= 5 || mois == 6 && jour <= 20) {
            return "Printemps";
        } else if (mois == 6 || mois >= 7 && mois <= 8 || mois == 9 && jour <= 22) {
            return "Ete";
        } else if (mois == 9 || mois >= 10 && mois <= 11 || mois == 12) {
            return "Automne";
        } else {
            return "Entrée invalide";
        }
    }
    public static boolean estDateValide(int mois, int jour) {
        if (mois < 1 || mois > 12) {
            return false;
        }
        int[] joursMax = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return jour >= 1 && jour <= joursMax[mois - 1];
    }
}
