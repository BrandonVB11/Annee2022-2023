/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class EnsembleVoituresAutorisees{

	// TODO
	// Utilisez un objet de la classe EnsembleTableHashing
	EnsembleTableHashing<Voiture>[] table;
	int taille=0;
	int cap = 500;
	// construit un ensemble vide mais pouvant contenir jusqu'a 500 voitures
	public EnsembleVoituresAutorisees(){
		// TODO
		this.table = new EnsembleTableHashing[cap];
		for(int i =0; i< cap; i++) {
			EnsembleTableHashing<Voiture> e = new EnsembleTableHashing<Voiture>(cap);
			table[i] = e;
		}
		this.taille=0;
	}


	/**
	 * ajoute la voiture dans l ensemble des voitures autorisees
	 * @param voiture la voiture autorisee
	 * @return true si la voiture etait pas encore presente, false sinon
	 */
	public boolean ajouterVoiture(Voiture voiture){
		if(voiture ==null) throw new IllegalArgumentException();
		if(voitureAutorisee(voiture)) return false;
		table[Math.abs(voiture.hashCode())%cap].ajouter(voiture);
		taille++;
		return true;
		// TODO
 	
	}

	/**
	 * retire la voiture de l ensemble des voitures autorisees
	 * @param voiture la voiture non autorisee
	 * @return true si la voiture etait presente, false sinon
	 */
	public boolean retirerVoiture(Voiture voiture){
		if(voiture == null) throw new IllegalArgumentException();
		if(!voitureAutorisee(voiture)) return false;
		table[Math.abs(voiture.hashCode())%cap].enlever(voiture);
		taille--;
		return true;
		// TODO
	}

	
	/**
	 * verifie si la voiture est presente dans l ensemble des voitures autorisees
	 * @param voiture la voiture a verifier
	 * @return true si la voiture est presente, false sinon
	 */
	public boolean voitureAutorisee(Voiture voiture){
		if(voiture == null) throw new IllegalArgumentException();
		return table[Math.abs(voiture.hashCode())%cap].contient(voiture);
		// TODO
	}




}