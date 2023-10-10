import java.util.Scanner;
public class LectureNombres {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nombrePositifs = 0;

        System.out.println("Entrez 5 nombres strictement positifs :");

        while (nombrePositifs < 5) {
            int nombre = scanner.nextInt();

            if (nombre > 0) {
                nombrePositifs++;
            }
            else {
                System.out.println("Le nombre " + nombre + " n'est pas strictement positif.");
            }
        }
        System.out.println("Vous avez entré 5 nombres strictement positifs.");
    }
}
