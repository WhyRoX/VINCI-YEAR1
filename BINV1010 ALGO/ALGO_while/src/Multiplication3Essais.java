
public class Multiplication3Essais {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tu as droit a 3 essais");
		int premierNombre = unEntierAuHasardEntre (0, 10);
		int secondNombre = unEntierAuHasardEntre (0, 10);
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int rep = scanner.nextInt();
		int essai = 0;
		while(rep != premierNombre * secondNombre && essai < 2) {
			System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			rep = scanner.nextInt();
			essai++;
		}
		System.out.println("BRAVO");
	}

	// A NE PAS MODIFIER
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
	}
	
}
