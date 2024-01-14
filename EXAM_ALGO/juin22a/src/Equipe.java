
public class Equipe {
	
	private int numeroEquipe; // 1 ou 2
	private String[] tableCandidats;
	private int nombreCandidatsEnJeu; // le nombre de candidats encore en jeu
	private int points;

	// A NE PAS MODIFIER
	public Equipe(int numero, String[] tableCandidats) {
		if(numero!=1&& numero!=2)
			throw new IllegalArgumentException();
		if(tableCandidats==null)
			throw new IllegalArgumentException();
		this.numeroEquipe=numero;
		this.nombreCandidatsEnJeu = tableCandidats.length;
		this.tableCandidats = new String[tableCandidats.length];
		for (int i = 0; i < tableCandidats.length; i++) {
			this.tableCandidats[i]=tableCandidats[i];
		}
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LA CLASSE TEST
	public Equipe(int numero, String[] tableCandidats,int nombreCandidats) {
		this(numero,tableCandidats);
		this.nombreCandidatsEnJeu = nombreCandidats;
	}

			
	public int getNombreCandidatsEnJeu() {
		return nombreCandidatsEnJeu;
	}	

	public int getNumero() {
		return numeroEquipe;
	}

	public int getPoints() {
		return points;
	}

	/**
	 * ajoute 1 point pour l'equipe
	 */
	public void ajouter1Point(){
		this.points ++;
	}

	/**
	 * renvoie le premier candidat de la table et le retire de celle-ci
	 * le deuxieme candidat prend sa place, le troisieme prend la place du deuxieme et ainsi de suite
	 * @return le candidat qui vient d'etre supprime ou null si la table ne contient plus de candidat
	 */
	public String selectionnerCandidat(){
		if (nombreCandidatsEnJeu == 0) return null;

		String candidat = tableCandidats[0];
		for (int i = 0; i < tableCandidats.length-1; i++) {
			tableCandidats[i] = tableCandidats[i + 1];

		}
		nombreCandidatsEnJeu--;
		return candidat;
	}
	
	/**
	 * met le candidat apres le dernier candidat encore present
	 * la table ne peut etre pleine
	 * @param candidat le candidat a ajouter
	 * @return true si le candidat a ete ajoute, false sinon
	 * @throws IllegalArgumentException si le candidat est null
	 */
	
	public boolean remettreEnJeu(String candidat){
		if(candidat==null)
			throw new IllegalArgumentException();
		//TODO		
		//return false;
		if(tableCandidats.length== nombreCandidatsEnJeu)
			return false;
		tableCandidats[nombreCandidatsEnJeu]=candidat;
		nombreCandidatsEnJeu++;
		return true;
	}
	
	//A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	public String toString(){
		String aRenvoyer ="";
		for (int i = 0; i < nombreCandidatsEnJeu; i++) {
			aRenvoyer = aRenvoyer+" "+tableCandidats[i];
		}	
		return aRenvoyer;
	}

}
