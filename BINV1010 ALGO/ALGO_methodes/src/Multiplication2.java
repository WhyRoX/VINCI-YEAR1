
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
		System.out.println("Entre la valeur minimale des nombres a multiplier ensuite la valeure maximale : ");
		int nombreDeBonnesReponses = 0;
		while(nombreDeBonnesReponses < 3){
			if (faireUneMultiplication()) {
				nombreDeBonnesReponses++;
			}
		}

	}
	public static boolean faireUneMultiplication(){
		int min = 0;
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
