
import java.util.ArrayDeque;
import java.util.HashSet;


public class Brocante {
	
	// TODO
	// suivez l'implementation imposee dans l'enonce
	
	
	
	public Brocante(char[] typesEmplacements){
		//TODO
		
	}
	
	/**
	 * reserve l'emplacement qui porte le numero passe en parametre au demandeur passe en parametre
	 * La reservation reussit si
	 *     l'emplacement est de type A
	 *     l'emplacement est libre
	 *     le demandeur n'a pas encore d'emplacement de type A
	 * @param demandeur le demandeur qui demande un emplacement
	 * @param numeroEmplacement le numero de l'emplacement souhaite
	 * @return true si la reservation a reussi, false sinon
	 * @throws IllegalArgumentException si le numero de l'emplacement n'existe pas
	 */
	public boolean reserverEmplacementA(String demandeur,int numeroEmplacement){
		//TODO
		return false;
		
	}
	

	
	/**
	 * attribue automatiquement un emplacement libre de type B au demandeur passe en parametre
	 * @param  demandeur le demandeur d'un emplacement
	 * @return le numero de l'emplacement attribue ou -1 si plus d'emplacement libre de type B
	 */
	public int attribuerAutomatiquementEmplacementB(String demandeur){
		//TODO
		return -1;
	
	}
	
	/**
	 * renvoie, sous forme d'une chaine de caracteres, tous les numeros des emplacements et leurs eventuels occupants
	 */
	public String toString(){	
		//TODO
		return null;
		
	}
	

}
