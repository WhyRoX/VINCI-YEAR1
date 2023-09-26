public class CalculBMI {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Entrez votre poids (en kg) : ");
        int poids = scanner.nextInt();
        System.out.print("Entrez votre taille (en m) : ");
        double taille = scanner.nextDouble();
        double bmi = poids / (taille * taille);
        if (bmi <= 20) {
            System.out.println("Votre BMI est inferieur à 20, vous êtes mince " + bmi);

            }
            else if (bmi > 20 && bmi <= 25) {
            System.out.println("Vous avez un poids normal " + bmi);
            } else if ( bmi > 25 && bmi <= 30) {
            System.out.println("Vous êtes en embonpoint " + bmi);

        }
        else
            System.out.println("Vous êtes en surprois " + bmi);
    }
}
