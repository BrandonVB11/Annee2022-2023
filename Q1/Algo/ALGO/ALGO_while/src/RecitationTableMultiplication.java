/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class RecitationTableMultiplication {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Entrainement aux tables de multiplications.");
        int tableChoisi = unEntierAuHasardEntre (0, 10);
        System.out.println("Calculez la table de  "+ tableChoisi);
        double responseCorrect = 0;
        double responsePropose = 0;
        int compteur = 1;
        while (responsePropose == responseCorrect && compteur < 11){
            responseCorrect = compteur*tableChoisi;
            System.out.println("Calculez : " + compteur + " x " + tableChoisi + " = ");
            System.out.println("donner la response de ce calcul");
            responsePropose = scanner.nextDouble();
            if (responsePropose != responseCorrect){
                System.out.println("c est faux ! La bonne response est "+responseCorrect);
            }else {
                compteur++;
            }
        }
        System.out.println("Félicitation !");
    }


    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
