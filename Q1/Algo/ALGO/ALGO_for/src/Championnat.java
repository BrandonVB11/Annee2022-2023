/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Championnat {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        double coteMax = -Double.MAX_VALUE; // le plus petit reel
        double coteMin = 10;
        double totalCote = 0;
        double moyenneResultat = 0;
        for (int i = 1; i < 9 ; i++) {
            System.out.println("Entrez la côte du juge "+ i +" : ");
            double cote = scanner.nextInt();
            totalCote = totalCote + cote;
            if (cote > coteMax){
                coteMax = cote;
            }else {
                if (cote < coteMin){
                    coteMin = cote;
                }
            }
        }
        System.out.println("La note max est "+coteMax);
        System.out.println("La note min est "+coteMin);
        totalCote = totalCote-coteMax-coteMin;
        moyenneResultat = totalCote/6;
        if (moyenneResultat >= 8){
            System.out.println("Bravo !!! Vous passez au prochain tours avec une note de "+moyenneResultat);
        }else {
            System.out.println("Vous n'etes pas qualifiés pour la suite car votre note est en dessous de 8 ( "+moyenneResultat+" )");
        }
    }
}
