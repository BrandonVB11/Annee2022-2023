/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class NombreNegatifPostifParmi10 {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int compteurNegatif = 0;
        int compteurPositif = 0;
        for (int i = 1; i < 11 ; i++) {
            System.out.println("Entrez l'entier "+ i +" : ");
            int entier = scanner.nextInt();
            if (entier < 0){
                compteurNegatif++;
            }else {
                compteurPositif++;
            }
        }
        System.out.println("Il y a "+compteurNegatif+" en entier negative");
        System.out.println("Il y a "+compteurPositif+" en entier positive");
    }
}

