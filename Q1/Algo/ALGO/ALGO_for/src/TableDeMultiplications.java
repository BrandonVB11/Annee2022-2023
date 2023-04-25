/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class TableDeMultiplications {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int multiplication = 0;
        System.out.println("Entrez le numero de la table que vous voulez : ");
        int entier2 = scanner.nextInt();
        for (int i = 0; i < 11  ; i++) {
            multiplication = i*entier2;
            System.out.println(i+" x "+entier2+" = "+multiplication);
        }

    }
}
