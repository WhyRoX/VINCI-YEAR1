import java.util.Scanner;

public class NombreMystereInverse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez le nombre � deviner entre 0 et 100 : ");
        int nombreADeviner = scanner.nextInt();

        System.out.println("L'ordinateur va tenter de deviner le nombre...");

        int min = 0;
        int max = 100;
        int essais = 0;
        char reponse;

        do {
            int proposition = (min + max) / 2;
            essais++;
            System.out.println("Est-ce que le nombre a deviner est " + proposition + " ? (+, -, =)");
            reponse = scanner.next().charAt(0);

            if (reponse == '+') {
                min = proposition + 1;
            } else if (reponse == '-') {
                max = proposition - 1;
            }
        } while (reponse != '=' && min <= max);

        if (reponse == '=') {
            System.out.println("L'ordinateur a trouvé le nombre en " + essais + " essais.");
        } else {
            System.out.println("L'ordinateur n'a pas réussi à deviner le nombre. Le nombre � deviner �tait : " + nombreADeviner);
        }
    }
}
