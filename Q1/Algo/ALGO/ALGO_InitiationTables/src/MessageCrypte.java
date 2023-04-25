/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class MessageCrypte {
	private char [] message;

	/**
	 * Consdtruit un nouveau message a partir d'une String
	 * @param message
	 */
	public MessageCrypte(String message){
		this.message = message.toCharArray();
	}

	public String toString(){
		return new String(this.message) ;
	}

	/**
	 * Cette methode implemente le code de Cesar: http://www.dcode.fr/chiffre-cesar
	 * Remplace le code de chaque caractere dans le message par son code plus le decalage
	 * en parametre. Par exemple si le message contient {'B', 'O', 'N', 'D' }
	 * et que le decalage est 2, apres remplacement, le message deviendra
	 * {'D', 'Q', 'P', 'F'}.
	 * Le decalage peut etre negatif.
	 * Un decalage de -2 sur le message {'L', 'C', 'O', 'G', 'U'} donnera
	 * {'J', 'A', 'M', 'E', 'S' }
	 *
	 * @param decalage
	 */
	public void decalerCaracteres(int decalage){
		// TODO
		for(int i=0; i<message.length; i++){
			message[i] += decalage;
		}
	}

	/**
	 * Permute chaque lettre a une position impaire avec celle qui la precede
	 *
	 * Par exemple le message {'C', 'O', 'O', 'T', 'U', 'P', 'S'}
	 * deviendra {'O', 'C', 'T', 'O', 'P', 'U', 'S'}
	 */
	public void permutation(){
		// Pensez a d'abord tester la methode precedente via la classe test
		// TODO

		for(int i=0; i<message.length; i++){
			// System.out.println("i = " + i);

			if(i == message.length-1) break;
			char temp = message[i+1];
			message[i+1] = message[i];
			message[i] = temp;
			i++;
		}
	}

	/**
	 * Echange chaque paire de caracteres du message de la facon suivante:
	 * Le premier est echange avec le dernier
	 * L'avant-dernier avec le 2eme
	 * L'avant-avant-dernier avec le 3eme
	 * etc.
	 * Par exemple le message {'R', 'U', 'O', 'J', 'N', 'O', 'B'}
	 * deviendra  {'B', 'O', 'N', 'J', 'O', 'U', 'R'}
	 */
	public void miroir(){
		// TODO
		for(int i=0; i<(message.length/2); i++){
			// System.out.println("i = " + i);
			char temp1 = message[i];
			char temp2 = message[(message.length-1) - i];
			// System.out.println("temp1 = " + temp1 + " temp2 = " + temp2);
			message[(message.length-1) - i] = temp1;
			message[i] = temp2;
		}
	}

	/**
	 * Crypte le message en implementant la methode de l'alphabet de substitution.
	 * Lisez la description du la substitution monoalphabetique ici:
	 * https://fr.wikipedia.org/wiki/Chiffrement_par_substitution
	 * On supposera que seule les lettre 'A' a 'Z' sont presentes le caractere espace n'est pas remplace
	 * alphabetDeSubstitution[0] contient la lettre de substitution pour le caractere 'A'
	 * alphabetDeSubstitution[1] contient la lettre de substitution pour le caractere 'B
	 * etc...
	 * @param alphabetDeSubstitution
	 */
	public void substitution(char []alphabetDeSubstitution){
		// TODO Defi!
		for(int i=0; i<message.length; i++){
			message[i] = alphabetDeSubstitution[i];
		}

	}





}
