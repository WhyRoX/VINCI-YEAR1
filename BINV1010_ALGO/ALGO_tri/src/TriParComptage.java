import java.util.Arrays;

public class TriParComptage {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Trie le tableau t en utilisant le tri par comptage
	 * precondition (a ne pas verifier) : les entiers contenus dans la table sont compris entre 0 et borneSup
	 * @param t la table a trier
	 * @param borneSup la borne sup des entiers contenus dans la table
	 */
	public static void triSelf (int[] t, int borneSup) {
		int[] nombres = new int[borneSup +1];
		for (int k : t) {
			nombres[k]++;
		}

		int i = 0;
		int j = 0;

		while (i < t.length || j < nombres.length) {
			if (nombres[j] == 0) j++;
			else {
				t[i] = j;
				nombres[j]--;
				i++;
			}
		}
	}
   
   /**
	 * trie la table t en utilisant le tri par comptage
	 * precondition (a ne pas verifier) : les entiers contenus dans la table sont compris entre borneInf et borneSup
	 * @param t la table a trier
	 * @param borneInf la borne inf des entiers contenus dans la table
	 * @param borneSup la borne sup des entiers contenus dans la table
	 */
   public static void triSelf (int[] t, int borneInf, int borneSup) {
		// TODO 
	    //exercice supplementaire
	    //la methode precedente pourrait appeler cette methode, modifiez-la
   }
   
   /**
	 * trie le tableau t en utilisant le tri par comptage
	 * @param t
	 */
   public static void triSelf (int[] t) {
	    // TODO 
	    //exercice supplementaire
	    // cette methode pourrait utiliser la methode precedente !
   }
	
   private static void afficher(int[] table){
		for(int i = 0 ; i < table.length ; i++)
			System.out.print(" "+ table[i]);
		System.out.println();
	}

	private static boolean sontIdentiques(int[] table1, int[] table2){
		if(table1.length != table2.length)
			return false;
		for(int i = 0 ; i < table1.length ; i++)
			if(table1[i]!=table2[i])
				return false;
		return true;

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

	public static void main(String[] args) {
		int choix;
		System.out.println("*****************************************");
		System.out.println("Programme Test pour le tri par comptage :");
		System.out.println("*****************************************");
		System.out.println();

		do{
			System.out.println("1 -> Tester la methode 'triSelf(int[] t, int borneSup)'");
			System.out.println("2 -> Tester la methode 'triSelf(int[] t, int borneInf, int borneSup) (ex supp)");
			System.out.println("3 -> Tester la methode 'triSelf() (ex supp)");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){

				case 1: testTri0Max();
					break;
				case 2: testTriMinMax();
					break;
				case 3: testTri();
					break;
			}
		}while(choix >= 1 && choix <= 3);
		System.out.println("Merci pour votre visite.");
	}

