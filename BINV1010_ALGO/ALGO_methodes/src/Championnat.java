
/**
 * Championnat.java
 * @author Enes Yumer
 * 
 */
public class Championnat {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		int participantsEnFinale = 0;
		char choix;

		do {
			double resultat = resultatUnParticipant();
			System.out.println("Le résultat du concurrent est : " + resultat);

			if (estQualifie(resultat)) {
				participantsEnFinale++;
			}

			System.out.print("Encore un concurrent (O/N) ? ");
			choix = Utilitaires.lireCharPermis("on");

		} while (choix == 'o');

		System.out.println("Nombre de participants en finale : " + participantsEnFinale);
	}
	public static boolean estQualifie(double resultat) {
		return resultat >= 8;
	}

	/**
	 * lit les cotes, calcule et renvoie le resultat d'un concurrent.
	 * Chaque concurrent est cote pour la presentation de son exercice, sur 10 points, par 8 membres du jury.
     * On elimine de ces cotes la plus haute et la plus basse. Le resultat d un concurrent est egal a�la moyenne des 6 cotes restantes.
	 * @return le resultat du concurrent
	*/
	public static double resultatUnParticipant() {
		double sommeCotes = 0;
		double coteMin = Double.MAX_VALUE;
		double coteMax = 0;

		for (int i = 0; i < 8; i++) {
			System.out.print("Entrez la cote du jury n°" + (i + 1) + ": ");
			double cote = Utilitaires.lireReelComprisEntre(0, 10);

			sommeCotes += cote;

			if (cote < coteMin) {
				coteMin = cote;
			}
			if (cote > coteMax) {
				coteMax = cote;
			}
		}

		return (sommeCotes - coteMin - coteMax) / 6;
	}

}
