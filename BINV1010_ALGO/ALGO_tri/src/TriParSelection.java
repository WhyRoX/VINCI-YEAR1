import java.util.Arrays;

public class TriParSelection {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * trie la table t en utilisant le tri par selection
	 * @param t table a trier
	 */
	public static void triSelf (int[] t) {
		int index = 0;
		int minimum = 0;
		for (int i = 0; i < t.length -1; i++) {
			minimum = t[i];
			for (int j = i+1; j < t.length; j++) {
				if (t[j] < minimum) {
					minimum = t[j];
					index = t[i];
					t[i] = t[j];
					t[j] = index;
				}
			}
		}
	}
	
	/**
	 * renvoie une nouvelle table triee a partir de la table t.
	 * @param t la table a partir de laquelle on cree la table triee
	 * @return une nouvelle table triee
	 */
	public static int[] tri (int[] t) {
		int[] tableau = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			tableau[i] = t[i];
		}
		triSelf(tableau);
		return tableau;
	}

	/**
	 * renvoie une table de taille 5 contenant les 5 plus petits elements de t.
	 * Si la table t contient moins de 5 elements, la taille de la
	 * table renvoyee sera egale a la taille de t.
	 * @param t la table a partir de laquelle on cree la table demandee
	 * @return une table contenant les 5 plus petits elements de t
	 */
	public static int[] tri5(int[] t) {
		int[] copie = new int[t.length];

		// Copie de la table originale pour éviter de la modifier
		for (int i = 0; i < t.length; i++) {
			copie[i] = t[i];
		}

		// Tri de la copie dans l'ordre croissant
		for (int i = 0; i < copie.length - 1; i++) {
			for (int j = 0; j < copie.length - i - 1; j++) {
				if (copie[j] > copie[j + 1]) {
					int temp = copie[j];
					copie[j] = copie[j + 1];
					copie[j + 1] = temp;
				}
			}
		}

		// Création de la table à renvoyer avec les 5 plus petits éléments
		int[] resultat = new int[Math.min(5, t.length)];

		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = copie[i];
		}

		return resultat;

		// La table passee en parametre ne peut etre modifiee.
		// POUR UNE QUESTION D'EFFICACITE : IL NE FAUT PAS TRIER TOUTE LA TABLE ET
		// ENSUITE PRENDRE LES 5 PREMIERS!!!

		//version simple : utilisez t, une table intermediaire et la table a renvoyer

		//version defi : n'utilisez pas de table intermediaire :
		//utilisez uniquement t et la table a renvoyer
	}
	public static int[] tri52(int[] t) {
		// Initialisation avec les 5 premiers éléments de la table (si elle contient plus de 5 éléments)
		int[] resultat = new int[Math.min(5, t.length)];

		for (int i = 0; i < resultat.length; i++) {
			resultat[i] = t[i];
		}

		// Tri de la table partielle dans l'ordre croissant (tri à bulles)
		for (int i = 0; i < resultat.length - 1; i++) {
			for (int j = 0; j < resultat.length - i - 1; j++) {
				if (resultat[j] > resultat[j + 1]) {
					int temp = resultat[j];
					resultat[j] = resultat[j + 1];
					resultat[j + 1] = temp;
				}
			}
		}

		// Parcours des éléments restants de la table originale
		for (int i = 5; i < t.length; i++) {
			// Si l'élément est plus petit que le plus grand élément actuel dans la table résultante
			if (t[i] < resultat[4]) {
				// Remplacement du plus grand élément par l'élément actuel
				resultat[4] = t[i];

				// Réorganisation pour maintenir l'ordre croissant (tri à bulles)
				for (int j = 0; j < resultat.length - 1; j++) {
					for (int k = 0; k < resultat.length - j - 1; k++) {
						if (resultat[k] > resultat[k + 1]) {
							int temp = resultat[k];
							resultat[k] = resultat[k + 1];
							resultat[k + 1] = temp;
						}
					}
				}
			}
		}

		return resultat;
	}



	/**
	 * trie la table t entre les indices indiceDebut et indiceFin (inclus)
	 * @param t la table a trier
	 * @param indiceMin l'indice du debut de la sous-table a trier
	 * @param indiceMax l'indice de fin de la sous-table a trier
	 * @throws IllegalArgumentException en cas de parametre invalide
	 */
	public static void triPartiel (int[] t, int indiceMin, int indiceMax) {
		if(indiceMax > t.length) throw new IllegalArgumentException("La borne max dépasse la taille du tableau");
		for(int i = indiceMin; i <= indiceMax - 1; i++){
			int iMin = i;
			for(int j = i+1; j <= indiceMax; j++){
				if(t[j] < t[iMin]){
					iMin = j;
				}
			}

			int tmp = t[i];
			t[i] = t[iMin];
			t[iMin] = tmp;
		}
	}


	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 *
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */

	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);
		}
	}


	public static void main (String[] args) {
		int choix;			
		System.out.println("******************************************");
		System.out.println("Programme Test pour le tri par selection :");
		System.out.println("******************************************");
		System.out.println();
		do{
			System.out.println("1 -> Tester la methode 'triSelf()'");
			System.out.println("2 -> Tester la methode 'tri()'");
			System.out.println("3 -> Tester la methode 'tri5()'");
			System.out.println("5-> Tester la methode 'tri52()'");
			System.out.println("4 -> Tester la methode 'triPartiel() (ex supp)'");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){

			case 1: testTriSelf(); 
			break;
			case 2: testTri();
			break;
			case 3: testTri5();
			break;
			case 4: testTriPartiel();
			break;
			case 5: testTri52();
			break;
			}
		}while(choix >=1 && choix<=5);
		System.out.println("Merci pour votre visite.");
	}

	private static void testTriSelf () {

		System.out.println();
		System.out.println("triSelf()");
		System.out.println("---------");

		//test1
		int numeroTest = 1;
		System.out.println("test "+numeroTest+" (table quelconque)");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {1,3,4,6,7,8,9,10,12,15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			triSelf(tableATrier);
			if(tableATrier==null){
				System.out.println("test "+numeroTest+ " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableATrier.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableATrier));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test2
		numeroTest = 2;
		System.out.println("test "+numeroTest+" (table avec 1 entier)");
		try{
			int[] tableATrier = {9};
			int[] tableAttendue = {9};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			triSelf(tableATrier);
			if(tableATrier==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableATrier.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableATrier));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test3
		numeroTest = 3;
		System.out.println("test "+numeroTest+" (table vide)");
		try{
			int[] tableATrier = {};
			int[] tableAttendue = {};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			triSelf(tableATrier);
			if(tableATrier==null){
				System.out.println("test "+numeroTest+ " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableATrier.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableATrier));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test4
		numeroTest = 4;
		System.out.println("test "+numeroTest+ " (table deja triee)");
		try{
			int[] tableATrier = {2,3,4,5};
			int[] tableAttendue = {2,3,4,5};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			triSelf(tableATrier);
			if(tableATrier==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableATrier.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableATrier));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test5
		numeroTest = 5;
		System.out.println("test "+numeroTest+" (table avec ex-aequo)");
		try{
			int[] tableATrier = {2,7,3,2,7,5,1,1,2};
			int[] tableAttendue = {1,1,2,2,2,3,5,7,7};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			triSelf(tableATrier);
			if(tableATrier==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableATrier.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableATrier));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();


		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testTri(){

		System.out.println();
		System.out.println("tri()");
		System.out.println("-----");

		//test1
		int numeroTest = 1;
		System.out.println("test "+numeroTest+" (table quelconque)");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableATrierCopie = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {1,3,4,6,7,8,9,10,12,15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] tableTriee = tri(tableATrier);
			if(tableTriee==null){
				System.out.println("test "+numeroTest+ " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableTriee.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableTriee));
			assertEquals("test "+numeroTest+" ko : la table recue en parametre a ete modifiee",Arrays.toString(tableATrier),Arrays.toString(tableATrierCopie));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test2
		numeroTest = 2;
		System.out.println("test "+numeroTest+ " (table avec 1 entier)");
		try {
			int[] tableATrier = {9};
			int[] tableAttendue = {9};
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			int[] tableTriee = tri(tableATrier);
			if (tableTriee == null) {
				System.out.println("test " + numeroTest + "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableTriee.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableTriee));
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test3
		numeroTest = 3;
		System.out.println("test "+numeroTest+" (table vide)");
		try{
			int[] tableATrier = {};
			int[] tableAttendue = {};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] tableTriee = tri(tableATrier);
			if (tableTriee == null) {
				System.out.println("test " + numeroTest + "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableTriee.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableTriee));
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test4
		numeroTest = 4;
		System.out.println("test "+numeroTest+ " (table deja triee)");
		try{
			int[] tableATrier = {2,3,4,5};
			int[] tableAttendue = {2,3,4,5};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] tableTriee = tri(tableATrier);
			if (tableTriee == null) {
				System.out.println("test " + numeroTest + "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableTriee.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableTriee));
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test5
		numeroTest = 5;
		System.out.println("test "+numeroTest+" (table avec ex-aequo)");
		try{
			int[] tableATrier = {2,7,3,2,7,5,1,1,2};
			int[] tableAttendue = {1,1,2,2,2,3,5,7,7};
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			int[] tableTriee = tri(tableATrier);
			if (tableTriee == null) {
				System.out.println("test " + numeroTest + "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableTriee.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableTriee));
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}
	
	private static void testTriPartiel(){
		System.out.println();
		System.out.println("triPartie()");
		System.out.println("-----------");
		//test1
		int numeroTest = 1;
		System.out.println("test "+numeroTest+" (table quelconque)");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {1,3,4,6,7,8,9,10,12,15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			System.out.println("indiceDebut = 0 et indiceFin = 9");
			triPartiel(tableATrier,0,9);
			if(tableATrier==null){
				System.out.println("test "+numeroTest+ " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableATrier.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableATrier));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test2
		numeroTest = 2;
		System.out.println("test "+numeroTest+" (table quelconque)");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {4,1,3,6,7,8,9,12,15,10};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			System.out.println("indiceDebut = 1 et indiceFin = 8");
			triPartiel(tableATrier,1,8);
			if(tableATrier==null){
				System.out.println("test "+numeroTest+ " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,tableATrier.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(tableATrier));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test3
		numeroTest = 3;
		System.out.println("test "+numeroTest+" (indiceDebut = -1 --> IllegalArgumentException");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {4,1,3,6,7,8,9,12,15,10};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			System.out.println("indiceDebut = -1 et indiceFin = 8");
			triPartiel(tableATrier,-1,8);
			System.out.println("test "+numeroTest+ " ko, il fallait lancer une IllegallArgumentException");
			System.exit(0);

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			System.out.println("Avez-vous prevu l'IllegallArgumentException ?");
			e.printStackTrace();
			System.exit(0);
		}catch(IllegalArgumentException e){

		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test4
		numeroTest = 4;
		System.out.println("test "+numeroTest+" (indiceFin = 10 --> IllegalArgumentException");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {4,1,3,6,7,8,9,12,15,10};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			System.out.println("indiceDebut = 0 et indiceFin = 10");
			triPartiel(tableATrier,0,10);
			System.out.println("test "+numeroTest+ " ko, il fallait lancer une IllegallArgumentException");
			System.exit(0);

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			System.out.println("Avez-vous prevu l'IllegallArgumentException ?");
			e.printStackTrace();
			System.exit(0);
		}catch(IllegalArgumentException e){

		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test5
		numeroTest = 5;
		System.out.println("test "+numeroTest+" (indiceDebut > indiceFin--> IllegalArgumentException");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {4,1,3,6,7,8,9,12,15,10};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			System.out.println("indiceDebut = 4 et indiceFin = 2");
			triPartiel(tableATrier,4,2);
			System.out.println("test "+numeroTest+ " ko, il fallait lancer une IllegallArgumentException");
			System.exit(0);

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ " ko, il y a eu sortie de table");
			System.out.println("Avez-vous prevu l'IllegallArgumentException ?");
			e.printStackTrace();
			System.exit(0);
		}catch(IllegalArgumentException e){

		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testTri5(){
		System.out.println();
		System.out.println("tri5()");
		System.out.println("------");

		//test1
		int numeroTest = 1;
		System.out.println("test "+numeroTest+" (table quelconque)");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableATrierCopie = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {1,3,4,6,7};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri5(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));
			assertEquals("test "+numeroTest+" ko : la table recue en parametre a ete modifiee",Arrays.toString(tableATrier),Arrays.toString(tableATrierCopie));
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test2
		numeroTest = 2;
		System.out.println("test "+numeroTest+" (table avec ex-aequo)");
		try{
			int[] tableATrier = {4,1,3,9,1,3,8,12,12,1};
			int[] tableAttendue = {1,1,1,3,3};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri5(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test3
		numeroTest = 3;
		System.out.println("test "+numeroTest+" (table avec 5 entiers)");
		try{
			int[] tableATrier = {15,8,12,7,10};
			int[] tableAttendue = {7,8,10,12,15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri5(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test4
		numeroTest = 4;
		System.out.println("test "+numeroTest+" (table avec 3 entiers)");
		try{
			int[] tableATrier = {15,8,12};
			int[] tableAttendue = {8,12,15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri5(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test5
		numeroTest = 5;
		System.out.println("test "+numeroTest+" (table avec 1 entier)");
		try{
			int[] tableATrier = {15};
			int[] tableAttendue = {15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri5(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test6
		numeroTest = 6;
		System.out.println("test "+numeroTest+" (table vide)");
		try{
			int[] tableATrier = {};
			int[] tableAttendue = {};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri5(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testTri52(){
		System.out.println();
		System.out.println("tri52()");
		System.out.println("------");

		//test1
		int numeroTest = 1;
		System.out.println("test "+numeroTest+" (table quelconque)");
		try{
			int[] tableATrier = {4,6,3,9,1,15,8,12,7,10};
			int[] tableATrierCopie = {4,6,3,9,1,15,8,12,7,10};
			int[] tableAttendue = {1,3,4,6,7};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri52(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));
			assertEquals("test "+numeroTest+" ko : la table recue en parametre a ete modifiee",Arrays.toString(tableATrier),Arrays.toString(tableATrierCopie));
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test2
		numeroTest = 2;
		System.out.println("test "+numeroTest+" (table avec ex-aequo)");
		try{
			int[] tableATrier = {4,1,3,9,1,3,8,12,12,1};
			int[] tableAttendue = {1,1,1,3,3};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri52(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test3
		numeroTest = 3;
		System.out.println("test "+numeroTest+" (table avec 5 entiers)");
		try{
			int[] tableATrier = {15,8,12,7,10};
			int[] tableAttendue = {7,8,10,12,15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri52(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test4
		numeroTest = 4;
		System.out.println("test "+numeroTest+" (table avec 3 entiers)");
		try{
			int[] tableATrier = {15,8,12};
			int[] tableAttendue = {8,12,15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri52(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test5
		numeroTest = 5;
		System.out.println("test "+numeroTest+" (table avec 1 entier)");
		try{
			int[] tableATrier = {15};
			int[] tableAttendue = {15};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri52(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		//test6
		numeroTest = 6;
		System.out.println("test "+numeroTest+" (table vide)");
		try{
			int[] tableATrier = {};
			int[] tableAttendue = {};
			System.out.println("table testee : "+ Arrays.toString(tableATrier));
			int[] table5 = tri52(tableATrier);
			if(table5==null){
				System.out.println("test "+numeroTest+ "ko, la table est null");
				System.exit(0);
			}
			assertEquals("test "+numeroTest+" ko : taille table apres tri ko",tableAttendue.length,table5.length);
			assertEquals("test "+numeroTest+" ko : contenu table apres tri ko",Arrays.toString(tableAttendue),Arrays.toString(table5));

		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("test "+numeroTest+ "ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		}
		catch(Exception e){
			System.out.println("test "+numeroTest+ "ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test "+numeroTest+ " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

}
