import java.util.Arrays;
/**
 *
 * @author Van Bellinghen Brandon
 *
 */
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
		double moyennne = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			moyennne += tableDesTemperatures[i];
		}
		return moyennne/tableDesTemperatures.length;
	}


	/**
	 * recherche la temperature la plus basse
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus basse
	 */
	public double temperatureMin(){
		double min = 0;
		for (int i = 0; i <tableDesTemperatures.length ; i++) {
			if (tableDesTemperatures[i] < min){
				min = tableDesTemperatures[i];
			}
		}
		return min;
	}


	/**
	 * calcule le nombre de temperatures negatives (< 0)
	 * @return le nombre de jours de gel
	 */
	public int nombreJoursDeGel(){
		int nombreDeJourGel = 0;
		for (int i = 0; i <tableDesTemperatures.length ; i++) {
			if (tableDesTemperatures[i] < 0){
				nombreDeJourGel++;
			}
		}
		return nombreDeJourGel;
	}


	/**
	 * remplit une table avec les numeros des jours de gel
	 * @return une table avec les jours de gel, la dimension de cette table correspond a ce nombre de jours
	 */
	public int[] joursDeGel(){
		int[] joursGel = new int[nombreJoursDeGel()];
		int j = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] < 0) {
				joursGel[j] = i + 1;
				j++;
			}
		}
		return joursGel;
	}


	/**
	 * verifie si toutes les temperatures sont positives
	 * @return true si toutes les temperatures sont positives, false sinon
	 */
	public boolean toutesPositives(){
		for (int i = 0; i <tableDesTemperatures.length ; i++) {
			if (tableDesTemperatures[i] <= 0){
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
	public boolean contientAuMoinsUneTemperatureSuperieureA(double temperature){
		for (int i = 0; i <tableDesTemperatures.length ; i++) {
			if (tableDesTemperatures[i] > temperature){
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
	public double temperatureMax(){
		double max = 0;
		for (int i = 0; i <tableDesTemperatures.length ; i++) {
			if (max < tableDesTemperatures[i]){
				max = tableDesTemperatures[i];
			}
		}
		return max;
	}


	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus elevee
	 * @return une table avec les jours de haute temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMax(){
		double tempxMax = temperatureMax();
		int nbrTempMax = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] == tempxMax) {
				nbrTempMax++;
			}
		}
		int[] tableDesJoursTempMax = new int[nbrTempMax];
		nbrTempMax = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] == tempxMax) {
				tableDesJoursTempMax[nbrTempMax] = i+1;
				nbrTempMax++;
			}
		}
		return tableDesJoursTempMax;
	}





	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus basse
	 * @return une table avec les jours de basse temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMin(){
			double tempxMin = temperatureMin();
			int nbrTempMin = 0;
			for (int i = 0; i < tableDesTemperatures.length; i++) {
				if (tableDesTemperatures[i] == tempxMin) {
					nbrTempMin++;
				}
			}
			int[] tableDesJoursTempMin = new int[nbrTempMin];
			nbrTempMin = 0;
			for (int i = 0; i < tableDesTemperatures.length; i++) {
				if (tableDesTemperatures[i] == tempxMin) {
					tableDesJoursTempMin[nbrTempMin] = i+1;
					nbrTempMin++;
				}
			}
			return tableDesJoursTempMin;
		}
	}


