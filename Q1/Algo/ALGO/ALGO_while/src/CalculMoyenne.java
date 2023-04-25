/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class CalculMoyenne {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        double totalCote = 0;
        char arret = 0;
        double moyenne = 0;
        int compteur = 0;
        while (arret != 'N' && arret != 'n'){
            System.out.println("Entrez votre côte :");
            int cote = scanner.nextInt();
            totalCote = totalCote+cote;
            compteur++;
            System.out.println("Vous avez d'autres notes ? (Y et y OU N et n)");
            arret = scanner.next().charAt(0);
        }
        moyenne = totalCote/compteur;
        System.out.println("Votre moyenne est de "+moyenne);
    }
}
