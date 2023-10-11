public class Croissant3 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.print("Entier 2 : ");
        int entier2 = scanner.nextInt();
        System.out.print("Entier 3 : ");
        int entier3 = scanner.nextInt();

        if(entier2 > entier1 && entier3 > entier2 ) {
            System.out.println("Nombres introduit dans l'ordre croissant");
        }
        else System.out.println("Nombres introduit en désordre");

    }
}
