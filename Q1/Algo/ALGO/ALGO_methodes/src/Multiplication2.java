/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Multiplication2 {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Tu vas faire des multiplications.");
		System.out.println("La valeur minimale des 2 nombres a multiplier est 0.");
		System.out.println("Tu peux choisir la valeur maximale de ces 2 nombres.");
		System.out.println("Cette valeur sera la meme pour tous les exercices");
		System.out.println("Pour chaque multiplication, tant que tu n'auras pas donne la bonne reponse, tu devras la recommencer");
		System.out.println("Le programme termine lorsque tu auras reussi 3 multiplications du premier coup");

		// A NE PAS COMPLETER

	}



	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;
		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}

	/**
	 * pose un problème de multiplication à l'utilisateur
	 * @return 1 si la réponse est bonne, 0 si elle ne l'est pas.
	 */
	public static int faireUneMultiplication() {
		int nombre1 = unEntierAuHasardEntre(1, 10);
		int nombre2 = unEntierAuHasardEntre(0, 10);
		int compteur = 0;
		System.out.println( nombre1+ " * "+nombre2+" = ");
		int response = scanner.nextInt();
		if (response == nombre1*nombre2){
			System.out.println("T'as de ");
			compteur++;
		}else {
			System.out.println( nombre1+ " * "+nombre2+" = ");
			response = scanner.nextInt();
			compteur = 0;
		}
		if (compteur == 3){
			System.out.println("Bravo t'as enchaine 3 bonne responses");
			return 1;
		}
		return 0;
	}
}
