import java.util.Arrays;

public class TestParticipantsV1 {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
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
		System.out.println("**********************************************");
		System.out.println("Programme Test pour la classe ParticipantsV1 :");
		System.out.println("**********************************************");
		System.out.println();
		do {
			System.out.println("1 -> Tester la methode 'contientParticipant()'");
			System.out.println("2 -> Tester la methode 'ajouterUnParticipant()'");
			System.out.println("3 -> Tester la methode 'supprimerUnParticipant()'");
			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					contient();
					break;
				case 2:
					ajouter();
					break;
				case 3:
					supprimer();
					break;
			}
		} while (choix >= 1 && choix <= 3);
		System.out.println("Fin des tests");
	}

	private static void contient() {
		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : contient un participant qui existe dans une table non pleine ");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1", "p2","p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3"};
			String participant = "p2";
			System.out.println("le participant a verifier : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.contientParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : contient un participant qui existe dans une table non pleine ");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1", "p2","p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3"};
			String participant = "p1";
			System.out.println("le participant a verifier : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.contientParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : contient un participant qui existe dans une table non pleine ");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1", "p2","p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3"};
			String participant = "p3";
			System.out.println("le participant a verifier : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.contientParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : contient un participant qui existe dans une table pleine ");
		try {
			int nombreMaxParticipants = 4;
			String[] t = { "p1", "p2","p3","p4"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3","p4"};
			String participant = "p4";
			System.out.println("le participant a verifier : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.contientParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : contient un participant qui n'existe pas dans une table non pleine ");
		try {
			int nombreMaxParticipants = 7;
			String[] t = { "p1", "p2","p3","p4"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3","p4"};
			String participant = "p9";
			System.out.println("le participant a verifier : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, p.contientParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : contient un participant qui n'existe pas dans une table pleine ");
		try {
			int nombreMaxParticipants = 4;
			String[] t = { "p1", "p2","p3","p4"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3","p4"};
			String participant = "p9";
			System.out.println("le participant a verifier : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, p.contientParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
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

	private static void ajouter() {

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (3 places libres)");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1", "p2" };
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3"};
			String participant = "p3";
			System.out.println("le participant a ajouter : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.ajouterUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();


		numeroTest = 2;
		System.out.println("test " + numeroTest + " : ajout dans une table non pleine (1 place libre)");
		try {
			int nombreMaxParticipants = 3;
			String[] t = { "p1", "p2"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3"};
			String participant = "p3";
			System.out.println("le participant a ajouter : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.ajouterUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : ajout dans une table pleine (ajout impossible)");
		try {
			int nombreMaxParticipants = 3;
			String[] t = { "p1", "p2", "p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3"};
			String participant = "p4";
			System.out.println("le participant a ajouter : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, p.ajouterUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();


		numeroTest = 4;
		System.out.println("test " + numeroTest + " : ajout d'un participant deja inscrit (ajout impossible)");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1", "p2", "p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1", "p2", "p3"};
			String participant = "p2";
			System.out.println("le participant a ajouter : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, p.ajouterUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : ajout dans une table vide (4 places libres)");
		try {
			int nombreMaxParticipants = 4;
			String[] t = {};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1"};
			String participant = "p1";
			System.out.println("le participant a ajouter : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.ajouterUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
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

	private static void supprimer() {

		System.out.println();
		int numeroTest = 1;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1","p2","p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1","p3"};
			String participant = "p2";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 2;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine");
		try {
			int nombreMaxParticipants = 8;
			String[] t = { "p1","p2","p3","p4","p5","p6"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1","p6","p3","p4","p5"};
			String participant = "p2";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 3;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine");
		try {
			int nombreMaxParticipants = 4;
			String[] t = { "p1","p2","p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1","p2"};
			String participant = "p3";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 4;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine");
		try {
			int nombreMaxParticipants = 7;
			String[] t = { "p1","p2","p3","p4","p5"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p5","p2","p3","p4"};
			String participant = "p1";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 5;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1","p2","p3","p4","p5"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1","p5","p3","p4"};
			String participant = "p2";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 6;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1","p2","p3","p4","p5"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1","p2","p3","p4"};
			String participant = "p5";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", true, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 7;
		System.out.println("test " + numeroTest + " : suppression dans une table non pleine qui ne contient pas le participant");
		try {
			int nombreMaxParticipants = 5;
			String[] t = { "p1","p2","p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1","p2","p3"};
			String participant = "p9";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("le test " + numeroTest + " a reussi");
		System.out.println();

		numeroTest = 8;
		System.out.println("test " + numeroTest + " : suppression dans une table pleine qui ne contient pas le participant");
		try {
			int nombreMaxParticipants = 3;
			String[] t = { "p1","p2","p3"};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = { "p1","p2","p3"};
			String participant = "p9";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
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
			int nombreMaxParticipants = 4;
			String[] t = {};
			System.out.println("le nombre max de participants : "+nombreMaxParticipants);
			ParticipantsV1 p = new ParticipantsV1(nombreMaxParticipants, t);
			System.out.println("les participants deja inscrits : "+ Arrays.toString(t));
			String[] tSol = {};
			String participant = "p9";
			System.out.println("le participant a supprimer : " +participant);
			assertEquals("le test "+numeroTest+ " a echoue (boolean renvoye)", false, p.supprimerUnParticipant(participant));
			assertEquals("le test "+numeroTest+ " a echoue (nombre inscrits)", tSol.length, p.getNombreInscrits());
			assertEquals("le test "+numeroTest+ " a echoue (contenu table)", Arrays.toString(tSol), p.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("le test "+numeroTest+ " a echoue : sortie de table");
			System.exit(0);
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
}
