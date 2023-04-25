/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Utilitaires {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);


    /**
     * genere un entier compris entre les 2 valeurs passees en parametre
     *
     * @param valeurMinimale la valeur minimale de l'entier genere
     * @param valeurMaximale la valeur maximale de l'entier genere
     * @return l'entier genere
     */
    public static int unEntierAuHasardEntre(int valeurMinimale, int valeurMaximale) {
        double nombreReel;
        int resultat;
        nombreReel = Math.random();
        resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
        return resultat;
    }

    /**
     * lit un nombre reel positif ou nul
     *
     * @param message le message affiche en cas de lecture invalide
     * @return un nombre reel positif
     */
    public static double lireReelPositif(String message) {
        double reelPositif = scanner.nextDouble();
        while (reelPositif < 0) {
            System.out.println("Attention " + message);
            System.out.print("Recommencez : ");
            reelPositif = scanner.nextDouble();
        }
        return reelPositif;
    }

    /**
     * lit un nombre reel strictement positif
     *
     * @return un nombre reel positif
     */
    public static double lireReelStrictementPositif(String message) {
        double reelStrictementPositif = scanner.nextDouble();
        while (reelStrictementPositif <= 0) {
            System.out.println("Attention " + message);
            System.out.print("Recommencez : ");
            reelStrictementPositif = scanner.nextDouble();
        }
        return reelStrictementPositif;
    }

    /**
     * lit un nombre reel compris entre les 2 valeurs passees en parametre
     *
     * @param messageErreur le message affiche en cas de lecture invalide
     * @param min     le plus petit reel accepte
     * @param max     le plus grand reel accepte
     * @return un nombre reel compris entre 2 bornes
     */
    public static double lireReelComprisEntre(double min, double max,String messageErreur) {
        double reponse = 0;
        do {
            reponse = scanner.nextDouble();
            if (reponse < min || reponse > max) {
                System.out.println(messageErreur);
            }
        } while (reponse < min || reponse > max);
        return reponse;
    }

    /**
     * lit le caractere o ou n
     *
     * @return le caractere o un n
     */
    public static char lireOouN() {
        char reponseUtilisateur = 'x';
        while (reponseUtilisateur != 'o' && reponseUtilisateur != 'O' && reponseUtilisateur != 'n' && reponseUtilisateur != 'N') {
            reponseUtilisateur = scanner.next().charAt(0);
            if (reponseUtilisateur != 'o' && reponseUtilisateur != 'O' && reponseUtilisateur != 'n' && reponseUtilisateur != 'N') {
                System.out.println("La reponse donner n'est ni \"O\" ni \"N\"...Repetez l'operation");
            }
        }
        return reponseUtilisateur;
    }

    /**
     * empeche l'utilisateur d'ecrire 0 en lui demendant de changer d'entier
     * @return le chiffre choisi par l'utilisateur
     */
    public static int lireEntierNonNul() {
        int entier = 0;
        do {
            entier = scanner.nextInt();
            if (entier == 0) {
                System.out.println("La division par 0 et mathematiquement impossible dans ce cas.\nIntroduisez un autre entier :");
            }
        } while (entier == 0);
        return entier;
    }

    /**
     * empeche l'utilisateur d'ecrire 0 en lui demendant de changer d'entier
     * @return le chiffre choisi par l'utilisateur
     */
    public static int lireEntierNonNul2() {
        int entier = 0;
        do {
            entier = scanner.nextInt();
            if (entier == 0) {
                System.out.println("Il faut au moins 1.\nIntroduisez un autre entier :");
            }
        } while (entier == 0);
        return entier;
    }

    /**
     * Impose a l'utilisateur l'utilisation de chiffre positif
     */
    public static int lireEntierPositif() {
        int entier = 0;
        do {
            entier = scanner.nextInt();
            if (entier < 0) {
                System.out.println("Impossible d'introduire un entier negatif ici!.\nIntroduisez un autre entier :");
            }
        } while (entier < 0);
        return entier;
    }


    /**
     * Impose a l'utilisateur d'introduire un chiffre plus grand ou egale a 1
     * @param message Message en cas de saisi invalide
     */

    public static int lireEntierStrictementPositif(String message) {
        int entier;
        do {
            entier = scanner.nextInt();
            if (entier < 1) {
                System.out.println(message);
            }
        } while (entier < 1);
        return entier;
    }
}
