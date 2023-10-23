import java.util.Scanner;

public class tests {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args){
        int entier1, entier2, max;
        entier1 = scanner.nextInt();
        entier2 = scanner.nextInt();

        // Mettez l'appel de methode
        max = max2(entier1, entier2);
        System.out.println("max = "+ max);

    }

    // completez l'entete de la methode
    public static int max2 (int entier1, int entier2) {
        if (entier1 > entier2) {
            return entier1;
        } else return entier2;
    }

}
