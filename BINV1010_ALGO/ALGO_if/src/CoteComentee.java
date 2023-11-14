public class CoteComentee {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Entrez votre cote : ");
        double cote = scanner.nextDouble();
        if (cote < 10) {
            System.out.println("L’étudiant n’a pas validé l’UE");

        }
        else if (cote >= 10 && cote < 14) {
            System.out.println("L’étudiant a validé l’UE");
        } else if ( cote >= 14 && cote < 16) {
            System.out.println("L’étudiant a validé l’UE avec une belle cote");

        }
        else
            System.out.println("L’étudiant a validé l’UE avec une très belle cote");
    }
}
