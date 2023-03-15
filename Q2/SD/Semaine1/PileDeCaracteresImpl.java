// implementation d'une pile en utilisant un tableau de taille variable redimensionnable

/**
 * @author Brandon Van Bellinghen
 *
 */

public class PileDeCaracteresImpl implements PileDeCaracteres{

	private char[] table; 			// ne modifiez pas cet identifiant, va servir pour les tests
	private int nombreCaracteres; 	// taille logique
								  	//ne mofifiez pas cet identifiant, va servir pour les tests

	
	public PileDeCaracteresImpl(){
		table = new char[4];
		nombreCaracteres = 0;
	}

	
	public PileDeCaracteresImpl(int capacite){
		if (capacite <= 0)
			throw new IllegalArgumentException("la taille physique ne peut etre negative ou nulle");
		table = new char[capacite];
		nombreCaracteres = 0;
	}

	
	public int taille(){
		return nombreCaracteres;
	}

	
	public boolean estVide(){
		return nombreCaracteres == 0;
	}

	
	public void push(char c){
		if(table.length == nombreCaracteres){
			char[] temps = new char[table.length*2];
			for (int i = 0; i < table.length; i++) {
				temps[i] = table[i];
			}
			table = temps;
		}
		table[nombreCaracteres] = c;
		nombreCaracteres++;
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
	}


	public char pop() throws PileVideException{
		if (estVide()){
			throw new PileVideException();
		}
		char caracterePop = table[nombreCaracteres-1];
		nombreCaracteres--;
		return caracterePop;
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
	}


	public char sommet()throws PileVideException{
		if (estVide()){
			throw new PileVideException();
		}
		char sommet = table[nombreCaracteres-1];
		return sommet;
		// TODO
		// PENSEZ A CONSULTER LA JAVADOC (cfr Interface PileDeCaracteres)
	}

} 