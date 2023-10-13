import java.util.Iterator;

/**
 * implementation de l'interface ListeSimple avec une liste simplement chainee 
 * 
 * @author 
 * 
 */
public class ListeSimpleImpl<E> implements ListeSimple<E> {
	
	private Noeud tete;
	private int taille;
	

	public ListeSimpleImpl(){
		tete = null;
		taille=0;
	}

	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public ListeSimpleImpl(Object[] table) {
		if(table==null)
			throw new IllegalArgumentException();
		this.taille = table.length;
		for (int i = table.length-1; i>=0; i--) {
			E element = (E)table[i];
			this.tete=new Noeud(element,tete);
		}	
	}
	
	// A NE PAS MODIFIER --> POUR LES TESTS!!!
	public String toString(){
		String aRenvoyer="";
		Noeud baladeur=tete;
		int cpt = 0;
		while(baladeur!=null) {
			cpt++;
			if(cpt>taille){
				aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
				return aRenvoyer;
			}
			aRenvoyer+=" "+baladeur.element;
			baladeur=baladeur.suivant;
		}
		return aRenvoyer;
	}

	
	public int taille(){
		return taille;
	}
		
	public boolean estVide(){
		return taille==0;
	}
	
	// renvoie l element contenu dans le noeud de tete
	public E premier()throws ListeVideException{
		if (estVide()){
			throw new ListeVideException();
		}
		return tete.element;
		// TODO

	}


	// insere un nouveau noeud en tete de liste avec l element 
	public void insererEnTete(E element) {
		Noeud noeud = new Noeud(element,tete);
		if (estVide()){
			tete = noeud;
			taille++;
		}else {
			noeud.suivant = tete;
			tete = noeud;
			taille++;
		}
		// TODO

	}
	

	// verifie la presence d un noeud contenant l element passe en parametre
	public boolean contient(E element){
		// TODO
		Noeud baladeur = tete;
		while (baladeur != null){
			if (baladeur.element.equals(element)){
				return true;
			}
			baladeur = baladeur.suivant;
		}
		return false;
	}


	// insere un nouveaud noeud apres le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean insererApres(E element, E elementAInserer){
		// TODO
		Noeud baladeur = tete;
		Noeud nouveau = new Noeud(elementAInserer,tete);
		while (baladeur != null){
			if (baladeur.element.equals(element)){
				nouveau.suivant = baladeur.suivant;
				baladeur.suivant = nouveau;
				taille++;
				return true;
			}
			baladeur = baladeur.suivant;
		}
		return false;
	
	}


	//supprime le noeud contenant la premiere occurrence de l'element passe en parametre
	public boolean supprimer(E element){
		// TODO
		Noeud baladeur = tete;
		Noeud precedent = null;
		while(baladeur != null){
			if(baladeur.element.equals(element)){
				if(precedent == null){
					tete = tete.suivant;
				}else{
					precedent.suivant = baladeur.suivant;
				}
				taille--;
				return true;
			}
			precedent = baladeur;
			baladeur = baladeur.suivant;
		}
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		return new IterateurImpl();
	}
	
	
	private class Noeud{
		private E element;
		private Noeud suivant;

		public Noeud(E element, Noeud suivant){
			this.element = element;
			this.suivant = suivant;
		}
	}
	
	
	private class IterateurImpl implements Iterator{
		
		private Noeud noeudNext;
		
	
		// Au depart le noeud "next" est le noeud de tete
		private IterateurImpl() {
			noeudNext =  tete;
		}
		
		@Override
		// verifie si le noeud "next" est null
		public boolean hasNext() {
			// TODO
			if (noeudNext != null){
				return true;
			}
			return false;
		}

		
		@Override
		// renvoie l element qui se trouve dans le noeud "next"
		// le noeud "next" passe au noeud suivant
		public E next() {	  
		   // TODO
			if(hasNext()) {
				E element = noeudNext.element;
				noeudNext = noeudNext.suivant;
				return element;
			}
		   // pensez a consulter la JAVADOC de la classe Iterator!!!
		   return null;
		}

		
		@Override
		// A NE PAS COMPLETER : Les suppressions sont interdites
		public void remove() {
			throw new UnsupportedOperationException();			
		}
		
	}

}
