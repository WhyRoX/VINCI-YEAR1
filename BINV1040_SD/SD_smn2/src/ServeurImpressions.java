import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ServeurImpressions {

	// table de 10 files d'attente d'impression
	private ArrayDeque<DemandeImpression>[] tableFilesDAttente;
	
	/**
	 * construit une table avec 10 files d'attente d'impression
	 */
	public ServeurImpressions() {
		tableFilesDAttente = new ArrayDeque[10];
		for (int i = 0; i < tableFilesDAttente.length; i++) {
			tableFilesDAttente[i] = new ArrayDeque<>();
		}
		//A cause d'une limitation du generique en JAVA
		//new ArrayDeque[10] --> OK (avec avertissement)
		//new ArrayDeque<DemandeImpression>[10] --> KO

	}
	
	/**
	 * verifie si toutes les files d'attente sont vides
	 * @return true si toutes les files sont vides, false sinon
	 */
	public boolean serveurVide(){
		for (ArrayDeque<DemandeImpression> demandeImpressions : tableFilesDAttente) {
			if (!demandeImpressions.isEmpty()) return false;
		}
		return true;

	}
	
	/**
	 * ajoute la demande d'impression en fin de la file correspondante a sa priorite
	 * @param demande la demande a ajouter
	 * @throws IllegalArgumentException si la demande est null
	 */
	public void ajouter(DemandeImpression demande){
		if (demande == null) throw new IllegalArgumentException();
		int priorite = demande.getPriorite();
		tableFilesDAttente[priorite].add(demande);
	}
	
	/**
	 * retire la demande d'impression en tete de file de priorite la plus haute qui est non vide
	 * @return la demande d'impression qui a ete retiree
	 * @throws NoSuchElementException si aucune demande d impression dans le serveur
	 */
	public DemandeImpression retirer(){
		//if (serveurVide()) throw new NoSuchElementException(); si on garde, return null sinn ->
		for (int i = 9; i >= 0 ; i--) {
			if (!tableFilesDAttente[i].isEmpty()) return tableFilesDAttente[i].remove();
		}
		throw new NoSuchElementException();
	}

	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	@Override
	public String toString() {
		return Arrays.toString(tableFilesDAttente) ;
	}

}


