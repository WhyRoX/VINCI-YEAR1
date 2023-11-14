public class RechercheMax2 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.println("Entier 2 : ");
        int entier2 = scanner.nextInt();
        if (entier1 > entier2) {
            System.out.println(entier1 + " est le plus grand nombre");
        } else {
            System.out.println(entier2 + " est le plus grand nombre");
        }
    }
}
