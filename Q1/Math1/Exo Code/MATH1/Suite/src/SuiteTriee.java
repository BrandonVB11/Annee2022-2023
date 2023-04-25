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
			this.ajouter(x);  // appel récursif car this est une SuiteTriée
			super.ajouter(this.tete());
		}
	}


	//TODO
	//Compléter en ajoutant les méthodes qui doivent être modifiées et celles qui
	//peuvent être améliorées.
	//Si une méthode de la classe Suite ne peut pas s'appliquer à une suite triée,
	//vous ferez en sorte qu'elle lance une UnsupportedOperationException si on
	//l'appelle sur une suite triée.


}