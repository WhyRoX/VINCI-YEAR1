import java.util.Scanner;

public class SommeNegPos {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sommePos = 0;
        int sommeNeg = 0;
        for (int i = 1; i <= 5; i++) {
            System.out.print("Entrez l'entier: ");
            int entier = scanner.nextInt();
            if (entier<0){
                sommeNeg = sommeNeg + entier;
            }
            else sommePos = sommePos + entier;
        }
        System.out.println(sommeNeg);
        System.out.println(sommePos);
    }
}
