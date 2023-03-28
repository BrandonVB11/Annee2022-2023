public class Ens2 extends EnsembleAbstrait {

	private Elt[] elements; // contient les elements de l'ensemble. Il ne peut pas y avoir de doublon.
	private int cardinal;

	public Ens2() {
		//TODO
		this.elements = new Elt[MAX];
		this.cardinal = 0;
	}

	public boolean estVide() {
		if (cardinal != 0){
			return false;
		}
		return true;
	}
	
	public Elt unElement() {
		int a = 0;
		if (this.estVide()){
			throw new MathException("Ensemble est vide");
		}
		return elements[a];
	}

	public boolean contient(Elt e) {
		if (e == null)throw new IllegalArgumentException("parametre invalide");
		if (estVide())return false;
		for (int i = 0; i <cardinal ; i++) {
			if (elements[i].val() == e.val()){
				return true;
			}
		}
		return false;
	}

	public void ajouter(Elt e) {
		if (e == null)throw new IllegalArgumentException("parametre invalide");
		if (contient(e))return;
		elements[cardinal] = e;
		cardinal++;
	}

	public void enlever(Elt e) {
		if (e == null)throw new IllegalArgumentException("parametre invalide");
		if (contient(e)){
			for (int i = 0; i <cardinal ; i++) {
				if (elements[i].equals(e)){
					elements[i]=elements[cardinal-1];
					cardinal--;
				}
			}
		}
	}

	public int cardinal() {
		//TODO
		return cardinal;
	}

	public void complementer() {
		//TODO;

	}

	public String toString() {
		//TODO
		return null ;
	}

}
