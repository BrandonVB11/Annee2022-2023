/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class NombreNegatifsParmi10 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int compteur = 0;
        for (int i = 1; i < 11 ; i++) {
            System.out.println("Entrez l'entier "+ i +" : ");
            int entier = scanner.nextInt();
            if (entier < 0){
                compteur++;
            }
        }
        System.out.println("Il y a "+compteur+" en entier negative");
    }
}
