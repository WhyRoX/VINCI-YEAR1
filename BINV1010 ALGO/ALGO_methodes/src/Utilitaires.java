public class Utilitaires {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    /**
     * genere un entier compris entre les 2 valeurs passees en parametre
     * @param valeurMinimale la valeur minimale de l'entier genere
     * @param valeurMaximale la valeur maximale de l'entier genere
     * @return l'entier genere
     */
    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
    }



    /**
     * lit un nombre reel positif ou nul
     * @return un nombre reel positif
     */
    public static double lireReelPositif(){
        double x = scanner.nextDouble();
        while(x < 0){
            System.out.println("Attention le reel doit etre positif");
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
    }


    /**
     * lit un nombre reel compris entre les 2 valeurs passees en parametre
     * @param min le plus petit reel accepte
     * @param max le plus grand reel accepte
     * @return un nombre reel compris entre 2 bornes
     */
    public static double lireReelComprisEntre(double min, double max ){
        double x = scanner.nextDouble();
        while(x < min || x > max){
            System.out.println("Attention le reel doit etre compris entre "+min+" et "+max);
            System.out.print("Recommencez : ");
            x = scanner.nextDouble();
        }
        return x;
    }


    /**
     * lit le caractere o ou n
     * @return le caractere o un n
     */
    public static char lireOouN(){
        char c = scanner.next().charAt(0);
        while(c != 'o' && c != 'n'){
            System.out.println("Attention le caractere doit etre o ou n");
            System.out.print("Recommencez : ");
            c = scanner.next().charAt(0);
        }
        return 'p';
    }

    /**
     * lit un entier non nul
     * @return un entier positif
     */
    public static int lireEntierNonNul(){
        int x = scanner.nextInt();
        while(x == 0){
            System.out.println("Attention le reel doit etre non nul");
            System.out.print("Recommencez : ");
            x = scanner.nextInt();
        }
        return x;
    }

    /**
     * lit si l'utilisateur a écrit quelque chose
     * @return ce qui a été écrit
     */
    public static String lireStringNonVide() {
        String s = scanner.nextLine();
        while (s.isEmpty()) {
            System.out.println("Attention, la chaîne ne doit pas être vide");
            System.out.print("Recommencez : ");
            s = scanner.nextLine();
        }
        return s;
    }

    /**
     * lit un entier positif
     * @return un entier positif
     */
    public static int lireEntierPositif() {
        int x = scanner.nextInt();
        while (x <= 0) {
            System.out.println("Attention, l'entier doit être positif");
            System.out.print("Recommencez : ");
            x = scanner.nextInt();
        }
        return x;
    }
}
