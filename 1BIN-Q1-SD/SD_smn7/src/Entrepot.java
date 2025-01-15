import java.util.HashMap;

/**
 *
 * @author Enes Yumer
 *
 *
 */

public class Entrepot {

	private Hangar[] tableHangars;
	private HashMap<Integer, Societe> societesMap;
	private int nombreHangarsOccup = 0;


	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		if(nombreHangars<=0)
			throw new IllegalArgumentException();
		societesMap = new HashMap<>();
		tableHangars = new Hangar[nombreHangars];
		for (int i = 0; i < nombreHangars; i++) {
			tableHangars[i] = new Hangar(i);
		}

	}

	/**
	 * renvoie le nombre d'hangars libres
	 * @return le nombre d'hangars libres
	 */
	public int nombreHangarsLibres(){
		return tableHangars.length - nombreHangarsOccup;

	}


	/**
	 * renvoie le nombre de societes presentes
	 * @return le nombre de societes presentes
	 */
	public int nombreSocietesPresentes(){

		return societesMap.size();

	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		if(societesMap.containsKey(numeroSociete)){
			return societesMap.get(numeroSociete);
		}
		return null;

	}

	/**
	 * attribue un hangar a la societe passee en parametre
	 * Si l'attribution a pu se faire :
	 * la societe est enregistree comme presente (si pas encore presente)
	 * le hangar lui est ajoute
	 * @param numeroSociete le numero de la societe
	 * @param nomSociete le nom de la societe
	 * @return le numero du hangar attribue ou -1 s'il n'y en a plus de libre
	 */
	public int attribuerHangar(int numeroSociete, String nomSociete) {
		if(nombreHangarsLibres()==0){
			return -1;
		}
		Societe societeTemp = new Societe(numeroSociete, nomSociete);
		if(!societesMap.containsKey(numeroSociete)) {
			societesMap.put(numeroSociete, societeTemp);
		}
		int numeroHangar;
		if (numeroSociete >= tableHangars.length) numeroHangar = numeroSociete % tableHangars.length;
		else numeroHangar = numeroSociete;

		while (tableHangars[numeroHangar].getSociete() != null) {
			if (numeroHangar >= tableHangars.length - 1) {
				numeroHangar = -1;
			}
			numeroHangar++;
		}
		societesMap.get(numeroSociete).ajouterHangar(numeroHangar);
		tableHangars[numeroHangar].setSociete(societeTemp);
		nombreHangarsOccup++;

		return numeroHangar;
		// Pour une meilleure repartition des hangars occupes dans l'entrepot,
		// veuillez suivre les indications donnees dans l'enonce!

	}
	/*
	public String listeHangars(int numeroSociete) {
		if (societeMap.get(numeroSociete) == null)
			return "La societe n'existe pas ! ";
		return societeMap.get(numeroSociete).lesHangars();
	}*/
	



}
