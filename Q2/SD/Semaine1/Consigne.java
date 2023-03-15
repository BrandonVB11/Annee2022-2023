/**
 * @author Brandon Van Bellinghen
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
		if(nombreCasiers <= 0){
			throw new IllegalArgumentException();
		}
		casiersLibres = new PileImpl<>(nombreCasiers);
		tousLesCasiers = new Casier[nombreCasiers];
		for (int i = 0; i < nombreCasiers; i++) {
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
		return casiersLibres.taille() != 0;
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
		if(!resteUnCasierLibre()){
			return -1;
		}
		Casier casier = casiersLibres.pop();
		casier.setMotDePasse(motDePasse);
		return casier.getNumero();
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
		if (numeroCasier < 0 || numeroCasier >= tousLesCasiers.length){
			return false;
		}
		if (tousLesCasiers[numeroCasier].getMotDePasse().equals("")) {
			return false;
		}
		if (tousLesCasiers[numeroCasier].getMotDePasse().equals(motDePasse)) {
			Casier a = tousLesCasiers[numeroCasier];
			casiersLibres.push(a);
			a.setMotDePasse("");
			return true;
		}
		return false;
	}

}
