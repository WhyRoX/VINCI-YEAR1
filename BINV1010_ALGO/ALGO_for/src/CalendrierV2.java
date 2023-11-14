import java.util.Scanner;

public class CalendrierV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez la longueur du mois (28, 29, 30 ou 31 jours) : ");
        int longueurMois = scanner.nextInt();

        System.out.print("Entrez le jour de la semaine où le 1er du mois tombe (1 pour lundi, 2 pour mardi, etc.) : ");
        int premierJour = scanner.nextInt();


        // Affichage en-tête calendrier
        System.out.println("Lu Ma Me Je Ve Sa Di");

        int jourActuel = 1;

        // Espace initial
        for (int i = 1; i < premierJour; i++) {
            System.out.print("   ");
        }

        // Boucle pour afficher le calendrier
        while (jourActuel <= longueurMois) {

            System.out.printf("%2d ", jourActuel);
            jourActuel++;

            // Passe à la ligne après chaque dimanche
            if ((jourActuel + premierJour - 1) % 7 == 1) {
                System.out.println();
            }
        }
    }
}

