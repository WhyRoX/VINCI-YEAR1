public class ResultConcours {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        double meilleureCote = 0;
        int participant = 0;
        boolean exAequo = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Entrez le résultat du participant n°" + (i+1) + ": ");
            double resultat = scanner.nextDouble();

            if (resultat > meilleureCote) {
                meilleureCote = resultat;
                participant = i + 1;
                exAequo = false;
            } else if (resultat == meilleureCote) {
                exAequo = true;
            }

        }
        if (exAequo) {
            System.out.println("Le participant n°" + participant + " a le resultat le plus haut mais il y a un ex-aequo");
        }
        else System.out.println("Le participant n°" + participant);
    }
}