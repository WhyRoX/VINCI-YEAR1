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

	/* Renvoie true si la suite courante contient au moins 2 occurences de l'Elt e qui se suivent
	 *         false sinon
	 * Exemples :
	 * ----------
	 * this = (1,2,2)          alors auMoins2EnSuivant(null) --> IllegalArgumentException
	 * this = (3,6,6,3,10)     alors auMoins2EnSuivant(3)    --> false
	 * this = (3,9,6,3,3,12,3) alors auMoins2EnSuivant(3)    --> true
	 * this = ()               alors auMoins2EnSuivant(4)    --> false
	 * this = (3,8,2,6,3,3)    alors auMoins2EnSuivant(3)    --> true
	 * this = (8,3,6,3,4,3)    alors auMoins2EnSuivant(3)    --> false
	 * this = (8,3,3,3,4,5)    alors auMoins2EnSuivant(3)    --> true
	 * this = (3)              alors auMoins2EnSuivant(3)    --> false
	 * @param Elt e
	 * @return true si la suite courante contient au moins 2 occurences de e qui se suivent
	 *         false sinin
	 * @throw IllegalArgumentException en cas de paramètre invalide
	 */

	public boolean auMoins2EnSuivant(Elt e) {
		if (e == null) throw new IllegalArgumentException();
		return auMoins2EnSuivantBis(e) ;
	}
	private boolean auMoins2EnSuivantBis(Elt e) {
		if (this.estVide()){
			return false;
		}
		if (this.corps().estVide())
			return false ;
		if (this.tete().equals(e)){
			if (this.corps().tete().equals(e)){
				return true;
			}
		}
		return this.corps().auMoins2EnSuivantBis(e);
	}

} 

