import java.util.Scanner;

public class LimitationDepenses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le montant maximum que vous pouvez dépenser : ");
        int montantMaximum = scanner.nextInt();

        int montantRestant = montantMaximum;

        System.out.print("Entrez le montant de vos achats : ");

        while (true) {
            int achat = scanner.nextInt();

            if (achat <= montantRestant) {
                montantRestant -= achat;
                System.out.print("Montant restant : " + montantRestant);
            } else {
                System.out.print("Montant de l'achat trop élevé.");
                break;
            }
        }

        System.out.println("Montant restant : " + montantRestant);
        scanner.close();
    }
}
