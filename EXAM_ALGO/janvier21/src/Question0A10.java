import java.util.Arrays;
import java.util.NoSuchElementException;

public class Question0A10 {
	
	private String question;
	private int[] tableReponses;
	private int nbReponses;
	private static final int MAX = 10; //nombre max de reponses a conserver dans la table
	
	// A NE PAS CHANGER
	// VA SERVIR POUR LES TESTS
	public Question0A10(String question, int[] tableARecopier){
		this.question = question;
		this.tableReponses = new int[MAX];
		for (int i = 0; i < tableARecopier.length; i++) {
			tableReponses[i]=tableARecopier[i];
		}
		this.nbReponses = tableARecopier.length;
	}

	/**
	 * construit une question sans reponse
	 * @param question l'enonce de la question
	 * @throws IllegalArgumentException si la question est null ou vide 
	 */
	public Question0A10(String question){
		if(question == null || question.isEmpty())
			throw new IllegalArgumentException();
		tableReponses = new int[MAX];
		nbReponses = 0;
	}
	
	
	public int getNbReponses() {
		return nbReponses;
	}
	

	/**
	 * calcule la moyenne des reponses
	 * @return la moyenne
	 * @throws NoSuchElementException s'il n'y a pas de reponse
	 */
	public double moyenne(){
		if(nbReponses ==0)
			throw new NoSuchElementException();
		double somme=0;

		for (int i = 0; i < nbReponses; i++) {
			somme+=tableReponses[i];
		}
		return somme/nbReponses;
	}	
	
	
	/**
	 * verifie si les entiers sont bien tous compris entre 0 et 10
	 * @param table la table a verifier
	 * @return true si tous les entiers sont des reponses, false sinon
	 * @throws IllegalArgumentException si la table est null
	 */
	public static boolean contientReponses(int[] table) {
		if(table == null)
			throw new IllegalArgumentException();
		
		// cette methode est static! C'est la table passee en parametre qui est verifiee
        for (int j : table) {
            if (j > 10 || j < 0) return false;
        }
		//TODO
		return true;
	}
	
	
	/**
	 * ajoute en fin de tableReponses, les reponses contenues dans la table passee en parametre
	 * Ex : tableReponses 3 5 9 7 6 tableReponsesSupp 9 8 2 --> tableReponses 3 5 9 7 6 9 8 2
	 * tableReponses ne peut contenir que MAX reponses 
	 * Il se peut donc que toutes les reponses ne soient pas ajoutees
	 * Ex : (MAX = 10) tableReponses 1 2 3 4 5 6 7 tableReponsesSupp 1 2 3 4 5 --> tableReponses 1 2 3 4 5 6 7 1 2 3
	 * @param tableReponsesSupp la table avec des reponses supplementaires
	 * @throws IllegalArgumentException si la table passee en parametre est null ou n'est pas une table qui contient des reponses
	 */
	public void ajouterReponses(int[] tableReponsesSupp){
		if(tableReponsesSupp==null){
			throw new IllegalArgumentException();
		}
		if(!contientReponses(tableReponsesSupp)){
			throw new IllegalArgumentException();
		}

		int reponsesRestantes = MAX - nbReponses;
		int reponsesAjoutees = Math.min(reponsesRestantes, tableReponsesSupp.length);

		for (int i = 0; i < reponsesAjoutees; i++) {
			tableReponses[nbReponses + i] = tableReponsesSupp[i];
		}
		nbReponses += reponsesAjoutees;
	}
	
	/**
	 * construit une table de frequences a partir des reponses reprises dans tableReponses
	 * @return la table de frequences
	 */
	public int[] tableFrequences() {
		// Initialiser la table de fréquences
		int[] frequences = new int[11]; // Indices de 0 à 10 inclus

		// Compter les occurrences de chaque réponse dans tableReponses
		for (int i = 0; i < nbReponses; i++) {
			int reponse = tableReponses[i];
			frequences[reponse]++;
			// Assurer que la réponse est dans la plage [0, 10]
			/*if (reponse >= 0 && reponse <= 10) {
				frequences[reponse]++;
				System.out.println(Arrays.toString(frequences));
			}*/
		}

		return frequences;
	}



	/**
	 * Recherche la mediane des reponses en utilisant l'algorithme décrit.
	 * @return la mediane
	 * @throws NoSuchElementException s'il n'y a pas de reponse
	 */
	public int mediane() {
		if (nbReponses == 0) {
			throw new NoSuchElementException();
		}

		// Créer une copie temporaire du tableau de réponses
		int[] tempTable = new int[nbReponses];
		for (int i = 0; i < nbReponses; i++) {
			tempTable[i] = tableReponses[i];
		}

		// Définir le nombre d'étapes
		int nombreEtapes = (nbReponses / 2) + 1;

		// Répéter le processus à chaque étape
		for (int etape = 1; etape <= nombreEtapes; etape++) {
			// Recherche de la plus petite valeur dans le tableau temporaire
			int minIndex = 0;
			for (int i = 1; i < tempTable.length; i++) {
				if (tempTable[i] < tempTable[minIndex]) {
					minIndex = i;
				}
			}

			// Remplacer la plus petite valeur par 11
			tempTable[minIndex] = 11;
		}

		// Trouver la médiane en cherchant la première occurrence de 11 dans le tableau temporaire
		int mediane = 11;
		for (int i = 0; i < tempTable.length; i++) {
			if (tempTable[i] == 11) {
				mediane = tempTable[i];
				break;
			}
		}

		return mediane;
	}



	// A NE PAS CHANGER
	// VA SERVIR POUR LES TESTS
	public String toString(){
		String aRenvoyer = ""+question+" ";
		for (int i = 0; i < nbReponses; i++) {
			aRenvoyer += tableReponses[i] + " ";
		}
		return aRenvoyer;
	}


}
