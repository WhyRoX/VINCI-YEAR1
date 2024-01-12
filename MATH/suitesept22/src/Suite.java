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

	/* Renvoie true si aucun élément de la suite n'est compris entre a et b
	 *         false sinon
	 * Précondition à ne pas vérifier : a<=b
	 * Exemples :
	 * ----------
	 * this = (1,5,6,10,3) alors aucunEntre(6,9)   --> false
	 * this = (1,5,6,10,3) alors aucunEntre(7,9)   --> true
	 * this = (1,5,6,10,3) alors aucunEntre(-5,-2) --> true
	 * this = (1,5,6,10,3) alors aucunEntre(-2,5)  --> false
	 * this = ()           alors aucunEntre(6,9)   --> true
	 * @param int a : borne inférieure
	 * @param int b : borne supérieure
	 * @return true si aucun élément de la suite courante n'est compris entre a et b
	 *         false sinon
	 */
	public boolean aucunEntre(int a, int b) {
		//TODO
		return false ;
	}

	/*  Renvoie true si la suite contient au moins n fois l'Elt e et
	 *          false sinon
	 *  Exemples :
	 *  ----------
	 *  this = (3,7,7,12,7), n=2  et e=7     alors auMoinsNOccurences(n,e) --> true
	 *  this = (3,7,7,12,7), n=3  et e=7     alors auMoinsNOccurences(n,e) --> true
	 *  this = (3,7,7,12,7), n=4  et e=7     alors auMoinsNOccurences(n,e) --> false
	 *  this = (),           n=0  et e=2     alors auMoinsNOccurences(n,e) --> true
	 *  this = (),           n=1  et e=7     alors auMoinsNOccurences(n,e) --> false
	 *  this = (3,7,7,12,7), n=-1 et e=7     alors auMoinsNOccurences(n,e) --> IllegalArgumentException
	 *  this = (3,7,7,12,7), n=-8 et e=7     alors auMoinsNOccurences(n,e) --> IllegalArgumentException
	 *  this = (3,7,7,12,7), n=1  et e=null  alors auMoinsNOccurences(n,e) --> IllegalArgumentException
	 *
	 * @param int n : nombre minimum d'occurences de l'Elt e
	 * @param Elt e : élément de la suite dont on chercher n occurence(s)
	 * @return true  si la suite contient au moins n fois l'Elt e
	 *         false sinon
	 * @throw IllegalArgumentException si n<0
	 * @throw IllegalArgumentException si e est null
	 */
	public boolean auMoinsNOccurences(int n, Elt e) {
		if (n < 0) throw new IllegalArgumentException("x < 0");
		if (e == null) throw new IllegalArgumentException("e est null");
		return auMoinsNOccurencesBis(n,e) ;
	}
	private boolean auMoinsNOccurencesBis(int n, Elt e) {
		if (n==0)
			return true ;

		if (this.estVide())
			return false ;

		if (this.tete().equals(e)){
			return this.corps().auMoinsNOccurencesBis(n-1,e);
		}
		return this.corps().auMoinsNOccurencesBis(n,e);

	}

} 

