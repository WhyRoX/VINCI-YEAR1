import java.util.Scanner;

public class CalculTva {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez le prix hors tva : ");
        double prixHorsTva = scanner.nextDouble();
        System.out.print("Entrez le taux de tva (par exemple 12,5) : ");
        double tauxTva = scanner.nextDouble();
        double prixAvecTva = prixHorsTva + (prixHorsTva*tauxTva/100);
        System.out.println("Le prix avec tva est "+ prixAvecTva);
    }

}
