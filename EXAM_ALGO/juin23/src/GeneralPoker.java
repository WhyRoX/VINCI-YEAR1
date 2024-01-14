
public class GeneralPoker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println( estMeilleur(5, 2, 3,7));
		
		System.out.println( estMeilleur(50, 7, 30,2));
		
		System.out.println( estMeilleur(5, 2, 7,1));
		
		System.out.println( estMeilleur(1, 2, 1,6));
		
		System.out.println( estMeilleur(1, 2, 1,2));
		
		System.out.println( estMeilleur(10, 100, 10, 200));
		
		int [] jet1 = {1, 2, 1, 5, 6, 5, 5};	
		System.out.println("Jet 1");
		printMeilleurs( meilleursGroupes(jet1) );
		
		// Egalit�
		int [] jet2 = {1, 1, 1, 5, 6, 5, 6, 5, 4, 4, 4};
		System.out.println("Jet 2");
		printMeilleurs( meilleursGroupes(jet2) );
		
		// Main minimale
		int [] jet3 = {1, 2};		
		System.out.println("Jet 3");
		printMeilleurs( meilleursGroupes(jet3) );
		
		// Tous diff�rents
		int [] jet4 = {1, 100, 3, 10, 15, 2, 7};
		System.out.println("Jet 4");
		printMeilleurs( meilleursGroupes(jet4) );
		
		// Cas main maximale
		int [] jet5 = {10, 10, 10, 10, 10};
		System.out.println("Jet 5");
		printMeilleurs( meilleursGroupes(jet5) );

	}
	
	public static void printMeilleurs(int [][] meilleurs) {
		System.out.println("  Meilleur(s) groupe(s)");
		for (var groupe : meilleurs) {			
			System.out.println("   taille =  "+ groupe[0] + " valeur = " + groupe[1]);
			
		}
		
	}
	
	/**
	 * Renvoie vrai si le groupe 1 est meilleur que le groupe 2. 
	 * Un groupe est constitu� d'un nombre et d'une nature (la valeur)
	 * En cas d'�galit�, la valeur est donc fausse
	 * @param nbrDes1 nombre de d�s du groupe 1
	 * @param valDes1 valeur sur chaque d� du groupe 1
	 * @param nbrDes2 nombre de d�s du groupe 2
	 * @param valDes2 valeur sur chaque d� du groupe 2
	 * @return
	 */
	public static boolean estMeilleur(int nbrDes1, int valDes1, int nbrDes2, int valDes2) {

		if (nbrDes1>nbrDes2) return true;
		if (nbrDes1<nbrDes2) return false;
		return valDes1>valDes2;
	}
	
	/**
	 * Renvoie un tableau 2x2 repr�sentant les deux meilleur groupes d'un jet
	 * Chaque ligne repr�sente un groupement de valeurs. 
	 * la case [0][0] est le nombre de des du meilleur groupement
	 * la case [0][1] est la valeur sur chaque des du meilleur groupement
	 * la case [1][0] est le nombre de des du 2�me meilleur groupement
	 * la case [0][1] est la valeur sur chaque des du 2�me meilleur groupement   
	 * 
	 * Vous pouvez supposer que les entiers seront toujours sup�rieurs � 0. 
	 * Si il n'y a qu'un seul groupement car la taille de celui-ci 
	 * est �gal au nombre de des, la m�thode renvoie un tableau de
	 * une ligne et deux colonnes.
	 * 
	 * @param jet chaque case de ce tableau repr�sente la valeur d'un des d�s 
	 *        du jet.
	 * @return voir description
	 */
	public static int [][] meilleursGroupes(int [] jet){

		int n_max=0;
		int valMax=0;
		int n_max2=0;
		int valMax2=0;
		int n;
		for (int i = 0; i < jet.length; i++) {
			n=0;
			if (jet[i]>0){
				for (int j = 0; j < jet.length; j++) {
					if (jet[i] == jet[j]) {
						n++;
						if (i!=j){
							jet[j] = 0;
						}
					}
				}
				if (n >= n_max2) {
					if (n > n_max ||(n==n_max && valMax<jet[i])) {
						n_max2 = n_max;
						valMax2 = valMax;
						n_max = n;
						valMax = jet[i];
					} else if (valMax2<jet[i]) {
						n_max2 = n;
						valMax2 = jet[i];
					}
				}
			}
		}
		if (n_max2==0 && valMax2==0) {
			int[][] tableMeilleurs = new int[1][2];
			tableMeilleurs[0][0]=n_max;
			tableMeilleurs[0][1]=valMax;
			return tableMeilleurs;
		}
		int[][] tableMeilleurs = new int[2][2];
		tableMeilleurs[0][0]=n_max;
		tableMeilleurs[0][1]=valMax;
		tableMeilleurs[1][0]=n_max2;
		tableMeilleurs[1][1]=valMax2;
		return tableMeilleurs;
	}

}
