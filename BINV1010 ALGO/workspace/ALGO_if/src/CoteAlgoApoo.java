public class CoteAlgoApoo {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Votre cote d'algo : ");
        double coteALGO = scanner.nextDouble();
        System.out.print("Vote cote d'apoo : ");
        double coteAPOO = scanner.nextDouble();
        if (coteALGO > coteAPOO) {
            System.out.println("Vous avez le mieux réussi vote cours d'ALGO");
        } else if (coteAPOO > coteALGO) {
            System.out.println("Vous avez le mieux réussi vote cours d'APOO");
        }
        else {
            System.out.println("Les deux cours sont égaux");
        }

    }
}
