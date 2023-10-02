import java.util.Scanner;

public class Calendrier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la longueur du mois (28, 29, 30 ou 31 jours) : ");
        int longueurMois = scanner.nextInt();

        System.out.print("Entrez le jour de la semaine où le 1er du mois tombe (1 pour lundi, 2 pour mardi, etc.) : ");
        int premierJour = scanner.nextInt();


        String[] jours = {"Lu", "Ma", "Me", "Je", "Ve", "Sa", "Di"};

        // Affichage en-tête calendrier
        for (String jour : jours) {
            System.out.print(jour + " ");
        }
        System.out.println();

        int jourActuel = 1;

        // Boucle pour afficher le calendrier
        for (int semaine = 1; jourActuel <= longueurMois; semaine++) {
            for (int jourSemaine = 1; jourSemaine <= 7; jourSemaine++) {
                if (semaine == 1 && jourSemaine < premierJour) {
                    System.out.print("   ");
                } else if (jourActuel <= longueurMois) {
                    // Afficher le jour
                    System.out.printf("%2d ", jourActuel);
                    jourActuel++;
                } else {
                    // Si tous les jours affichés, imprimer des espaces
                    System.out.print("   ");
                }
            }
            System.out.println(); // A la ligne après chaque semaine
        }
    }
}
