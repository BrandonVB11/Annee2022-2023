import java.util.IllegalFormatCodePointException;

/**
 * @author 
 *
 */

public class Consigne{
	private Pile<Casier> casiersLibres;
	private Casier[] tousLesCasiers;
	
	/**
	 * construit une consigne de gare avec tous les casiers libres au depart
	 * @param nombreCasiers le nombre de casier de la consigne
	 * @throws IllegalArgumentException si le nombre de casiers est negatif ou nul
	 */
	public Consigne(int nombreCasiers){
		// TODO
		if (nombreCasiers <= 0){
			throw new IllegalArgumentException();
		}
		this.tousLesCasiers = new Casier[nombreCasiers];
		this.casiersLibres = new PileImpl<>();

		for (int i = 1; i < nombreCasiers; i++) {
			Casier c = new Casier(i);
			casiersLibres.push(c);
			tousLesCasiers[i] = c;
		}
		
	}

	/**
	 * verifie la presence d'un casier libre
	 * @return true s'il reste au moins un casier de libre, false sinon
	 */
	public boolean resteUnCasierLibre() {
		// TODO
		if (casiersLibres.estVide()){
			return false;
		}
		return true;
	}

	
	/**
	 * attribue un casier libre
	 * @param motDePasse le mot de passe qui permettra de liberer le casier
	 * @return le numero du casier attribue ou -1 s'il n'y en a plus de libre
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public int attribuerCasierLibre(String motDePasse) {
		// TODO
		if (motDePasse == null || motDePasse.equals("")){
			throw new IllegalArgumentException();
		}
		if (casiersLibres.estVide()){
			return -1;
		}
		Casier libre = casiersLibres.pop();
		libre.setMotDePasse(motDePasse);
		return libre.getNumero();
	}

	
	/**
	 * libere un casier
	 * @param numeroCasier le numero de casier qui doit etre libere
	 * @param motDePasse le mot de passe a comparer avec le mot de passe du casier
	 * @return true si le numero de casier existe et le mot de passe est le bon, false sinon
	 * @throws IllegalArgumentException si le mot de passe est vide ou null
	 */
	public boolean libererCasier(int numeroCasier, String motDePasse) {
		// TODO
		if (motDePasse == null || motDePasse.equals("")){
			throw new IllegalArgumentException();
		}
		Casier aLibere = new Casier(numeroCasier);

		return false;
	}

}
