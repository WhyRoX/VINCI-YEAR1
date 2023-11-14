public class CoteCommenteeV2 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrez votre cote : ");
        double cote = Utilitaires.lireReelPositif();
        System.out.println(donnerCommentaire(cote));
    }

    /**
     * @param cote de l'étudiant
     * @return si l'étudiant a validé l'UE ou non, si oui précise
     *         si la cote était bonne ou pas
     */
    public static String donnerCommentaire(double cote){
        if (cote < 10) {
            return "L’étudiant n’a pas validé l’UE";

        }
        else if (cote >= 10 && cote < 14) {
            return "L’étudiant a validé l’UE";
        } else if ( cote >= 14 && cote < 16) {
            return "L’étudiant a validé l’UE avec une belle cote";

        }
        return "L’étudiant a validé l’UE avec une très belle cote";
    }
}
