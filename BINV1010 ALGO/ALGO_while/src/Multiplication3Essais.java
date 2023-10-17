
public class Multiplication3Essais {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tu as droit a 3 essais");
		int premierNombre = unEntierAuHasardEntre (0, 10);
		int secondNombre = unEntierAuHasardEntre (0, 10);
		System.out.print("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		int rep = scanner.nextInt();
		int essai = 0;
		while(rep != premierNombre * secondNombre && essai < 2) {
			System.out.print("Calculez : " + premierNombre + " x " + secondNombre + " = ");
			rep = scanner.nextInt();
			essai++;
		}
		if (rep != premierNombre * secondNombre) {
			System.out.println("Tu as raté");
			System.out.println("La bonne réponse était : " + premierNombre * secondNombre);
		}
		else System.out.println("BRAVO");

	}

	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		return (int) (Math.random() * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
	}
	
}
