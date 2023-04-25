/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Multiplication3Essais {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
	
		System.out.println("Entrainement aux multiplications. Voici une multiplication :");
		System.out.println("Tu as droit a 3 essais");
		int premierNombre = unEntierAuHasardEntre (0, 10);
		int secondNombre = unEntierAuHasardEntre (0, 10);
		System.out.println("Calculez : " + premierNombre + " x " + secondNombre + " = ");
		double responseCorrect = premierNombre*secondNombre;
		double responsePropose = 0;
		int nombreEssai = 3;

		while (responsePropose != responseCorrect && nombreEssai != 0){
			System.out.println("donner la response de ce calcul");
			responsePropose = scanner.nextDouble();
			if (responsePropose != responseCorrect){
				System.out.println("c est faux recommence");
				nombreEssai--;
			}
		}
		if (nombreEssai == 0){
			System.out.println("Vous avez utilisé vos 3 essais");
			System.out.println("La bonne response est "+responseCorrect);
		}else {
			System.out.println("Bravo !!!");
		}
		// A COMPLETER
	}

	// A NE PAS MODIFIER
	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}
	
}
