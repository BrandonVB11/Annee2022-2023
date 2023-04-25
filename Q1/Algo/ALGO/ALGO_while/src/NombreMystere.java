/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class NombreMystere {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int nombreMystere = unEntierAuHasardEntre(0,100);
        int nombreATrouve= 0;

        while (nombreATrouve != nombreMystere){
            System.out.println("Entrez votre nombre entre 0 et 100");
            nombreATrouve = scanner.nextInt();
            if (nombreATrouve < nombreMystere){
                System.out.println("Il est plus petit que le nombre mystere");
            }else{
                if (nombreATrouve > nombreMystere){
                    System.out.println("Il est plus grand que le nombre mystere");
                }else{
                    if (nombreATrouve == nombreMystere){
                        System.out.println("Vous avez trouver le nombre mystere");
                    }
                }
            }
        }
        System.out.println("Felicitation ! Vous avez trouvé le nombre mystere qui etait "+nombreMystere);
    }

    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
