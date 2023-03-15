
// implementation de l'interface Ensemble via un tableau de booleens
/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class EnsembleTableBooleens<E> implements Ensemble<E>{
   
 	private boolean[] table; 
	private int taille;

	// capacite = nombre d'elements de l'univers
	public EnsembleTableBooleens(int capacite){
		table = new boolean[capacite];	
		taille = 0;		
	}

	public int taille(){
		// TODO
		return this.taille;
	}
	
	public boolean estVide(){
		// TODO
		if (taille == 0){
			return true;
		}
		return false;

	}

	public boolean contient(E element){
		// TODO
		return table[element.hashCode()];

	}

	public boolean ajouter(E element){
		// TODO
		if (contient(element)){
			return false;
		}
		table[element.hashCode()] = true;
		taille++;
		return true;
	}

	public boolean enlever(E element){
		// TODO
		if(!contient(element))
			return false;
		table[element.hashCode()] = false;
		taille--;
		return true;
	}

	}
