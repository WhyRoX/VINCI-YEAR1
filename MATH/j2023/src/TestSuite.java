import java.util.ArrayList;
import java.util.Scanner;

public class TestSuite {
	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("* Programme Test pour la classe Suite *");
		System.out.println("***************************************");
		System.out.println() ;
		System.out.println("Tests de la méthode auMoins2EnSuivant :") ;
		System.out.println("=======================================") ;
		System.out.println( );
		if (testAuMoins2EnSuivant())
			System.out.println("Les tests de la méthode auMoins2EnSuivant ont réussi.");
		else
			System.out.println("Les tests de la méthode auMoins2EnSuivant ont échoués.");
		System.out.println();
	}

	private static boolean testAuMoins2EnSuivant() {
		boolean testOK = true;
		int temps = 300;

		System.out.println(" --------");
		System.out.println("| Test 1 |");
		System.out.println(" --------");

		Suite s = new Suite("(1,2,2)");
		Suite copieS = new Suite("(1,2,2)");
		try {
			s.auMoins2EnSuivant(null);
			System.out.println("Attention il fallait une IllegalArgumentException car e est null !");
			testOK = false;
		} catch (IllegalArgumentException e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch(Exception e) {
			System.out.println("Mauvais type d'exception : Attendu IllegalArgumentException mais reçu : ") ;
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 2 |");
		System.out.println(" --------");

		s = new Suite("(3,6,6,3,10)");
		copieS = new Suite("(3,6,6,3,10)");
		try {
			if (s.auMoins2EnSuivant(new Elt(3))) {
				System.out.println("Attention votre méthode dit que la suite "+s+" contient l'élément 3 deux fois en suivant !");
				System.out.println("Or ce n'est pas le cas !");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch (Exception e) {
			System.out.println("Il ne fallait pas d'exception : ");
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 3 |");
		System.out.println(" --------");

		s = new Suite("(3,9,6,3,3,12,3)");
		copieS = new Suite("(3,9,6,3,3,12,3)");
		try {
			if (!s.auMoins2EnSuivant(new Elt(3))) {
				System.out.println("Attention votre méthode dit que la suite "+s+"ne contient pas l'élément 3 deux fois en suivant !");
				System.out.println("Or c'est le cas !");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch (Exception e) {
			System.out.println("Il ne fallait pas d'exception : ");
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 4 |");
		System.out.println(" --------");

		s = new Suite();
		copieS = new Suite();
		try {
			if (s.auMoins2EnSuivant(new Elt(4))) {
				System.out.println("Attention votre méthode dit que la suite "+s+" contient l'élément 4 deux fois en suivant !");
				System.out.println("Or ce n'est pas cas !");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch (Exception e) {
			System.out.println("Il ne fallait pas d'exception : ");
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 5 |");
		System.out.println(" --------");

		s = new Suite("(3,8,2,6,3,3)");
		copieS = new Suite("(3,8,2,6,3,3)");
		try {
			if (!s.auMoins2EnSuivant(new Elt(3))) {
				System.out.println("Attention votre méthode dit que la suite "+s+"ne contient pas l'élément 3 deux fois en suivant !");
				System.out.println("Or c'est le cas !");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch (Exception e) {
			System.out.println("Il ne fallait pas d'exception : ");
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 6 |");
		System.out.println(" --------");

		s = new Suite("(8,3,6,3,4,3)");
		copieS = new Suite("(8,3,6,3,4,3)");
		try {
			if (s.auMoins2EnSuivant(new Elt(3))) {
				System.out.println("Attention votre méthode dit que la suite "+s+" contient l'élément 3 deux fois en suivant !");
				System.out.println("Or ce n'est pas cas !");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch (Exception e) {
			System.out.println("Il ne fallait pas d'exception : ");
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 7 |");
		System.out.println(" --------");

		s = new Suite("(8,3,3,3,4,5)");
		copieS = new Suite("(8,3,3,3,4,5)");
		try {
			if (!s.auMoins2EnSuivant(new Elt(3))) {
				System.out.println("Attention votre méthode dit que la suite "+s+"ne contient pas l'élément 3 deux fois en suivant !");
				System.out.println("Or c'est le cas !");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch (Exception e) {
			System.out.println("Il ne fallait pas d'exception : ");
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		System.out.println(" --------");
		System.out.println("| Test 8 |");
		System.out.println(" --------");

		s = new Suite("(3)");
		copieS = new Suite("(3)");
		try {
			if (s.auMoins2EnSuivant(new Elt(3))) {
				System.out.println("Attention votre méthode dit que la suite "+s+" contient l'élément 3 deux fois en suivant !");
				System.out.println("Or ce n'est pas cas !");
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			} else {
				System.out.println("OK") ;
			}
		} catch (Exception e) {
			System.out.println("Il ne fallait pas d'exception : ");
			e.printStackTrace();
			try {
				Thread.sleep(temps);
			} catch (InterruptedException ex) {
			}
			testOK = false;
		}

		System.out.println() ;

		return testOK ;
	}

	private static boolean sontDifferentes(Suite s1, Suite s2) {
		ArrayList<Elt> listeAvant = new ArrayList<Elt>();
		s1.forEach(e -> listeAvant.add(e));
		ArrayList<Elt> listeApres = new ArrayList<Elt>();
		s2.forEach(e -> listeApres.add(e));
		return !listeAvant.equals(listeApres);
	}

	

}
