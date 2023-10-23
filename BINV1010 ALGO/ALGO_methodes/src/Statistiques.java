
public class Statistiques {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Ce programme affiche la cote la plus elevee parmi les cotes que vous allez encoder.");
		System.out.println("Les cotes sont evaluees sur 20.");
		System.out.println("Il faut au moins une cote.");
		System.out.print("Entrez le nombre de cotes : ");
		int nombreCotes = scanner.nextInt();
		double coteMax = -1; // le plus petit reel
		for (int i = 1; i <= nombreCotes ; i++) {
			System.out.print("Entrez la cote n°" + i + ": ");
			double cote = scanner.nextDouble();
			if(cote>coteMax){
				coteMax = cote;
			}
		}
		System.out.println("La cote la plus elevee est "+ coteMax);
	}
}
