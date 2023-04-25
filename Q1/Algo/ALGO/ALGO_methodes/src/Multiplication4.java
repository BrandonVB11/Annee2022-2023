/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Multiplication4 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire des multiplications de nombres compris entre 0 et 10");
		System.out.println("Tu peux choisir le nombre d'essais que tu auras pour chaque multiplication");
		System.out.println("Ce nombre sera le meme pour toutes les multiplications");
		System.out.println("Tu recevras la reponse, si tu ne l'as toujours pas trouvee au terme du nombre d'essais accorde");
		System.out.println("Apres chaque multiplication, le programme te demandera si tu en veux une autre");
	
		//A NE PAS COMPLETER
	}


	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}

	/**
	 * genere une multiplication entre 2 entiers
	 * entier 2 est choisi par utilisateur
	 * @return la multiplication qu on doit faire entre 2 entiers
	 */
	public static int faireMultiplication(){
		int entier1 = unEntierAuHasardEntre(1,10);
		int entier2 = scanner.nextInt();
		int reponse;
		int correct;
		correct=entier1*entier2;
		System.out.println(entier1+"*"+entier2);
		reponse=scanner.nextInt();
		System.out.println("resoud ces calcules");
		while (reponse!=correct) {
			System.out.println("c est faux , la bonne repose est "+correct);
			if (correct == reponse) {
				System.out.println("Bravo !");
			}
		}
		return entier1*entier2;
	}
}
