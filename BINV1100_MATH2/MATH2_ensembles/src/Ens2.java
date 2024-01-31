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
		if (e == null) throw new IllegalArgumentException();
		if (!this.contient(e)){
			elements[cardinal] = e;
			cardinal++;
			//elements[e.val()] = e;
			//cardinal++;
		}
	}

	public void enlever(Elt e) {
		if (e == null) throw new IllegalArgumentException();
		int index = -1;
		for (int i = 0; i < cardinal; i++) {
			if (e.equals(elements[i])) {
				index = i;
				break;
			}
		}
		if (index != -1) {
			elements[index] = elements[cardinal - 1];
			cardinal--;
		}
	}


	public int cardinal() {
		//TODO
		return cardinal;
	}

	public void complementer() {
		Elt[] tabComp = new Elt[MAX];
		cardinal = 0;

		for (int i = 1; i <= MAX; i++) {
			Elt elt = new Elt(i);

			//
			if (!contient(elt)) {
				tabComp[cardinal] = elt;
				cardinal++;
			}
		}
		for (int i = 0; i < cardinal; i++) {
			elements[i] = tabComp[i];
		}
	}





	public String toString() {
		//TODO
		return null ;
	}

}
