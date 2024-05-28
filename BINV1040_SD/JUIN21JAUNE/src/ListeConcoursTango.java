import java.util.HashMap;

public class ListeConcoursTango {

	private Noeud tete; 
	private Noeud queue; 
	private HashMap<Danseur, Noeud> mapDanseurNoeud;

	public ListeConcoursTango() {
		mapDanseurNoeud = new HashMap<Danseur, Noeud>();
		tete=null;
		queue=null;
	}
	
	/**
	 * determine le nombre de danseurs 
	 * @return le nombre de danseurs
	 */
	public int taille () {
		return mapDanseurNoeud.size();
	}

	/**
	 * verifie si la liste ne contient aucun danseur
	 * @return true si la liste est vide, false sinon
	 */
	public boolean estVide () {
		return mapDanseurNoeud.isEmpty();
	}
	
	
	/**
	 * calcule le nombre de danseur appartenant a la nationalite passee en parametre
	 * @param nationalite la nationalite recherchee
	 * @return le nombre de danseur appartenant a la nationalite recherchee
	 */
	public int donnerNombreDanseursDeNationalite(String nationalite){
		//TODO
		// contrainte : cette methode doit etre iterative
		int count = 0;
		Noeud baladeur = tete;
		while(baladeur != null){
			if (baladeur.danseur.getNationalite().equals(nationalite)){
				count++;
			}
			baladeur = baladeur.suivant;
		}
		return count;
	}
	
	
	
	/**
	 * verifie si tous les danseurs ont au moins 3 annees d'experience
	 * @return true si tous les danseurs ont au moins 3 annees d'experience, false sinon
	 */
	public boolean ontTous3AnsMinimumDExperience(){
		//TODO
		//contrainte : cette methode doit etre recursive
		return ontTous3AnsMinimumDExperience(tete);
	}
	private boolean ontTous3AnsMinimumDExperience(Noeud n){
		if(n==null)
			return true;
		if(n.danseur.getExperience()<3)
			return false;
		return ontTous3AnsMinimumDExperience(n.suivant);
	}


	/**
	 * Donne le partenaire du danseur passé en paramètre.
	 * @param danseur le danseur dont on cherche le partenaire
	 * @return le partenaire ou null si le danseur n'est pas présent dans la liste
	 * @throws IllegalArgumentException si le paramètre est null
	 */
	public Danseur donnerPartenaire(Danseur danseur) {
		if (danseur == null) {
			throw new IllegalArgumentException("Le paramètre danseur ne peut pas être null");
		}

		if (mapDanseurNoeud.containsKey(danseur)) {
			Noeud noeud = mapDanseurNoeud.get(danseur);

			// Vérifie si le suivant existe et est du sexe opposé
			if (noeud.suivant != null && noeud.suivant.danseur.getSexe() != danseur.getSexe()) {
				return noeud.suivant.danseur;
			}

			// Vérifie si le précédent existe et est du sexe opposé
			if (noeud.precedent != null && noeud.precedent.danseur.getSexe() != danseur.getSexe()) {
				return noeud.precedent.danseur;
			}
		}

		return null; // Retourne null si aucun partenaire n'est trouvé
	}
		
	/**
	 * ajoute les 2 danseurs en fin de liste
	 * les 2 danseurs doivent etre de sexe oppose et ne peuvent pas encore etre presents dans la liste
	 * @param danseur1 un des danseurs du couple
	 * @param danseur2 l'autre danseur du couple
	 * @return true si l'ajout a pu se faire, false sinon
	 * @throws IllegalArgumentException si un des parametres est null
	 * 
	 */
	public boolean ajouterCouple (Danseur danseur1, Danseur danseur2) {
		if(danseur1==null||danseur2==null)
			throw new IllegalArgumentException();
		if(mapDanseurNoeud.containsKey(danseur1)||mapDanseurNoeud.containsKey(danseur2)){
			return false;
		}
		if(danseur1.getSexe()==danseur2.getSexe()){
			return false;
		}
		Noeud nouveauNoeud1 = new Noeud(danseur1);
		Noeud nouveauNoeud2 = new Noeud(danseur2);
		if (tete == null) {
			// La liste est vide, initialiser la tête et la queue
			tete = nouveauNoeud1;
			queue = nouveauNoeud2;
			nouveauNoeud1.suivant = nouveauNoeud2;
			nouveauNoeud2.precedent = nouveauNoeud1;
		} else {
			// Ajouter les nouveaux noeuds à la fin de la liste
			queue.suivant = nouveauNoeud1;
			nouveauNoeud1.precedent = queue;
			nouveauNoeud1.suivant = nouveauNoeud2;
			nouveauNoeud2.precedent = nouveauNoeud1;
			queue = nouveauNoeud2;
		}

		mapDanseurNoeud.put(danseur1, nouveauNoeud1);
		mapDanseurNoeud.put(danseur2, nouveauNoeud2);
		return true;
	}


	// pour les tests
	public ListeConcoursTango(Danseur[] tableACopier) {	
		mapDanseurNoeud = new HashMap<Danseur, Noeud>();
		if(tableACopier.length==0)
			return;
		tete = new Noeud(tableACopier[0]);
		mapDanseurNoeud.put(tableACopier[0], tete);
		Noeud prec = tete;
		for (int i = 1; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapDanseurNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		queue = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete;
			int cpt=0;
			while (baladeur != null) {
				if(cpt==0)
					aRenvoyer += baladeur.danseur.getNom();
				else
					aRenvoyer += ","+baladeur.danseur.getNom();
				baladeur = baladeur.suivant;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// pour les tests
	public String queueTete(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = queue;
			int cpt=0;
			while (baladeur != null) {
				if(cpt==0)
					aRenvoyer += baladeur.danseur.getNom();
				else
					aRenvoyer += ","+baladeur.danseur.getNom();
				baladeur = baladeur.precedent;
				cpt++;
				if(cpt==100){
					return "boucle infinie";
				}
			}
			return aRenvoyer+")";
		}catch (NullPointerException e){
			return "nullPointerException";
		}
	}

	// Classe interne Noeud
	private class Noeud{
		
		private Danseur danseur;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud(Danseur danseur) {
			this(null, danseur, null);
		}

		private Noeud(Noeud precedent, Danseur danseur, Noeud suivant) {
			this.danseur = danseur;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

}
