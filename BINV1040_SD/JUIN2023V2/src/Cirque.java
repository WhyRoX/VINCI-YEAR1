import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Cirque {
	
	// suivez l'implementation imposee dans l'enonce

	private String[] tableReservations; //table des reservations
	private HashMap<String, HashSet<Integer>> mapEnfants; //cle = enfant, valeur = ensemble de ses places

	/**
	 * initialise un spectacle de cirque
	 * @param nombreTotalPlaces le nombre total de places disponibles
	 * @param tablePrenoms la table avec les prenoms des enfants du village
	 * @throws IllegalArgumentException si un des parametres ne permet pas d'initialiser le spectacle :
	 *         il faut au moins une place
	 *         la table des prenoms ne peut etre null ou vide
	 *         les prenoms ne peuvent etre null ou vides
	 *         il ne peut y avoir des doublons dans la table des prenoms
	 */
	public Cirque(int nombreTotalPlaces, String[] tablePrenoms){
		if (nombreTotalPlaces < 1) throw new IllegalArgumentException("il faut au moins une place");
		if (tablePrenoms == null || tablePrenoms.length <= 0) throw new IllegalArgumentException("la table des prenoms ne peut etre null ou vide");

		tableReservations = new String[nombreTotalPlaces];
		mapEnfants = new HashMap<>();

		for (String prenom : tablePrenoms) {
			if (prenom == null || prenom.isEmpty()) throw new IllegalArgumentException("les prenoms ne peuvent etre null ou vides");
			if (mapEnfants.containsKey(prenom)) throw new IllegalArgumentException("Pas de doublons");
			mapEnfants.put(prenom, new HashSet<>());
		}


		// pour verifier la presence de doublons dans la table des prenoms :
		// verifier si les ajouts dans le map se font bien
		// Dans un map, chaque cle est unique !

	}


	/**
	 * reserve une ou plusieurs places
	 * la reservation reussit si toutes les places demandees sont libres
	 * ATTENTION : PAS de reservation partielle (tout ou rien)
	 * @param prenom le prenom de l'enfant qui demande des places
	 * @param ensemblePlacesDemandees l'ensemble avec les numeros des places demandees
	 * @return true si la reservation a reussi, false sinon
	 * @throws IllegalArgumentException si le prenom est null ou vide
	 * 								 ou si l'enfant n'est pas un enfant du village
	 *                               ou si l'ensemble est null ou vide
	 *                               ou si l'enseble contient un numero de place inexistant
	 */
	public boolean reserver(String prenom, HashSet<Integer> ensemblePlacesDemandees){

		if (prenom == null || prenom.isEmpty())
			throw new IllegalArgumentException("le prenom est null ou vide");
		if (!mapEnfants.containsKey(prenom))
			throw new IllegalArgumentException("l'enfant n'est pas un enfant du village");
		if (ensemblePlacesDemandees == null || ensemblePlacesDemandees.isEmpty())
			throw new IllegalArgumentException("l'ensemble est null ou vide");

		for (Integer place : ensemblePlacesDemandees) {
			if (place < 0 || place > tableReservations.length)
				throw new IllegalArgumentException("l'enseble contient un numero de place inexistant");
			if (tableReservations[place] != null) return false;
			tableReservations[place]=prenom;
			mapEnfants.get(prenom).add(place);
		}
		for (int i : ensemblePlacesDemandees) {
			tableReservations[i]=prenom;
			mapEnfants.get(prenom).add(i);
		}

		return true;

	}


	/**
	 * renvoie une table contenant les places reservees par un enfant
	 * cette table doit etre triee selon l'ordre croissant des numeros de place
	 * la table sera de dimension 0, si l'enfant n'a aucune reservation
	 * @param prenom le prenom de l'enfant
	 * @return la table avec les places reservees par un enfant
	 * @throws IllegalArgumentException si le prenom est null ou vide
	 * 								 ou si l'enfant n'est pas un enfant du village
	 */
	public int[] placesReservees (String prenom) {
		if (prenom == null || prenom.isEmpty())
			throw new IllegalArgumentException("prennullouvide");
		if (!mapEnfants.containsKey(prenom))
			throw new IllegalArgumentException("l'enfant n'est pas un enfant du village");
		int[] reserved = new int[mapEnfants.get(prenom).size()];
		int i = 0;
		for (int x :mapEnfants.get(prenom)) {
			reserved[i]=x;
			i++;
		}
		Arrays.sort(reserved);

		return reserved;
		// Pour trier la table, utilisez la methode static sort() de la classe Arrays

	}


	/**
	 * renvoie la table des reservations et le map
	 */
	public String toString(){
		// vous pouvez modifier cette methode comme vous voulez
		// MAIS cette methode ne sera pas evaluee
		// ne perdez pas de temps sur des affichages!
		if(tableReservations ==null)
			return "attention table des reservations est null";
		if(mapEnfants==null)
			return "attention mapEnfants est null";
		return "table des reservations :\n"+Arrays.toString(tableReservations)+"\nmapEnfants :\n"+mapEnfants.toString();
	}
	
}
