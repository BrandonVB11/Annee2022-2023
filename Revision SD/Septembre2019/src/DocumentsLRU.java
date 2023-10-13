import java.util.HashMap;


public class DocumentsLRU {

	private Noeud tete, queue; // sentinelle de tete et sentinelle de queue
	private HashMap<String, Noeud> map;
	private int taille; // nombre de documents actuellement dans la liste
	private int capacite; // nombre de documents max que peut contenir la liste
	
	/**
	 * initialise une liste vide avec une sentinelle de tete et une sentinelle de queue
	 * @param capacite nombre de documents max
	 * @throws IllegalArgumentException la capacite doit etre positive
	 */
	public DocumentsLRU(int capacite){
		if(capacite<=0){
			throw new IllegalArgumentException();
		}
		this.capacite=capacite;
		this.taille = 0; 	// au depart la liste ne contient aucun document
		tete = new Noeud(null,"bidonTete",null);
		queue = new Noeud(tete,"bidonQueue",null);
		tete.suivant = queue;
		this.map = new HashMap<String, Noeud>();
	}
	
	/**
	 * renvoie le noeud contenant le document passe en parametre ou null si le document n'est pas present dans la liste
	 * @param document le document recherche
	 * @return le noeud contenant le document ou null
	 */
	private Noeud donnerNoeud(String document){
		//TODO
		if (!map.containsKey(document))
			return null;
		Noeud doc = map.get(document);
		return doc;
	
	}
	
	/**
	 * supprime le noeud passe en parametre
	 * @param noeud le noeud a supprimer
	 */
	private void supprimer(Noeud noeud){
		//TODO
		if (map.containsKey(noeud.document));
		noeud.precedent.suivant = noeud.suivant;
		noeud.suivant.precedent = noeud.precedent;
		map.remove(noeud.document);
	}
	
	/**
	 * ajoute un noeud apres la sentinelle de tete avec le document passe en parametre
	 * @param document le document a ajouter
	 */
	private void ajouterMRU(String document){
		//TODO
		
	}
	
	/**
	 * supprime le noeud (et donc le document!) qui se trouve avant la sentinelle de queue si ce noeud existe
	 * precondition : taille > 0
	 */
	private void supprimerLRU(){
		//TODO
		
	}
	

	/**
	 * place le document passe en parametre dans la liste selon le mecanisme LRU
	 * @param document le document qui est ouvert
	 */
	public void ouvrirDocument(String document){
		//TODO
		
	}
	
	
	public String toString(){
		//TODO
		return null;
		
	}
	
	
	private class Noeud{
		private String document;
		private Noeud precedent;
		private Noeud suivant;
		
		public Noeud(Noeud precedent,String document,Noeud suivant) {
			super();
			this.precedent = precedent;
			this.document = document;	
			this.suivant = suivant;
		}
		
		
	}
}
