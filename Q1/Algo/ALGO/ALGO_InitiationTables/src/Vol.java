/* 
 *  
 *  Classe permettant de memoriser et de traiter les coordonnees d'un vol
 *  
 *   
 * @author ... <----- !!!!!!! renseignez votre nom ici !!!!!
 * 
 *  
 */

/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Vol {

	private String nom; // nom du parapentiste
	private Coordonnees[] tableCoordonnees;

	// A NE PAS MODIFIER
	/**
	 * constructeur par recopie, le nom du parapentiste est Tommy
	 * @param tableCoordonnees la table de coordonnees a recopier
	 * @throws IllegalArgumentException si la table de coordonnees est null ou vide
	 */
	public Vol(Coordonnees[] tableCoordonnees) throws IllegalArgumentException{
		if(tableCoordonnees==null)
			throw new IllegalArgumentException();
		if(tableCoordonnees.length==0)
			throw new IllegalArgumentException();
		this.tableCoordonnees = new Coordonnees[tableCoordonnees.length];
		for (int i = 0; i < tableCoordonnees.length; i++) {
			this.tableCoordonnees[i]=tableCoordonnees[i];
		}
		this.nom = "tommy";
	}

	// A NE PAS MODIFIER
	/**
	 * constructeur par recopie
	 * @param nom le nom du parapentiste
	 * @param tableCoordonnees
	 * @throws IllegalArgumentException en cas de parametre invalide
	 */
	public Vol(String nom, Coordonnees[] tableCoordonnees) throws IllegalArgumentException{
		this(tableCoordonnees);
		if(nom==null)
			throw new IllegalArgumentException();
		if(nom.length()==0)
			throw new IllegalArgumentException();
		this.nom = nom;
	}


	// choix 1
	/**
	 * renvoie le lieu d'arrivee
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return les coordonnees du lieu d'arrivee
	 */
	public Coordonnees lieuArrivee(){
		// return tableau des coordonnées - 1
		return tableCoordonnees[tableCoordonnees.length - 1];
	}


	// choix 2
	/**
	 * verifie si le lieu de depart correspond au lieu d'arrivee
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return true si les coordonnees du lieu de depart sont identiques a celles du lieu d'arrivee, false sinon
	 */
	public boolean estUnTour(){
		// return un equals tableau des cordonnées - 1
		return tableCoordonnees[0].equals(tableCoordonnees[tableCoordonnees.length - 1]);
	}


	// choix 3
	/**
	 * renvoie le lieu survole apres n unites de temps
	 * (n = 0 --> lieu de depart)
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @param n le nombre d'unites de temps
	 * @return les coordonnees demandees ou null si un tel lieu n'existe pas car le vol n'est pas assez long
	 */
	public Coordonnees niemeLieu(int n){
		if (n > tableCoordonnees.length-1 || n < 0) {
			return null;
		}
		return tableCoordonnees[n];
	}
	

	// choix 4
	/**
	 * renvoie le lieu survole le plus au sud du parcours
	 * En cas d'ex-aequo, ce sera le premier lieu qui sera renvoye
	 * Le lieu le plus au sud est le lieu qui a la plus petite latitude
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return les coordonnees du lieu le plus au sud
	 */
	public Coordonnees lieuLePlusAuSud() {
		Coordonnees lieuLePlusAuSud = tableCoordonnees[0];
		for (Coordonnees coordonnees : tableCoordonnees) {
			if (coordonnees.getLatitude() < lieuLePlusAuSud.getLatitude()) {
				lieuLePlusAuSud = coordonnees;
			}
		}
		return lieuLePlusAuSud;
	}


	// choix 5
	/**
	 * renvoie le lieu survole le plus eloigne (a vol d'oiseau) du lieu de depart
	 * En cas d'ex-aequo, ce sera le premier lieu qui sera renvoye
	 * precondition (a ne pas verifier) la table de coordonnees n'est pas vide
	 * @return les coordonnees du lieu le plus eloigne du lieu de depart
	 */
	public Coordonnees lieuLePlusEloigne(){
		// declaration de la coordonnée maximum
		Coordonnees maximum = tableCoordonnees[0];
		// boucle for avec condition (de sortie)
		for (int i = 1; i < tableCoordonnees.length; i ++){
			if (tableCoordonnees[i].distance(tableCoordonnees[0])>maximum.distance(tableCoordonnees[0])){
				maximum = tableCoordonnees[i];
			}

		}
		return maximum;
	}
	
	
	// choix 6
	/**
	 * verifie si la cible a ete atteinte
	 * @param cible les coordonnees de la cible a atteindre
	 * @return true si on trouve au moins une fois des coordonnees d'un lieu survole identiques aux coordonnees de la cible, false sinon
	 * @throws IllegalArgumentException si la cible est null
	 */
	public boolean cibleAtteinte(Coordonnees cible){
		// condition de départ si aucune cible précisé
		if (cible == null)
			throw new IllegalArgumentException("la cible est null");
		// boucle for avec condition (de sortie)
		for (int i = 0; i < tableCoordonnees.length; i++) {
			if (tableCoordonnees[i].equals(cible)) {
				return true;
			}
		}
		return false;
	}


	// choix 7
	/**
	 * calcule le nombre de cibles atteintes
	 * L'ordre dans lequel les cibles sont atteintes n'a aucune importance
	 * Si une cible est atteinte plus d'une fois, elle n'est comptabilisee qu'une fois
	 * precondition (a ne pas verifier) la table des cibles ne contient pas de doublons
	 * @param cibles la table avec les coordonnees des cibles a atteindre
	 * @return le nombre demande
	 * @throws IllegalArgumentException si la table de cibles est null
	 */
	public int nombreCiblesAtteintes(Coordonnees[] cibles){
		// condition de départ si aucune cible précisé
		if (cibles == null)
			throw new IllegalArgumentException("la cible est null");
		// declaration de variable
		int nombreCibles = 0;
		// boucle for avec condition (de sortie)
		for (int j = 0; j < cibles.length; j++) {
			if (cibleAtteinte(cibles[j]) == true) {
				nombreCibles++;
			}
		}
		return nombreCibles;
	}


	// choix 8
	/**
	 * calcule la distance parcourue. 
	 * Cette distance sera obtenue en additionnant les distances des segments du parcours memorise.
	 * @return distance parcourue.
	 */
	public double distance() {
		// déclaration de la variable
		double distanceParcourue = 0;
		// boucle for
		for (int i = 0; i < tableCoordonnees.length - 1; i++) {
			distanceParcourue += tableCoordonnees[i].distance(tableCoordonnees[i + 1]);
		}
		return distanceParcourue;
	}


	


	// choix 9
	/**
	 * renvoie un booleen signalant si un meme lieu a ete survole plusieurs fois 
	 * Si le lieu d'arrivee correspond au lieu de depart, on considere que ce lieu a ete survole plusieurs fois
	 * @return true si un meme lieu a ete survole plusieurs fois, false sinon
	 */
	public boolean aSurvoleUnMemeLieu() {
		// Cette methode est proposee en DEFI!
		// pensez a utiliser la methode equals() de la classe Coordonnee
		
		//TODO
		// Ex defi !!!
		
		return false;
	}
	
	
	// choix 10
	/**
	 * verifie si toutes les cibles sont dans le parcours et dans le même ordre.
	 * @param cibles la table des cibles faisant partie du parcours
	 * @return true si le parcours a bien ete suivi, false sinon
	 * @throws IllegalArgumentException si la table de cibles est null
	 */
	public boolean parcoursSuivi(Coordonnees[] cibles){
		// Cette methode est proposee en DEFI!
		if(cibles==null)
			throw new IllegalArgumentException();
		
		// pensez a utiliser la methode equals() de la classe Coordonnee
	
		//TODO
		// Ex Defi !!!
		
		return false;
	}


	
	// DEFI (amelioration choix 9)
	/**
	 * verifie si le parapentiste a croise son propre
	 * parcours. Si le lieu d'arrivee correspond au lieu de depart, celui-ci ne
	 * sera pas considere comme un croisement. Vous utiliserez la methode
	 * segmentsCroises de la classe de Coordonnees .
	 * @return true s'il a croise au moins une fois son parcours, false sinon
	 */
	public boolean aCroiseSonParcours() {
		
		// Cette methode est proposee en DEFI!
		// cfr enonce
	
		return false;
	}
	
} 
