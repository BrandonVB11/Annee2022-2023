/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Multiplication3Entiers {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrainement aux multiplications. Voici un exercice :");

        int nombre1 = unEntierAuHasardEntre (0, 10);
        int nombre2 = unEntierAuHasardEntre (0, 10);
        int nombre3 = unEntierAuHasardEntre (0, 10);
        System.out.println("Calculez : " + nombre1 + " x " + nombre2 + " x "+ nombre3 +" = ");
        int responseCalcul = nombre1*nombre2*nombre3;
        System.out.println("Entrez votre reponse : ");
        int response = scanner.nextInt();
        if (response == responseCalcul){
            System.out.println("Bravo !!!");
        }else{
            System.out.println("La bonne response est "+responseCalcul);
        }

        // A COMPLETER
    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
