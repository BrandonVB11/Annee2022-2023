import java.util.Arrays;

public class Ens1 extends EnsembleAbstrait {

	private boolean[] tabB; // e appartient à l'ensemble courant ssi tabE[e.val()] est à true.
	private int cardinal;

	public Ens1() {
		//TODO
		this.tabB = new boolean[MAX+1];
		this.cardinal = 0;
	}

	public boolean estVide() {
		//TODO
		return cardinal == 0;
	}

	public Elt unElement() {
		//TODO
		int a = 0;
		if (estVide()){
			throw new MathException();
		}
		for (int i = 0; i < tabB.length; i++) {
			if (tabB[i] == true){
				a = i;
				break;
			}
		}
		return new Elt(a);
	}

	public boolean contient(Elt e) {
		if (e == null)throw new IllegalArgumentException();
		return tabB[e.val()] ;
	}

	public void ajouter(Elt e) {
		//TODO
		if (e == null)throw new IllegalArgumentException("parametre invalide");
		if (!contient(e)){
			tabB[e.val()] = true;
			cardinal++;
		}
	}

	public void enlever(Elt e) {
		//TODO
		if (e == null)throw new IllegalArgumentException("parametre invalide");
		if (contient(e)){
			tabB[e.val()] = false;
			cardinal--;
		}
	}

	public int cardinal() {
		//TODO
		return this.cardinal;
	}

	public void complementer() {
		//TODO
		for(int i = 0; i < tabB.length; i++){
			if(tabB[i]){
			tabB[i] = false;
			}else {
				tabB[i] = true;
			}
			cardinal = tabB.length -1 - cardinal;
		}
	}

	public String toString() {
		// TODO
		// renvoie une chaine de caractere decrivant this en extension
		// ex: {1, 2, 3}
		String s = "{";
		for (int i = 0; i < tabB.length; i++) {
			if (tabB[i]){
				s += i + ", ";
			}
		}
		if (s.length() > 1){
			s = s.substring(0, s.length() - 2);
		}
		s += "}";
		return s;
	}

}
