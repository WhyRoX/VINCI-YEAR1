
public class Multiplication2 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications.");
		System.out.println("La valeur minimale des 2 nombres a multiplier est 0.");
		System.out.println("Tu peux choisir la valeur maximale de ces 2 nombres.");
		System.out.println("Cette valeur sera la meme pour tous les exercices");
		System.out.println("Pour chaque multiplication, tant que tu n'auras pas donne la bonne reponse, tu devras la recommencer");
		System.out.println("Le programme termine lorsque tu auras reussi 3 multiplications du premier coup");
	
		// A NE PAS COMPLETER
		int min = 0;
		int max = askMaxValue();
		int nombreDeBonnesReponses = faireMultiplications(min, max);

		System.out.println("Félicitations, tu as réussi " + nombreDeBonnesReponses + " multiplications du premier coup !");
	}

	/**
	 * Cette méthode demande à l'utilisateur de choisir la valeur maximale des nombres à multiplier
	 * @return la valeur maximale des nombres à multiplier qui sera utilisé pour la
	 * suite du programme, faireUneMultiplication
	 */
	public static int askMaxValue() {
		System.out.println("Entre la valeur maximale des nombres à multiplier: ");
		return scanner.nextInt();
	}

	/**
	 * Cette méthode demande à l'utilisateur de faire des multiplications
	 * @param min valeur minimale des nombres à multiplier qui sera de 0 ici. (possibilité de modifier plus tard)
	 * @param max valeur max qui est donné par la méthode askMaxValue
	 * @return le nombre de bonnes réponses afin de pouvoir afficher le message de fin voir ligne 20.
	 */
	public static int faireMultiplications(int min, int max) {

		int nombreDeBonnesReponses = 0;

		while (nombreDeBonnesReponses < 3) {
			int nombre1 = unEntierAuHasardEntre(min, max);
			int nombre2 = unEntierAuHasardEntre(min, max);
			boolean reponseCorrecte = false;

			while (!reponseCorrecte) {
				System.out.println("Combien font " + nombre1 + " * " + nombre2 + " ?");
				int reponse = scanner.nextInt();
				if (reponse == nombre1 * nombre2) {
					System.out.println("Bonne réponse !");
					reponseCorrecte = true;
					nombreDeBonnesReponses++;
				} else {
					System.out.println("Mauvaise réponse");
				}
			}
		}

		return nombreDeBonnesReponses;
	}



	public static int unEntierAuHasardEntre (int min, int max){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (max - min + 1)) + min;
		return resultat;
	}
}
