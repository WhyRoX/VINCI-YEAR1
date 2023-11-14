import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choissisez une nombre (>0 et >1) : ");
        int nombre = scanner.nextInt();
        int i = 0;

        while (i < nombre){
            i++;
            System.out.println(i);
        }

    }
}
