import java.util.Scanner;

public class DeuxMeilleursCotes {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double meilleureCote = 0;
        double deuxiemeMeilleureCote = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Entrez la cote de l'examen n°" + (i + 1) + ": ");
            double cote = scanner.nextDouble();

            if (cote > meilleureCote) {
                deuxiemeMeilleureCote = meilleureCote;
                meilleureCote = cote;
            } else if (cote > deuxiemeMeilleureCote) {
                deuxiemeMeilleureCote = cote;
            }
        }

        System.out.println("Les deux meilleures cotes de l'étudiant sont : " + meilleureCote + " et " + deuxiemeMeilleureCote);

    }
}
