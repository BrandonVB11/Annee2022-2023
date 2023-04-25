/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class SommeCinqEntiers {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int somme = 0;
        for (int i = 1; i < 6 ; i++) {
            System.out.println("Entrez l'entier "+ i +" : ");
            int entier = scanner.nextInt();
            somme = somme + entier;
        }
        System.out.println( "La somme est de "+somme);
    }
}
