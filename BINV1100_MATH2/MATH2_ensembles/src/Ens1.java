public class Ens1 extends EnsembleAbstrait {

	private boolean[] tabB; // e appartient à l'ensemble courant ssi tabE[e.val()] est � true.
	private int cardinal;

	public Ens1() {
		tabB = new boolean[MAX+1];
	}
	
	public boolean estVide() {
        return cardinal == 0;
    }
	
	public Elt unElement() {
		if (this.estVide()) throw new MathException();
		Elt elt = null;
		for (int i = 1; i <= MAX; i++) {
			if (tabB[i]) {
				elt = new Elt(i);
				break;
			}
		}
		return elt;
	}

	public boolean contient(Elt e) {
		if (e == null) throw new IllegalArgumentException();
        return tabB[e.val()];
    }

	public void ajouter(Elt e) {
		if (e == null) throw new IllegalArgumentException();
		if (!tabB[e.val()]){
			tabB[e.val()] = true;
			cardinal++;
		}

	}

	public void enlever(Elt e) {
		if (e == null) throw new IllegalArgumentException();
		if (this.contient(e)){
			tabB[e.val()] = false;
			cardinal--;
		}
	}

	public int cardinal() {
		return cardinal ;
	}

	public void complementer() {
		boolean[] tabComp = new boolean[MAX+1];
		cardinal = 0;
		for (int i = 1; i <= MAX; i++) {
			if (tabB[i] == false) {
				tabComp[i] = true;
				cardinal++;
			}
		}
		tabB = tabComp;
	}

	public String toString() {
		// TODO
		return null;
	}
	
}