	public static void testTri0Max() {
		System.out.println();
		System.out.println("triSelf(int[] t, int borneSup)");
		System.out.println("------------------------------");

		//test1
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " (table quelconque - tous les entiers 0 --> 9 presents)");
		try {
			int[] tableATrier = {4,2,2,7,3,0,2,5,1,9,2,8,5,2,6,5};
			int[] tableAttendue = {0,1,2,2,2,2,2,3,4,5,5,5,6,7,8,9};
			int borneSup = 9;
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			System.out.println("borne sup : "+borneSup);
			triSelf(tableATrier,borneSup);
			if (tableATrier == null) {
				System.out.println("test " + numeroTest + " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableATrier.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableATrier));

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		//test2
		numeroTest = 2;
		System.out.println("test " + numeroTest + " (table quelconque sans 0, 3, 6 et 8)");
		try {
			int[] tableATrier = {4,2,2,7,2,1,2,5,1,9,2,7,5,2,5,5};
			int[] tableAttendue = {1,1,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
			int borneSup = 9;
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			System.out.println("borne sup : "+borneSup);
			triSelf(tableATrier,borneSup);
			if (tableATrier == null) {
				System.out.println("test " + numeroTest + " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableATrier.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableATrier));

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		//test 3
		numeroTest = 3;
		System.out.println("test " + numeroTest + " (table quelconque - borne sup != 9)");
		try {
			int[] tableATrier = {4,2,2,2,0,2,5,0,2,5,2,5,5};
			int[] tableAttendue = {0,0,2,2,2,2,2,2,4,5,5,5,5};
			int borneSup = 5;
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			System.out.println("borne sup : "+borneSup);
			triSelf(tableATrier,borneSup);
			if (tableATrier == null) {
				System.out.println("test " + numeroTest + " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableATrier.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableATrier));

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		//test4
		numeroTest = 4;
		System.out.println("test " + numeroTest + " (table sans la borne sup)");
		try {
			int[] tableATrier = {4,2,2,7,2,0,2,5,0,4,2,7,5,2,5,5};
			int[] tableAttendue = {0,0,2,2,2,2,2,2,4,4,5,5,5,5,7,7};
			int borneSup = 9;
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			System.out.println("borne sup : "+borneSup);
			triSelf(tableATrier,borneSup);
			if (tableATrier == null) {
				System.out.println("test " + numeroTest + " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableATrier.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableATrier));

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		//test 5
		numeroTest = 5;
		System.out.println("test " + numeroTest + " (table avec 1 entier)");
		try {
			int[] tableATrier = {3};
			int[] tableAttendue = {3};
			int borneSup = 5;
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			System.out.println("borne sup : "+borneSup);
			triSelf(tableATrier,borneSup);
			if (tableATrier == null) {
				System.out.println("test " + numeroTest + " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableATrier.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableATrier));

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		//test6
		numeroTest = 6;
		System.out.println("test " + numeroTest + " (table vide)");
		try {
			int[] tableATrier = {};
			int[] tableAttendue = {};
			int borneSup = 3;
			System.out.println("table testee : " + Arrays.toString(tableATrier));
			System.out.println("borne sup : "+borneSup);
			triSelf(tableATrier,borneSup);
			if (tableATrier == null) {
				System.out.println("test " + numeroTest + " ko, la table est null");
				System.exit(0);
			}
			assertEquals("test " + numeroTest + " ko : taille table apres tri ko", tableAttendue.length, tableATrier.length);
			assertEquals("test " + numeroTest + " ko : contenu table apres tri ko", Arrays.toString(tableAttendue), Arrays.toString(tableATrier));

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("test " + numeroTest + " ko, il y a eu sortie de table");
			e.printStackTrace();
			System.exit(0);
		} catch (Exception e) {
			System.out.println("test " + numeroTest + " ko, il y a eu une exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("test " + numeroTest + " ok");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

		/*


		int[] t2 = {};
		int[] tTriee2 = {};
		TriParComptage.triSelf(t2,9);
		if(!sontIdentiques(t2, tTriee2)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 2 a reussi!");

		int[] t3 = {8};
		int[] tTriee3 = {8};
		TriParComptage.triSelf(t3,8);
		if(!sontIdentiques(t3, tTriee3)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 3 a reussi!");

	*/



	public static void testTriMinMax() {
		int[] t = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[] tTriee = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.triSelf(t,0,9);
		if(!sontIdentiques(t, tTriee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 1 a reussi!");

		int[] t2 = {4,2,2,7,2,2,5,9,2,7,5,2,5,5};
		int[] tTriee2 = {2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.triSelf(t2,2,9);
		if(!sontIdentiques(t2, tTriee2)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 2 2 7 2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 2 a reussi!");

		int[] t3 = {4,2,-2,7,-2,2,5,9,2,7,5,2,5,5};
		int[] tTriee3 = {-2,-2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.triSelf(t3,-2,9);
		if(!sontIdentiques(t3, tTriee3)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est 4 2 -2 7 -2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 3 a reussi!");

		int[] t4 = {};
		int[] tTriee4 = {};
		TriParComptage.triSelf(t4,7,8);
		if(!sontIdentiques(t4, tTriee4)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 4 a reussi!");

		int[] t5 = {8};
		int[] tTriee5 = {8};
		TriParComptage.triSelf(t5,8,8);
		if(!sontIdentiques(t5, tTriee5)){
			System.out.println("\nAttention test 5 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t5);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 5 a reussi!");

	}

	public static void testTri() {
		int[] t = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[] tTriee = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.triSelf(t);
		if(!sontIdentiques(t, tTriee)){
			System.out.println("\nAttention test 1 ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);

		}
		System.out.println("Le test 1 a reussi!");

		int[] t2 = {4,2,2,7,2,0,2,5,0,9,2,7,5,2,5,5};
		int[] tTriee2 = {0,0,2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.triSelf(t2);
		if(!sontIdentiques(t2, tTriee2)){
			System.out.println("\nAttention test 2 ko");
			System.out.println("La table a trier est 4 2 2 7 2 0 2 5 0 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t2);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 2 a reussi!");
		int[] t3 = {4,2,2,7,2,2,5,9,2,7,5,2,5,5};
		int[]tTriee3 = {2,2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.triSelf(t3);
		if(!sontIdentiques(t3, tTriee3)){
			System.out.println("\nAttention test 3 ko");
			System.out.println("La table a trier est 4 2 2 7 2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t3);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 3 a reussi!");
		int[] t4 = {4,2,-2,7,-2,2,5,9,2,7,5,2,5,5};
		int[]tTriee4 = {-2,-2,2,2,2,2,4,5,5,5,5,7,7,9};
		TriParComptage.triSelf(t4);
		if(!sontIdentiques(t4, tTriee4)){
			System.out.println("\nAttention test 4 ko");
			System.out.println("La table a trier est 4 2 -2 7 -2 2 5 9 2 7 5 2 5 5");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t4);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(4);
		}
		System.out.println("Le test 4 a reussi!");

		int[] t5 = {};
		int[]tTriee5 = {};
		TriParComptage.triSelf(t5);
		if(!sontIdentiques(t5, tTriee5)){
			System.out.println("\nAttention test 5 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t5);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 5 a reussi!");

		int[] t6 = {8};
		int[]tTriee6 = {8};
		TriParComptage.triSelf(t6);
		if(!sontIdentiques(t6, tTriee6)){
			System.out.println("\nAttention test 6 ko");
			System.out.println("La table a trier est vide ");
			System.out.print("Apres appel de votre methode la table est ");
			afficher(t6);
			System.out.println("Cette table n'est pas triee!");
			System.out.println("Revoyez votre methode");
			System.exit(0);
		}
		System.out.println("Le test 6 a reussi!");
	}


	
}
