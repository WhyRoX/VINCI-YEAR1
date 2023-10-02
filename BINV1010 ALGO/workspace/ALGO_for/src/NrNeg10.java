import java.util.Scanner;

public class NrNeg10 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int neg = 0;
        for (int i = 1; i <= 10 ; i++) {
            System.out.print("Entrez l'entier: ");
            int entier = scanner.nextInt();
            if (entier<0) {
                neg = neg + 1;
            }
        }
        System.out.println(neg);
    }
}
