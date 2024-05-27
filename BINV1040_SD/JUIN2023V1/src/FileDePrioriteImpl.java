import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FileDePrioriteImpl<E> implements FileDePriorite<E>{

	private Noeud racine;
	private Comparator comparateur;
	
	public FileDePrioriteImpl(Comparator<E> comparateur){
		this.comparateur = comparateur;
	}

	@Override
	public void insere(E e) {
		insere(racine,e);
		//contrainte : ecrivez cette methode de facon recursive
		//Lisez bien les explications sur l'utilisation de la methode compare() dans l'enonce

	}
	/**On fait le choix que la descendance gauche d’un nœud ne contiendra que des
	éléments de priorité supérieure à l’élément de ce nœud et
	la descendance droite d’un nœud ne contiendra que des éléments de priorité inférieure ou égale.**/
	private void insere(Noeud n, E e) {
		if (n== null) {
			racine = new Noeud(e);
		} else if (comparateur.compare(e, n.element) <= 0) {
			if (n.droit == null) {
				n.droit = new Noeud(e);
			} else {
				insere(n.droit, e);
			}
		} else {
				if (n.gauche == null){
					n.gauche = new Noeud(e);
				}
				else insere(n.gauche, e);
		}
		//cette methode est une methode recursive !
	}


	@Override
	public E max() {

		//contrainte : ecrivez cette methode de facon recursive
		return max(racine);
	}
	private E max(Noeud n){
		if (n == null) {
			return null;
		}
		if (n.gauche == null) {
			return n.element;
		}
		return max(n.gauche);
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterateur();
	}


	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public String toString () {
		return "[ "+toString(racine)+" ]";
	}

	private String toString (Noeud n) {
		if (n==null) 
			return "";
		if (n.gauche == null && n.droit == null) 
			return ""+n.element;
		if (n.gauche == null) 
			return " [ ] "+n.element+" [ "+toString(n.droit)+" ] ";
		if (n.droit == null) 
			return " [ "+toString(n.gauche)+" ] "+n.element+ " [ ] ";
		return " [ "+toString(n.gauche)+" ] "+n.element+" [ "+toString(n.droit)+" ] ";	
	}

	public class Noeud{

		private E element; 
		private Noeud gauche;
		private Noeud droit;

		private Noeud(E element){
			this.element = element;
			this.gauche = null;
			this.droit = null;
		}

		private Noeud (Noeud gauche, E element, Noeud droit){
			this.element = element;
			this.gauche = gauche;
			this.droit = droit;
		}
	}

	private class Iterateur implements Iterator {

		private ArrayDeque<E> file;

		public Iterateur () {
			file = new ArrayDeque();
			remplirFile(racine);
		}
		/**On fait le choix que la descendance gauche d’un nœud ne contiendra que des
		 éléments de priorité supérieure à l’élément de ce nœud et
		 la descendance droite d’un nœud ne contiendra que des éléments de priorité inférieure ou égale.**/
		private void remplirFile (Noeud n) {
			//cette methode est une methode recursive !
			if (n == null) {
				return;
			}
			remplirFile(n.gauche);
			file.add(n.element);
			remplirFile(n.droit);
		}

		public boolean hasNext () {
			return !file.isEmpty();
		}

		public E next () {
			if(!hasNext())
				throw new NoSuchElementException();
			return file.removeFirst();
		}
	}


	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	// permet de construire la file de priorite de l'enonce

	public FileDePrioriteImpl(E e1, E e2, E e3, E e4, E e5, E e6, E e7,Comparator<E> comparateur){
		Noeud nG = new Noeud(null,e2,new Noeud(e5));
		Noeud nG1 = new Noeud(new Noeud(e7),e4,new Noeud(e6));
		Noeud nD = new Noeud(nG1,e3, null);
		racine = new Noeud(nG,e1,nD);
		this.comparateur = comparateur;
	}

}
