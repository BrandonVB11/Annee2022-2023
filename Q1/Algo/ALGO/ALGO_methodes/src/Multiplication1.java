/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Multiplication1{

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Tu vas faire 5 multiplications");
		System.out.println("La valeur minimale des nombres a multiplier est 0, la valeur maximale est 10");
		System.out.println("Pour chaque multiplication, tu as droit a 1 essai");
		System.out.println("Tu recevras la reponse, si tu la rate");
		System.out.println("A la fin, le programme affichera le nombre de bonnes reponses.");

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
	public static int faireUneMultiplication(){
		int nombre1 = unEntierAuHasardEntre(0, 10);
		int nombre2 = unEntierAuHasardEntre(0, 10);
		System.out.print(nombre1 + " * " + nombre2 + " = ");
		int reponse = scanner.nextInt();
		if(reponse == nombre1*nombre2){
			return 1;
		}
		System.out.println("Non, la bonne réponse est " + (nombre1*nombre2));
		return 0;
	}
}