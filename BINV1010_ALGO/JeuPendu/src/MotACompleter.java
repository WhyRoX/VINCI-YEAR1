
public class MotACompleter {
	
	private char[] motATrouver;   // le mot a trouver
	private char[] motACompleter; // le mot a completer

	/**
	 * au depart le mot a completer contient uniquement des '_'
	 * precondition (a ne pas verifier) : le mot a trouver contient des lettres majuscules
	 * @param motATrouver
	 */
	public MotACompleter(String motATrouver) {		
		this.motATrouver= motATrouver.toCharArray();
		this.motACompleter = new char[motATrouver.length()];
		for (int i = 0; i < motACompleter.length; i++) {
			motACompleter[i] = '_';
		}
	}

	/**
	 * verifie si le mot a completer ne contient plus de _
	 * @return true si le mot est complet, false sinon
	 */
	public boolean estComplet() {
		for (char c : motACompleter) {
			if (c == '_')
				return false;
		}
		return true;
	}
	
	/**
	 * verifie si le mot a trouver contient la lettre passee en parametre
	 * precondition (a ne pas verifier) : la lettre est une lettre majuscule de l'alphabet
	 * @param lettre la lettre recherchee
	 * @return true si la lettre a ete trouvee, false sinon 
	 */
	public boolean contientLettre(char lettre){
		for (char c : motATrouver) {
			if (c == lettre)
				return true;
		}
		return false;
	}
	
	/**
	 * ajoute (ou ecrase) la lettre dans le mot a completer autant de fois qu'elle se trouve
	 * dans le mot a trouver en respectant leur position
	 * ex : mot a trouver COLIBRI - mot a completer  C_L_BR_ - lettre I
	 *      mot a completer -> C_LIBRI
	 * precondition (a ne pas verifier) : la lettre est une lettre majuscule de l'alphabet
	 * @param lettre la lettre a ajouter
	 */
	public void ajouterLettre(char lettre){
		for (int i = 0; i < motATrouver.length; i++) {
			if (motATrouver[i] == lettre)
				motACompleter[i] = lettre;
		}
	}

	/**
	 * verifie si la premiere lettre du mot a trouver a ete ajoutee
	 * @return true si la premiere lettre du mot a trouve a ete ajoutee, false sinon
	 */
	public boolean premiereLettreEstAjoutee(){
		if (motACompleter[0] == motATrouver[0])
			return true;
		else
			return false;
	}

	/**
	 * ajoute la premiere lettre du mot a trouver au mot a completer autant de fois que necessaire
	 */
	public void ajouterPremiereLettre(){
		for (int i = 0; i < motATrouver.length; i++) {
			if (motATrouver[i] == motATrouver[0])
				motACompleter[i] = motATrouver[0];
		}
	}

	/**
	 * recherche la premiere lettre qui n'a pas encore ete trouvee
	 * ex : mot a trouver COLIBRI - mot a completer  CO__BR_ --> L est la lettre renvoyee
	 * @return la premiere lettre non trouvee ou ' ' si toutes les lettres ont ete trouvees
	 */
	public char premiereLettreNonTrouvee(){
		for (int i = 0; i < motACompleter.length; i++) {
			if (motACompleter[i] == '_')
				return motATrouver[i];
		}
	return ' ';
	}

	public String motATrouver() {
		return String.copyValueOf(motATrouver);
	}

	public String motACompleter() {
		return String.copyValueOf(motACompleter);
	}

	/**
	 * renvoie une chaine de caracteres avec le mot a completer en mettant un espace entre chaque lettre
	 * @return le mot a completer pour affichage
	 */
	public String toString(){
		if(motACompleter.length==0)
			return "";
		String aAfficher = ""+motACompleter[0];
		for (int i = 1; i < motACompleter.length; i++) {
			aAfficher += " "+ motACompleter[i];
		}
		return aAfficher;
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public MotACompleter(String motATrouver,String motACompleter) {
		this.motATrouver= motATrouver.toUpperCase().toCharArray();
		this.motACompleter = motACompleter.toUpperCase().toCharArray();
	}

}
