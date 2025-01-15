import java.util.Arrays;
import java.util.HashSet;

public class TableauNonTrieDEntiersV2 {

    private int[] t;
    private int nombreEntiers; // taille logique
    private static final int TAILLE = 10; // taille physique

    // Les nombreEntiers entiers occupent les nombreEntiers premieres cases du tableau!
    // PAS DE TROU!
    // L'ordre des entiers doit etre conserve lors des suppressions

    public TableauNonTrieDEntiersV2() {
        t = new int[TAILLE];
        nombreEntiers = 0;
    }


    public int getNombreEntiers() {
        return this.nombreEntiers;
    }
    private int trouverIndice(int entier){
        for (int i = 0; i < nombreEntiers; i++) {
            if(t[i] == entier)
                return i;
        }
        return -1;
    }
    /**
     * supprime la premiere occurrence d'un entier
     * @param entier l'entier a supprimer
     * @return true si l'entier a pu etre supprime, false sinon
     */
    public boolean supprimerPremiereOccurrence(int entier) {
        int indice = trouverIndice(entier);
        if (indice == -1){
            return false;
        }
		/*for (int i = indice; i < nombreEntiers-1; i++) {
			t[i] = t[i+1];

		}*/
        t[indice] = t[nombreEntiers-1];
        nombreEntiers--;
        return true;

        //Attention, l'ordre des entiers doit etre conserver
     
    }

    /**
     * supprime toutes les occurrences d'un entier
     * @param entier l'entier a supprimer
     * @return le nombre de suppressions effectuees
     */
    public int supprimerToutesLesOccurrences(int entier) {
        int indice = 0;
        int indiceEcrire = 0;
        int count = 0;

        while (indice < nombreEntiers) {
            if (t[indice] == entier) {
                count++;
            } else {
                t[indiceEcrire] = t[indice];
                indiceEcrire++;
                System.out.println(Arrays.toString(t));
            }
            indice++;
        }
        nombreEntiers -= count;
        return count;
    }

    /**
     * supprime tous les ex-aequos.
     * Notez que cette methode laisse exactement une occurence de chaque entier qui se trouvait dans le tableau initial.
     * @return int le nombre de suppressions effectuees
     */
    public int supprimerTousLesExAequos() {
        int count = 0;

        for (int i = 0; i < nombreEntiers - 1; i++) {
            for (int j = i + 1; j < nombreEntiers; j++) {
                if (t[i] == t[j]) {
                    for (int k = j; k < nombreEntiers - 1; k++) {
                        t[k] = t[k + 1];
                    }
                    nombreEntiers--;
                    count++;
                    j--;
                }
            }
        }
        return count;
    }

    //A NE PAS MODIFIER
    //VA SERVIR POUR LES TESTS
    public TableauNonTrieDEntiersV2(int[] tableARecopier, int tailleLogique) {
        if (tableARecopier == null)
            throw new IllegalArgumentException();
        if (tailleLogique > tableARecopier.length || tableARecopier.length > TAILLE)
            throw new IllegalArgumentException();
        this.nombreEntiers = tailleLogique;
        t = new int[TAILLE];
        for (int i = 0; i < tableARecopier.length; i++) {
            t[i] = tableARecopier[i];
        }
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public TableauNonTrieDEntiersV2(int[] tableARecopier) {
        this(tableARecopier, tableARecopier.length);
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public HashSet<Integer> toHashSet(){
        HashSet<Integer> ensemble = new HashSet<Integer>();
        for (int i = 0; i < nombreEntiers; i++) {
            ensemble.add(t[i]);
        }
        return ensemble;
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    @Override
    public String toString() {
        if(nombreEntiers ==0)
            return "[]";
        String aRenvoyer = "["+ t[0];
        for (int i = 1; i < nombreEntiers; i++)
            aRenvoyer = aRenvoyer + ", " + this.t[i];
        return aRenvoyer+"]";
    }

}
