/** Classe Relation héritant de RelationDeBase
	 Fournit des outils de manipulation des relations entre sous-ensembles de l'Univers
 */

import java.math.MathContext;
import java.util.*;

public class Relation extends RelationDeBase {

	/** Valeur numérique de MAXELT */
	private static final int MAX = Elt.MAXELT.val();

	/** Construit la Relation vide sur l'ensemble vide */
	public Relation() {
		super();
	}

	/** Construit la Relation vide de d vers a */
	public Relation(EnsembleAbstrait d, EnsembleAbstrait a) {
		super(d, a);
	}

	/** Clone */
	public Relation clone() {
		return (Relation) super.clone();
	}
	
	//Ex1
	//renvoie le domaine de la relation courante
	public EnsembleAbstrait domaine() {
		EnsembleAbstrait domaine = new Ensemble();
		for (Couple c : this) {
			domaine.ajouter(c.getX());
		}
		return domaine;
	}
	
	//renvoie l'image de la relation courante
	public EnsembleAbstrait image() {
		EnsembleAbstrait domaine = new Ensemble();
		for (Couple c : this) {
			domaine.ajouter(c.getY());
		}
		return domaine;
	}
	
	// EX 2
	// renvoie la complémentaire de la relation courante
	public Relation complementaire() {
		Relation rel = new Relation(depart(),arrivee()); // on crée une relation vide avec les mêmes ensembles de départ et d'arrivée
		for (Elt x : depart()) {
			for (Elt y : arrivee()) {
				Couple couple = new Couple(x, y);
				if (!contient(couple)){
					rel.ajouter(couple);
				}
			}
		}
		return rel;
	}

	// renvoie la réciproque de la relation courante
	public Relation reciproque() {
		Relation rel = new Relation(arrivee(),depart()); // attention, l'ordre est inversé donc le départ devient l'arrivée et vice versa
		for (Couple c : this) {
			rel.ajouter(c.reciproque());
		}
		return rel;
	}

	// si possible, remplace la relation courante par son union avec r
	//sinon, lance une IllegalArgumentException
	public void ajouter(RelationInterface r) {
		if (r == null) throw new IllegalArgumentException("paramètre null");
		if (!depart().equals(r.depart()) || !arrivee().equals(r.arrivee())) {
			throw new IllegalArgumentException("Ensembles de départ ou d'arrivée différents");
		}
		for (Couple couple : r) {
			ajouter(couple);
		}
	}

	// si possible, remplace this par sa différence avec r
	//sinon, lance une IllegalArgumentException
	public void enlever(RelationInterface r) {
		if (r == null) throw new IllegalArgumentException("paramètre null");
		if (!depart().equals(r.depart()) || !arrivee().equals(r.arrivee())) {
			throw new IllegalArgumentException("Ensembles de départ ou d'arrivée différents");
		}

		for (Couple couple : this.clone()) {
			if (r.contient(couple)) {
				this.enlever(couple);
			}

		}
	}

	// si possible, remplace this par son intersection avec r
	//sinon, lance une IllegalArgumentException
	public void intersecter(RelationInterface r) {
		if (r == null) throw new IllegalArgumentException("paramètre null");
		if (!depart().equals(r.depart()) || !arrivee().equals(r.arrivee())) {
			throw new IllegalArgumentException("Ensembles de départ ou d'arrivée différents");
		}
		for (Couple couple : this.clone()) {
			if (!r.contient(couple)) {
				this.enlever(couple);
			}
		}
	}

	// si possible, renvoie la composée : this après r
	//sinon, lance une IllegalArgumentException
	public Relation apres(RelationInterface r) {
		if (r == null || !r.arrivee().equals(this.depart())) throw new IllegalArgumentException();
		Relation rel = new Relation(r.depart(), this.arrivee());
		for (Couple c1 : r) {
			for (Couple c2 : this) {
				if (c1.getY().equals(c2.getX())){
					rel.ajouter(c1.getX(), c2.getY());

				}
				iter++;
			}
		}
		return rel;
	}


	
	/*Les exercices 4 et 5 ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */
	
	/* Ex 4 */
		
