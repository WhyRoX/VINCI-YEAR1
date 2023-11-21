import java.util.Arrays;
import java.util.HashSet;

public class TestTableauNonTrieDEntiers {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur
	 *            message a afficher en cas de probleme
	 * @param attendu
	 *            la valeur qu'on s'attendait a recevoir
	 * @param recu
	 *            la valeur qu'on a recu en realite
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

	public static void main(String[] args) {

		int choix;
		System.out.println("******************************************************");
		System.out.println("Programme Test pour la classe TableauNonTrieDEntiers :");
		System.out.println("******************************************************");
		System.out.println();
		do {
			System.out.println("1 -> Tester la methode 'ajouter()'");
			System.out.println("2 -> Tester la methode 'contient()'");
			System.out.println("3 -> Tester la methode 'nombreOccurrences()'");
			System.out.println("4 -> Tester la methode 'supprimerPremiereOccurrence()'");
			System.out.println("5 -> Tester la methode 'supprimerToutesLesOccurrences()'");
			System.out.println("6 -> Tester la methode 'estTrie()'");
			System.out.println("7 -> Tester la methode 'contientExAequo()'");
			System.out.println("8 -> Tester la methode 'supprimerTousLesExAequos()'");

			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					ajouterUnEntier();
					break;
				case 2:
					verifierContient();
					break;
				case 3:
					verifierNombreOccurrences();
					break;
				case 4:
					supprimerUne();
					break;
				case 5:
					supprimerTout();
					break;
				case 6:
					verifierEstTrie();
					break;
				case 7:
					testerContientExAequo();
					break;
				case 8:
					testerSupprimerTousLesExAequos();
					break;
			}
		} while (choix >= 1 && choix <= 8);
		System.out.println("\nFin des tests");
	}

	private static void ajouterUnEntier() {

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (3 entiers)");
		try {
			int[] t = { 3, 4, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 6;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = { 3, 4, 5, 6 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouter(entier));
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
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (9 entiers)");
		try {
			int[] t = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 10;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouter(entier));
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
		System.out.println("test " + numeroTest + " : ajout dans une table pleine (10 entiers)");
		try {
			int[] t = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 11;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.ajouter(entier));
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
		System.out.println("test " + numeroTest + " : ajout dans une table pleine (10 entiers)");
		try {
			int[] t = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 10;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.ajouter(entier));
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
		System.out.println("test " + numeroTest + " : ajout dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier ajoute : "+entier);
			int[] tSol = {3};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.ajouter(entier));
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

	private static void verifierContient() {

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : contient dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = {3,6,7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 0;
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
		System.out.println("test " + numeroTest + " : contient dans une table pleine qui contient l'entier");
		try {
			int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : contient dans une table pleine qui ne contient pas l'entier");
		try {
			int[] t = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 777;
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
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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

		System.out.println("Tous les tests ont reussi!");
		System.out.println();

	}


	private static void verifierNombreOccurrences() {
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : nombre occurrences dans une table non pleine");
		try {
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (nombre occurrences ko)", 1, tNt.nombreOccurrences(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : nombre occurrences dans une table non pleine");
		try {
			int[] t = { 3, 3, 3, 3, 3, 3};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (nombre occurrences ko)", 6, tNt.nombreOccurrences(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : nombre occurrences dans une table non pleine");
		try {
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 0;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (nombre occurrences ko)", 0, tNt.nombreOccurrences(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : nombre occurrences dans une table pleine");
		try {
			int[] t = {9, 8, 7, 6, 5, 9, 8, 7, 6, 5};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (nombre occurrences ko)", 2, tNt.nombreOccurrences(entier));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : nombre occurrences dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier recherche : "+entier);
			assertEquals("le test "+numeroTest+ " a echoue (nombre occurrences ko)", 0, tNt.nombreOccurrences(entier));
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

	private static void supprimerUne() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 5 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
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
			int[] t = { 3, 4, 5, 6 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			ensembleAttendu.remove(entier);
			int[] tSol = { 3, 6, 5};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			if(ensembleAttendu.equals(tNt.toHashSet())){
				if(!Arrays.toString(tSol).equals(tNt.toString())){
					System.out.println("le test "+numeroTest+ " a echoue");
					System.out.println(("le contenu de la table est ok, mais vous n'avez pas suivi l'algorithme impose."));
					System.exit(0);
				}
			}else{
				assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
			}
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
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 8, 5, 6, 7 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
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
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 3;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 7, 4, 5, 6};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 4, 5, 6, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 7;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 4, 5, 6 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient l'entier");
		try {
			int[] t = { 3, 0, 4, 6, 7, 8 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 0;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 8, 4, 6, 7 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient plusieurs x l'entier");
		try {
			int[] t = { 3, 4, 5, 4, 6, 7, 8 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 8, 5, 4, 6, 7 };
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient l'entier");
		try {
			int[] t = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 9;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {0, 1, 2, 3, 4, 5, 6, 7, 8};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 3, 4, 5, 6 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 9;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 4, 5, 6};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 10;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 3, 4, 5, 6 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 0;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 4, 5, 6};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 11;
		System.out.println("test " + numeroTest + " : suppression dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 5;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {};
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.supprimerPremiereOccurrence(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
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


	private static void supprimerTout() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 1x l'entier");
		try {
			int[] t = { 3, 4, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 5 };
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 1, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 3, 4, 5, 7, 2 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 6;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 4, 5, 7, 2 };
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 0, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();


		numeroTest = 3;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas l'entier");
		try {
			int[] t = { 3, 4, 5, 7, 2 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 0;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { 3, 4, 5, 7, 2 };
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 0, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : suppression dans une table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 6;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {};
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 0, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui ne contient pas l'entier");
		try {
			int[] t = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 6;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = {1,2,3,4,5,1,2,3,4,5 };
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 0, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 2x l'entier");
		try {
			int[] t = { 0, 1, 6, 3, 4, 5, 6, 7, 8, 9 };

			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 6;
			System.out.println("l'entier supprime : "+entier);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			ensembleAttendu.remove(6);
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 2, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 3x l'entier");
		try {
			int[] t = { 4, 1, 3, 4, 2, 5, 4, 6, 8, 9 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			ensembleAttendu.remove(entier);
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 3, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 3x l'entier");
		try {
			int[] t = { 0, 2, 0, 5, 0, 6, 9 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 0;
			System.out.println("l'entier supprime : "+entier);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			ensembleAttendu.remove(entier);
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 3, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 4x l'entier, dont 1x en dernier lieu");
		try {
			int[] t = { 1, 7, 2, 7, 4, 5, 6, 7, 8, 7 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 7;
			System.out.println("l'entier supprime : "+entier);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			ensembleAttendu.remove(entier);
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 4, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 10;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 10x l'entier");
		try {
			int[] t = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 1;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { };
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 10, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 11;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 3x l'entier");
		try {
			int[] t = {4, 4, 4};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int entier = 4;
			System.out.println("l'entier supprime : "+entier);
			int[] tSol = { };
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 3, tNt.supprimerToutesLesOccurrences(entier));
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
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


	private static void verifierEstTrie() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " :  table non pleine triee");
		try {
			int[] t = { 3, 4, 6, 7, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " :  table non pleine triee");
		try {
			int[] t = { 3, 4, 6, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " :  table pleine triee");
		try {
			int[] t = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " :  table non pleine non triee");
		try {
			int[] t = { 3, 5, 4, 6, 7, 8};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " :  table non pleine non triee");
		try {
			int[] t = { 3, 4, 6, 5, 7, 8};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " :  table non pleine non triee");
		try {
			int[] t = { 4, 2, 5, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " :  table non pleine non triee");
		try {
			int[] t = { 3, 4, 5, 6, 8, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " :  table pleine non triee");
		try {
			int[] t = { 0, 1, 2, 3 , 4, 9, 5, 6, 7, 8};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " :  table pleine non triee");
		try {
			int[] t = { 0, 1, 2, 4, 5, 6, 7, 8, 9, 3};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 10;
		System.out.println("test " + numeroTest + " :  table vide");
		try {
			int[] t = { };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.estTrie());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 11;
		System.out.println("test " + numeroTest + " :  table non pleine triee avec ex-aequo");
		try {
			int[] t = { 2, 2, 4, 4, 4, 7, 7, 7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.estTrie());
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


	private static void testerContientExAequo() {

		System.out.println();

		int numeroTest = 1;
		System.out.println("test " + numeroTest + " :  table pleine sans ex-aequo");
		try {
			int[] t = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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
			int[] t = { 4, 2, 5, 7, 8, 1};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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
			int[] t = { 4, 22, 5, 22, 8888, 1};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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
			int[] t = { 4, 2, 5, 8, 1, 2};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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
			int[] t = { 8, 4, 2, 5, 3, 8, 1};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " :  table pleine avec ex-aequo");
		try {
			int[] t = {0, 1, 7, 3, 4, 5, 6, 7, 8, 9};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " :  table pleine avec ex-aequo");
		try {
			int[] t = {0, 1, 5, 3, 4, 2, 6, 7, 8, 2};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, tNt.contientExAequo());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " :  table vide");
		try {
			int[] t = {};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
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

	private static void testerSupprimerTousLesExAequos() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui ne contient pas d'ex-aequo");
		try {
			int[] t = {0,9,2,3,44444,5,6,7,8,1};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int[] tSol = {0,9,2,3,44444,5,6,7,8,1};
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 0, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table apres suppression )", Arrays.toString(tSol), tNt.toString());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas d'ex-aequo");
		try {
			int[] t = { 4, 333, 0, 55 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int[] tSol = { 4, 333, 0, 55 };
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 0, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
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
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			int[] tSol = {};
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", 0, tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", tSol.length, tNt.getNombreEntiers());
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
			int[] t = { 1, 3, 44444, 3 , 5};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", t.length- ensembleAttendu.size(), tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui contient 2x 2X un meme entier");
		try {
			int[] t = { 1, 2, 1, 2};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", t.length- ensembleAttendu.size(), tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient beaucoup d'ex-aquos");
		try {
			int[] t = { 1, 4, 4, 4, 1, 4, 1, 4, 1, 1 };
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", t.length- ensembleAttendu.size(), tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui contient 10 x 7");
		try {
			int[] t = {7,7,7,7,7,7,7,7,7,7};
			System.out.println("la table testee : "+ Arrays.toString(t));
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", t.length- ensembleAttendu.size(), tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		// test 8 : suppression dans une table pleine qui contient 10 x le meme
		// entier
		try {
			int[] t = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
			TableauNonTrieDEntiers tNt = new TableauNonTrieDEntiers(t);
			HashSet<Integer> ensembleAttendu = new HashSet<>();
			for (int i = 0; i < t.length; i++) {
				ensembleAttendu.add(t[i]);
			}
			assertEquals("le test "+numeroTest+ " a echoue (entier renvoye)", t.length- ensembleAttendu.size(), tNt.supprimerTousLesExAequos());
			assertEquals("le test "+numeroTest+ " a echoue (nombre entiers apres suppression)", ensembleAttendu.size(), tNt.getNombreEntiers());
			if(!ensembleAttendu.equals(tNt.toHashSet())){
				System.out.println("le test "+numeroTest+ " a echoue");
				System.out.println("La table recue "+tNt.toString());
				System.out.println("Elle aurait du contenir (dans n'importe quel ordre) "+ensembleAttendu.toString());
				System.exit(0);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}


		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

}
