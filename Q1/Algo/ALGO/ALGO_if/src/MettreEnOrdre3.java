/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class MettreEnOrdre3 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrez l'entier 1 : ");
        int entier1 = scanner.nextInt();
        System.out.println("Entrez l'entier 2 : ");
        int entier2 = scanner.nextInt();
        System.out.println("Entrez l'entier 3 : ");
        int entier3 = scanner.nextInt();
        if (entier1 < entier2 && entier1 < entier3 && entier2 < entier3){
            System.out.println("Vos entiers sont bien en ordre croissant");
            System.out.print(entier1);
            System.out.print(",");
            System.out.print(entier2);
            System.out.print(",");
            System.out.print(entier3);
        }else {
            System.out.println("Vos entiers ne sont pas en ordre croissant");
        }
    }
}
