import java.util.Iterator;

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

	/* Renvoie true si l'Elt x n'est jamais juste après l'Elt y dans la suite courante
	 *         false sinon
	 * Exemples :
	 * ----------
	 * this = (1,2,2)        alors jamaisApres(null,3)   --> IllegalArgumentException
	 * this = (1,2,2)        alors jamaisApres(3,null)   --> IllegalArgumentException
	 * this = (3,6,4,3,6)    alors jamaisApres(3,4)      --> false
	 * this = (3,9,3,4,5,7)  alors jamaisApres(3,4)      --> true
	 * this = ()             alors jamaisApres(3,4)      --> true
	 * this = (7,8,4,6,10)   alors jamaisApres(3,4)      --> true
	 * this = (8,3,6,3,7,3)  alors jamaisApres(3,4)      --> true
	 * this = (8,3,6,3,7,3)  alors jamaisApres(3,3)      --> true
	 * this = (8,3,3,7,3)    alors jamaisApres(3,3)      --> false
	 * this = (8,9,12,4,3)   alors jamaisApres(3,4)      --> false
	 * this = (3)            alors jamaisApres(3,4)      --> true
	 * @param Elt x
	 * @param Elt y
	 * @return true si l'Elt x n'est jamais après l'Elt y dans la suite courante
	 *         false sinon
	 * @throw IllegalArgumentException en cas de paramètre invalide
	 */

	public boolean jamaisApres(Elt x, Elt y) {
		if (x == null) throw new IllegalArgumentException(" x est null");
		if (y == null) throw new IllegalArgumentException(" y est null");
		return jamaisApresBis(x,y);
	}
	private boolean jamaisApresBis(Elt x, Elt y) {
		if (this.estVide()) return true;
		if (this.tete().equals(y)){
			if (this.corps().estVide()) return true;
			else if (this.corps().tete().equals(x)) {
				return false;
			}
		}
		return this.corps().jamaisApresBis(x,y);
	}

} 

