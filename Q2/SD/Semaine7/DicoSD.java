import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class DicoSD {
	private LinkedList<String> listURL;
	private HashMap<String, LinkedList<String>> dicoSD;


	// Au depart le dico est vide
	public DicoSD() {
		dicoSD = new HashMap<String, LinkedList<String>>();
	}

	/**
	 * ajout dans le dico une association sd-url si cette association n'est pas encore presente
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si cette association n'etait pas encore presente dans le dico, false sinon
	 */
	public boolean ajouter(String sd, String url){
		if (dicoSD.containsKey(sd)){
			listURL = dicoSD.get(sd);
			if (!listURL.contains(url)) {
				listURL.addLast(url);
				dicoSD.put(sd, listURL);
				return true;
			}
			return false;
		}
		else {
			listURL = new LinkedList<String>();
			listURL.addLast(url);
			dicoSD.put(sd, listURL);
			return true;
		}
	}

	/**
	 * verifie si la structure de donnees se trouve dans le dico
	 * cette structure de donnees doit posseder au moins une url!
	 * @param sd
	 * @return true si sd est present, false sinon
	 */
	public boolean contient(String sd){
		if (dicoSD.containsKey(sd)){
			listURL = dicoSD.get(sd);
			if (listURL.size()>0){
				return true;
			}
		}
		return false;
	}


	/**
	 * renvoie tous les urls associes a la structure de donnees passee en parametre
	 * @param sd
	 * @return une chaine de caracteres avec les urls selon le format : [urlPile1, urlPile2] ou [] si la structure de donnees n'existe pas
	 */
	public String lesURLs(String sd){
		if (dicoSD.containsKey(sd)){
			listURL = dicoSD.get(sd);
			return  listURL.toString();
		}
		return "[]";
	}

	/**
	 * supprime dans le dico l'association sd-url si celle-ci est presente
	 * @param sd une structure de donnees
	 * @param url une url vers un site internet
	 * @return true si l'association etait presente dans le dico, false sinon
	 */
	public boolean supprimer(String sd, String url){
		if (dicoSD.containsKey(sd)){
			listURL = dicoSD.get(sd);
			if (listURL.contains(url)) {
				listURL.remove(url);
				dicoSD.put(sd, listURL);
				return true;
			}
		}
		return false;
	}

}
