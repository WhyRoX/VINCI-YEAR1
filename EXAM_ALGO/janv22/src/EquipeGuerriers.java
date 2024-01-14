import java.util.Arrays;
import java.util.NoSuchElementException;

public class  EquipeGuerriers {

	private Guerrier[] tableGuerriers;
	private int nombreGuerriersEnVie;

	/**
	 * construit l'equipe 
	 * @param nombreGuerriers nombre de guerriers en vie au debut du jeu
	 * @param pointsDeVieDeDepart nombre de points de vie attribue a chaque guerrier au debut du jeu
	 * @throws IllegalArgumentException il faut au moins 1 guerrier vivant pour combattre la creature du mal
	 */
	public EquipeGuerriers(int nombreGuerriers, int pointsDeVieDeDepart){
		if(nombreGuerriers<=0||pointsDeVieDeDepart<=0) 
			throw new IllegalArgumentException("jeu impossible!");
		int numero = nombreGuerriers;
		tableGuerriers = new Guerrier[nombreGuerriers];
		nombreGuerriersEnVie = nombreGuerriers;
		for (int i = 0; i < nombreGuerriers; i++) {
			tableGuerriers[i] = new Guerrier(numero, pointsDeVieDeDepart);
			numero--;
		}
	}

	// Attention : seul interet de ce constructeur : les tests!!!
	// A NE PAS MODIFIER
	public EquipeGuerriers(Guerrier[] tableARecopier, int nombreGuerriersEnVie) {
		tableGuerriers = new Guerrier[tableARecopier.length];
		for (int i = 0; i < tableGuerriers.length; i++) {
			tableGuerriers[i]=tableARecopier[i];
		}
		this.nombreGuerriersEnVie = nombreGuerriersEnVie;
	}

	/**
	 * renvoie le nombre de guerriers encore en vie
	 * @return le nombre de guerriers encore en vie
	 */
	public int nombreGuerriersEnVie(){
		return nombreGuerriersEnVie;
	}


	/**
	 * renvoie le numero du guerrier qui doit combattre
	 * @return le numero du guerrier qui doit combattre
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 */
	public int donnerNumeroProchainGuerrier() {
		if (nombreGuerriersEnVie == 0){
			throw new NoSuchElementException();
		}
		return tableGuerriers[nombreGuerriersEnVie-1].getNumero();
	}


	/**
	 * diminue le nombre de points de vie du guerrier qui doit combattre
	 * reorganise la table en tenant compte de ces nouveaux points de vie
	 * @param pointsDeViePerdus le nombre de points de vie perdu par le guerrier au combat
	 * @return les nouveaux points de vie du guerrier
	 * @throws NoSuchElementException si tous les guerriers sont morts
	 * @throws IllegalArgumentException si le nombre de points de vie perdus est negatif
	 */
	public int recevoirDegats(int pointsDeViePerdus){
		if (nombreGuerriersEnVie == 0) {
			throw new NoSuchElementException();
		}
		if (pointsDeViePerdus < 0) {
			throw new IllegalArgumentException();
		}
		Guerrier guerrier = tableGuerriers[nombreGuerriersEnVie-1];
		guerrier.retirerPointsDeVie(pointsDeViePerdus);
		if (guerrier.getPointsDeVie() == 0){
			nombreGuerriersEnVie--;
			return 0;
		}
		Guerrier temp;
		int index = nombreGuerriersEnVie-1;
		for (int i = nombreGuerriersEnVie -1; i > 0 ; i--) {
			if (guerrier.getPointsDeVie() <= tableGuerriers[i-1].getPointsDeVie()){
				temp = tableGuerriers[i-1];
				tableGuerriers[i-1]=tableGuerriers[i];
				tableGuerriers[i]= temp;
				index--;
			}
			else break;
		}
		return tableGuerriers[index].getPointsDeVie();
	}

	/**
	 * construit une table avec les guerriers en vie
	 * La taille logique de cette table doit etre egale a la taille physique
	 * @return la table avec les guerriers en vie
	 */
	public Guerrier[] tableGuerriersEnVie(){
		Guerrier[] tableGuerriersEnVie = new Guerrier[nombreGuerriersEnVie];
		for (int i = 0; i < nombreGuerriersEnVie; i++) {
			tableGuerriersEnVie[i] = tableGuerriers[i];
		}
		return tableGuerriersEnVie;
	}

	/**
	 * construit une table avec les guerriers morts
	 * La taille logique de cette table doit etre egale a la taille physique
	 * @return la table avec les guerriers morts
	 */
	public Guerrier[] tableGuerriersMorts(){
		Guerrier[] tableGuerriersMorts = new Guerrier[tableGuerriers.length-nombreGuerriersEnVie];
		int index = 0;
		for (int i = nombreGuerriersEnVie; i < tableGuerriers.length; i++) {
			tableGuerriersMorts[index]= tableGuerriers[i];
			index++;
		}
		return tableGuerriersMorts;
	}

	/**
	 * A NE PAS MODIFIER
	 * VA SERVIR POUR LES TESTS
	 * @return le contenu de la table des guerriers
	 */
	public String toString(){
		return Arrays.toString(tableGuerriers);
	}

}
