/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class GamesOfIPL {

    public static void main(String[] args) {

        System.out.println("Bienvenue au combat entre CogneDur et FrappeFort");

        Guerrier cogneDur = new Guerrier("CogneDur",25);
        Guerrier frappeFort = new Guerrier("FrappeFort",25);

        int pointsDeVieCogneDur = 25;
        int pointsDeVieFrappeFort = 25;

        while(cogneDur.estVivant() && frappeFort.estVivant()){

            int de = unEntierAuHasardEntre(1,6);
            System.out.println("CogneDur inflige "+de+" points de dégâts à FrappeFort.");
            pointsDeVieFrappeFort = pointsDeVieFrappeFort-de;
            if(pointsDeVieFrappeFort <= 0){
                System.out.println("Il reste 0 point de vie à FrappeFort.");
                System.out.println("FrappeFort est mort. Paix à son âme, il est mort en brave");
            }else{
                System.out.println("Il reste "+pointsDeVieFrappeFort+ " points de vie à FrappeFort.");

                de = unEntierAuHasardEntre(1,6);
                System.out.println("FrappeFort inflige "+de+" points de dégâts à CogneDur.");
                pointsDeVieCogneDur = pointsDeVieCogneDur-de;
                if(pointsDeVieCogneDur<=0){
                    System.out.println("Il reste 0 point de vie à CogneDur.");
                    System.out.println("CogneDur est mort. Paix à son âme, il est mort en brave");
                }
                else{
                    System.out.println("Il reste "+pointsDeVieCogneDur+ " points de vie à CogneDur.");
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