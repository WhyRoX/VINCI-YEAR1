
import java.util.Arrays;

public class Temperatures {

	private String mois;
	private double[] tableDesTemperatures;
	
	// A NE PAS MODIFIER
	public Temperatures(String mois, double [] tableARecopier) {
		if(tableARecopier == null)
			throw new IllegalArgumentException();
		if(tableARecopier.length == 0)
			throw new IllegalArgumentException();
		this.mois = mois;
		this.tableDesTemperatures = new double[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			this.tableDesTemperatures[i]=tableARecopier[i];
		}
	}

	// A NE PAS MODIFIER
	public String toString(){
		String aRenvoyer = "temperatures du mois de " + this.mois + " : \n";
		return aRenvoyer + Arrays.toString(tableDesTemperatures);
	}


	/**
	 * calcule la moyenne des temperatures
	 * @return la moyenne
	 */
	public double moyenne(){
		double somme = 0;
		for (double temp : tableDesTemperatures) {
			somme += temp;
		}
		return somme / tableDesTemperatures.length;
	}


	/**
	 * recherche la temperature la plus basse
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus basse
	 */
	public double temperatureMin(){
		double tempMin = Double.MAX_VALUE;
		for (double temp : tableDesTemperatures)
			if (temp < tempMin)
				tempMin = temp;
		return tempMin;
	}


	/**
	 * calcule le nombre de temperatures negatives (< 0)
	 * @return le nombre de jours de gel
	 */
	public int nombreJoursDeGel(){
		int count = 0;
		for (double temp : tableDesTemperatures)
			if (temp < 0)
				count++;
		return count;
	}


	/**
	 * remplit une table avec les numeros des jours de gel
	 * @return une table avec les jours de gel, la dimension de cette table correspond a ce nombre de jours
	 */
	public int[] joursDeGel(){

		int[] joursDeGelArray = new int[nombreJoursDeGel()];
		System.out.println(Arrays.toString(joursDeGelArray));
		int index = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] < 0){
				joursDeGelArray[index] = i+1;
				System.out.println(Arrays.toString(joursDeGelArray));
				index++;
			}
		}

		return joursDeGelArray;
	}


	/**
	 * verifie si toutes les temperatures sont positives
	 * @return true si toutes les temperatures sont positives, false sinon
	 */
	public boolean toutesPositives(){
		for (double temperature : tableDesTemperatures) {
			if (temperature < 0) {
				return false;
			}
		}
		return true;
	}


	/**
	 * verifie la presence d'au moins une temperature negative (<0)
	 * @return true si la table contient au moins une temperature negative, false sinon
	 */
	public boolean contientAuMoinsUnJourDeGel(){
		return !toutesPositives();
	}


	/**
	 * verifie la presence d'au moins une temperature superieure a la temperature passee en parametre
	 * @param temperature la temperature qui sert a cette recherche
	 * @return true si la table contient au moins une temperature superieure a temperature, false sinon
	 */
	public boolean contientAuMoinsUneTemperatureSuperieureA(double temperature) {
		for (double temp : tableDesTemperatures) {
			if (temp > temperature) {
				return true;
			}
		}
		return false;
	}



	/**
	 * recherche la temperature la plus elevee
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus elevee
	 */
	public double temperatureMax() {
		double max = tableDesTemperatures[0];
		for (double temperature : tableDesTemperatures) {
			if (temperature > max) {
				max = temperature;
			}
		}
		return max;
	}


	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus elevee
	 * @return une table avec les jours de haute temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMax() {
		double maxTemperature = temperatureMax();
		int count = 0;
		for (double temperature : tableDesTemperatures) {
			if (temperature == maxTemperature) {
				count++;
			}
		}
		int[] joursMaxArray = new int[count];
		int index = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] == maxTemperature) {
				joursMaxArray[index] = i;
				index++;
			}
		}
		return joursMaxArray;
	}





	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus basse
	 * @return une table avec les jours de basse temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMin() {
		double minTemperature = temperatureMin();
		int count = 0;
		for (double temperature : tableDesTemperatures) {
			if (temperature == minTemperature) {
				count++;
			}
		}
		int[] joursMinArray = new int[count];
		int index = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] == minTemperature) {
				joursMinArray[index] = i;
				index++;
			}
		}
		return joursMinArray;
	}

}
