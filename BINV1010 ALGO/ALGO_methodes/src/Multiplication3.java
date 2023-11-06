
public class Multiplication3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("Au depart la valeur minimale des nombres a multiplier est 1 et la valeur maximale est 10");
		System.out.println("Ces 2 bornes augmenteront de 10 a chaque multiplication réussie");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la réponse, si tu la rate");
		// A NE PAS COMPLETER
		int bonneRep = faireMultiplications();
		System.out.println("Félicitations, tu as réussi " + bonneRep + " multiplication(s) du premier coup !");

	}

	/**
	 * Methode qui demande à l'utilisateur de faire 5 multiplications
	 * @return le nombre de bonnes réponses afin de pouvoir afficher le message de fin.
	 */
	public static int faireMultiplications() {
		int bonneRep = 0;
		int valeurMinimale = 1;
		int valeurMaximale = 10;
		for (int i = 0; i < 5; i++) {
			int nombre1 = unEntierAuHasardEntre(valeurMinimale, valeurMaximale);
			int nombre2 = unEntierAuHasardEntre(valeurMinimale, valeurMaximale);
			int reponseAttendue = nombre1 * nombre2;

			System.out.println("Combien font " + nombre1 + " * " + nombre2 + " ?");
			int reponseUtilisateur = scanner.nextInt();

			if (reponseUtilisateur == reponseAttendue) {
				bonneRep++;
				System.out.println("Bonne réponse !");
			} else {
				System.out.println("Mauvaise réponse. La réponse correcte est : " + reponseAttendue);
			}

			valeurMinimale += 10;
			valeurMaximale += 10;
		}
		return bonneRep;
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
