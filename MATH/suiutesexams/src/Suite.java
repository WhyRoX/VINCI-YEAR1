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

	/* Renvoie le nombre de fois que l'Elt x est juste avant l'Elt y dans la
	 *         suite courante
	 * Exemples :
	 * ----------
	 * this = (1,2,2)   alors nbFoisAvant(null,3)  --> IllegalArgumentException
	 * this = (1,2,2)   alors nbFoisAvant(3,null)  --> IllegalArgumentException
	 * this = (3,6,4,2,6)      alors nbFoisAvant(3,4)  --> 0
	 * this = (3,4,9,3,4)      alors nbFoisAvant(3,4)  --> 2
	 * this = ()               alors nbFoisAvant(3,4)  --> 0
	 * this = (7,8,4,6,10)     alors nbFoisAvant(3,4)  --> 0
	 * this = (8,3,4,3,4,3)    alors nbFoisAvant(3,4)  --> 2
	 * this = (8,3,4,3,4,3)    alors nbFoisAvant(3,3)  --> 0
	 * this = (8,3,3,3,3,3,2)  alors nbFoisAvant(3,3)  --> 4
	 * this = (8)              alors nbFoisAvant(3,4)  --> 0
	 * this = (3)              alors nbFoisAvant(3,4)  --> 0
	 * @param Elt x
	 * @param Elt y
	 * @return le nombre de fois que x est juste avant y dans la suite courante
	 * @throw IllegalArgumentException en cas de paramètre invalide
	 **/

	public int nbFoisAvant(Elt x, Elt y) {
		if (x == null) throw new IllegalArgumentException(" x est null");
		if (y == null) throw new IllegalArgumentException(" y est null");
		return nbFoisAvantBis(x,y) ;
	}
	/*private int nbFoisAvantBis(Elt x, Elt y) {
		if (this.estVide()) return 0;
		if (this.tete().equals(x)) {
			if (this.corps().estVide()) return 0;
			else if (this.corps().tete().equals(y)) {
				return 1+this.corps().nbFoisAvantBis(x,y);
			}
		}
		return this.corps().nbFoisAvantBis(x,y);
	}*/
	private int nbFoisAvantBis(Elt x, Elt y) {
		if (this.estVide()) return 0;
		if (this.corps().estVide()) return 0;

		if (this.tete().equals(x) && this.corps().tete().equals(y)){
			return 1+this.corps().nbFoisAvantBis(x,y);
		}
		return this.corps().nbFoisAvantBis(x,y);
	}

} 

