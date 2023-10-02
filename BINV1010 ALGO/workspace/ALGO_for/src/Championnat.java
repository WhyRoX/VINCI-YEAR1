import java.util.Scanner;

public class Championnat {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sommeCotes = 0;
        double coteMin = Double.MAX_VALUE;
        double coteMax = 0;

        for (int i = 0; i < 8; i++) {
            System.out.print("Entrez la cote du jury n°" + (i + 1) + ": ");
            double cote = scanner.nextDouble();

            sommeCotes += cote;

            if (cote < coteMin) {
                coteMin = cote;
            }
            if (cote > coteMax) {
                coteMax = cote;
            }
        }
        double resultat = (sommeCotes - coteMin - coteMax) / 6;

        System.out.println("Le résultat du concurrent est : " + resultat);

        if (resultat >= 8) {
            System.out.println("Le concurrent est sélectionné pour la finale !");
        } else {
            System.out.println("Le concurrent n'est pas sélectionné pour la finale.");
        }
    }
}
