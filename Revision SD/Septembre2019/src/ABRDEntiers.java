import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ABRDEntiers implements Iterable<Integer>{

	private NoeudEntier racine;


	public ABRDEntiers () {
		racine = null ;
	}
	
	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	// si le parametre est 1, construit l'arbre de l'enonce 
	public ABRDEntiers(int i){
		if(i==1){
			NoeudEntier g2 = new NoeudEntier(new NoeudEntier(1,2),3,1,null);
			NoeudEntier g1 = new NoeudEntier(g2, 7, 3, new NoeudEntier(8, 1));
			NoeudEntier d1 = new NoeudEntier(new NoeudEntier(13,1), 15, 2, null);
			racine = new NoeudEntier(g1,12,2,d1);		
		}
	}

	public boolean estVide () {
		return racine == null;
	}

	// A NE PAS MODIFIER!!!
	// VA SERVIR POUR LES TESTS!!!
	public String toString () {
		return "[ "+toString(racine)+" ]";
	}

	private String toString (NoeudEntier n) {
		if (n==null) 
			return "";
		if (n.gauche == null && n.droit == null) 
			return ""+n.entier+"("+n.nombreOccurrences+"x)";
		if (n.gauche == null) 
			return " [ ] "+n.entier+"("+n.nombreOccurrences+"x)"+" [ "+toString(n.droit)+" ] ";
		if (n.droit == null) 
			return " [ "+toString(n.gauche)+" ] "+n.entier+"("+n.nombreOccurrences+"x)"+ " [ ] ";
		return " [ "+toString(n.gauche)+" ] "+n.entier+"("+n.nombreOccurrences+"x)"+" [ "+toString(n.droit)+" ] ";		
	}
	

	/**
	 * verifie si le nombre d'occurrences de l'entier passe en parametre > 1
	 * @param entier l'entier recherche
	 * @return true si l'entier est present et possede plus d'1 occurrence, false sinon 
	 */
	public boolean contientPlusieurs(int entier){
		//TODO
		return false;
	}
	
	
	
	/**
	 * supprime une fois le plus grand entier contenu dans l'arbre
	 * @throws ABRVideException si l'arbre est vide
	 */
	public void supprimeMax(){
		//TODO
		//contrainte : vous ecrirez cette methode de facon recursive!
	
	}
	



	public Iterator<Integer> iterator () {
		return new IterateurDec(this);
	}

	// classe interne
	private class NoeudEntier {

		private int entier; 
		private int nombreOccurrences;
		private NoeudEntier gauche;
		private NoeudEntier droit;

		
		private NoeudEntier (int entier) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
			this.nombreOccurrences=1;
		}
		
		

		private NoeudEntier(int entier, int nombreOccurrences) {
			this.entier = entier;
			this.gauche = null;
			this.droit = null;
			this.nombreOccurrences = nombreOccurrences;
		}

		private NoeudEntier(NoeudEntier gauche,int entier, NoeudEntier droit) {
			super();
			this.entier = entier;
			this.gauche = gauche;
			this.droit = droit;
			this.nombreOccurrences=1;
		}

		private NoeudEntier(NoeudEntier gauche,int entier, int nombreOccurrences,
				NoeudEntier droit) {
			super();
			this.entier = entier;
			this.nombreOccurrences = nombreOccurrences;
			this.gauche = gauche;
			this.droit = droit;
		}
		
		

	}
	
	
	private class IterateurDec implements Iterator<Integer> {

		private ArrayDeque<Integer> fileDEntiers;

		public IterateurDec(ABRDEntiers a) {
			fileDEntiers = new ArrayDeque<Integer>();
			remplirFile(a.racine);
		}

		
		private void remplirFile(NoeudEntier n) {
			//TODO
			//Suivez bien les indications de l'enonce
			
		}

		
		public boolean hasNext() {
			//TODO
			return false;
			
		}

		public Integer next() {
			//TODO
			return 0;
		
		}
	}


}