public class RechercheMax3V2 {
public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez l'entier 1 : ");
        int entier1 = Utilitaires.lireEntierPositif();
        System.out.print("Entrez l'entier 2 : ");
        int entier2 = Utilitaires.lireEntierPositif();
        System.out.print("Entrez l'entier 3 : ");
        int entier3 = Utilitaires.lireEntierPositif();

        System.out.println("Le plus grand entier est " +
                max3(entier1, entier2, entier3));
    }
    @SuppressWarnings("all")
    public static int max3(int a, int b, int c){
        if(a > b && a > c){
            return a;
        }else{
            if(b > c){
                return b;
            }else{
                return c;
            }
        }
    }

}
