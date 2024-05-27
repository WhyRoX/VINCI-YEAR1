import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListeSDImpl<E> implements ListeSD<E>,Iterable<E> {

	private Noeud tete, queue;
	private HashMap<E, Noeud> mapElementNoeud;

	public ListeSDImpl () {
		mapElementNoeud = new HashMap<>();
		tete = new Noeud();
		queue = new Noeud();
		tete.suivant = queue;
		queue.precedent = tete;

	}

	public int taille () {
		return mapElementNoeud.size();
	}

	public boolean estVide () {
		return mapElementNoeud.isEmpty();
	
	}

	public boolean contient (E element) {
		return mapElementNoeud.containsKey(element);
	}

	public E premier() {
		return tete.suivant.element;

	}

	public E dernier() {
		return queue.precedent.element;

	}

	public E donnerPrecedent (E element) {
		if (!mapElementNoeud.containsKey(element) || mapElementNoeud.get(element).precedent == tete)
			return null;
		return mapElementNoeud.get(element).precedent.element;
	}
	public E donnerPrecedentV2 (E element) {
		if(mapElementNoeud.containsKey(element)){
			Noeud noeud = mapElementNoeud.get(element);
			if(noeud.precedent != tete){
				return noeud.precedent.element;
			}
		}
		return null;
	}

	public E donnerSuivant (E element) {
		if (!mapElementNoeud.containsKey(element) || mapElementNoeud.get(element).suivant == queue)
			return null;
		return mapElementNoeud.get(element).suivant.element;

	}
	public E donnerSuivantV2 (E element) {
		if(mapElementNoeud.containsKey(element)){
			Noeud noeud = mapElementNoeud.get(element);
			if(noeud.suivant != queue){
				return noeud.suivant.element;
			}
		}
		return null;
	}
	public Noeud insertBrain (Noeud precedent, E element, Noeud suivant){
		if (mapElementNoeud.containsKey(element))
			return null;

		Noeud nouveauNoeud = new Noeud(precedent, element, suivant);
		precedent.suivant = nouveauNoeud;
		suivant.precedent = nouveauNoeud;
		nouveauNoeud.suivant.precedent = nouveauNoeud;
		mapElementNoeud.put(element, nouveauNoeud);
		return nouveauNoeud;
	}
	// insertBrain est une methode qui permet d'ajouter un element dans la liste
	// elle prend en parametre le noeud precedent, l'element a ajouter et le noeud suivant
	// elle renvoie le nouveau noeud cree
	// si l'element est deja present dans la liste, elle renvoie null
	// elle met a jour le chainage des noeuds
	public Noeud insertBrain (E element, Noeud pos) {
		return insertBrain(pos.precedent, element, pos);
	}

	public boolean insererEnTete (E element){
		return insertBrain(tete, element, tete.suivant) != null;

	}

	public boolean insererEnQueue (E element) {

		return insertBrain(queue.precedent, element, queue) != null;

	}


	public boolean insererApres(E element, E elementAInserer) {
		if (mapElementNoeud.containsKey(elementAInserer)) return false;
		Noeud nouveauNoeud = new Noeud(elementAInserer);

		Noeud noeudAvant = mapElementNoeud.get(element);
		if (noeudAvant == null) return false;
		Noeud noeudApres = noeudAvant.suivant;

		nouveauNoeud.precedent = noeudAvant;
		nouveauNoeud.suivant = noeudApres;
		noeudAvant.suivant = nouveauNoeud;
		noeudApres.precedent = nouveauNoeud;

		mapElementNoeud.put(elementAInserer, nouveauNoeud);
		return true;
	}

	public boolean insererApres2 (E element, E elementAInserer) {
		if (mapElementNoeud.containsKey(element)){
			Noeud noeud = mapElementNoeud.get(element);
			Noeud noeud2 = insertBrain(noeud, elementAInserer, noeud.suivant);
            return noeud2 != null;
        }
		return false;
	}

	public boolean insererAvant (E element, E elementAInserer) {
		if (mapElementNoeud.containsKey(element)){
			Noeud noeud = mapElementNoeud.get(element);
			Noeud noeud2 = insertBrain(noeud.precedent, elementAInserer, noeud);
			return noeud2 != null;
		}
		return false;
	}


	public boolean supprimer (E element) {
		if (mapElementNoeud.containsKey(element)){

			Noeud noeud = mapElementNoeud.get(element);
			noeud.precedent.suivant = noeud.suivant;
			noeud.suivant.precedent = noeud.precedent;
			mapElementNoeud.remove(element);
			return true;
		}
		return false;
	}

	
	public boolean permuter (E element1, E element2) {

		if (!mapElementNoeud.containsKey(element1) || !mapElementNoeud.containsKey(element2))
			return false;

		Noeud noeud1 = mapElementNoeud.get(element1);
		Noeud noeud2 = mapElementNoeud.get(element2);

		E temp = noeud1.element;
		
		noeud1.element = noeud2.element;
		noeud2.element = temp;
		mapElementNoeud.put(element1, noeud2);
		mapElementNoeud.put(element2, noeud1);
		return true;

		// REMARQUE : CE SONT LES VALEURS QUI SONT PERMUTEES, PAS LES NOEUDS!!!
		// Il est donc inutile de revoir le chainage
		// N'oubliez pas de modifier les noeuds associes dans le map

	}

	public Iterator<E> iterator() {

		return new IterateurImpl();
		// il faut renvoyer un objet de type Iterator :
		//return new IterateurImpl<E>();
		// completez la classe interne IterateurImpl !
	}

	public String toString () {
		String aRenvoyer = "";
		int num = 1;
		Noeud baladeur = tete.suivant;
		while (baladeur != queue) {
			aRenvoyer += num + " - " + baladeur.element + "\n";
			baladeur = baladeur.suivant;
			num++;
		}
		return aRenvoyer;   
	}



	// Classe interne Noeud
	private class Noeud{
		private E element;
		private Noeud suivant;
		private Noeud precedent;

		private Noeud() {
			this(null, null, null);
		}

		private Noeud(E element) {
			this(null, element, null);
		}

		private Noeud(Noeud precedent, E element, Noeud suivant) {
			this.element = element;
			this.suivant = suivant;
			this.precedent = precedent;
		}
	}

	

	// Classe interne IterateurImpl
	private class IterateurImpl implements Iterator<E>{

		private Noeud noeudCourant;

		private IterateurImpl() {
			noeudCourant = tete.suivant;

		}

		public boolean hasNext() {
			return noeudCourant != queue;


		}

		// renvoie l element qui se trouve dans le noeud courant
		// le noeud courant passe au noeud suivant
		public E next() {
			E element = noeudCourant.element;
			noeudCourant = noeudCourant.suivant;
			return element;

		}

		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
	}

	// pour les tests
	public ListeSDImpl(E[] tableACopier) {
		mapElementNoeud = new HashMap<E, Noeud>();
		tete = new Noeud();   // sentinelle de tete
		queue = new Noeud();  // sentinelle de queue
		Noeud prec = tete;
		for (int i = 0; i < tableACopier.length; i++) {
			Noeud nouveauNoeud = new Noeud(tableACopier[i]);
			mapElementNoeud.put(tableACopier[i], nouveauNoeud);
			nouveauNoeud.precedent = prec;
			prec.suivant = nouveauNoeud;
			prec = nouveauNoeud;
		}
		prec.suivant = queue;
		queue.precedent = prec;
	}

	// pour les tests
	public String teteQueue(){
		try{
			String aRenvoyer = "(";
			Noeud baladeur = tete.suivant;
			int cpt=0;
			while (baladeur != queue) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
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
			Noeud baladeur = queue.precedent;
			int cpt=0;
			while (baladeur != tete) {
				if(cpt==0)
					aRenvoyer += baladeur.element;
				else
					aRenvoyer += ","+baladeur.element;
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

}
