import java.util.Scanner;

public class RecicationTableDeMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nombre = (int) (Math.random() * 10) + 1;
        System.out.println("Tu vas donner la table de multiplication par " + nombre + " :");

        boolean erreurs = false;
        int i = 1;

        while (i <= 10) {
            System.out.print(i + " x " + nombre + " = ");
            int reponse = scanner.nextInt();
            int resultatAttendu = i * nombre;

            if (reponse != resultatAttendu) {
                System.out.println("Non, c'est faux, la bonne réponse est " + resultatAttendu);
                erreurs = true;
                break;
            }

            i++;
        }

        if (!erreurs) {
            System.out.println("Félicitations !");
        }

        scanner.close();
    }
}
