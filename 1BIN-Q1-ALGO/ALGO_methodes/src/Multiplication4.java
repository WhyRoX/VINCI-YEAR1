
public class Multiplication4 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications de nombres compris entre 0 et 10");
		System.out.println("Tu peux choisir le nombre d'essais que tu auras pour chaque multiplication");
		System.out.println("Ce nombre sera le meme pour toutes les multiplications");
		System.out.println("Tu recevras la réponse, si tu ne l'as toujours pas trouvée au terme du nombre d'essais accorde");
		System.out.println("Apres chaque multiplication, le programme te demandera si tu en veux une autre");
	
		//A NE PAS COMPLETER
		System.out.println("Entre le nombre d'essais que tu veux avoir pour chaque multiplication : ");
		int nombreDEssais = scanner.nextInt();
		faireMultiplications(nombreDEssais);


	}

	/**
	 * Cette méthode demande à l'utilisateur de faire des multiplications
	 * @param nombreDEssais max que l'utilisateur a pour chaque multiplication
	 * @return 1 pour finir le code, à modifier si besoin plus tard
	 */
	@SuppressWarnings("all")
	public static int faireMultiplications(int nombreDEssais) {
		int min = 0;
		int max = 10;
		boolean continuer = true;
		while (continuer) {
			int nombre1 = unEntierAuHasardEntre(min, max);
			int nombre2 = unEntierAuHasardEntre(min, max);
			int reponseAttendue = nombre1 * nombre2;
			boolean reponseCorrecte = false;
			int nombreDEssaisRestants = nombreDEssais;
			while (!reponseCorrecte && nombreDEssaisRestants > 0) {
				System.out.println("Combien font " + nombre1 + " * " + nombre2 + " ?");
				int reponse = scanner.nextInt();
				if (reponse == reponseAttendue) {
					System.out.println("Bonne réponse !");
					reponseCorrecte = true;
				} else {
					System.out.println("Mauvaise réponse");
					nombreDEssaisRestants--;
				}
			}
			if (!reponseCorrecte) {
				System.out.println("La bonne réponse était " + reponseAttendue);

			}
			System.out.println("Voulez-vous faire une autre multiplication ? (o/n) : ");
			char choix = Utilitaires.lireCharPermis("on");

			if (choix == 'n') {
				continuer = false;
			}
		}
		return 1;
	}
	public static int unEntierAuHasardEntre (int min, int max){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (max - min + 1)) + min;
		return resultat;
	}
}
