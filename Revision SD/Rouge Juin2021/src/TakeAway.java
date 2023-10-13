import java.util.*;

public class TakeAway {
	
	private ArrayDeque<String> fileAttente;
	private HashSet<String> ensembleClientsActuellementDansFile;
	private HashMap<String, Reservation> mapClientReservation;	
	private ArrayList<Reservation> listeReservations;
	private int nombreMenusRestants;
	private final static int MAX_MENUS_CLIENT = 4;
	
	
	/**
	 * debute les reservations des menus d'un dimanche
	 * @param nombreMenusMisEnVente le nombre de menus mis en vente
	 * @throws IllegalArgumentException s'il n'y a pas au moins un menu a vendre 
	 */
	public TakeAway(int nombreMenusMisEnVente) {
		if(nombreMenusMisEnVente<=0)
			throw new IllegalArgumentException();
		this.nombreMenusRestants = nombreMenusMisEnVente;
		fileAttente = new ArrayDeque<String>();
		ensembleClientsActuellementDansFile = new HashSet<String>();
		mapClientReservation = new HashMap<String, Reservation>();
		listeReservations = new ArrayList<Reservation>();
	}

	
	public int getNombreMenusRestants() {
		return nombreMenusRestants;
	}
	
	/**
	 * ajoute, si possible, le client dans la file d'attente
	 * le client ne peut pas deja y etre
	 * si client a deja une reservation pour ce dimanche, le max de menus autorise n'est pas deja atteint
	 * il reste des menus a reserver
	 * @param client le client a ajouter
	 * @return true si l'ajout a pu se faire, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 */
	public boolean placerDansFileAttente(String client){
		//TODO
		if (client == null || client.equals("")){
			throw new IllegalArgumentException();
		}
		if (fileAttente.contains(client)){
			return false;
		}
		if (nombreMenusRestants < 0){
			return false;
		}
		if (mapClientReservation.containsKey(client)){
			if (mapClientReservation.get(client).getNombreMenusDemandes() == MAX_MENUS_CLIENT){
				return false;
			}
		}
		fileAttente.add(client);
		ensembleClientsActuellementDansFile.add(client);
		return true;
	}
		
	/**
	 * retire de la file d'attente le client de tete
	 * @return le client de tete ou null si la file est vide
	 */
	public String selectionnerClientSuivant(){
		//TODO
		String prochain = fileAttente.removeFirst();
		ensembleClientsActuellementDansFile.remove(prochain);
		return prochain;
	}
	
	/**
	 * ajoute, si possible, une nouvelle reservation  
	 * le nombre de menus restants doit etre suffisant pour satisfaire completement la reservation
	 * (il n'y a pas de reservation partielle)
	 * le nombre de menus demandes ne peut depasser le max autorise
	 * @param client le client qui fait la demande
	 * @param nombreMenusDemandes le nombre de menus demandes
	 * @return true si la reservation a pu etre faite, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 *  	ou si le nombre de menus demandes est <= 0
	 * @throws IllegalStateException si le client a deja fait une reservation pour ce dimanche  
	 */
	public boolean passerNouvelleReservation(String client, int nombreMenusDemandes){
		//TODO
		if (client == null || client.equals("")){
			throw new IllegalArgumentException();
		}
		if (nombreMenusDemandes <= 0){
			throw new IllegalArgumentException();
		}
		if (listeReservations.contains(client)){
			throw new IllegalStateException();
		}
		if (nombreMenusDemandes > nombreMenusRestants){
			return false;
		}
		if (mapClientReservation.containsKey(client)){
			if (mapClientReservation.get(client).getNombreMenusDemandes() == MAX_MENUS_CLIENT){
				return false;
			}
		}
		Reservation r = new Reservation(client,nombreMenusDemandes);
		mapClientReservation.put(client,r);
		listeReservations.add(r);
		return true;
	}	

	
	
	/**
	 * modifie, si possible, une reservation existante
	 * le nombre de menus restants doit etre suffisant
	 * (il n'y a pas de reservation partielle)
	 * le nombre de menus de la reservation apres ajout du nombre demande en plus ne peut depasser le max autorise
	 * @param client le client qui veut modifier sa reservation
	 * @param nombreMenusDemandesEnPlus le nombre de menus qui va s'ajouter au nombre de menus deja reserves
	 * @return true si la reservation a pu etre modifiee, false sinon
	 * @throws IllegalArgumentException si le client est null ou vide
	 *  	ou si le nombre de menus demandes est <= 0
	 * @throws IllegalStateException si le client n'a pas encore fait de reservation pour ce dimanche
	 */
	public boolean modifierReservation(String client,int nombreMenusDemandesEnPlus){
		//TODO
		if (client == null || client.equals("")){
			throw new IllegalArgumentException();
		}
		if (nombreMenusDemandesEnPlus > nombreMenusRestants){
			throw new IllegalArgumentException();
		}
		if(!listeReservations.contains(client)){
			throw new IllegalStateException();
		}
		if (mapClientReservation.containsKey(client)){
			if (mapClientReservation.get(client).getNombreMenusDemandes()+nombreMenusDemandesEnPlus == MAX_MENUS_CLIENT){
				return false;
			}
		}
		Reservation modifier = mapClientReservation.get(client);
		modifier.setNombreMenusDemandes(modifier.getNombreMenusDemandes()+nombreMenusDemandesEnPlus);
		mapClientReservation.put(client,modifier);
		return true;
	}	
	
	
	public String toString(){
		// cette methode ne sera pas evaluee
		// elle peut-etre interessante a appeler en cas de bug
		// n'hesitez pas a la completer
		return "le nombre de menus restants : "+ nombreMenusRestants 
				+ "\nla file d'attente : "+ fileAttente +  "\nles reservations " + listeReservations;
	}

}

		
	
	
	
	
	
