
public class JeuDuPendu {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Entrez le mot a trouver : ");

		String motATrouver = scanner.next().toUpperCase();

		FenetrePendu fenetrePendu = new FenetrePendu();

		MotACompleter mot = new MotACompleter(motATrouver);

		LettresLues lettresLues = new LettresLues();

		fenetrePendu.afficherMot(mot.toString());
		int morceaux = 0;
		while (true){
			char lettre = Character.toUpperCase(fenetrePendu.lireLettre());
			lettresLues.ajouterLettreLue(lettre);
			fenetrePendu.afficherLettresLues(lettresLues.toString());
			if (mot.contientLettre(lettre)){
				mot.ajouterLettre(lettre);
				fenetrePendu.afficherMot(mot.motACompleter());
				fenetrePendu.afficherLettresLues(lettresLues.toString());
				if (mot.estComplet()){
					fenetrePendu.afficherInformation("GG");
					try {
						Thread.sleep(2000);
						System.exit(0);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					break;
				}
			}
			else {
				morceaux++;
				fenetrePendu.afficherPendu(morceaux);
				if (morceaux >= 6){
					fenetrePendu.afficherInformation("Dommage pour toi, t'es nul");
					break;
				}

			}
		}
	}

}
