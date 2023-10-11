
public class MeetNbr {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {
        int nbrPos = 0;
        int nbrNeg = 0;
        for (int i = 0; i < 10; i++){
            System.out.print("Donnez une chiffre : ");
            int ent = scanner.nextInt();
            if (ent < 0) {
                nbrNeg++;
            }
            else nbrPos++;

        }
        System.out.println("Nombre de pos : " + nbrPos);
        System.out.println("Nombre de neg : " + nbrNeg);
    }
}
