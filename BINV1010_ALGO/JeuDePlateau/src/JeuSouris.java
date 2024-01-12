public class JeuSouris {

	public static void main(String[] args){

		int positionSouris = 1;
		int positionFromage = 10;
		PlateauJeuSouris jeu = new PlateauJeuSouris();
		jeu.afficherInformation("Vas-y !");
		jeu.placerSouris(positionSouris);
		jeu.placerFromage(10);


		/*while (positionSouris < 16) {
			int lanceDe = jeu.lancerDe();
			jeu.supprimerSouris();
			jeu.placerSouris(positionSouris += lanceDe);
			if (positionSouris >= 10){
				jeu.supprimerFromage();
			}
			if (positionSouris > 16){
				positionSouris = 16;
				jeu.afficherInformation("Bien joué t'es arrivé à la maison");
			}
		}*/
		while (positionSouris < 16) {
			positionSouris += jeu.lancerDe();
			if (positionSouris > 16){
				positionSouris = 16;
			}
			if (positionSouris >= positionFromage){
				jeu.supprimerFromage();
			}
			jeu.supprimerSouris();
			jeu.placerSouris(positionSouris);
		}
		jeu.afficherInformation("Bravo !");
	}
}
