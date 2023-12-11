import java.util.Arrays;

public class TestSudokuGeneral {

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

	public static void main(String[] args) {

		int choix;
		System.out.println("*********************************************");
		System.out.println("Programme Test pour la classe SudokuGeneral :");
		System.out.println("*********************************************");
		System.out.println();
		do {
			System.out.println("1 -> Tester la methode estPresentDansLigne()");
			System.out.println("2 -> Tester la methode estPresentDansColonne()");
			System.out.println("3 -> Tester la methode estPresentDansRegion()");
			System.out.println("4 -> Tester la methode estCoupLegal()");
			System.out.println("5 -> Tester la methode nombreLePlusPresent");

			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					verifierLigne();
					break;
				case 2:
					verifierColonne();
					break;
				case 3:
					verifierRegion();
					break;
				case 4:
					verifierLegal();
					break;
				case 5:
					verifierMax();
					break;
			}
		} while (choix >= 1 && choix <= 5);
		System.out.println("Fin des tests");
	}

	private static void verifierLigne() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansLigne(nombre,indiceLigne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 0;
			System.out.println("L'indice ligne : "+indiceLigne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansLigne(nombre,indiceLigne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 1;
			System.out.println("L'indice ligne : "+indiceLigne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansLigne(nombre,indiceLigne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 8;
			System.out.println("L'indice ligne : "+indiceLigne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansLigne(nombre,indiceLigne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 7;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 4;
			System.out.println("L'indice ligne : "+indiceLigne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansLigne(nombre,indiceLigne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " grille 4x4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 3;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 3;
			System.out.println("L'indice ligne : "+indiceLigne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansLigne(nombre,indiceLigne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " grille 4x4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 3;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansLigne(nombre,indiceLigne));
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

	private static void verifierColonne() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceColonne = 6;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansColonne(nombre,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceColonne = 0;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansColonne(nombre,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceColonne = 8;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansColonne(nombre,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " grille 4X4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 2;
			System.out.println("le nombre verifie : "+nombre);
			int indiceColonne = 0;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansColonne(nombre,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " grille 4X4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 3;
			System.out.println("le nombre verifie : "+nombre);
			int indiceColonne = 2;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansColonne(nombre,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " grille 4X4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 2;
			System.out.println("le nombre verifie : "+nombre);
			int indiceColonne = 3;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansColonne(nombre,indiceColonne));
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

	private static void verifierRegion() {

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 0;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 0;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 0;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 3;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 0;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 6;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 6;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 6;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();


		numeroTest = 5;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 3;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 6;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 1;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 3;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 6;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();


		numeroTest = 7;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 2;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 3;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 6;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 6;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 3;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 6;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " grille 4x4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 2;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 0;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 10;
		System.out.println("test " + numeroTest + " grille 4x4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 3;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 0;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 11;
		System.out.println("test " + numeroTest + " grille 4x4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 2;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estPresentDansRegion(nombre,indiceLigne,indiceColonne));
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

	private static void verifierLegal() {

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 6;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 3;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 8;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 2;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 8;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 8;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 8;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 4;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 1;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 8;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			int nombre = 1;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 8;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 0;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " grille 4X4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 3;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 0;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 3;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " grille 4X4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 2;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 2;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " grille 4X4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 1;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 3;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 1;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", true, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 9;
		System.out.println("test " + numeroTest + " grille 4X4");
		try {
			SudokuGeneral sudoku = grille4X4();
			int nombre = 1;
			System.out.println("le nombre verifie : "+nombre);
			int indiceLigne = 2;
			System.out.println("L'indice ligne : "+indiceLigne);
			int indiceColonne = 0;
			System.out.println("L'indice colonne : "+indiceColonne);
			assertEquals("le test "+numeroTest+ " a echoue ", false, sudoku.estCoupLegal(nombre,indiceLigne,indiceColonne));
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

	private static void verifierMax() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille9X9();
			assertEquals("le test "+numeroTest+ " a echoue ", 4, sudoku.nombreLePlusPresent());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grille4X4();
			assertEquals("le test "+numeroTest+ " a echoue ", 4, sudoku.nombreLePlusPresent());
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " grille 9x9");
		try {
			SudokuGeneral sudoku = grilleVide();
			assertEquals("le test "+numeroTest+ " a echoue ", -1, sudoku.nombreLePlusPresent());
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

	private static SudokuGeneral grille9X9(){
		int[][] grille9x9 = {
				{4, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 4, 0, 0, 0, 0},

				{0, 7, 0, 0, 0, 3, 4, 5, 0},
				{2, 0, 0, 0, 0, 0, 9, 8, 7},
				{0, 0, 0, 0, 0, 0, 1, 3, 2},

				{0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
		return new SudokuGeneral(grille9x9);
	}

	private static SudokuGeneral grille4X4(){
		int[][] grille4x4 = {
				{4, 0, 0, 0},
				{0, 0, 1, 0},

				{0, 4, 0, 1},
				{2, 0, 3, 4}
		};
		return new SudokuGeneral(grille4x4);
	}

	private static SudokuGeneral grilleVide(){
		int[][] grilleVide = {
				{0, 0, 0, 0},
				{0, 0, 0, 0},

				{0, 0, 0, 0},
				{0, 0, 0, 0}
		};
		return new SudokuGeneral(grilleVide);
	}

}




/*
		// Coup legal
		if (!grille.estCoupLegal(1, 5, 1))
			System.out.println("Le coup i=1, j=5, nombre=1 devrait etre legal et est indique comme illegal");
		else
			System.out.println("1, 5, 1 ok!");
		
		// Coup illegal colonne
		System.out.println("Test Coup illegal colonne");
		if (grille.estCoupLegal(5, 0, 4))
			System.out.println("Le coup i=5, j=0, nombre=4 devrait etre illegal et est indique comme legal");
		else
			System.out.println("5, 0, 4 ok!");
		
		// Coup illegal ligne
		System.out.println("Test Coup illegal ligne");
		if (grille.estCoupLegal(7, 7, 1))
			System.out.println("Le coup i=7, j=7, nombre=1 devrait etre illegal et est indique comme legal");
		else
			System.out.println("7, 7, 1 ok!");

		// Coup illegal region
		System.out.println("Test Coup illegal region");
		if (grille.estCoupLegal(3, 8, 9))
			System.out.println("Le coup i=3, j=8, nombre=9 devrait etre illegal et est indique comme legal");
		else
			System.out.println("3, 8, 9 ok!");
		
		
		System.out.println("\nTEST2: teste si un coup est legal sur la grille 4x4");
		
		grille = new SudokuGeneral(grille4x4);
		
		// Coup legal 4x4
		if (!grille.estCoupLegal(0, 1, 1))
			System.out.println("Le coup i=0, j=1, nombre=1 devrait etre legal et est indique comme illegal");
		else
			System.out.println("0, 1, 1 ok!");		
		
		// CHIFFRE LE PLUS PRESENT

		System.out.println("\nTEST3: teste le chiffre le plus present dans la grille 4x4");
				
		if (grille.nombreLePlusPresent()!=3 )
			System.out.println("Le chiffre le plus present devrait etre 3");
		else
			System.out.println("chiffrePlusPresent ok sur 4x4");
				
		System.out.println("\nTEST4: teste le chiffre le plus present dans la grille 9x9");
		
		grille = new SudokuGeneral(grille9x9);
		if (grille.nombreLePlusPresent()!=4 )
			System.out.println("Le chiffre le plus present devrait etre 4");
		else
			System.out.println("chiffrePlusPresent ok sur 9x9");

 */
