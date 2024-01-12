import java.util.ArrayList;
import java.util.Scanner;

public class TestSuite {
	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("* Programme Test pour la classe Suite *");
		System.out.println("***************************************");
		System.out.println() ;
		System.out.println("Tests de la méthode toujoursAvant :") ;
		System.out.println("===================================") ;
		System.out.println( );
		if (testToujoursAvant())
			System.out.println("Les tests de la méthode toujoursAvant ont réussi.");
		else
			System.out.println("Les tests de la méthode toujoursAvant ont échoués.");
		System.out.println();
	}

	private static boolean testToujoursAvant() {
		boolean testOK = true;
		int temps = 300;

		System.out.println(" --------");
		System.out.println("| Test 1 |");
		System.out.println(" --------");

		Suite s = new Suite("(1,2,2)");
		Suite copieS = new Suite("(1,2,2)");
		try {
			s.nbFoisAvant(null, new Elt(3));
			System.out.println("Attention il fallait une IllegalArgumentException car x est null !");
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

		s = new Suite("(1,2,2)");
		copieS = new Suite("(1,2,2)");
		try {
			s.nbFoisAvant(new Elt(3),null);
			System.out.println("Attention il fallait une IllegalArgumentException car x est null !");
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
		System.out.println("| Test 3 |");
		System.out.println(" --------");

		s = new Suite("(3,6,4,2,6)");
		copieS = new Suite("(3,6,4,2,6)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(4)) ;
			if (nbFois!=0) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 4 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 0 fois juste avant dans cette suite.");
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

		s = new Suite("(3,4,9,3,4)");
		copieS = new Suite("(3,4,9,3,4)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(4)) ;
			if (nbFois!=2) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 4 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 2 fois juste avant 4 dans cette suite.");
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

		System.out.println(" --------");
		System.out.println("| Test 5 |");
		System.out.println(" --------");

		s = new Suite();
		copieS = new Suite();
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(4)) ;
			if (nbFois!=0) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 4 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 0 fois juste avant 4 dans cette suite.");
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

		s = new Suite("(7,8,4,6,10)");
		copieS = new Suite("(7,8,4,6,10)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(4)) ;
			if (nbFois!=0) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 4 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 0 fois avant 4 dans cette suite.");
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

		s = new Suite("(8,3,4,3,4,3)");
		copieS = new Suite("(8,3,4,3,4,3)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(4)) ;
			if (nbFois!=2) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 4 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 2 fois juste avant 4 dans cette suite.");
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

		s = new Suite("(8,3,4,3,4,3)");
		copieS = new Suite("(8,3,4,3,4,3)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(3)) ;
			if (nbFois!=0) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 3 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 0 fois juste avant 3 dans cette suite.");
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
		System.out.println("| Test 9 |");
		System.out.println(" --------");

		s = new Suite("(8,3,3,3,3,3,2)");
		copieS = new Suite("(8,3,3,3,3,3,2)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(3)) ;
			if (nbFois!=4) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 3 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 4 fois juste avant 3 dans cette suite.");
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
		System.out.println("| Test 10 |");
		System.out.println(" --------");

		s = new Suite("(8)");
		copieS = new Suite("(8)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(4)) ;
			if (nbFois!=0) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 4 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 0 fois avant 4 dans cette suite.");
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

		System.out.println(" ---------");
		System.out.println("| Test 11 |");
		System.out.println(" ---------");

		s = new Suite("(3)");
		copieS = new Suite("(3)");
		try {
			int nbFois = s.nbFoisAvant(new Elt(3),new Elt(4)) ;
			if (nbFois!=0) {
				System.out.println("Attention votre méthode dit que 3 se trouve "+nbFois+" fois juste avant 4 dans la suite "+s+".");
				System.out.println("Or 3 se trouve 0 fois avant 4 dans cette suite.");
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
