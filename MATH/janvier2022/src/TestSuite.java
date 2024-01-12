import java.util.ArrayList;
import java.util.Scanner;

public class TestSuite {
	private final static Scanner scanner = new Scanner(System.in);
	private static final String[] NOMS_METHODE = {"tousDiviseursDe","ajouterEnKEmePosition" };

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
					testOK = testTousDiviseursDe();
					break;
				case 2:
					testOK = testAjouterEnKEmePosition();
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

	
	
	private static boolean testTousDiviseursDe() {
		boolean testOK = true;
		int temps = 300 ;

		System.out.println(" --------") ;
		System.out.println("| Test 1 |") ;
		System.out.println(" --------") ;
		Suite s = new Suite("(3,9,6,3,10)");
		Suite copieS = new Suite("(3,9,6,3,10)") ;
		try {
			if (s.tousDiviseursDe(36)) {
				System.out.println("Réponse attendue : false");
				System.out.println("Votre méthode a renvoyé : true ");
				System.out.println("Tous les éléments de s="+s+" ne sont pas des diviseurs de 36 car 10 ne l'est pas.") ;
				testOK = false;
			} else if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courrante !");
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

		System.out.println(" --------") ;
		System.out.println("| Test 2 |") ;
		System.out.println(" --------") ;
		s = new Suite("(3,9,6,3,12)");
		copieS = new Suite("(3,9,6,3,12)") ;
		try {
			if (!s.tousDiviseursDe(36)) {
				System.out.println("Réponse attendue : true");
				System.out.println("Votre méthode a renvoyé : false");
				System.out.println("Attention ! Tous les éléments de s="+s+" sont des diviseurs de 36.") ;
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

		System.out.println(" --------") ;
		System.out.println("| Test 3 |") ;
		System.out.println(" --------") ;
		s = new Suite();
		copieS = new Suite() ;
		try {
			if (!s.tousDiviseursDe(36)) {
				System.out.println("Réponse attendue : true");
				System.out.println("Votre méthode a renvoyé : false");
				System.out.println("En effet ! Il n'y a aucun élément de s="+s+" sont qui n'est pas diviseur de 36.") ;
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

		System.out.println(" --------") ;
		System.out.println("| Test 4 |") ;
		System.out.println(" --------") ;
		s = new Suite("(8,2,6)");
		copieS = new Suite("(8,2,6)") ;
		try {
			if (!s.tousDiviseursDe(-24)) {
				System.out.println("Réponse attendue : true");
				System.out.println("Votre méthode a renvoyé : false");
				System.out.println("Attention ! Tous les éléments de s="+s+" sont des diviseurs de -24.") ;
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

		System.out.println(" --------") ;
		System.out.println("| Test 5 |") ;
		System.out.println(" --------") ;
		s = new Suite("(8,3,6)");
		copieS = new Suite("(8,3,6)") ;
		try {
			if (!s.tousDiviseursDe(0)) {
				System.out.println("Réponse attendue : true");
				System.out.println("Votre méthode a renvoyé : false");
				System.out.println("Attention ! Tous les éléments de s="+s+" sont des diviseurs de 0 !") ;
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

		return testOK;
	}
	
	private static boolean testAjouterEnKEmePosition() {
		boolean testOK = true;
		int temps = 300 ;
		
		System.out.println(" --------") ;
		System.out.println("| Test 1 |") ;
		System.out.println(" --------") ;
		Suite s = new Suite("(1,7,6)");
		Suite copieS = new Suite("(1,7,6)") ;
		Suite sAttendue = new Suite("(1,3,7,6)") ;
		try {
			Suite sRecue = s.ajouterEnKEmePosition(new Elt(3), 2);
			if (sontDifferentes(sAttendue, sRecue)) {
				System.out.println("La suite attendue est " + sAttendue);
				System.out.println("Votre méthode a renvoyé : " + sRecue);
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
		System.out.println(" --------") ;
		System.out.println("| Test 2 |") ;
		System.out.println(" --------") ;

		s = new Suite("(1,7,6)") ;
		sAttendue = new Suite("(1,7,6,3)") ;
		try {
			Suite sRecue = s.ajouterEnKEmePosition(new Elt(3), 4);
			if (sontDifferentes(sAttendue, sRecue)) {
				System.out.println("La suite attendue est " + sAttendue);
				System.out.println("Votre méthode a renvoyé : " + sRecue);
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

		System.out.println(" --------") ;
		System.out.println("| Test 3 |") ;
		System.out.println(" --------") ;

		s = new Suite("(1,7,6)") ;
		try {
			Suite sRecue = s.ajouterEnKEmePosition(new Elt(3), 5);
			System.out.println("Attention il fallait une IllegalArgumentException !") ;
			System.out.println("La suite "+s+" n'a que 3 éléments, on ne sait donc pas ajouter en 5ème position !") ;
			testOK = false ;
		} catch(Exception e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		}

		System.out.println(" --------") ;
		System.out.println("| Test 4 |") ;
		System.out.println(" --------") ;

		s = new Suite("(1,7,6)") ;
		try {
			Suite sRecue = s.ajouterEnKEmePosition(new Elt(3), -1);
			System.out.println("Attention il fallait une IllegalArgumentException !") ;
			System.out.println("On ne sait ajouter en -1ème position !") ;
			testOK = false ;
		} catch(Exception e) {
			if (sontDifferentes(s, copieS)) {
				System.out.println("Attention ! Votre méthode a modifié la suite courante !");
				testOK = false;
			}
		}

		System.out.println(" --------") ;
		System.out.println("| Test 5 |") ;
		System.out.println(" --------") ;

		s = new Suite() ;
		copieS = new Suite() ;
		sAttendue = new Suite("(3)") ;
		try {
			Suite sRecue = s.ajouterEnKEmePosition(new Elt(3), 1);
			if (sontDifferentes(sAttendue, sRecue)) {
				System.out.println("La suite attendue est " + sAttendue);
				System.out.println("Votre méthode a renvoyé : " + sRecue);
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
