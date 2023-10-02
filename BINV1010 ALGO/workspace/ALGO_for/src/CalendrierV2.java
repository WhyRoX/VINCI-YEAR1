import java.util.Scanner;

public class CalendrierV2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demande à l'utilisateur de saisir la longueur du mois
        System.out.print("Entrez la longueur du mois (28, 29, 30 ou 31 jours) : ");
        int longueurMois = scanner.nextInt();

        // Demande à l'utilisateur de saisir le jour de la semaine où le 1er du mois tombe
        System.out.print("Entrez le jour de la semaine où le 1er du mois tombe (1 pour lundi, 2 pour mardi, etc.) : ");
        int premierJour = scanner.nextInt();


        // Affichage de l'en-tête du calendrier
        System.out.println("Lu Ma Me Je Ve Sa Di");

        // Variable pour compter les jours du mois
        int jourActuel = 1;

        // Espace initial
        for (int i = 1; i < premierJour; i++) {
            System.out.print("   ");
        }

        // Boucle pour afficher le calendrier
        while (jourActuel <= longueurMois) {
            // Affiche le jour actuel
            System.out.printf("%2d ", jourActuel);
            jourActuel++;

            // Passe à la ligne après chaque dimanche
            if ((jourActuel + premierJour - 1) % 7 == 1) {
                System.out.println();
            }
        }
    }
}

