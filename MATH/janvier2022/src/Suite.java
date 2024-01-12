public class Suite extends SuiteDeBase {

	// valeur numérique de MAXELT
	private static final int MAX = Elt.MAXELT.val();

	/** Constructeur vide */
	public Suite() {
		super();
	}

	/** Constructeur par recopie */
	public Suite(SuiteDeBase s) {
		super(s);
	}

	/** Constructeur à partir d'une String */
	public Suite(String st) {
		super(st);
	}

	/** Constructeur à partir d'un Elt et d'une Suite */
	public Suite(Elt t, Suite c) {
		super(t, c);
	}

	/** Construit la Suite réduite à (x) */
	public Suite(Elt x) {
		this();
		this.ajouter(x);
	}

	public Suite corps() {
		return (Suite) super.corps();
	}
	
	@Override
	public int hashCode(){
		int prime = 31;
		int result = 1;
		for (Elt e : this){
			result = result *prime + e.hashCode();
		}
		return result;
	}

    
	/* Renvoie true si tous les éléments de la suite courante sont des diviseurs de x
	 *         false sinon
	 * Exemples :
	 * ----------
	 * this = (3,9,6,3,10) alors tousDiviseurDe(36)  --> false
	 * this = (3,9,6,12,3) alors tousDiviseurDe(36)  --> true
	 * this = ()           alors tousDiviseurDe(36)  --> true
	 * this = (8,2,6)      alors tousDiviseurDe(-24) --> true
	 * this = (8,3,6)      alors tousDiviseursDe(0)  --> true
	 * @param int x
	 * @return true si tous les éléments de la suite courante sont des diviseurs de x
	 */

	public boolean tousDiviseursDe(int x) {
		if (this.estVide()) return true;
		if (x % this.tete().val() != 0){
			return false;
		}
		return corps().tousDiviseursDe(x);
	}
	
	/*  Renvoie une copie de suite courante dans laquelle on a ajouté l'Elt e à la position k
     *  Exemples : 
     *  ----------
     *  this = (1,7,6) ;  e = new Elt(3) et k = 2  alors ajouterEnKEmePosition(e, k) --> (1,3,7,6)
     *  this = (1,7,6) ;  e = new Elt(3) et k = 4  alors ajouterEnKEmePosition(e, k) --> (1,7,6,3)
     *  this = (1,7,6) ;  e = new Elt(3) et k = 5  alors ajouterEnKEmePosition(e, k) --> IllegalArgumentException
	 *  this = (1,7,6) ;  e = new Elt(3) et k = -1 alors ajouterEnKEmePosition(e, k) --> IllegalArgumentException
	 *  this = ()      ;  e = new Elt(3) et k = 1  alors ajouterEnKEmePosition(e, k) --> (3)
     * @param Elt e
     * @param int k
     * @return une suite qui est une copie de la suite courante dans laquelle on a ajouté l'Elt e à la position k
     * @throw IllegalArgumentException si e est null
     * @throw IllegalArgumentException s'il n'est pas possible d'ajouter l'Elt e à la position k
     */
	public Suite ajouterEnKEmePosition(Elt e, int k) {
		if (e == null || k <= 0)
			throw new IllegalArgumentException();
		return ajouterEnKEmePositionBis(e,k);
	}
	private Suite ajouterEnKEmePositionBis(Elt e, int k){
		if (k == 1){
			return new Suite(e, new Suite(this));
		}
		if (this.estVide())
			throw new IllegalArgumentException();
		return new Suite(this.tete(), this.corps().ajouterEnKEmePositionBis(e, k-1));
	}

} 

