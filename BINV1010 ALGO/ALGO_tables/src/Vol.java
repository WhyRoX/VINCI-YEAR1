/* 
 *  
 *  Classe permettant de memoriser et de traiter les coordonnees d'un vol
 *  
 *   
 * @author ... <----- !!!!!!! renseignez votre nom ici !!!!!
 * 
 *  
 */


public class Vol {

	private String nom; // nom du parapentiste
	private Coordonnees[] tableCoordonnees;

	// A NE PAS MODIFIER
	/**
	 * constructeur par recopie, le nom du parapentiste est Tommy
	 * @param tableCoordonnees la table de coordonnees a recopier
	 * @throws IllegalArgumentException si la table de coordonnees est null ou vide
	 */
	public Vol(Coordonnees[] tableCoordonnees) throws IllegalArgumentException{
		if(tableCoordonnees==null)
			throw new IllegalArgumentException();
		if(tableCoordonnees.length==0)
			throw new IllegalArgumentException();
		this.tableCoordonnees = new Coordonnees[tableCoordonnees.length];
		for (int i = 0; i < tableCoordonnees.length; i++) {
			this.tableCoordonnees[i]=tableCoordonnees[i];
		}
		this.nom = "tommy";
	}

	// A NE PAS MODIFIER
	/**
	 * constructeur par recopie
	 * @param nom le nom du parapentiste
	 * @param tableCoordonnees
	 * @throws IllegalArgumentException en cas de parametre invalide
	 */
	public Vol(String nom, Coordonnees[] tableCoordonnees) throws IllegalArgumentException{
		this(tableCoordonnees);
		if(nom==null)
			throw new IllegalArgumentException();
		if(nom.length()==0)
			throw new IllegalArgumentException();
		this.nom = nom;
	}


	// choix 1
	/**
	 * renvoie le lieu d'arrivee
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return les coordonnees du lieu d'arrivee
	 */
	public Coordonnees lieuArrivee(){
		
		//TODO
		
		return null;
	}


	// choix 2
	/**
	 * verifie si le lieu de depart correspond au lieu d'arrivee
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return true si les coordonnees du lieu de depart sont identiques a celles du lieu d'arrivee, false sinon
	 */
	public boolean estUnTour(){
		
		// pensez a utiliser la methode equals() de la classe Coordonnee
		
		//TODO
		
		return false;
	}


	// choix 3
	/**
	 * renvoie le lieu survole apres n unites de temps
	 * (n = 0 --> lieu de depart)
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @param n le nombre d'unites de temps
	 * @return les coordonnees demandees ou null si un tel lieu n'existe pas car le vol n'est pas assez long
	 */
	public Coordonnees niemeLieu(int n){	
		
		// !!!!!!Pas de boucle for!!!!!! REFLECHISSEZ !

		//TODO
		
		return null;

	}
	

	// choix 4
	/**
	 * renvoie le lieu survole le plus au sud du parcours
	 * En cas d'ex-aequo, ce sera le premier lieu qui sera renvoye
	 * Le lieu le plus au sud est le lieu qui a la plus petite latitude
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return les coordonnees du lieu le plus au sud
	 */
	public Coordonnees lieuLePlusAuSud() {

		//TODO
		
		return null;
	}


	// choix 5
	/**
	 * renvoie le lieu survole le plus eloigne (a vol d'oiseau) du lieu de depart
	 * En cas d'ex-aequo, ce sera le premier lieu qui sera renvoye
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return les coordonnees du lieu le plus eloigne du lieu de depart
	 */
	public Coordonnees lieuLePlusEloigne(){
		
		// pensez a utiliser la methode distance() de la classe Coordonnee
		// la distance est un reel (double)
		
		//TODO
		
		return null;
	}
	
	
	// choix 6
	/**
	 * verifie si la cible a ete atteinte
	 * @param cible les coordonnees de la cible a atteindre
	 * @return true si on trouve au moins une fois des coordonnees d'un lieu survole identiques aux coordonnees de la cible, false sinon
	 * @throws IllegalArgumentException si la cible est null
	 */
	public boolean cibleAtteinte(Coordonnees cible){
		
		if(cible==null)
			throw new IllegalArgumentException("la cible est null");
		
		// pensez a utiliser la methode equals() de la classe Coordonnee
		
		//TODO
		
		return false;
	}


	// choix 7
	/**
	 * calcule le nombre de cibles atteintes
	 * L'ordre dans lequel les cibles sont atteintes n'a aucune importance
	 * Si une cible est atteinte plus d'une fois, elle n'est comptabilisee qu'une fois
	 * precondition (a ne pas verifier) la table des cibles ne contient pas de doublons
	 * @param cibles la table avec les coordonnees des cibles a atteindre
	 * @return le nombre demande
	 * @throws IllegalArgumentException si la table de cibles est null
	 */
	public int nombreCiblesAtteintes(Coordonnees[] cibles){

		if(cibles==null)
			throw new IllegalArgumentException();

		// pensez a utiliser la methode cibleAtteinte()

		//TODO

		return 0;
	}


	// choix 8
	/**
	 * calcule la distance parcourue. 
	 * Cette distance sera obtenue en additionnant les distances des segments du parcours memorise.
	 * @return distance parcourue.
	 */
	public double distance() {
		
		// pensez a utiliser la methode distance() de la classe Coordonnee
		// la distance est un reel (double)
	
		//TODO
		
		return 0;
	}


	


	// choix 9
	/**
	 * renvoie un booleen signalant si un meme lieu a ete survole plusieurs fois 
	 * Si le lieu d'arrivee correspond au lieu de depart, on considere que ce lieu a ete survole plusieurs fois
	 * @return true si un meme lieu a ete survole plusieurs fois, false sinon
	 */
	public boolean aSurvoleUnMemeLieu() {
		// Cette methode est proposee en DEFI!
		// pensez a utiliser la methode equals() de la classe Coordonnee
		
		//TODO
		// Ex defi !!!
		
		return false;
	}
	
	
	// choix 10
	/**
	 * verifie si toutes les cibles sont dans le parcours et dans le même ordre.
	 * @param cibles la table des cibles faisant partie du parcours
	 * @return true si le parcours a bien ete suivi, false sinon
	 * @throws IllegalArgumentException si la table de cibles est null
	 */
	public boolean parcoursSuivi(Coordonnees[] cibles){
		// Cette methode est proposee en DEFI!
		if(cibles==null)
			throw new IllegalArgumentException();
		
		// pensez a utiliser la methode equals() de la classe Coordonnee
	
		//TODO
		// Ex Defi !!!
		
		return false;
	}


	
	// DEFI (amelioration choix 9)
	/**
	 * verifie si le parapentiste a croise son propre
	 * parcours. Si le lieu d'arrivee correspond au lieu de depart, celui-ci ne
	 * sera pas considere comme un croisement. Vous utiliserez la methode
	 * segmentsCroises de la classe de Coordonnees .
	 * @return true s'il a croise au moins une fois son parcours, false sinon
	 */
	public boolean aCroiseSonParcours() {
		
		// Cette methode est proposee en DEFI!
		// cfr enonce
	
		return false;
	}
	
} 
