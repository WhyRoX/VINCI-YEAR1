import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ServeurImpressions {

	// table de 10 files d'attente d'impression
	private ArrayDeque<DemandeImpression>[] tableFilesDAttente;

	/**
	 * construit une table avec 10 files d'attente d'impression
	 */
	@SuppressWarnings("unchecked")
	public ServeurImpressions() {
		// Initialisation du tableau de files d'attente
		tableFilesDAttente = new ArrayDeque[10];
		// Initialisation de chaque file d'attente
		for (int i = 0; i < 10; i++) {
			tableFilesDAttente[i] = new ArrayDeque<>();
		}
	}

	/**
	 * verifie si toutes les files d'attente sont vides
	 *
	 * @return true si toutes les files sont vides, false sinon
	 */
	public boolean serveurVide() {
		// Vérification si toutes les files d'attente sont vides
		for (ArrayDeque<DemandeImpression> file : tableFilesDAttente) {
			if (!file.isEmpty()) {
				return false; // Au moins une file n'est pas vide
			}
		}
		return true; // Toutes les files sont vides
	}

	/**
	 * ajoute la demande d'impression en fin de la file correspondante a sa priorite
	 *
	 * @param demande la demande a ajouter
	 * @throws IllegalArgumentException si la demande est null
	 */
	public void ajouter(DemandeImpression demande) {
		// Vérification de la nullité de la demande
		if (demande == null) {
			throw new IllegalArgumentException("La demande ne peut pas être null.");
		}
		// Ajout de la demande à la file correspondante à sa priorité
		int priorite = demande.getPriorite();
		tableFilesDAttente[priorite].add(demande);
	}

	/**
	 * retire la demande d'impression en tete de file de priorite la plus haute qui est non vide
	 *
	 * @return la demande d'impression qui a ete retiree
	 * @throws NoSuchElementException si aucune demande d impression dans le serveur
	 */
	public DemandeImpression retirer() {
		// Parcours des files d'attente de la plus haute priorité à la plus basse
		for (int i = 9; i >= 0; i--) {
			ArrayDeque<DemandeImpression> file = tableFilesDAttente[i];
			// Si la file n'est pas vide, retirer et retourner la première demande
			if (!file.isEmpty()) {
				return file.remove();
			}
		}
		// Si aucune demande d'impression n'est disponible, lever une exception
		throw new NoSuchElementException("Aucune demande d'impression dans le serveur.");
	}


	// A NE PAS MODIFIER
	// VA SERVIR POUR LES TESTS
	@Override
	public String toString() {
		return Arrays.toString(tableFilesDAttente);
	}

}
