import java.util.HashMap;

/**
 *
 * @author Brandon Van Bellinghen											-------> METTEZ ICI VOS NOM ET PRENOM
 *
 *
 */

public class Entrepot {

	//TODO
	private HashMap<String , Societe> mapVehiculeSociete;
	private Hangar[] tableDeHangar;
	private HashMap<Integer, Societe> entrepot;
	private int nombreHangarsOccupes = 0;


	/**
	 * construit un entrepot contenant nombreHangars
	 * @param nombreHangars le nombre d'hangars
	 * @throws IllegalArgumentException si le nombre d'hangars est negatif ou nul
	 */
	public Entrepot(int nombreHangars) {
		if (nombreHangars <= 0) {
			throw new IllegalArgumentException();
		}

		mapVehiculeSociete = new HashMap<String, Societe>();
		tableDeHangar = new Hangar[nombreHangars];
		entrepot = new HashMap<Integer, Societe>();

		for (int i = 0; i < nombreHangars; i++) {
			Hangar hangar = new Hangar(i);
			tableDeHangar[i] = hangar;
		}

	}

	/**
	 * renvoie le nombre d'hangars libres
	 * @return le nombre d'hangars libres
	 */
	public int nombreHangarsLibres(){
		//TODO
		return tableDeHangar.length - nombreHangarsOccupes;

	}


	/**
	 * renvoie le nombre de societes presentes
	 * @return le nombre de societes presentes
	 */
	public int nombreSocietesPresentes(){
		//TODO
		return entrepot.size();
	}

	/**
	 * renvoie la societe dont le numero est passe en parametre
	 * @param numeroSociete le numero de la societe
	 * @return la societe recherchee ou null si aucune societe presente ne possede ce numero
	 */
	public Societe getSociete(int numeroSociete){
		//TODO
		return entrepot.get(numeroSociete);

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
		if (numeroSociete < 0) {
			return -1;
		}

		if (numeroSociete > tableDeHangar.length) {
			numeroSociete = numeroSociete % tableDeHangar.length;
		}

		if (nombreHangarsOccupes <= tableDeHangar.length) {
			if (!entrepot.containsKey(numeroSociete)) {
				Societe societe = new Societe(numeroSociete, nomSociete);
				entrepot.put(numeroSociete, societe);

			}

			int compteur = 0;
			int i = numeroSociete;

			Societe societe = entrepot.get(numeroSociete);

			while (compteur < tableDeHangar.length) {
				if (i == tableDeHangar.length) {
					i = 0;
				}

				if (tableDeHangar[i].getSociete() == null) {

					societe.ajouterHangar(i);
					tableDeHangar[i].setSociete(societe);
					nombreHangarsOccupes++;

					System.out.println(entrepot.toString());

					return i;
				}
				i++;
				compteur++;
			}
		}

		return -1;
		// Pour une meilleure repartition des hangars occupes dans l'entrepot, 
		// veuillez suivre les indications donnees dans l'enonce!

	}

	/**
	 * libere un hangar
	 *
	 * @param numeroHangar
	 * @return true si le hangar a ete liberer, false sinon
	 */
	public boolean libererHangar(int numeroHangar) {
		if (numeroHangar > tableDeHangar.length) {
			return false;
		}

		Societe societe = tableDeHangar[numeroHangar].getSociete();
		return entrepot.remove(societe.getNumeroSociete(), societe);
	}

	/**
	 * Ajoute un véhicule à la liste des véhicules de la société correspondante.
	 * Si la société n'est pas présente dans l'entrepôt, elle est créée.
	 *
	 * @param immatriculation l'immatriculation du véhicule à ajouter
	 * @param numeroSociete le numéro de la société à laquelle le véhicule appartient
	 */
	public void addVehicule(String immatriculation, int numeroSociete) {
		Societe societe;
		if (entrepot.containsKey(numeroSociete)) {
			societe = entrepot.get(numeroSociete);
		} else {
			societe = new Societe(numeroSociete, "Societe " + numeroSociete);
			entrepot.put(numeroSociete, societe);
		}
		mapVehiculeSociete.put(immatriculation, societe);
	}

	/**
	 * Vérifie si un véhicule est autorisé à entrer dans l'entrepôt.
	 * Un véhicule est autorisé s'il appartient à une société ayant un hangar dans l'entrepôt.
	 *
	 * @param immatriculation l'immatriculation du véhicule à vérifier
	 * @return true si le véhicule est autorisé, false sinon
	 */
	public boolean estAutorisé(String immatriculation) {
		if (!mapVehiculeSociete.containsKey(immatriculation)) {
			return false;
		}

		Societe societe = mapVehiculeSociete.get(immatriculation);
		return entrepot.containsValue(societe);
	}

	public void hangarHorsService(){

	}

	public void hangarenService(){

	}
}
