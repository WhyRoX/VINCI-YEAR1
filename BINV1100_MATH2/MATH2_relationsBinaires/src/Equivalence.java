/** Classe Equivalence
	 Chaque instance de cette classe est une relation d'�quivalence sur un sous-ensemble de l'Univers
 */

import java.util.*;

public class Equivalence extends RelationAbstraite {

	private EnsembleAbstrait sousJac; // ensemble sous-jacent
	private Elt[] tabRep; // tableau des repr�sentants
	private int numVersion; // num�ro de version


	// Construit l�identit� sur e
	// Lance une IllegalArgumentException en cas de param�tre invalide 
	public Equivalence(EnsembleAbstrait e) {
		if (e == null)
			throw new IllegalArgumentException("Equivalence : parametre null");
		sousJac = new Ensemble(e);
		tabRep = new Elt[MAX+1];
		numVersion = 1;
		for (Elt elt : e) {
			tabRep[elt.val()] = elt;
		}

	}


	// ajoute (si nécessaire) l’arête x-y au diagramme de classes de
	// l’Equivalence courante ; autrement dit, fusionne les classes de
	// c.getx() et de c.gety().
	// Lance une IllegalArgumentException en cas de paramètre invalide
	public void ajouter(Couple c) {
		if (c == null || !sousJac.contient(c.getX()) || !sousJac.contient(c.getY()))
			throw new IllegalArgumentException("Equivalence : parametre null or element not in set");
		Elt aRemp = tabRep[c.getX().val()];
		Elt rempPar = tabRep[c.getY().val()];
		for (Elt elt : sousJac) {
			if (tabRep[elt.val()].equals(aRemp) && !tabRep[elt.val()].equals(rempPar)) {
				tabRep[elt.val()] = rempPar;
				numVersion++;
			}
		}
	}

	// Construit la cl�ture �quivalente de r, pour autant que celle-ci soit une relation sur un ensemble.
	// lance une IllegalArgumentException sinon
	public Equivalence(Relation r) {
		if (r == null || r.depart() == null || r.arrivee() == null)
			throw new IllegalArgumentException("Equivalence : parametre null");
		sousJac = new Ensemble(r.depart());
		tabRep = new Elt[MAX+1];
		for (Elt elt : r.depart()) {
			tabRep[elt.val()] = elt;
		}
		for (Couple couple : r) {
			ajouter(couple);
		}
		numVersion = 1;
	}

	
	// renvoie true si c.getx() et c.gety() sont dans la m�me classe et false sinon
	// Lance une IllegalArgumentException en cas de param�tre invalide 
	public boolean contient(Couple c) {
		if (c == null || !sousJac.contient(c.getX()) || !sousJac.contient(c.getY()))
			throw new IllegalArgumentException();
		return tabRep[c.getX().val()].equals(tabRep[c.getY().val()]);
	}

	// renvoie la classe d'�quivalence de x, ou g�n�re une IllegalArgumentException
// si e est null ou si e n'appartient pas � l'ensemble sous-jacent
	public EnsembleAbstrait classe(Elt e) {
		if (e == null || !sousJac.contient(e))
			throw new IllegalArgumentException();
		EnsembleAbstrait res = new Ensemble();
		Elt repE = tabRep[e.val()];
		for (Elt elt : sousJac) {
			if (tabRep[elt.val()].equals(repE)) {
				res.ajouter(elt);
			}
		}
		return res;
	}

	// Si c.getx()et c.gety() sont distincts et si la classe commune
	// de c.getx() et c.gety() est {c.getx(),c.gety()}, alors cette classe
	// sera scind�e en deux classes.
	// g�n�re une IllegalArgumentException si le param�tre est invalide,
	// ou si c.getx(), c.gety() sont dans la m�me classe  mais qu'on n'est pas 
	// dans le cas o� on peut scind�e cette classe.
	public void enlever(Couple c) {
		//TODO
	}

	// renvoie le nombre de classes de l'Equivalence courante
	public int nbreClasses() {
		//TODO
		return -1;
	}

	// renvoie le quotient de l�ensemble sous-jacent par l'Equivalence
	// courante
	public EnsembleAbstrait[] quotient() {
		//TODO
		return null;
	}


	public boolean estVide() {
		return sousJac.estVide();
	}

	@Override
	public EnsembleAbstrait depart() {
		return sousJac.clone();
	}

	@Override
	public EnsembleAbstrait arrivee() {
		return sousJac.clone();
	}
	
	/** renvoie un it�rateur sur l'Equivalence courante */
	public Iterator<Couple> iterator() {
		return new EquivalenceIterator();
	}

	private class EquivalenceIterator implements java.util.Iterator<Couple> {
		private Iterator<Couple> itC;
		private int version;

		public EquivalenceIterator() {
			version = numVersion;
			Relation r = new Relation(sousJac, sousJac);
			EnsembleInterface reste = sousJac.clone();
			while (!reste.estVide()) {
				Elt e = reste.unElement();
				EnsembleAbstrait classeE = classe(e);
				Iterator<Elt> itClasseE = classeE.iterator();
				while (itClasseE.hasNext()) {
					Elt next = itClasseE.next();
					r.ajouter(e, next);
					r.ajouter(next, e);
					r.ajouter(next, next);
				}
				reste.enlever(classeE);
			}
			r.cloTrans();
			itC = r.iterator();
		}

		@Override
		public boolean hasNext() {
			return itC.hasNext();
		}

		@Override
		public Couple next() {
			if (numVersion != this.version)
				throw new ConcurrentModificationException();
			if (!hasNext())
				throw new NoSuchElementException();
			return itC.next();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

} // Equivalence
