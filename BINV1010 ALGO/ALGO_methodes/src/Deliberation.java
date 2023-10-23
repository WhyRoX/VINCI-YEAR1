import javax.swing.text.Utilities;

public class Deliberation {

    public static void main(String[] args) {
        int nbrEtudiants = 25;
        double moyenneClasse = 0;
        for (int i = 1; i < nbrEtudiants; i++) {
            System.out.println("Calul de la moyenne de l'étudiant " + i);
            double moyenneEtudiant = calculerMoyenneEtudiant();
            moyenneClasse += moyenneEtudiant;
        }
        System.out.println("La moyenne de la classe est : " + moyenneClasse/nbrEtudiants);

    }
    /**
     * Cette méthode calcule la moyenne des notes d'un étudiant.
     *
     * @return La moyenne des notes de l'étudiant.
     */
    public static double calculerMoyenneEtudiant(){
        int nbrDeCotes = 10;
        double sommeDesCotes = 0;
        for (int i = 1; i <= nbrDeCotes ; i++) {
            System.out.print("Entrez la note n°" + i + ": ");
            double cote = Utilitaires.lireReelComprisEntre(0,20);
            sommeDesCotes += cote;
        } return sommeDesCotes/nbrDeCotes;
    }

}
