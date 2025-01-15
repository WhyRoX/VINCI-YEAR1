import java.util.ArrayList;
import java.util.Scanner;

public class TestSuite {
	private final static Scanner scanner = new Scanner(System.in);
	private static final String[] NOMS_METHODE = {"sommeDesPlusGrandsQue","contientAuMoinsNElements" };

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("* Programme Test pour la classe Suite *");
		System.out.println("***************************************");
		int choix ;
		while (true) {
			for (int i = 0; i < NOMS_METHODE.length; i++) {
				System.out.println((i + 1) + " -> Tester la méthode '" + NOMS_METHODE[i] + "'");
			}

			choix = scanner.nextInt();
			System.out.println() ;
			boolean testOK;
			switch (choix) {
				case 1:
					testOK = testSommeDesPlusGrandsQue();
					break;
				case 2:
					testOK = testContientAuMoinsNElements() ;
					break;
				default:
					return;
			}
			if (testOK)
				System.out.println("Les tests de la méthode " + NOMS_METHODE[choix - 1] + " ont réussi.");
			else
				System.out.println("Les tests de la méthode " + NOMS_METHODE[choix - 1] + " ont échoués.");
			System.out.println();
		}
	}

	private static boolean testSommeDesPlusGrandsQue() {
		boolean testOK = true;
		int temps = 300 ;

		System.out.println(" --------") ;
		System.out.println("| Test 1 |") ;
		System.out.println(" --------") ;

		Suite s = new Suite("(3,9,6,3,10)");
		Suite copieS = new Suite("(3,9,6,3,10)") ;
		try {
			int somme = s.sommeDesPlusGrandsQue(9);
			if (somme!=19) {
				System.out.println(s+".sommeDesPlusGrands(9) = 9+10 =19 ");
				System.out.println("Or votre méthode renvoie "+somme);
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println() ;

		System.out.println(" --------") ;
		System.out.println("| Test 2 |") ;
		System.out.println(" --------") ;

		s = new Suite("(4,9,2,12,6)");
		copieS = new Suite("(4,9,2,12,6)") ;
		try {
			int somme = s.sommeDesPlusGrandsQue(5);
			if (somme!=27) {
				System.out.println(s+".sommeDesPlusGrands(5) = 9+12+6 =27 ");
				System.out.println("Or votre méthode renvoie "+somme);
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println();

		System.out.println(" --------") ;
		System.out.println("| Test 3 |") ;
		System.out.println(" --------") ;

		s = new Suite();
		copieS = new Suite() ;
		try {
			int somme = s.sommeDesPlusGrandsQue(-1);
			if (somme!=0) {
				System.out.println(s+".sommeDesPlusGrands(-1) = 0");
				System.out.println("Or votre méthode renvoie "+somme);
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println();

		System.out.println(" --------") ;
		System.out.println("| Test 4 |") ;
		System.out.println(" --------") ;

		s = new Suite("(11,3,9)");
		copieS = new Suite("(11,3,9)") ;
		try {
			int somme = s.sommeDesPlusGrandsQue(12);
			if (somme!=0) {
				System.out.println(s+".sommeDesPlusGrands(12) = 0");
				System.out.println("Or votre méthode renvoie "+somme);
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println();

		return testOK;
	}

	private static boolean testContientAuMoinsNElements() {
		boolean testOK = true;
		int temps = 300 ;

		System.out.println(" --------") ;
		System.out.println("| Test 1 |") ;
		System.out.println(" --------") ;

		Suite s = new Suite("(3,7,5,12,2)");
		Suite copieS = new Suite("(3,7,5,12,2)") ;
		try {
			if (!s.contientAuMoinsNElements(4)) {
				System.out.println("Attention ! La suite "+s+" contient 5 éléments !") ;
				System.out.println("Or votre méthode dit qu'elle ne contient pas au moins 4 éléments !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(4) :") ;
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println() ;

		System.out.println(" --------") ;
		System.out.println("| Test 2 |") ;
		System.out.println(" --------") ;

		s = new Suite("(3,7,5,12,2)");
		copieS = new Suite("(3,7,5,12,2)") ;
		try {
			if (!s.contientAuMoinsNElements(5)) {
				System.out.println("Attention ! La suite "+s+" contient 5 éléments !") ;
				System.out.println("Or votre méthode dit qu'elle ne contient pas au moins 5 éléments !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(5) :") ;
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println() ;

		System.out.println(" --------") ;
		System.out.println("| Test 3 |") ;
		System.out.println(" --------") ;

		s = new Suite("(3,7,5,12,2)");
		copieS = new Suite("(3,7,5,12,2)") ;
		try {
			if (s.contientAuMoinsNElements(6)) {
				System.out.println("Attention ! La suite "+s+" contient 5 éléments !") ;
				System.out.println("Or votre méthode dit qu'elle en contient au moins 6 !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(6) :") ;
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println() ;

		System.out.println(" --------") ;
		System.out.println("| Test 4 |") ;
		System.out.println(" --------") ;

		s = new Suite();
		copieS = new Suite() ;
		try {
			if (s.contientAuMoinsNElements(1)) {
				System.out.println("Attention ! La suite "+s+" ne contient pas d'éléments !") ;
				System.out.println("Or votre méthode dit qu'elle en contient au moins 1 !") ;;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(1) :") ;
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println() ;

		System.out.println(" --------") ;
		System.out.println("| Test 5 |") ;
		System.out.println(" --------") ;

		s = new Suite();
		copieS = new Suite() ;
		try {
			if (!s.contientAuMoinsNElements(0)) {
				System.out.println("Attention ! La suite "+s+" ne contient pas d'élément") ;
				System.out.println("Or votre méthode dit qu'elle ne contient pas au moins 0 élément !") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(0) :") ;
			System.out.println("Il ne fallait pas d'exception : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			}
			catch(InterruptedException ex) {
			}
			testOK = false ;
		}

		System.out.println() ;

		System.out.println(" --------") ;
		System.out.println("| Test 6 |") ;
		System.out.println(" --------") ;

		s = new Suite("(3,7,5,12,2)");
		copieS = new Suite("(3,7,5,12,2)") ;
		try {
			s.contientAuMoinsNElements(-1);
			System.out.println(s+".contientAuMoinsNElements(-1) :") ;
			System.out.println("Attention, il fallait une exception car n<0") ;
			testOK=false ;
		} catch(IllegalArgumentException e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		} catch(Exception e) {
			System.out.println(s+".contientAuMoinsNElements(-1) :") ;
			System.out.println("Attention ce n'est pas le bon type d'exception :");
			System.out.println("Attendu : IllegalArgumentExcepion") ;
			System.out.println("Reçu : "+e.getClass()) ;
			testOK=false ;
		}

		System.out.println() ;

		return testOK;
	}

	private static boolean sontDifferentes(Suite s1, Suite s2) {
		ArrayList<Elt> listeAvant = new ArrayList<Elt>();
		s1.forEach(e -> listeAvant.add(e));
		ArrayList<Elt> listeApres = new ArrayList<Elt>();
		s2.forEach(e -> listeApres.add(e));
		return !listeAvant.equals(listeApres);
	}

	

}
