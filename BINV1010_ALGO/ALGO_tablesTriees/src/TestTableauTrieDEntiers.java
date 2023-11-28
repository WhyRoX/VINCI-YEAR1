import java.util.Arrays;

public class TestTableauTrieDEntiers{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println(messageErreur);
				System.out.println("Attendu : " + attendu);
				System.out.println("Recu : " + recu);
				System.exit(0);
			}
		} else {
			if (attendu instanceof Character && recu instanceof String) {
				attendu = "" + attendu;
			}
			if (attendu instanceof String && recu instanceof Character) {
				recu = "" + recu;
			}
			if (!attendu.equals(recu)) {
				System.out.println(messageErreur);
				System.out.println("Attendu : " + attendu);
				System.out.println("Recu : " + recu);
				System.exit(0);
			}
		}
	}

	public static void main(String [] args){

		int choix;
		System.out.println("***************************************************");
		System.out.println("Programme Test pour la classe TableauTrieDEntiers :");
		System.out.println("***************************************************");
		System.out.println();
		do{
			System.out.println("1 -> Tester la methode 'ajouterUnEntier(int unEntier)'");
			System.out.println("2 -> Tester la methode 'contient(int unEntier)'");
			System.out.println("3 -> Tester la methode 'supprimerUneOccurrence(int unEntier)'");			
			System.out.println("4 -> Tester la methode 'supprimerToutesLesOccurrences(int unEntier)'");
			System.out.println("5 -> Tester la methode 'contientExAequo()'");
			System.out.println("6 -> Tester la methode 'supprimerTousLesExAequos()'");
			System.out.print("\nEntrez votre choix : ");
			choix=scanner.nextInt();
			switch(choix){
			case 1: verifierAjout(); 
			break; 
			case 2: verifierContient(); 
			break; 
			case 3: supprimerUne(); 
			break;			
			case 4: supprimerTout();
			break; 
			case 5: testerContientExAequo();
			break;
			case 6: testerSupprimerTousLesExAequos();
			break;
			}
		} while (choix >= 1 && choix <= 6);
		System.out.println("Fin des tests !");
	}


	private static void verifierAjout(){

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (4 entiers)");
		try {
			int[] t = { 1, 3, 5, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 6;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {1,3,5,6,7};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (4 entiers)");
		try {
			int[] t = { 1, 3, 5, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {1,3,4,5,7};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (4 entiers)");
		try {
			int[] t = { 1, 3, 5, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 2;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {1,2,3,5,7};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (4 entiers)");
		try {
			int[] t = { 1, 3, 5, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 0;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {0,1,3,5,7};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (4 entiers)");
		try {
			int[] t = { 1, 3, 5, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 8;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {1, 3, 5, 7, 8};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (9 entiers)");
		try {
			int[] t = { 0, 1, 2, 3, 4, 6, 7, 8, 9 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : ajout dans une table pleine (10 entiers)");
		try {
			int[] t = { 0, 1, 2, 3, 4, 6, 7, 8, 9, 10 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {0, 1, 2, 3, 4, 6, 7, 8, 9, 10 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " : ajout dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {3};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouterUnEntier(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres ajout)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void verifierContient(){

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 7;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 3, 4, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 1;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 3, 4, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 3, 4, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 9;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();


		numeroTest = 8;
		System.out.println("test " + numeroTest + " : contient dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " : contient dans une table pleine qui contient l'entier");
		try {
			int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 9;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 10;
		System.out.println("test " + numeroTest + " : contient dans une table pleine qui ne contient pas l'entier");
		try {
			int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 10;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contient(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}


	private static void supprimerUne(){

		System.out.println();

		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 5 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6, 7, 8 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 5, 6, 7, 8};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6, 7, 8 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 4, 5, 6, 7, 8};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6, 7, 8 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 8;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 4, 5, 6, 7};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient l'entier");
		try {
			int[] t = { 0,1,2,3, 4, 5, 6, 7, 8,9 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {0,1,2, 3, 5, 6, 7,8,9};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient l'entier");
		try {
			int[] t = { 0,1,2,3, 4, 5, 6, 7, 8,9 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 9;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {0,1,2, 3, 4,5, 6, 7,8};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient plusieurs X l'entier");
		try {
			int[] t = { 1,1,1,1,2,2,2,5,5,7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 2;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 1,1,1,1,2,2,5,5,7 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 2, 3, 5, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {2, 3, 5, 7};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui ne contient pas l'entier");
		try {
			int[] t = { 0,1,2,3,4,5,6,7,8,9 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 10;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 0,1,2,3,4,5,6,7,8,9};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();
		numeroTest = 10;
		System.out.println("test " + numeroTest + " : suppression dans une table vide");
		try {
			int[] t = { };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 10;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.supprimerUneOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();
		System.out.println("Tous les tests ont reussi!"); 
		System.out.println();
	}


	private static void supprimerTout(){

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 5 };
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 1, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		System.out.println();
		numeroTest = 2;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 4 x l'entier");
		try {
			int[] t = {1, 2, 3, 3, 3, 3, 4, 4};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {1, 2, 4, 4};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 4, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		System.out.println();
		numeroTest = 3;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 3 x l'entier au debut");
		try {
			int[] t = { 2, 2, 2, 3, 3, 4, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 2;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3,3,4, 5 };
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 3, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 4 x l'entier a la fin");
		try {
			int[] t = { 2, 3, 3, 4, 5, 5, 5, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {2, 3,3,4};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 4, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 3 x l'entier");
		try {
			int[] t = { 1,1,2, 2,2,3, 3, 5, 5, 5};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 2;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {1,1,3,3,5,5,5};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 3, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 4 x l'entier a la fin");
		try {
			int[] t = { 1,1,2, 3, 3, 4, 5, 5, 5, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {1,1,2, 3,3,4};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 4, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient uniquement l'entier a supprimer");
		try {
			int[] t = { 3,3,3,3,3,3};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 6, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 4 x l'entier a la fin");
		try {
			int[] t = { 5,5,5,5,5,5, 5, 5, 5, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 10, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();




		numeroTest = 9;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui ne contient pas l'entier");
		try {
			int[] t = { 1,1,2, 3, 3, 4, 5, 5, 5, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 6;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {1,1,2, 3,3,4,5,5,5,5};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 0, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 11;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 1,1,2, 3, 3, 4 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 0;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {1,1,2, 3,3,4};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 0, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " : suppression dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 0, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		System.out.println("Tous les tests ont reussi!"); 
		System.out.println();
	}

	
	private static void testerContientExAequo(){



		System.out.println();

		int numeroTest = 1;
		System.out.println("test " + numeroTest + " :  table pleine sans ex-aequo");
		try {
			int[] t = {0, 1, 2, 3, 4, 5, 6, 77, 888, 9999};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " :  table non pleine sans ex-aequo");
		try {
			int[] t = { 1, 2, 55, 77, 888};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " :  table non pleine avec ex-aequo");
		try {
			int[] t = { 1, 2, 5, 5, 8};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " :  table non pleine avec ex-aequo");
		try {
			int[] t = { 1, 5, 5, 8};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " :  table non pleine avec ex-aequo");
		try {
			int[] t = { 2, 2, 5, 8, 99};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " :  table non pleine avec ex-aequo");
		try {
			int[] t = { 1, 2, 5, 8, 8};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " :  table pleine avec ex-aequo");
		try {
			int[] t = { 1, 2, 3,4,5,6,7,8,9,9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " :  table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " :  table avec 1 entier");
		try {
			int[] t = {5};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();


		System.out.println("Tous les tests ont reussi!"); 
		System.out.println();
	}


	private static void testerSupprimerTousLesExAequos(){

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas d'ex-aequo");
		try {
			int[] t = { 3, 444, 55555 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = { 3, 444, 55555 };
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 0, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui ne contient pas d'ex-aequo");
		try {
			int[] t = {0,1,2,3,4,5,6,7,88,999};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {0,1,2,3,4,5,6,7,88,999};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 0, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : suppression dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 0, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 2x un meme entier");
		try {
			int[] t = { 1, 3, 3 ,4, 5};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {1, 3, 4, 5 };
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 1, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient des ex-aequos");
		try {
			int[] t = { 1, 3, 3 ,3, 5, 9, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {1, 3, 5, 9};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 3, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient des ex-aequos");
		try {
			int[] t = { 2, 2, 3 ,5,5, 99, 99, 99};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {2, 3, 5, 99};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 4, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient plusieurs x le meme entier");
		try {
			int[] t = { 3,3,3,3,3,3,3};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {3};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 6, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient des ex-aequos");
		try {
			int[] t = { 2, 4, 6,6,6,6,6, 8, 9, 10};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {2,4,6,8,9,10};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 4, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient des ex-aequos");
		try {
			int[] t = {1,2,3,4,5,6,7,8,9,9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {1,2,3,4,5,6,7,8,9};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 1, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 10;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient des ex-aequos");
		try {
			int[] t = {1,1,2,3,4,5,6,7,8,9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {1,2,3,4,5,6,7,8,9};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 1, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 11;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient des ex-aequos");
		try {
			int[] t = {2,2,2,4,4,4,4,5,9,9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {2,4,5,9};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 6, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 12;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 10 x le meme entier");
		try {
			int[] t = {4,4,4,4,4,4,4,4,4,4};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauTrieDEntiers tNt = new TableauTrieDEntiers(t);
			int[] tSol = {4};
			assertEquals("le test "+numeroTest+ " a echoue (nombre suppressions renvoye)", 9, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers dans la table apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		System.out.println();
		System.out.println("Tous les tests ont reussi!"); 
		System.out.println();
	}

}




