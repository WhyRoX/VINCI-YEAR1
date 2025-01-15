import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class GestionGuignol {
	
	//private static Scanner scanner = new Scanner(System.in);
	private static MonScanner scanner = new MonScanner("C:/Users/mysti/Desktop/VINCI/inputGuignol.txt");

	private static Guignol guignol;

	public static void main(String[] args) {	
		
		System.out.println("**************************************************");
		System.out.println("Gestion des reservations d'un spectacle de guignol");
		System.out.println("**************************************************");
	    System.out.println();
		System.out.print("Entrez le nombre total de places : ");
		int nombreTotalPlaces = scanner.nextInt();
		scanner.nextLine();

		try {
			guignol = new Guignol(nombreTotalPlaces);
			System.out.println();
			int choix = 0;
			System.out.println("Reservations");
			System.out.println("------------");
			do {
				System.out.println();
				System.out.println();
				System.out.println("1 -> reserver des places");
				System.out.println("2 -> afficher toutes les reservations");
				System.out.println("3 -> afficher les reservations d'un enfant");
				System.out.println("4 -> quitter le menu");
				System.out.println();
				System.out.print("Votre choix : ");
				choix = scanner.nextInt();
				scanner.nextLine();
				switch (choix) {
					case 1:
						reserver();
						break;
					case 2:
						afficherTout();
						break;
					case 3:
						afficherEnfant();
						break;
				}
			} while (choix >= 1 && choix <= 3);
			System.out.println("Fin des rervations!");
		}catch(IllegalArgumentException e){
			System.out.println("la configuration du spectacle s'est mal passee ");
			System.out.println("nombre de places invalide");
		}
	}

	private static void reserver() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le prenom : ");
		String prenom = scanner.nextLine();
		System.out.print("Entrez le nombre de places : ");
		int nombrePlaces = scanner.nextInt();
		int[] tablePlacesDemandees = new int[nombrePlaces];
		for (int i = 0; i < nombrePlaces; i++) {
			System.out.print("Entrez un numero de place : ");
			int numero = scanner.nextInt();
			tablePlacesDemandees[i]=numero;
		}
		scanner.nextLine();
		try {
			if (guignol.reserver(prenom, tablePlacesDemandees)) {
				System.out.println("La reservation a reussi!");
			} else {
				System.out.println("La reservation a echoue!");
			}
		}catch(IllegalArgumentException e){
			System.out.println("prenom ou table des places demandees invalide !");
		}catch(Exception e) {
			System.out.println("exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
	}


	private static void afficherTout() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.println(guignol);
	}

	private static void afficherEnfant() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le prenom : ");
		String prenom = scanner.nextLine();
		try {
			int[] tableReservation = guignol.placesReservees(prenom);
			if(tableReservation==null){
				System.out.println("null");
			}else{
				System.out.println(Arrays.toString(tableReservation));
			}
		}catch(IllegalArgumentException e){;
			System.out.println("prenom invalide !");
		}catch(Exception e) {
			System.out.println("exception inattendue");
			e.printStackTrace();
			System.exit(0);
		}
	}
}


