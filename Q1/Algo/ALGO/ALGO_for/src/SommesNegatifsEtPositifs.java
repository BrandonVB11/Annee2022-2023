/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class SommesNegatifsEtPositifs {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int sommePositif = 0;
        int sommeNegative = 0;
        for (int i = 1; i < 6 ; i++) {
            System.out.println("Entrez l'entier " + i + " : ");
            int entier = scanner.nextInt();
            if (entier >= 0) {
                sommePositif = sommePositif + entier;
            } else {
                sommeNegative = sommeNegative + entier;
            }
        }
        System.out.println("La somme des entiers positif est "+sommePositif);
        System.out.println("La somme des entiers negative est "+sommeNegative);
    }
}
