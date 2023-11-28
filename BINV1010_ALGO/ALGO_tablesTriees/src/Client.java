
public class Client {
	
	private String nom;
	private String prenom;
	private double[] tableMontants;			// table triee selon l'ordre decroissant des montants 
	private static final int TAILLE = 10;	// le nombre de montants max retenus

	
	/**
	 * construit un client avec ses 10 meilleurs montants = 0
	 * @param nom nom du client
	 * @param prenom prenom
	 */
	public Client (String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.tableMontants = new double[TAILLE];   // par defaut contient des 0!
	}
	
	/**
	 * ajoute le montant si celui-ci fait partie des 10 meilleurs montants
	 * le tri de la table doit etre respecte
	 * @param montant le montant a eventuellement ajouter
	 * @return true si le montant a ete ajoute, false sinon
	 */
	public boolean ajouter (double montant){
	
		// TODO
		return false;
	}

	
	@Override
	public String toString() {
		String aRenvoyer = "" + nom + " " + prenom + "  montants : ";
		for (int i = 0; i < TAILLE; i++) {
			aRenvoyer += " "+tableMontants[i];
		}
		return aRenvoyer;

	}
	
	
	
	
	
	
	
}
