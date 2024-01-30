public class Ens2 extends EnsembleAbstrait {

	private Elt[] elements; // contient les elements de l'ensemble. Il ne peut pas y avoir de doublon.
	private int cardinal;

	public Ens2() {
		elements = new Elt[MAX];
		
	}

	public boolean estVide() {

		return cardinal == 0;
	}
	
	public Elt unElement() {
		if (this.estVide()) throw new MathException();
		return elements[0];
	}

	public boolean contient(Elt e) {
		if (e == null) throw new IllegalArgumentException();
		for (int i = 0; i < cardinal; i++) {
			if (e.equals(elements[i])){ // pourquoi? jsp?
				return true;
			}
		}
		return false;
	}

	public void ajouter(Elt e) {
		
	}

	public void enlever(Elt e) {
		//TODO
		
	}

	public int cardinal() {
		//TODO
		return 0;
	}

	public void complementer() {
		//TODO;
		
	}

	public String toString() {
		//TODO
		return null ;
	}

}
