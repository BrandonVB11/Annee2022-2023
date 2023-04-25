/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class SommeCentEntiers {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int somme = 0;
        int entier = 0;
        for (int i = 1; i < 101; i++) {
            System.out.println("L'entier  est "+ i);
            entier++;
            somme = somme + entier;
        }
        System.out.println( "La somme est de "+somme);
    }
}
