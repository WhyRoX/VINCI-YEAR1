import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class GestionFancyFair {
	
	private static Scanner scanner = new Scanner(System.in);
	//private static MonScanner scanner = new MonScanner("inputFF.txt");

	private static FancyFair fancyFair;

	public static void main(String[] args) {	
		
		System.out.println("*****************************************************");
		System.out.println("Gestion des reservations d'un spectacle de fancy fair");
		System.out.println("*****************************************************");
	    System.out.println();
		System.out.println("Configuration du spectacle");
		System.out.println("--------------------------");
		System.out.print("Entrez le nombre total de places : ");
		int nombreTotalPlaces = scanner.nextInt();
		System.out.print("Entrez le nombre d'enfants : ");
		int nombreEnfants = scanner.nextInt();
		scanner.nextLine();
		String[] tablePrenoms = new String[nombreEnfants];
		for (int i = 0; i < tablePrenoms.length; i++) {
			System.out.print("Entrez le prenom de l'enfant " + (i + 1) + " : ");
			String prenom  = scanner.nextLine();
			tablePrenoms[i] = prenom;
		}
		try {
			fancyFair = new FancyFair(nombreTotalPlaces, tablePrenoms);
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
			System.out.println("la configuration s'est mal passee ");
			System.out.println("nombre de places ou table des prenoms invalide");
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
		HashSet<Integer> ensemblePlaces = new HashSet<>();
		for (int i = 0; i < nombrePlaces; i++) {
			System.out.print("Entrez un numero de place : ");
			int numero = scanner.nextInt();
			ensemblePlaces.add(numero);
		}
		scanner.nextLine();
		try {
			if (fancyFair.reserver(prenom, ensemblePlaces)) {
				System.out.println("La reservation a reussi!");
			} else {
				System.out.println("La reservation a echoue!");
			}
		}catch(Exception e){
			System.out.println("prenom ou numero de place invalide !");
		}
	}


	private static void afficherTout() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.println(fancyFair);		
	}

	private static void afficherEnfant() {
		// vous pouvez modifier cette methode comme vous voulez
		// cette classe ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		System.out.print("Entrez le prenom : ");
		String prenom = scanner.nextLine();
		try {
			int[] tableReservation = fancyFair.placesReservees(prenom);
			if(tableReservation==null){
				System.out.println("null");
			}else{
				System.out.println(Arrays.toString(tableReservation));
			}
		}catch(Exception e){;
			System.out.println("prenom invalide !");
		}
	}


}


