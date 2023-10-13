import java.util.HashMap;
import java.util.HashSet;

public class FeteNationale{

	
	private HashMap<String, Noeud> mapNomNoeud;
	private Noeud premierNoir; 
	private Noeud premierJaune;
	private Noeud premierRouge;
	
	// N'ajoutez pas d'autres attributs
		

	// A ne pas changer	
	/**
	 * Le constructeur construit une liste qui contient 3 participants de 3 couleurs differentes
	 * @param nomNoir le nom du premier participant noir
	 * @param nomJaune le nom du premier participant jaune
	 * @param nomRouge le nom du premier participant rouge
	 */
	public FeteNationale(String nomNoir, String nomJaune, String nomRouge){
		mapNomNoeud = new HashMap<String, FeteNationale.Noeud>();
		premierNoir = new Noeud(nomNoir);
		premierJaune = new Noeud(nomJaune);
		premierRouge = new Noeud(nomRouge);
		premierNoir.suivant=premierJaune;
		premierJaune.precedent=premierNoir;
		premierJaune.suivant= premierRouge;
		premierRouge.precedent=premierJaune;
		mapNomNoeud.put(nomNoir, premierNoir);
		mapNomNoeud.put(nomJaune, premierJaune);
		mapNomNoeud.put(nomRouge, premierRouge);
	}
	
	 
	// A ne pas changer, va servir pour les tests
	public String toString(){
		String aRenvoyer = "";
		Noeud baladeur = premierNoir;
		int cpt = 0;
		while(baladeur!=null){
			aRenvoyer += " "+baladeur.nom;
			baladeur = baladeur.suivant;
			cpt++;
			if(cpt==100)
				return "boucle infinie";			
		}
		return aRenvoyer;
	}
	
	
	/**
	 * ajoute un participant dans la liste en fonction de sa couleur
	 * apres ajout la liste doit toujours etre triee par couleur
	 * @param nom le nom du participant a ajouter
	 * @param couleur la couleur du participant a ajouter (n,j ou r)
	 * @throws IllegalArgumentException si le nom est null ou vide et/ou si la couleur n'est pas valide 
	 * @throws DejaPresentException si le participant est deja present dans la liste
	 * 
	 */
	
	public void ajouterParticipant(String nom, char couleur){
		// TODO
		if (nom == null && nom.equals("")){
			throw new IllegalArgumentException();
		}
		if (couleur != 'n' && couleur!= 'j' && couleur != 'r'){
			throw new IllegalArgumentException();
		}
		if (mapNomNoeud.containsKey(nom)){
			throw new DejaPresentException();
		}

		if (couleur == 'n'){
			Noeud noir = new Noeud(nom);
			noir.suivant = premierNoir;
			premierNoir.precedent = noir;
			premierNoir = noir;
			mapNomNoeud.put(nom, noir);
		}else {
			if (couleur == 'j') {
				Noeud jaune = new Noeud(nom);
				jaune.suivant = premierJaune;
				premierJaune.precedent.suivant = jaune;
				premierJaune = jaune;
				mapNomNoeud.put(nom, jaune);
			}else {
				Noeud rouge = new Noeud(nom);
				rouge.suivant = premierRouge;
				premierRouge.precedent.suivant = rouge;
				premierRouge = rouge;
				mapNomNoeud.put(nom, rouge);
			}
		}
	}
	
	
	/**
	 * renvoie la couleur du participant
	 * @param nom le nom du participant recherche
	 * @return une couleur
	 * @throws IllegalArgumentException si le nom est null ou vide
	 * @throws NonPresentException si le participant ne se trouve pas dans la liste
	 */
	public char donnerCouleur(String nom){
		
		// TODO
		// Indication : partez du participant et revenez en arriere dans le chainage
		throw new NonPresentException();
	}
	
	

	// Classe interne Noeud
	private class Noeud{
		
		private Noeud precedent;
		private String nom;
		private Noeud suivant;
		
		public Noeud(String nom) {
			this.nom = nom;
		}

		public Noeud(Noeud precedent, String nom, Noeud suivant) {
			this.nom = nom;
			this.precedent = precedent;
			this.suivant = suivant;
		}		
	}
}
