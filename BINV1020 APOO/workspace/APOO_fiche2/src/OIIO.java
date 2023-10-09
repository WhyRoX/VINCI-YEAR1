public class OIIO {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {

    char reponse;
    double totalCotes = 0;
    do {
        System.out.println("Entrez une cote (sur 20) : ");
        double cote = scanner.nextDouble();
        totalCotes += cote;
        System.out.println("Encore une cote (Y/N) ? ");
        reponse = scanner.next().charAt(0);
        
    } while (reponse == 'Y');

        System.out.println("La somme des cotes : " + totalCotes);
    }
}

