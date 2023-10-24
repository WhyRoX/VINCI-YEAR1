
public class Multiplication3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("Au depart la valeur minimale des nombres a multiplier est 1 et la valeur maximale est 10");
		System.out.println("Ces 2 bornes augmenteront de 10 a chaque multiplication reussie");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		// A NE PAS COMPLETER
		faireMultiplications();
	}

	public static void faireMultiplications() {
		int valeurMinimale = 1;
		int valeurMaximale = 10;
		for (int i = 0; i < 5; i++) {
			int nombre1 = unEntierAuHasardEntre(valeurMinimale, valeurMaximale);
			int nombre2 = unEntierAuHasardEntre(valeurMinimale, valeurMaximale);
			int reponseAttendue = nombre1 * nombre2;

			System.out.println("Combien font " + nombre1 + " * " + nombre2 + " ?");
			int reponseUtilisateur = scanner.nextInt();

			if (reponseUtilisateur == reponseAttendue) {
				System.out.println("Bonne réponse !");
			} else {
				System.out.println("Mauvaise réponse. La réponse correcte est : " + reponseAttendue);
			}

			valeurMinimale += 10;
			valeurMaximale += 10;
		}
	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
}
