
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
		int valeurMinimale = 0;
		int valeurMaximale = demanderValeurMaximale();
		int nombreDeBonnesReponses = faireMultiplications(valeurMinimale, valeurMaximale);

		System.out.println("Félicitations, tu as réussi " + nombreDeBonnesReponses + " multiplications du premier coup !");
	}

	public static int demanderValeurMaximale() {
		System.out.println("Entre la valeur maximale des nombres à multiplier : ");
		return scanner.nextInt();
	}
	public static int faireMultiplications(int valeurMinimale, int valeurMaximale) {
		int nombreDeBonnesReponses = 0;

		while (nombreDeBonnesReponses < 3) {
			int nombre1 = unEntierAuHasardEntre(valeurMinimale, valeurMaximale);
			int nombre2 = unEntierAuHasardEntre(valeurMinimale, valeurMaximale);
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



	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
