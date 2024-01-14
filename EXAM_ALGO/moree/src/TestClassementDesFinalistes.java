import java.lang.reflect.Field;
import java.util.Arrays;

public class TestClassementDesFinalistes {

	private static java.util.Scanner scanner = new java.util.Scanner(System.in);
	private static Class classe = ClassementDesFinalistes.class;
	private static Field finalistes;
	private static Field points;
	private static Field nbrFinalistes;

	public static void main(String[] args) throws IllegalAccessException {
		Field[] champs = classe.getDeclaredFields();
		for (Field f : champs) {
			if (f.getType() == String[].class) {
				finalistes = f;
				finalistes.setAccessible(true);
			} else if (f.getType() == int[].class) {
				points = f;
				points.setAccessible(true);
			} else if (f.getName().equals("nombreDeFinalistes")) {
				nbrFinalistes = f;
				nbrFinalistes.setAccessible(true);
			}
		}

		System.out.println("*****************************************************************");
		System.out.println("* Bienvenue dans la classe test pour la classe GestionResultats *");
		System.out.println("*****************************************************************");

		System.out.println();

		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode 'ajouter(int pts, String finaliste)'");
			System.out.println("2 -> Tester la methode 'premiers()'");
			System.out.println("3 -> Tester la methode 'ecartMaximum()'");
			System.out.println("4 -> Tester la methode 'disqualifier()'");
			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				testsAjouter();
				break;
			case 2:
				testsPremiers();
				break;
			case 3:
				testsEcartMaximum();
				break;
			case 4:
				testsDisqualifier();
			}
			System.out.println();
		} while (choix >= 1 && choix <= 4);
		System.out.println("Merci pour votre visite.");
	}

	public static void testsAjouter() throws IllegalAccessException {
		ClassementDesFinalistes gestionnaire = null;

		System.out.println("Test 1 : ajout dans des tables vides");
		System.out.println("------------------------------------");
		gestionnaire = new ClassementDesFinalistes(4);
		if (!gestionnaire.ajouter(3, "loic")) {
			System.out.println("Test echoue : Resultat attendu true mais recu false.");
			return;
		} else {
			int nbFin = (int) nbrFinalistes.get(gestionnaire);
			if (nbFin != 1) {
				System.out.println("Test echoue : Mauvais nombre de finalistes : attendu 1, recu " + nbFin);
				return;
			}
			int[] pts = (int[]) points.get(gestionnaire);
			int[] ptsCorrect = { 3, 0, 0, 0 };
			if (!Arrays.equals(pts, ptsCorrect)) {
				System.out.println("Test echoue : Tableau de points errone : attendu : "
						+ Arrays.toString(ptsCorrect) + " Recu : " + Arrays.toString(pts));
				return;
			}
			String[] finCorrect = { "loic", null, null, null };
			String[] fin = (String[]) finalistes.get(gestionnaire);
			if (!Arrays.equals(fin, finCorrect)) {
				System.out.println("Test echoue : Tableau de finalistes errone : attendu : "
						+ Arrays.toString(finCorrect) + " Reçu : " + Arrays.toString(fin));
				return;
			}
		}
		System.out.println("Test 1 r�ussi");
		System.out.println();

		System.out.println("Test 2 : ajout dans une table non pleine sans exaequo ");
		System.out.println("------------------------------------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit = { 10, 7, 3, 2, 0 };
		points.set(gestionnaire, ptsInit);
		String[] finInit = { "loic", "leo", "eric", "toto", null };
		finalistes.set(gestionnaire, finInit);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation avant ajouter(6,test)");
		System.out.println(gestionnaire);
		if (!gestionnaire.ajouter(6, "test")) {
			System.out.println("Test echoue : Resultat attendu true mais recu false.");
			return;
		} else {
			System.out.println("Situation apres ajout(6,test)");
			System.out.println(gestionnaire);
			int nbFin = (int) nbrFinalistes.get(gestionnaire);
			if (nbFin != 5) {
				System.out.println("Test echoue : Mauvais nombre de finalistes : attendu 5, recu " + nbFin);
				return;
			}
			int[] pts = (int[]) points.get(gestionnaire);
			int[] ptsCorrect = { 10, 7, 6, 3, 2 };
			if (!Arrays.equals(pts, ptsCorrect)) {
				System.out.println("Test echoue : Tableau de points errone : attendu : "
						+ Arrays.toString(ptsCorrect) + " Reçu : " + Arrays.toString(pts));
				return;
			}
			String[] finCorrect = { "loic", "leo", "test", "eric", "toto" };
			String[] fin = (String[]) finalistes.get(gestionnaire);
			if (!Arrays.equals(fin, finCorrect)) {
				System.out.println("Test echoue : Tableau de finalistes errone : attendu : "
						+ Arrays.toString(finCorrect) + " Recu : " + Arrays.toString(fin));
				return;
			}
		}
		System.out.println("Test 2 reussi");
		System.out.println();

		System.out.println("Test 3 : ajout dans une table non pleine avec exaequo");
		System.out.println("-----------------------------------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit2 = { 10, 7, 3, 2, 0 };
		points.set(gestionnaire, ptsInit2);
		String[] finInit2 = { "loic", "leo", "eric", "toto", null };
		finalistes.set(gestionnaire, finInit2);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation avant ajouter(3,test)");
		System.out.println(gestionnaire);
		if (!gestionnaire.ajouter(3, "test")) {
			System.out.println("Test echoue : Resultat attendu true mais recu false.");
			return;
		} else {
			System.out.println("Situation apres ajout(3,test)");
			System.out.println(gestionnaire);
			int nbFin = (int) nbrFinalistes.get(gestionnaire);
			if (nbFin != 5) {
				System.out.println("Test echoue : Mauvais nombre de finalistes : attendu 5, recu " + nbFin);
				return;
			}
			int[] pts = (int[]) points.get(gestionnaire);
			int[] ptsCorrect = { 10, 7, 3, 3, 2 };
			if (!Arrays.equals(pts, ptsCorrect)) {
				System.out.println("Test echoue : Tableau de points errone : attendu : "
						+ Arrays.toString(ptsCorrect) + " Recu : " + Arrays.toString(pts));
				return;
			}
			String[] finCorrect = { "loic", "leo", "eric", "test", "toto" };
			String[] finCorrect2 = { "loic", "leo", "test", "eric", "toto" };
			String[] fin = (String[]) finalistes.get(gestionnaire);
			if (!Arrays.equals(fin, finCorrect) && !Arrays.equals(fin, finCorrect2)) {
				System.out.println(
						"Test echoue : Tableau de finalistes errone : attendu : " + Arrays.toString(finCorrect)
								+ " ou " + Arrays.toString(finCorrect2) + "Recu : " + Arrays.toString(fin));
				return;
			}
		}
		System.out.println("Test 3 reussi");
		System.out.println();

		System.out.println("Test 4 : ajout de points a�un finaliste deja�present");
		System.out.println("----------------------------------------------------");
		gestionnaire = new ClassementDesFinalistes(4);
		int[] ptsInit3 = { 10, 7, 3, 2 };
		points.set(gestionnaire, ptsInit3);
		String[] finInit3 = { "loic", "leo", "eric", "toto" };
		finalistes.set(gestionnaire, finInit3);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation avant ajouter(9,toto)");
		System.out.println(gestionnaire);
		if (!gestionnaire.ajouter(9, new String("toto"))) {
			System.out.println("Test echoue : Resultat attendu true mais recu false.");
			return;
		} else {
			System.out.println("Situation apres ajout(9,toto)");
			System.out.println(gestionnaire);
			int nbFin = (int) nbrFinalistes.get(gestionnaire);
			if (nbFin != 4) {
				System.out.println("Test echoue : Mauvais nombre de finalistes : attendu 5, recu " + nbFin);
				return;
			}
			int[] pts = (int[]) points.get(gestionnaire);
			int[] ptsCorrect = { 11, 10, 7, 3 };
			if (!Arrays.equals(pts, ptsCorrect)) {
				System.out.println("Test echoue : Tableau de points errone : attendu : "
						+ Arrays.toString(ptsCorrect) + " Reçu : " + Arrays.toString(pts));
				return;
			}
			String[] finCorrect = { "toto", "loic", "leo", "eric" };
			String[] fin = (String[]) finalistes.get(gestionnaire);
			if (!Arrays.equals(fin, finCorrect)) {
				System.out.println("Test echoue : Tableau de finalistes errone : attendu : "
						+ Arrays.toString(finCorrect) + "Recu : " + Arrays.toString(fin));
				return;
			}
		}
		System.out.println("Test 4 reussi");
		System.out.println();

		System.out.println("Test 5 : ajout dans une table pleine");
		System.out.println("------------------------------------");
		gestionnaire = new ClassementDesFinalistes(4);
		int[] ptsInit4 = { 10, 7, 3, 2 };
		points.set(gestionnaire, ptsInit4);
		String[] finInit4 = { "loic", "leo", "eric", "toto" };
		finalistes.set(gestionnaire, finInit4);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation avant ajouter(9,test)");
		System.out.println(gestionnaire);
		if (gestionnaire.ajouter(9, "test")) {
			System.out.println("Test echoue : Resultat attendu false mais recu true.");
			return;
		}

		System.out.println("Situation apres ajout(9,test)");
		System.out.println(gestionnaire);
		System.out.println("Test 5 reussi");
		System.out.println();

		System.out.println("Tous les tests ont reussi");
	}

	public static void testsPremiers() throws IllegalAccessException {
		ClassementDesFinalistes gestionnaire = null;

		System.out.println("Test 1 : Pas de finalistes");
		System.out.println("--------------------------");
		gestionnaire = new ClassementDesFinalistes(4);
		String[] premiersCorrect = {};
		String[] premiersRecu = gestionnaire.premiers();
		if (!Arrays.equals(premiersCorrect, premiersRecu)) {
			System.out.println("Test echoue : Attendu : " + Arrays.toString(premiersCorrect) + " Recu : "
					+ Arrays.toString(premiersRecu));
			return;
		}
		System.out.println("Test 1 reussi");
		System.out.println();

		System.out.println("Test 2 : un seul premier");
		System.out.println("------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit = { 10, 7, 3, 2, 0 };
		points.set(gestionnaire, ptsInit);
		String[] finInit = { "loic", "leo", "eric", "toto", null };
		finalistes.set(gestionnaire, finInit);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation initiale :");
		System.out.println(gestionnaire);
		String[] premiersCorrect2 = { "loic" };
		String[] premiersRecu2 = gestionnaire.premiers();
		if (!Arrays.equals(premiersCorrect2, premiersRecu2)) {
			System.out.println("Test echoue : Attendu : " + Arrays.toString(premiersCorrect2) + " Recu : "
					+ Arrays.toString(premiersRecu2));
			return;
		}
		System.out.println("Test 2 reussi");
		System.out.println();

		System.out.println("Test 3 : plusieurs premiers");
		System.out.println("---------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit2 = { 10, 10, 10, 2, 0 };
		points.set(gestionnaire, ptsInit2);
		String[] finInit2 = { "loic", "leo", "eric", "toto", null };
		finalistes.set(gestionnaire, finInit2);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation initiale :");
		System.out.println(gestionnaire);
		String[] premiersCorrect3 = { "loic", "leo", "eric" };
		String[] premiersRecu3 = gestionnaire.premiers();
		if (!Arrays.equals(premiersCorrect3, premiersRecu3)) {
			System.out.println("Test echoue : Attendu : " + Arrays.toString(premiersCorrect3) + " Reçu : "
					+ Arrays.toString(premiersRecu3));
			return;
		}
		System.out.println("Test 3 reussi");
		System.out.println();

		System.out.println("Test 4 : que des premiers");
		System.out.println("---------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit3 = { 10, 10, 10, 10, 0 };
		points.set(gestionnaire, ptsInit3);
		String[] finInit3 = { "loic", "leo", "eric", "toto", null };
		finalistes.set(gestionnaire, finInit3);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation initiale :");
		System.out.println(gestionnaire);
		String[] premiersCorrect4 = { "loic", "leo", "eric", "toto" };
		String[] premiersRecu4 = gestionnaire.premiers();
		if (!Arrays.equals(premiersCorrect4, premiersRecu4)) {
			System.out.println("Test echoue : Attendu : " + Arrays.toString(premiersCorrect4) + " Recu : "
					+ Arrays.toString(premiersRecu4));
			return;
		}
		System.out.println("Test 4 reussi");
		System.out.println();

		System.out.println("Tous les tests ont reussi");
	}

	public static void testsEcartMaximum() throws IllegalAccessException {
		ClassementDesFinalistes gestionnaire = null;

		System.out.println("Test 1 : Pas de finalistes");
		System.out.println("--------------------------");
		gestionnaire = new ClassementDesFinalistes(4);
		int ecartMaxRecu = gestionnaire.ecartMaximum();
		if (ecartMaxRecu != 0) {
			System.out.println("Test echoue : Attendu : 0 " + " Recu : " + ecartMaxRecu);
			return;
		}
		System.out.println("Test 1 réussi");
		System.out.println();

		System.out.println("Test 2 : un seul finaliste");
		System.out.println("--------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit = { 10, 0, 0, 0, 0 };
		points.set(gestionnaire, ptsInit);
		String[] finInit = { "loic", null, null, null, null };
		finalistes.set(gestionnaire, finInit);
		nbrFinalistes.setInt(gestionnaire, 1);
		System.out.println("Situation initiale :");
		System.out.println(gestionnaire);
		ecartMaxRecu = gestionnaire.ecartMaximum();
		if (ecartMaxRecu != 0) {
			System.out.println("Test echoue : Attendu : 0 " + " Recu : " + ecartMaxRecu);
			return;
		}
		System.out.println("Test 2 reussi");
		System.out.println();

		System.out.println("Test 3 : plusieurs finalistes exaequo");
		System.out.println("--------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit2 = { 10, 10, 10, 0, 0 };
		points.set(gestionnaire, ptsInit2);
		String[] finInit2 = { "loic", "leo", "luc", null, null };
		finalistes.set(gestionnaire, finInit2);
		nbrFinalistes.setInt(gestionnaire, 3);
		System.out.println("Situation initiale :");
		System.out.println(gestionnaire);
		ecartMaxRecu = gestionnaire.ecartMaximum();
		if (ecartMaxRecu != 0) {
			System.out.println("Test echoue : Attendu : 0 " + " Recu : " + ecartMaxRecu);
			return;
		}
		System.out.println("Test 3 reussi");
		System.out.println();

		System.out.println("Test 4 : plusieurs finalistes");
		System.out.println("-----------------------------");
		gestionnaire = new ClassementDesFinalistes(6);
		int[] ptsInit3 = { 10, 9, 5, 3, 2, 1 };
		points.set(gestionnaire, ptsInit3);
		String[] finInit3 = { "loic", "leo", "luc", "toto", "marc", "jean" };
		finalistes.set(gestionnaire, finInit3);
		nbrFinalistes.setInt(gestionnaire, 6);
		System.out.println("Situation initiale :");
		System.out.println(gestionnaire);
		ecartMaxRecu = gestionnaire.ecartMaximum();
		if (ecartMaxRecu != 4) {
			System.out.println("Test echoue : Attendu : 4 " + " Recu : " + ecartMaxRecu);
			return;
		}
		System.out.println("Test 4 reussi");
		System.out.println();

		System.out.println("Tous les tests ont réussi");
	}

	public static void testsDisqualifier() throws IllegalAccessException {
		ClassementDesFinalistes gestionnaire = null;

		System.out.println("Test 1 : Pas de finalistes");
		System.out.println("--------------------------");
		gestionnaire = new ClassementDesFinalistes(4);
		System.out.println(gestionnaire);
		if (gestionnaire.disqualifier("toto")) {
			System.out.println("Test echoue : Attendu : false " + " Recu : true");
			return;
		}
		System.out.println("Test 1 reussi");
		System.out.println();
		
		System.out.println("Test 2 : disqualification du seul finaliste ");
		System.out.println("------------------------------------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit = { 10, 0, 0, 0, 0 };
		points.set(gestionnaire, ptsInit);
		String[] finInit = { "loic", null, null, null, null };
		finalistes.set(gestionnaire, finInit);
		nbrFinalistes.setInt(gestionnaire, 1);
		System.out.println("Situation avant disqualifier(loic)");
		System.out.println(gestionnaire);
		if (!gestionnaire.disqualifier("loic")) {
			System.out.println("Test echoue : Resultat attendu true mais recu false.");
			return;
		} else {
			System.out.println("Situation apres disqualifier(loic)");
			System.out.println(gestionnaire);
			int nbFin = (int) nbrFinalistes.get(gestionnaire);
			if (nbFin != 0) {
				System.out.println("Test echoue : Mauvais nombre de finalistes : attendu 0, recu " + nbFin);
				return;
			}
			int[] pts = (int[]) points.get(gestionnaire);
			int[] ptsCorrect = { 10, 0, 0, 0, 0 };
			int[] ptsCorrectBis = { 0, 0, 0, 0, 0 };
			if (!Arrays.equals(pts, ptsCorrect)&&!Arrays.equals(pts, ptsCorrectBis)) {
				System.out.println("Test echoue : Tableau de points errone : attendu : "
						+ Arrays.toString(ptsCorrect) + " ou " + Arrays.toString(ptsCorrectBis)+ " Recu : " + Arrays.toString(pts));
				return;
			}
			String[] finCorrect = { "loic", null, null, null, null };
			String[] finCorrectBis = { null, null, null, null, null };
			String[] fin = (String[]) finalistes.get(gestionnaire);
			if (!Arrays.equals(fin, finCorrect)&&!Arrays.equals(fin, finCorrectBis)) {
				System.out.println("Test echoue : Tableau de finalistes errone : attendu : "
						+ Arrays.toString(finCorrect) + " ou "+ Arrays.toString(finCorrectBis) + " Recu : " + Arrays.toString(fin));
				return;
			}
		}
		System.out.println();
		
		System.out.println("Test 3 : disqualification d'un finaliste dans une table pleine");
		System.out.println("--------------------------------------------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit2 = { 10, 7, 6, 5};
		points.set(gestionnaire, ptsInit2);
		String[] finInit2 = { "loic", "jean", "luc", "toto"};
		finalistes.set(gestionnaire, finInit2);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation avant disqualifier(jean)");
		System.out.println(gestionnaire);
		if (!gestionnaire.disqualifier(new String("jean"))) {
			System.out.println("Test echoue : Resultat attendu true mais recu false.");
			return;
		} else {
			System.out.println("Situation apres disqualifier(jean)");
			System.out.println(gestionnaire);
			int nbFin = (int) nbrFinalistes.get(gestionnaire);
			if (nbFin != 3) {
				System.out.println("Test echoue : Mauvais nombre de finalistes : attendu 3, recu " + nbFin);
				return;
			}
			int[] pts = (int[]) points.get(gestionnaire);
			int[] ptsCorrect = { 10, 6, 5, 5};
			int[] ptsCorrectBis = { 10, 6, 5, 0};
			if (!Arrays.equals(pts, ptsCorrect)&&!Arrays.equals(pts, ptsCorrectBis)) {
				System.out.println("Test echoue : Tableau de points errone : attendu : "
						+ Arrays.toString(ptsCorrect) + " ou " + Arrays.toString(ptsCorrectBis)+ " Recu : " + Arrays.toString(pts));
				return;
			}
			String[] finCorrect = { "loic", "luc", "toto", "toto"};
			String[] finCorrectBis = { "loic", "luc", "toto", null};
			String[] fin = (String[]) finalistes.get(gestionnaire);
			if (!Arrays.equals(fin, finCorrect)&&!Arrays.equals(fin, finCorrectBis)) {
				System.out.println("Test echoue : Tableau de finalistes errone : attendu : "
						+ Arrays.toString(finCorrect) + " ou "+ Arrays.toString(finCorrectBis) + " Recu : " + Arrays.toString(fin));
				return;
			}
		}
		System.out.println();
		
		System.out.println("Test 4 : disqualification d'un participant qui n'est pas un finaliste");
		System.out.println("---------------------------------------------------------------------");
		gestionnaire = new ClassementDesFinalistes(5);
		int[] ptsInit3 = { 10, 7, 6, 5};
		points.set(gestionnaire, ptsInit3);
		String[] finInit3 = { "loic", "jean", "luc", "toto",null};
		finalistes.set(gestionnaire, finInit3);
		nbrFinalistes.setInt(gestionnaire, 4);
		System.out.println("Situation avant disqualifier(marc)");
		System.out.println(gestionnaire);
		if (gestionnaire.disqualifier("marc")) {
			System.out.println("Test echoue : Resultat attendu false mais recu true.");
			return;
		} 
		System.out.println();
		
		System.out.println("Tous les tests ont reussi");
	}

}
