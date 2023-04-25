import java.util.Iterator;


public class SuiteTriee extends Suite {

	public SuiteTriee(){
		super();
	}

	public SuiteTriee corps(){
		return (SuiteTriee) super.corps();
	}

	public SuiteTriee(Suite s){
		super();
		Iterator<Elt> it = s.iterator();
		while(it.hasNext())
			this.ajouter(it.next());
	}

	public void ajouter(Elt x){
		if(this.estVide() || (x.val() < this.tete().val()))
			super.ajouter(x);
		else if(x.val() > this.tete().val()){
			this.couper();
			this.ajouter(x);  // appel r�cursif car this est une SuiteTri�e
			super.ajouter(this.tete());
		}
	}


	//TODO
	//Compl�ter en ajoutant les m�thodes qui doivent �tre modifi�es et celles qui
	//peuvent �tre am�lior�es.
	//Si une m�thode de la classe Suite ne peut pas s'appliquer � une suite tri�e,
	//vous ferez en sorte qu'elle lance une UnsupportedOperationException si on
	//l'appelle sur une suite tri�e.


}