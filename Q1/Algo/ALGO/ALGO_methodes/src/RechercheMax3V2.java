/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class RechercheMax3V2 {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Entrez l'entier 1 : ");
		int entier1 = scanner.nextInt();
		System.out.println("Entrez l'entier 2 : ");
		int entier2 = scanner.nextInt();
		System.out.println("Entrez l'entier 3 : ");
		int entier3 = scanner.nextInt();
		max(entier1, entier2, entier3);
	}

	public static void max(int entier1, int entier2, int entier3) {
		if (entier1 > entier2 && entier1 > entier3) {
			System.out.println("le plus grand entier est " + entier1);
		} else {
			if (entier2 > entier3 && entier2 > entier1) {
				System.out.println("le plus grand entier est " + entier2);
			} else {
				if (entier3 > entier1 && entier3 > entier2) {
					System.out.println("le plus grand est " + entier3);
				}
			}
		}
	}
}
