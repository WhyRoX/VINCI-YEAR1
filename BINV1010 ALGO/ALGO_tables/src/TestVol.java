
public class TestVol {

	private static Vol vol;

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 *
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu       la valeur qu'on s'attendait a recevoir
	 * @param recu          la valeur qu'on a recu en realite
	 */

	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println();
				System.out.println(messageErreur);
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
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
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}
		}
	}

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("*********************************");
		System.out.println("Programme Test pour la classe Vol");
		System.out.println("*********************************");
		int choix = 0;
		do {
			System.out.println("1 -> Tester la methode lieuArrivee()");
			System.out.println("2 -> Tester la methode estUnTour()");
			System.out.println("3 -> Tester la methode niemeLieu()");
			System.out.println("4 -> Tester la methode lieuLePlusAuSud()");
			System.out.println("5 -> Tester la methode lieuLePlusEloigne()");
			System.out.println("6 -> Tester la methode cibleAtteinte()");
			System.out.println("7 -> Tester la methode nombreCiblesAtteintes()");
			System.out.println("8 -> Tester la methode distance()");
			System.out.println("9 -> Tester la methode aSurvoleUnMemeLieu()");
			System.out.println("10 -> Tester la methode parcoursSuivi()");
			System.out.println();
			System.out.print("Entrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					testLieuArrivee();
					break;
				case 2:
					testEstUnTour();
					break;
				case 3:
					niemeLieu();
					break;
				case 4:
					testLieuLePlusAuSud();
					break;
				case 5:
					testLieuLePlusEloigne();
					break;
				case 6:
					testCibleAtteinte();
					break;
				case 7:
					testNombreCiblesAtteintes();
					break;
				case 8:
					testDistance();
					break;
				case 9:
					testASurvoleUnMemeLieu();
					break;
				case 10:
					testParcoursSuivi();
					break;
				default:
					break;
			}
		} while (choix >= 1 && choix <= 10);

	}

	private static void testLieuArrivee() {
		try{
			vol = chargerVol(1);
			Coordonnees attendu = new Coordonnees(4, 6);
			Coordonnees recu = vol.lieuArrivee();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol1 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

			vol = chargerVol(2);
			attendu = new Coordonnees(1, 1);
			recu = vol.lieuArrivee();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol2 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}
		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}

	private static void testEstUnTour() {
		try{
			vol = chargerVol(1);
			assertEquals("test vol1 ko",false,vol.estUnTour());
			vol = chargerVol(2);
			assertEquals("test vol2 ko",true,vol.estUnTour());
		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}

	private static void niemeLieu() {
		try{
			vol = chargerVol(1);
			Coordonnees attendu = new Coordonnees(1, 1);
			Coordonnees recu = vol.niemeLieu(0);
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol1 - n = 0 : ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}
			attendu = new Coordonnees(3, 3);
			recu = vol.niemeLieu(2);
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol1 - n = 2 : ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}
			attendu = new Coordonnees(4, 6);
			recu = vol.niemeLieu(5);
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol1 - n = 5 : ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}


		try{
			Coordonnees recu = vol.niemeLieu(-1);
			if(recu != null){
				System.out.println("test vol1 - n = -1 : ko");
				System.out.println("-->Attendu : null");
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}
		}catch (Exception e){
			System.out.println("test vol1 - n = -1 : ko");
			System.out.println("Exception inattendue (on attendait null)");
			e.printStackTrace();
			System.exit(0);
		}

		try{
			Coordonnees recu = vol.niemeLieu(6);
			if(recu != null){
				System.out.println("test vol1 - n = 6 : ko");
				System.out.println("-->Attendu : null");
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}
		}catch (Exception e){
			System.out.println("test vol1 - n = 6 : ko");
			System.out.println("Exception inattendue (on attendait null)");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}


	private static void testLieuLePlusAuSud() {
		try{
			vol = chargerVol(1);
			Coordonnees attendu = new Coordonnees(1, 1);
			Coordonnees recu = vol.lieuLePlusAuSud();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol1 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

			vol = chargerVol(2);
			attendu = new Coordonnees(-2, 1);
			recu = vol.lieuLePlusAuSud();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol2 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

			vol = chargerVol(3);
			attendu = new Coordonnees(-1, 0);
			recu = vol.lieuLePlusAuSud();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol3 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}

	private static void testLieuLePlusEloigne() {
		try{
			vol = chargerVol(1);
			Coordonnees attendu = new Coordonnees(4, 6);
			Coordonnees recu = vol.lieuLePlusEloigne();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol1 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

			vol = chargerVol(2);
			attendu = new Coordonnees(-2, 1);
			recu = vol.lieuLePlusEloigne();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol2 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

			vol = chargerVol(3);
			attendu = new Coordonnees(-1, 1);
			recu = vol.lieuLePlusEloigne();
			if(!attendu.equals(recu)){
				System.out.println();
				System.out.println("vol3 ko");
				System.out.println("-->Attendu : " + attendu);
				System.out.println("-->Recu : " + recu);
				System.exit(0);
			}

		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}


	private static void testCibleAtteinte() {
		try{
			vol = chargerVol(1);
			assertEquals("test vol1 - cible (3,3) : ko",true,vol.cibleAtteinte(new Coordonnees(3,3)));
			assertEquals("test vol1 - cible (1,2) : ko",false,vol.cibleAtteinte(new Coordonnees(1,2)));
			assertEquals("test vol1 - cible (1,1) : ko",true,vol.cibleAtteinte(new Coordonnees(1,1)));
			assertEquals("test vol1 - cible (4,6) : ko",true,vol.cibleAtteinte(new Coordonnees(4,6)));
			vol = chargerVol(2);
			assertEquals("test vol2 - cible (-2,1) : ko",true,vol.cibleAtteinte(new Coordonnees(-2,1)));

		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}

	private static void testNombreCiblesAtteintes() {
		try{
			vol = chargerVol(1);
			Coordonnees[] tableCoordonnees = new Coordonnees[3];
			tableCoordonnees[0]= new Coordonnees(4,6);
			tableCoordonnees[1]= new Coordonnees(4,4);
			tableCoordonnees[2]= new Coordonnees(9,9);
			assertEquals("test vol1 - cibles (4,6) (4,4) (9,9) : ko",2,vol.nombreCiblesAtteintes(tableCoordonnees));
		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}

	private static void testDistance() {
		try{
			vol = chargerVol(1);
			double attendu = 0.22;
			double recu = Math.round(vol.distance()*100)/100.0;
			assertEquals("vol1 ko",attendu,recu);
		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi !");
		System.out.println();

	}

	private static void testASurvoleUnMemeLieu() {
		try{
			vol = chargerVol(1);
			assertEquals("test vol1 ko",false,vol.aSurvoleUnMemeLieu());
			vol = chargerVol(2);
			assertEquals("test vol2 ko",true,vol.aSurvoleUnMemeLieu());
			vol = chargerVol(3);
			assertEquals("test vol3 ko",true,vol.aSurvoleUnMemeLieu());
		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi !");
		System.out.println();

	}

	private static void testParcoursSuivi() {
		try{
			vol = chargerVol(1);
			Coordonnees[] tableCoordonnees = new Coordonnees[3];
			tableCoordonnees[0]= new Coordonnees(2,2);
			tableCoordonnees[1]= new Coordonnees(4,6);
			tableCoordonnees[2]= new Coordonnees(5,5);
			assertEquals("test vol1 - parcours (2,2) (4,6) (5,5) : ko",false,vol.parcoursSuivi(tableCoordonnees));

			tableCoordonnees[0]= new Coordonnees(2,2);
			tableCoordonnees[1]= new Coordonnees(4,4);
			tableCoordonnees[2]= new Coordonnees(4,6);
			assertEquals("test vol1 - parcours (2,2) (4,4) (4,6) : ko",true,vol.parcoursSuivi(tableCoordonnees));

		}catch (Exception e){
			System.out.println("Exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}

	private static Vol chargerVol(int numVol) {
		Coordonnees[] tableCoordonnees;
		switch (numVol) {
		case 1:
			tableCoordonnees = new Coordonnees[6];
			tableCoordonnees[0]= new Coordonnees(1,1);
			tableCoordonnees[1]= new Coordonnees(2,2);
			tableCoordonnees[2]= new Coordonnees(3,3);
			tableCoordonnees[3]= new Coordonnees(4,4);
			tableCoordonnees[4]= new Coordonnees(5,5);
			tableCoordonnees[5]= new Coordonnees(4,6);	
			return new Vol(tableCoordonnees);
		case 2:
			tableCoordonnees = new Coordonnees[5];
			tableCoordonnees[0]= new Coordonnees(1,1);
			tableCoordonnees[1]= new Coordonnees(2,2);
			tableCoordonnees[2]= new Coordonnees(-1,2);
			tableCoordonnees[3]= new Coordonnees(-2,1);
			tableCoordonnees[4]= new Coordonnees(1,1);	
			return new Vol(tableCoordonnees);
		case 3:	
			tableCoordonnees = new Coordonnees[7];
			tableCoordonnees[0]= new Coordonnees(0,-1);
			tableCoordonnees[1]= new Coordonnees(0,0);
			tableCoordonnees[2]= new Coordonnees(0,1);
			tableCoordonnees[3]= new Coordonnees(-1,0);
			tableCoordonnees[4]= new Coordonnees(-1,1);
			tableCoordonnees[5]= new Coordonnees(0,1);
			tableCoordonnees[6]= new Coordonnees(1,1);
			return new Vol(tableCoordonnees);
		}
		return null;
	
	}
}
