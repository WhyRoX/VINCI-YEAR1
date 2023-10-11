public class Croissant {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.print("Entier 2 : ");
        int entier2 = scanner.nextInt();
        if (entier1 > entier2) {
            System.out.println(entier2 + " < " + entier1);
        } else if (entier2 > entier1) {
            System.out.println(entier1 + " < " + entier2);
        }
        else {
            System.out.println("Les deux entiers sont égaux");
        }
    }
}
