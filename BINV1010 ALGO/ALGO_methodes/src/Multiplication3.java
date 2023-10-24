
public class Multiplication3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("Au depart la valeur minimale des nombres a multiplier est 1 et la valeur maximale est 10");
		System.out.println("Ces 2 bornes augmenteront de 10 a chaque multiplication reussie");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		// A NE PAS COMPLETER
	}
	public static boolean faireUneMultiplication(){
		int min = 1;
		int max = 10;
		int nombre1 = unEntierAuHasardEntre(min, max);
		int nombre2 = unEntierAuHasardEntre(min, max);
		System.out.println("Combien font " + nombre1 + " * " + nombre2 + " ?");
		int reponse = scanner.nextInt();
		if (reponse == nombre1 * nombre2) {
			return true;
		} else {
			System.out.println("La bonne réponse était " + (nombre1 * nombre2));
			return false;
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
