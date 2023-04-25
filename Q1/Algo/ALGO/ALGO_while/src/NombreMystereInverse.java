/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class NombreMystereInverse {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);;

    public static void main(String[] args) {



        System.out.println("Faite deviner votre nombre à l'ordianteur ");

        int min = 1;
        int max = 100;
        int chance = 0;


        char plusOuMoin = 'O';

        while (plusOuMoin != '=') {
            if (chance > 10) {
                System.out.println("J'ai marre de jouer");
                System.out.println("T'as gagné");
                plusOuMoin = '=';
            } else {
                int choix = unEntierAuHasardEntre(min, max);
                chance++;


                System.out.println("Le choix de l'ordinateur est " + choix);
                System.out.println("Faites + si c'est plus ou - si c'est moin");
                plusOuMoin = scanner.next().charAt(0);

                if (plusOuMoin == '-') {
                    max = choix - 1;
                } else if (plusOuMoin == '+') {
                    min = choix + 1;
                } else if (plusOuMoin == '=') {
                    System.out.println("Vous avez trouvé l'ordinateur à trouver le nombre mystère");
                    System.out.println("Il a fallu " + chance + " suppositions pour le trouver");
                }
            }
        }
    }


    public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
        double nombreReel;
        int resultat;

        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }
}
