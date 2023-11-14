public class CalculMoyenne {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        char reponse;
        double totalCotes = 0;
        int nbrCotes = 0;

        do {
            System.out.println("Entrez une cote (sur 20) : ");
            double cote = scanner.nextDouble();
            totalCotes += cote;
            nbrCotes++;
            System.out.println("Encore une cote (Y,y,O,o/N) ? ");
            reponse = scanner.next().charAt(0);
        } while (reponse == 'Y' || reponse == 'y' || reponse == 'O' || reponse == 'o');

        System.out.println("La moyenne des cotes : " + totalCotes/nbrCotes);
    }

}
