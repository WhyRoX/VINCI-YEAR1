import java.util.Scanner;

public class LimitationDepenses {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le montant maximum que vous pouvez d�penser : ");

        int montantRestant = scanner.nextInt();

        while (true) {
            System.out.print("Entrez le montant de vos achats : ");
            int achat = scanner.nextInt();

            if (achat <= montantRestant) {
                montantRestant -= achat;
                System.out.println("Montant restant : " + montantRestant);
            } else {
                System.out.print("Montant de l'achat trop �lev�.");
                break;
            }
            if (montantRestant == 0){
                System.out.println("Il ne vous reste plus d'argent");
                break;
            }
        }

        //System.out.println("Montant restant : " + montantRestant);
        //scanner.close();
    }
}
