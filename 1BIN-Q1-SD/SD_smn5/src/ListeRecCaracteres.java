import java.util.NoSuchElementException;

import java.util.ArrayList;

public class ListeRecCaracteres {

	private NoeudCaractere tete;
	// N'ajoutez pas d'autres attributs
	
	public ListeRecCaracteres() {
		this.tete=null;
	}
	

	
	/**
	 * verifie la presence du caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return true si le caractere est present dans la liste, false sinon
	 */
	public boolean contient(char caractereRecherche){
		return contient(tete, caractereRecherche);

	}
	private boolean contient(NoeudCaractere noeud, char caractereRecherche) {
		if(noeud==null)
			return false;
		if(noeud.caractere==caractereRecherche)
			return true;
		return contient(noeud.suivant, caractereRecherche);
	}

	
	/**
	 * calcule le nombre de fois qu'apparait le caractere passe en parametre dans la liste
	 * @param caractereRecherche
	 * @return le nombre d'occurrences du caractere
	 */
	public int nombreOccurrences(char caractereRecherche){
		return nombreOccurrences(tete, caractereRecherche);

	}
	private int nombreOccurrences(NoeudCaractere noeud, char caract){
		if (noeud==null)
			return 0;
		if (noeud.caractere == caract) return 1+nombreOccurrences(noeud.suivant,caract);
		return nombreOccurrences(noeud.suivant, caract);
	}

	
	/**
	 * remplace la 1ere occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacer(char caractereARemplacer, char nouveauCaractere){
		remplacer(tete, caractereARemplacer, nouveauCaractere);
	}
	private void remplacer(NoeudCaractere noeud, char oldChar, char nvChar){
		if (noeud==null) return;
		if (noeud.caractere == oldChar){
			noeud.caractere = nvChar;
			return;
		}
		remplacer(noeud.suivant, oldChar, nvChar);
	}

	
	/**
	 * remplace toutes les occurrences du caractere a remplacer par un nouveau caractere
	 * @param caractereARemplacer le caractere a remplacer
	 * @param nouveauCaractere le nouveau caractere
	 */
	public void remplacerTout(char caractereARemplacer, char nouveauCaractere){
		remplacerTout(tete, caractereARemplacer, nouveauCaractere);
	}
	private void remplacerTout(NoeudCaractere noeud, char oldChar, char nvChar){
		if (noeud==null) return;
		if (noeud.caractere == oldChar){
			noeud.caractere = nvChar;
		}
		remplacerTout(noeud.suivant, oldChar, nvChar);
	}
	
	
	/**
	 * recherche le plus grand caractere de la liste ('a'<'b'< ...)
	 * @return le plus grand caractere 
	 * @throws NoSuchElementException si la liste est vide
	 */
	public char max() {
		if (tete == null) throw new NoSuchElementException();
		return max(tete);
		
		// le plus petit caractere : ' '

		
		// c'est cette methode qui leve une exception en cas de liste vide!
		// suggestion : la methode recursive (private!) pourrait renvoyer ' ' si le noeud passe en parametre est null
	}
	private char max(NoeudCaractere noeud){
		if (noeud == null) return ' ';
		char maxC = max(noeud.suivant);
		if (noeud.caractere > maxC){
			return noeud.caractere;
		}
		return maxC;
	}
	
	
	
	
	/**
	 * cree une arrayList contenant les caracteres de la liste 
	 * L'ordre doit etre respecte (une liste est une structure lineaire)
	 * @return l'arrayList cree
	 */
	public ArrayList<Character> enArrayList(){
		ArrayList<Character> array = new ArrayList<Character>();
		enArrayList(tete, array);
		return array;
		

		
		// cette methode s'occupe de creer (1x!) l'arraylist et la passe en parametre de la methode recursive
		// l'arrayList est un objet --> passage de parametre par adresse 
		// La methode recursive est une methode void!
		
	}
	private void enArrayList(NoeudCaractere noeud, ArrayList<Character> array){
		if (noeud == null) return;
		array.add(noeud.caractere);
		enArrayList(noeud.suivant, array);
	}

	/**
	 * verifie si les 2 listes contiennent les memes caracteres et ceci dans le meme ordre
	 * Une liste est une structure LINEAIRE!
	 * @param l la liste a comparer a la liste courante
	 * @return true si les 2 listes sont les memes, false sinon
	 */
	public boolean estEgalA(ListeRecCaracteres l){
		
		return estEgaleA(tete, l.tete);

		// N'utilisez pas la methode toString()!

		
	}
	private boolean estEgaleA(NoeudCaractere l1, NoeudCaractere l2) {

		if(l1 == null && l2 == null)
			return true;

		if(l1 == null || l2 == null)
			return false;

		if(l1.caractere != l2.caractere)
			return false;
		return estEgaleA(l1.suivant, l2.suivant);
	}
	
	

	


	
	// VERSION 2
	
//	public boolean supprimerPremiereOccurrence(char caractereASupprimer) {
//		if(tete == null)
//			return false;
//		if(tete.caractere==caractereASupprimer){
//			tete = tete.suivant;
//			return true;
//		}
//			
//		return this.supprimerPremiereOccurrence(tete, caractereASupprimer) ;
//	}
//	
//	private boolean supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
//		if (noeud.suivant == null)
//			return false ;
//		if (noeud.suivant.caractere == caractereASupprimer) {
//			noeud.suivant = noeud.suivant.suivant ;
//			return true ;
//		}
//		return supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
//	}
	
	
	

