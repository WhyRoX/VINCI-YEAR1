public class Croissant3 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.print("Entier 2 : ");
        int entier2 = scanner.nextInt();
        System.out.println("Entier 3 : ");
        int entier3 = scanner.nextInt();
        if(entier1 < entier2 && entier1 < entier3) {
            System.out.println(entier1);
        } else System.out.println(Math.min(entier2, entier3));
    }
}
