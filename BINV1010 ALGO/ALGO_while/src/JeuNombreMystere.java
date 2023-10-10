public class JeuNombreMystere {
    public static void main(String[] args) {
        int nombreMystere = (int)((Math.random() * 100) + 1);
        int nombreEssais = 0;
        int nombrePropose = 0;
        while (nombrePropose != nombreMystere) {
            System.out.print("Entrez un nombre entre 1 et 100 : ");
            nombrePropose = scanner.nextInt();
            nombreEssais++;
            if (nombrePropose < nombreMystere) {
                System.out.println("Plus grand !");
            }
            else if (nombrePropose > nombreMystere) {
                System.out.println("Plus petit !");
            }
            else {
                System.out.println("Bravo, vous avez trouvé le nombre mystère en " + nombreEssais + " essais !");
            }
        }
    }
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
}