	// Clôture la Relation courante pour la réflexivité
	public void cloReflex() {
		if (!depart().equals(arrivee())) throw new MathException();
		for(Elt e : depart()){
			ajouter(e,e);
		}
	}
	// Clôture la Relation courante pour la symétrie
	public void cloSym() {
		if (!depart().equals(arrivee())) throw new MathException();
		for (Couple c : clone()) {
			/*if (!c.getX().equals(c.getY())){ //V1
				ajouter(c.getY(), c.getX());
			}*/
			ajouter(c.getY(), c.getX()); // V2, BEST
			//ajouter(c.reciproque()); //V3

		}
		//ajouter(reciproque()); //V4 (sans le iter dcp)
	}

	// Clôture la Relation courante pour la transitivité (Warshall)
	public void cloTrans3() {
		if (!depart().equals(arrivee())) throw new MathException();
		for (Elt k : arrivee()) {
			for (Elt i : arrivee()) {
				for (Elt j : arrivee()) {
					if (contient(i, k) && contient(k, j)) {
						ajouter(i, j);
					}
				}
			}
		}
	}
	public void cloTrans2() {
        if (!depart().equals(arrivee())) {
            throw new MathException();
        }
        //methode warshall
        // 1) regarder flèche qui rentre
        for (Couple c1 : this) {
            Elt x1 = c1.getX();
            Elt y1 = c1.getY();
            // exemple (3 -> 2)
            // on garde 3 (x) et on garde 2 (y)
            for (Couple c2 : this) {
                // on reparcoure les couples et on check si l'ancien y (2) == x du nouveau couple
                if (c2.getX().equals(y1)) {
                    Elt y2 = c2.getY();
                    if (!contient(x1, y2)) {
                        ajouter(x1, y2);
                        // Si réussi on reparcoure tout de zero pour rafraichir les potentiels changements
                        cloTrans2();
                        return;
                    }
                }
            }
        }
    }
	int iter = 0;
	public void cloTrans(){
		if (!depart().equals(arrivee())) throw new MathException();
		for (int i = 0; i < MAX; i++) {
			ajouter(apres(this));
			iter++;
		}
		System.out.println("yo");
		System.out.println(iter);
		//archi pas opti 90 000 itération et 21 000
	}

	/*
	
	
	//Ex 5
	/*Les questions qui suivent ne concernent que les relations sur un ensemble.
	 * Les méthodes demandées génèreront donc une MathException lorsque l'ensemble de départ
	 * ne coïncide pas avec l'ensemble d'arrivée.
	 */
	// renvoie true ssi this est réflexive
	public boolean reflexive(){
		if (!depart().equals(arrivee())) throw new MathException();
		for (Elt e : arrivee()) {
			if (!contient(e,e)) return false;
		}
		return true;
	}

	// renvoie true ssi this est antiréflexive
	public boolean antireflexive(){
		if (!depart().equals(arrivee())) throw new MathException();
		for (Elt e : arrivee())
			if (contient(e,e)) return false;
		return true;
	}

	// renvoie true ssi this est symétrique
	public boolean symetrique(){
		if (!depart().equals(arrivee())) throw new MathException();
		for (Couple c : clone()){
			if (!contient(c.getY(),c.getX())) return false;
		}
		return true;
	}

	// renvoie true ssi this est antisymétrique
	public boolean antisymetrique(){
		if (!depart().equals(arrivee())) throw new MathException();
		for (Couple c : clone()){
			if (contient(c.getY(),c.getX())) return false;
		}
		return true;
	}

	// renvoie true ssi  this est transitive
	public boolean transitive(){
		//TODO
		return false;
	}
	
	// Ex 6
	//Construit une copie de la relation en paramètre
	//lance une IllegalArgumentException en cas de paramètre invalide
	public Relation(RelationInterface r) {
		//TODO
		this();

	}

	//renvoie l'identité sur e
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation identite(EnsembleAbstrait e) {
		//TODO
		return null;
	}

	//renvoie le produit cartésien de a et b
	//lance une IllegalArgumentException en cas de paramètre invalide
	public static Relation produitCartesien(EnsembleAbstrait a, EnsembleAbstrait b) {
			//TODO
		return null;
	}

} // class Relation