	/**
	 * cree une liste qui est une copie de la liste courante (meme ordre)
	 * @return une copie de la liste courante
	 */
	public ListeRecCaracteres clone(){
		ListeRecCaracteres l =  new ListeRecCaracteres();
		if (tete==null) return l;
		l.tete = new NoeudCaractere(tete.caractere,null);
		clone(tete.suivant, l.tete);
		return l;


		
		// DEFI!
		
		// La methode recursive renvoie un noeud!
		// Lisez attentivement la version 1 de la solution de supprimerPremiereOccurrence
		
	}
	private void clone(NoeudCaractere n1, NoeudCaractere n2){
		if (n1 == null) return;
		n2.suivant = new NoeudCaractere(n1.caractere, null);
		clone(n1.suivant, n2.suivant);
	}
	public int supprimerToutesLesOccurrences2(char caractereASupprimer){
		// check de la tete
		if(tete == null) return 0;
		// si tete == a supprimer il faut donc redefenir la tete
		if(tete.caractere == caractereASupprimer){
			// avant de redefinir la tete je supprime les autres
			int o = supprimerToutesLesOccurrences2(tete,caractereASupprimer);
			// redefinition de la tete
			tete =  tete.suivant;
			// si tete donc o + 1
			return o+1;
		}
		return supprimerToutesLesOccurrences2(tete,caractereASupprimer);
	}

	private int supprimerToutesLesOccurrences2(NoeudCaractere noeudCaractere, char caractereASupprimer){
		if(noeudCaractere == null)
			return 0;
		if(noeudCaractere.suivant == null)
			return 0;

		// je regarde le suivant (Pourquoi le suivant ? Pour redefinir le .suivant du noeud actuel)
		if(noeudCaractere.suivant.caractere == caractereASupprimer){
			noeudCaractere.suivant = noeudCaractere.suivant.suivant;
			return 1+supprimerToutesLesOccurrences2(noeudCaractere,caractereASupprimer);
		}
		return supprimerToutesLesOccurrences2(noeudCaractere.suivant,caractereASupprimer);
	}


	
	/**
	 * supprime le caractere autant de fois qu'il est present dans la liste
	 * @param caractereASupprimer
	 * @return le nombre de suppressions effectuees
	 */
	public int supprimerToutesLesOccurrences(char caractereASupprimer){
		if (!contient(caractereASupprimer)) return 0;
		// int suppr ne fonctionne pas car la valeur de la variable est perdue a chaque appel recursif
		// int suppr = 0;
		int[] suppr = new int[1];
		tete = supprimerToutesLesOccurrences(tete, caractereASupprimer, suppr);
		return suppr[0];
	}

	private NoeudCaractere supprimerToutesLesOccurrences(NoeudCaractere noeud, char del, int[] suppr){
		if (noeud == null) return null;
		if (noeud.caractere == del){
			suppr[0]++;
			return supprimerToutesLesOccurrences(noeud.suivant, del, suppr);
		}
		noeud.suivant = supprimerToutesLesOccurrences(noeud.suivant, del, suppr);
		return noeud;
	}
	/*




	*/
	/**
	 * supprime une fois le caractere passe en parametre
	 * si le caractere se trouve plusieurs fois, c est sa premiere occurrence qui sera supprimee
	 * @param caractereASupprimer
	 * @return true si le caractere etait bien present dans la liste, false sinon
	 */

	// VERSION 1

	public boolean supprimerPremiereOccurrence(char caractereASupprimer){
		if(!contient(caractereASupprimer))
			return false;
		tete = supprimerPremiereOccurrence(tete,caractereASupprimer);
		return true;
	}

	private NoeudCaractere supprimerPremiereOccurrence(NoeudCaractere noeud, char caractereASupprimer) {
		if(noeud==null)
			return null;
		if(noeud.caractere==caractereASupprimer)
			return noeud.suivant;
		noeud.suivant=supprimerPremiereOccurrence(noeud.suivant, caractereASupprimer);
		return noeud;
	}


	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeRecCaracteres(char[] tableCaracteres) {
		if(tableCaracteres==null)
			throw new IllegalArgumentException();
		for (int i = tableCaracteres.length-1; i>=0; i--) {
			this.tete=new NoeudCaractere(tableCaracteres[i],tete);
		}
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){
		String aRenvoyer = "";
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			aRenvoyer += " " + baladeur.caractere;
			baladeur = baladeur.suivant;
		}
		return aRenvoyer;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS !!!
	public void remplacerToutParX(){
		NoeudCaractere baladeur = tete;
		while(baladeur != null) {
			baladeur.caractere = 'x';
			baladeur = baladeur.suivant;
		}
	}

	private class NoeudCaractere{
		private char caractere;
		private NoeudCaractere suivant;

		public NoeudCaractere(char caractere, NoeudCaractere suivant){
			this.caractere = caractere;
			this.suivant = suivant;
		}

	}
}
