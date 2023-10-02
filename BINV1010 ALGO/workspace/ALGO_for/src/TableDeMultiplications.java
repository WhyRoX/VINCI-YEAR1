import java.util.Scanner;

public class TableDeMultiplications {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Choissisez la table de multiplication que vous voulez : ");
        int table = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + table + " = " + table*i);

        }
    }
    
}
