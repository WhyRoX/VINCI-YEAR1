public class CheckSaison {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Jour : ");
        int jour = scanner.nextInt();
        System.out.println("Mois : ");
        int mois = scanner.nextInt();
        String saison;

        if (mois >= 3 && mois <= 6) {
            saison = "Printemps";
            System.out.println(saison);

        } else if (mois >= 6 && mois <= 9) {
            saison = "Ete";
            System.out.println(saison);

        } else if (mois >= 9 && mois <= 12) {
            saison = "Automne";
            System.out.println(saison);

        }
        else {
            saison = "Hiver";
            System.out.println(saison);
        }


    }
}
