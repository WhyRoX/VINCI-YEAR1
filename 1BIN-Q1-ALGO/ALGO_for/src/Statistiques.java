
public class Statistiques {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez le nombre de cotes : ");
		int nombreCotes = scanner.nextInt();
		double coteMax = -1;
		double coteMin = Double.MAX_VALUE;
		double sommeCotes = 0;
		for (int i = 1; i <= nombreCotes ; i++) {
			System.out.print("Entrez la cote n°" + i + ": ");
			double cote = scanner.nextDouble();
			sommeCotes += cote;
			if(cote>coteMax){
				coteMax = cote;
			}
			if (cote < coteMin){
				coteMin = cote;
			}
		}
		double moyenneCotes = sommeCotes / nombreCotes;

		System.out.println("La cote la plus élevée est " + coteMax);
		System.out.println("La cote minimale est " + coteMin);
		System.out.println("La moyenne des cotes est " + moyenneCotes);
	}
}
