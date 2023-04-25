/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Multiplication3 {
	
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("Au depart la valeur minimale des nombres a multiplier est 1 et la valeur maximale est 10");
		System.out.println("Ces 2 bornes augmenteront de 10 a chaque multiplication reussie");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
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
		int max1 = 10;
		int max2 = 10;
		int nombre1 = unEntierAuHasardEntre(1,max1);
		int nombre2 = unEntierAuHasardEntre(0,max2);
		int compteur = 0;
		System.out.println( nombre1+ " * "+nombre2+" = ");
		int response = scanner.nextInt();
		while (compteur < 5)
		if (response == nombre1*nombre2){
			System.out.println("T'as la bonne response");
			compteur++;
			max1 += 10;
			max2 += 10;
		}
		return 0;
	}

}
