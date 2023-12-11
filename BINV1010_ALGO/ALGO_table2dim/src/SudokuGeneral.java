
/**
 * Represente une grille de Sudoku d'une taille (presque) quelconque
 */
public class SudokuGeneral {

	private int[][] grille; // Les cases non remplies sont representees par des 0


	/**
	 * verifie si un nombre est deja present dans la ligne dont l'indice est donne
	 * precondition (a ne pas verifier) l'indice est valide
	 * @param nombre le nombre verifie
	 * @param indiceLigne l'indice de la ligne
	 * @return true si le nombre est present dans la ligne, false sinon
	 */
	public boolean estPresentDansLigne(int nombre, int indiceLigne) {

		for (int j = 0; j < grille.length; j++) {
			if (grille[indiceLigne][j] == nombre) return true;
		}
		return false;

	}

	/**
	 * verifie si un nombre est deja present dans la colonne dont l'indice est donne
	 * precondition (a ne pas verifier) l'indice de la colonne est valide
	 * @param nombre le nombre verifie
	 * @param indiceColonne l'indice de la colonne
	 * @return true si le nombre est present dans la colonne, false sinon
	 */
	public boolean estPresentDansColonne(int nombre, int indiceColonne) {

		for (int i = 0; i < grille.length; i++) {
			if (grille[i][indiceColonne] == nombre) return true;
		}
		return false;

	}
	/**
	 * verifie si un nombre est deja present dans la region dont les indices de ligne
	 * et de colonne de la case superieure gauche sont donnees
	 * precondition (a ne pas verifier) les indices sont valides
	 * @param nombre le nombre verifie
	 * @param indiceLigneSupGauche l'indice de la ligne de la case superieure gauche de la region
	 * @param indiceColonneSupGauche l'indice de la colonne de la case superieure gauche de la region
	 * @return true si le nombre est dans la region, false sinon
	 */
	public boolean estPresentDansRegion(int nombre, int indiceLigneSupGauche, int indiceColonneSupGauche) {
		for (int i = indiceLigneSupGauche; i < indiceLigneSupGauche + Math.sqrt(grille.length); i++) {
			for (int j = indiceColonneSupGauche; j < indiceColonneSupGauche + Math.sqrt(grille.length); j++) {
				if (grille[i][j] == nombre) return true;
			}

		}
		return false;

	}


	/**
	 * verifie que si l'on met le nombre 'nombre' a la case dont les indices de ligne et de colonne sont donnees
	 * La grille de sudoku reste legale.
	 * precondition (a ne pas verifier) les indices sont valides
	 * @param indiceLigne indice de la ligne
	 * @param indiceColonne indice de la colonne
	 * @param nombre nombre que l'on veut placer dans la grille
	 * @return true si le coup est legal (voir enonce), false sinon
	 */
	public boolean estCoupLegal(int nombre, int indiceLigne, int indiceColonne) {

		// determine le coin superieur gauche de la region
		int tailleRegion = (int)Math.sqrt(grille.length);
		int indiceLigneSupGauche = (indiceLigne/tailleRegion)*tailleRegion;
		int indiceColonneSupGauche = (indiceColonne/tailleRegion)*tailleRegion; // Division entiere ex (4/3)*3 = 3

		if (estPresentDansLigne(nombre, indiceLigne)) return false;
		if (estPresentDansColonne(nombre, indiceColonne)) return false;
        return !estPresentDansRegion(nombre, indiceLigneSupGauche, indiceColonneSupGauche);

    }
	
	/**
	 * renvoie le nombre le plus present au sein de la grille.
	 * En cas d'ex aequo, n'importe lequel des vainqueurs est renvoye.
	 * @return le nombre le plus present dans la grille ou -1 si la grille est vide
	 */
	public int nombreLePlusPresent() {
		int[] entiers = new int[grille.length + 1];

		boolean grilleNonVide = false;

		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {
				if (grille[i][j] != 0){
					entiers[grille[i][j]] += 1;
					grilleNonVide = true;
				}
			}
		}

		if (!grilleNonVide) return -1;


		int index = 0;
		for (int i = 0; i < entiers.length; i++) {
			if (entiers[i] > entiers[index]) index = i;
		}
		return index;
		// piste pour une solution efficace
		// commencez par remplir une table de frequences
		// nombre de 0, nombre de 1, nombre de 2, ...
		// cette table peut etre completee en un seul parcours de la grille
		// et procedez ensuite a une recherche de max dans cette table
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString(){
		String aRenvoye = "";
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {
				aRenvoye += " "+grille[i][j];
			}
			aRenvoye+="\n";
		}
		return aRenvoye;
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	/**
	 * Constructeur utilise pour les tests.
	 * precondition : la grille passee en parametre est bien une grille de sudoku
	 * @param grilleARecopier grille qui sera recopiee.
	 */
	public SudokuGeneral(int[][] grilleARecopier) {
		this.grille = new int[grilleARecopier.length][grilleARecopier.length];
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille.length; j++) {
				grille[i][j]= grilleARecopier[i][j];
			}
		}
	}
	
}
