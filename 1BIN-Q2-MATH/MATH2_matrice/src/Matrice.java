import java.util.Arrays;

public class Matrice {
    private final int nbLignes;              // nombre de lignes
    private final int nbColonnes;            // nombre de colonnes
    private final double[][] data;           // matrice (nbLignes,nbColonnes)

    // ce constructeur cree la matrice nulle de genre (a,b)
    public Matrice(int a, int b) throws IllegalArgumentException {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException();
        }
        nbLignes=a ;
        nbColonnes=b ;
        data = new double[a][b] ;
    }

    //  Ce constructeur permet de construire la matrice correspondant 
    //  au tableau en parametre. 
    public Matrice(double[][] tab)  throws IllegalArgumentException {
        if (tab == null || tab.length == 0 || tab[0] == null || tab[0].length == 0){
            throw new IllegalArgumentException();
        }
        int temp = tab[0].length;
        for (int i = 1; i < tab.length; i++) {
            if (tab[i] == null ||tab[i].length != temp) {
                throw new IllegalArgumentException();
            }
        }
        data = new double[tab.length][tab[0].length];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                data[i][j] = tab[i][j];
            }
        }
        nbLignes = tab.length;
        nbColonnes = tab[0].length;
    }

    // constructeur par recopie
    public Matrice(Matrice a)  throws IllegalArgumentException {
        if (a == null) {
            throw new IllegalArgumentException();
        }
        nbLignes = a.nbLignes;
        nbColonnes = a.nbColonnes;

        data = new double[nbLignes][nbColonnes];
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                data[i][j] = a.data[i][j];
            }
        }

	}

    // cree la matrice identite d'ordre a
    public static Matrice identite(int a)  throws IllegalArgumentException {
    	        if (a <= 0) {
            throw new IllegalArgumentException();
        }
        Matrice res = new Matrice(a, a);
        for (int i = 0; i < a; i++) {
            res.data[i][i] = 1;
        }
        return res;
    }
    
    //Cette methode renvoie l'element de la ligne numLigne et de la 
    //colonne numColonne de la matrice. Si cet element n'existe pas, la 
    //methode lance une IllegalArgumentException 
	public double getElement(int numLigne, int numColonne)
			throws IllegalArgumentException {
        if (numLigne <= 0 || numLigne > nbLignes || numColonne <= 0
                || numColonne > nbColonnes) {
            throw new IllegalArgumentException();
        }
        return data[numLigne-1][numColonne-1];
	 }
    
    // ajoute b a la matrice courante si c'est possible
    public Matrice somme(Matrice b)  throws IllegalArgumentException {
        if (b == null || nbLignes != b.nbLignes || nbColonnes != b.nbColonnes) {
            throw new IllegalArgumentException();
        }
        Matrice res = new Matrice(nbLignes, nbColonnes);
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                res.data[i][j] = this.data[i][j] + b.data[i][j];
            }
        }
        return res;
    }

    // calcule le produit scalaire.this de la matrice courante avec scalaire
    public Matrice produitParScalaire(double scalaire){

        Matrice res = new Matrice(nbLignes, nbColonnes);
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                res.data[i][j] = data[i][j] * scalaire;
            }
        }
        return res;
    }

    // calcule le produit this*b de la matrice courante avec b si possible
    public Matrice produitAGauche(Matrice b)  throws IllegalArgumentException {
        if (b == null || nbColonnes != b.nbLignes) {
            throw new IllegalArgumentException();
        }
        Matrice res = new Matrice(nbLignes, b.nbColonnes);
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < b.nbColonnes; j++) {
                for (int k = 0; k < nbColonnes; k++) {
                    res.data[i][j] += data[i][k] * b.data[k][j];
                }
            }
        }
        return res;
    }
    
	// calcule le produit b*this de b avec la matrice courante si possible
    public Matrice produitADroite(Matrice b)  throws IllegalArgumentException {
    	        if (b == null || b.nbColonnes != nbLignes) {
            throw new IllegalArgumentException();
        }
        Matrice res = new Matrice(b.nbLignes, nbColonnes);
        for (int i = 0; i < b.nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                for (int k = 0; k < nbLignes; k++) {
                    res.data[i][j] += b.data[i][k] * data[k][j];
                }
            }
        }
        return res;
    }
	 
   // renvoie true si la matrice courante est carrée
	 public boolean carree(){
        return nbColonnes == nbLignes;
    }
    
    // Calcule this^n. Lance une Mathexception si this n'est pas carrée
    public Matrice puissance(int n) throws  IllegalArgumentException {
    	if (!carree()) {
            throw new MathException();
        }
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return identite(nbLignes);
        }
        Matrice res = identite(nbLignes);
        Matrice temp = new Matrice(this);
        while (n > 0) {
            if (n % 2 == 1) {
                res = res.produitAGauche(temp);
            }
            temp = temp.produitAGauche(temp);
            n /= 2;
        }
        return res;
    }
    
	//Calcule this^T : la tranposée de this
	public Matrice transposee() {
		Matrice res = new Matrice(nbColonnes, nbLignes);
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                res.data[j][i] = data[i][j];
            }
        }
        return res;
	}
	 
    // affiche la matrice en format standard
    public String toString(){
    	        String res = "";
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                res += data[i][j] + "\t";
            }
            res += "\n";
        }
        return res;
    }

     public Matrice pageRank() {
         // Initialiser le vecteur initial de PageRank à [1/N, 1/N, ..., 1/N]
         double initialPageRankValue = 1.0 / nbLignes;
         double[] initialPageRank = new double[nbLignes];
         Arrays.fill(initialPageRank, initialPageRankValue);

         // Créer la matrice de transition en normalisant les colonnes
         Matrice transitionMatrix = new Matrice(nbLignes, nbColonnes);
         for (int j = 0; j < nbColonnes; j++) {
             double sum = 0.0;
             for (int i = 0; i < nbLignes; i++) {
                 sum += data[i][j];
             }
             if (sum != 0) {
                 for (int i = 0; i < nbLignes; i++) {
                     transitionMatrix.data[i][j] = data[i][j] / sum;
                 }
             }
         }

         // Effectuer les itérations du PageRank (85 dans ce cas)
         int numIterations = 85;
         Matrice pagerankMatrix = new Matrice(initialPageRank.length, 1);
         for (int i = 0; i < initialPageRank.length; i++) {
             pagerankMatrix.data[i][0] = initialPageRank[i];
         }
         for (int iter = 0; iter < numIterations; iter++) {
             pagerankMatrix = transitionMatrix.produitAGauche(pagerankMatrix);
         }

         return pagerankMatrix;
     }
}
