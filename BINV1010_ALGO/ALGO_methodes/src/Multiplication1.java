public class Multiplication1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("La valeur minimale des nombres a multiplier est 0, la valeur maximale est 10");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		System.out.println("A la fin, le programme affichera le nombre de bonnes reponses.");
		// A NE PAS COMPLETER
		faireUneMultiplication();
	}

	/**
	 * Cette méthode génère et gère un exercice de multiplication.
	 * Elle choisit deux nombres au hasard entre une valeur minimale et une valeur maximale,
	 * demande à l'utilisateur de multiplier ces deux nombres,
	 * et vérifie si la réponse de l'utilisateur est correcte.
	 *
     */
	public static void faireUneMultiplication() {
		int min = 0;
		int max = 10;
		int nombreDeBonnesReponses = 0;
		for (int i = 0; i < 5; i++) {
			int nombre1 = unEntierAuHasardEntre(min, max);
			int nombre2 = unEntierAuHasardEntre(min, max);
			System.out.println("Combien font " + nombre1 + " * " + nombre2 + " ?");
			int reponse = scanner.nextInt();
			if (reponse == nombre1 * nombre2) {
				System.out.println("Bonne réponse !");
				nombreDeBonnesReponses++;
			} else {
				System.out.println("Faux, la bonne réponse était " + (nombre1 * nombre2));
			}
		}
		System.out.println("Vous avez obtenu " + nombreDeBonnesReponses + " bonnes réponses.");
	}





	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}