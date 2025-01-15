public class Tests {

    private int[][] t;

    /**
     * somme tous les entiers de la diagonale principale (\)
     * @return la somme des entiers contenus dans la diagonale principale
     * @throws IllegalStateException si la matrice n'est pas carree
     */
    public int sommeDiagonalePrincipale(){
        if(t.length!=t[0].length)
            throw new IllegalStateException();
        int somme = 0;
        for (int i = 0; i < t.length; i++) {
            somme = somme + t[i][i];
        }
        return somme;
    }

    public Tests(int[][] tTestee){
        t = tTestee;
    }
}