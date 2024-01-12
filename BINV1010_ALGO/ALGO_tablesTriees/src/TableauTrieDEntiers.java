public class TableauTrieDEntiers{

	private int [] t;  // table d'entiers triee par ordre croissant
	private int nombreEntiers;    // nombre d'entiers dans t
	private static final int TAILLE = 10;


	public TableauTrieDEntiers(){
		t = new int[TAILLE];
		nombreEntiers = 0;
	}

	public int getNombreEntiers(){
		return nombreEntiers;
	}

	/** 
	 * methode qui ajoute un entier si la table n'est pas encore pleine.
	 * La table doit rester triee!
	 * @param entier l'entier a ajouter
	 * @return boolean signale si l'entier a pu etre ajoute
	 */
	public boolean ajouterUnEntier(int entier){

		if(nombreEntiers == t.length) {
			return false;
		}

		int i = nombreEntiers-1;
		while(i>=0 && t[i] > entier) {
			t[i+1] = t[i];
			i--;
		}
		t[i+1] = entier;
		nombreEntiers++;
		return true;

		// CONTRAINTE : UTILISER L ALGORITHME D INSERTION DANS UNE TABLE TRIEE VU AU COURS
		// ou une variante plus efficace : il n'est pas indispensable de faire des permutations
		// de simples decalages suffisent
		// Dans l'algorithme vu au cours, l'element ajoute est deplace d'une case à la fois
		// jusqu'a sa place, alors qu'il pourrait etre deplace en une fois apres avoir fait les decalages
		// necessaires
		// A REFLECHIR !
	}

	
	/**
	 * methode qui recherche l'indice correspondant a la premiere occurrence de l'entier passe en parametre
	 * @param entier l'entier recherche
	 * @return indice correspondant a l'entier, -1 s'il n'est pas dans la table
	 */
	private int trouverIndiceLineaire(int entier){
		
		//recherche sequentielle cout O(N)

		for (int i = 0; i < this.nombreEntiers; i++) {
			if (t[i]==entier)
				return i;
			if (t[i]>entier)
				return -1;
		}
		return -1;
		
	}

	
	/** 
	 * methode qui verifie si la table contient l'entier passe en parametre
	 * @param entier l'entier recherche
	 * @return boolean true si l'entier est present dans la table, false sinon
	 */
	public boolean contient(int entier){
		

		// UTILISER LA METHODE trouverIndiceLineaire() donnee

		return trouverIndiceLineaire(entier) != -1;

	}  

	
	/** 
	 * methode qui supprime une occurrence de l'entier passe en parametre.
	 * La table doit rester triee!
	 * @param entier l'entier a supprimer
	 * @return boolean signale si l'entier a pu etre supprime
	 */
	public boolean supprimerUneOccurrence(int entier) {

		int index = trouverIndiceLineaire(entier);
		if (index == -1) {
			return false;
		}
		for (int i = index; i < nombreEntiers - 1; i++) {
			t[i] = t[i + 1];
		}
		nombreEntiers--;
		return true;
	}

	
	/** 
	 * methode qui supprime toutes les occurrences d'un entier
	 * @param entier l'entier a supprimer
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(int entier){

		int nbrSuppr = 0;
		int nbrASuppr = 0;
		for(int i=0; i<nombreEntiers; i++) {
			if(t[i] == entier) {
				nbrASuppr++;
			}else {
				t[i-nbrASuppr] = t[i];
			}
		}
		nombreEntiers = nombreEntiers - nbrASuppr;
		nbrSuppr = nbrASuppr;
		return nbrSuppr;

		//Dans une table triee, toutes les occurrences de l'entier se suivent
		//Il est possible d'ecrire cette methode en un seul passage dans la boucle
		//Pour une question d'efficacite, evitez d'utiliser la methode supprimerUneOccurrence()

	}

	
	/** 
	 * methode qui verifie si la table contient des ex-aequos
	 * @return boolean true si la table contient des ex-aequos, false sinon
	 */
	public boolean contientExAequo(){
		for(int i=0; i<nombreEntiers-1; i++) {
			if(t[i] == t[i+1])
				return true;
		}
		return false;

		// Il est possible d'ecrire cette methode en un seul passage dans la boucle
		// N'oubliez pas que la table est triee!
	}

	
	/** 
	 * methode qui supprime tous les ex-aequos
	 * @return int le nombre de suppressions effectuees
	 */
	public int supprimerTousLesExAequos(){
		int nombreExSupp;
		int nombreExASupp = 0;
		for(int i=1; i<nombreEntiers; i++) {
			if(t[i] == t[i-1]) {
				nombreExASupp++;
			}else {
				t[i-nombreExASupp] = t[i];
			}
		}
		nombreExSupp = nombreExASupp;
		nombreEntiers = nombreEntiers - nombreExASupp;
		return nombreExSupp;

	}

	//A ne pas modifier
	//Va servir pour les tests
	public String toString(){
		if(nombreEntiers ==0)
			return "[]";
		String aRenvoyer = "["+ t[0];
		for (int i = 1; i < nombreEntiers; i++)
			aRenvoyer = aRenvoyer + ", " + t[i];
		return aRenvoyer+"]";
	}

	/**
	 * constructeur par recopie
	 * ce constructeur leve une exception si la table passee en parametre contient plus de 10 entiers
	 * utile pour les tests et/ou si elle n'est pas triee
	 * @param tableARecopier une table triee d'au plus TAILLE entiers triee par ordre croissant
	 */

	public TableauTrieDEntiers(int[] tableARecopier){
		if (tableARecopier.length>TAILLE)
			throw new IllegalArgumentException();
		this.nombreEntiers = tableARecopier.length;
		t = new int[TAILLE];
		if(tableARecopier.length!=0)
			t[0] = tableARecopier[0];
		for (int i = 1; i< nombreEntiers; i++){
			if(tableARecopier[i]<tableARecopier[i-1]){
				throw new IllegalArgumentException();
			}
			t[i] = tableARecopier[i];
		}
	}


}