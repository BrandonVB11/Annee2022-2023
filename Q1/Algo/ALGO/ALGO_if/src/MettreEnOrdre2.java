/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class MettreEnOrdre2 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrez l'entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.println("Entrez l'entier 2 : ");
        int entier2 = scanner.nextInt();
        if (entier1 < entier2){
            System.out.println("Voici l'ordre croissant de ces 2 entiers");
            System.out.print(entier1);
            System.out.print(",");
            System.out.print(entier2);
        }else {
            System.out.println("Voici l'ordre croissant de ces 2 entiers");
            System.out.print(entier2);
            System.out.print(",");
            System.out.print(entier1);
        }
    }
}
