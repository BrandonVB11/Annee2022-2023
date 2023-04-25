/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class DessinCarresEmboités {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        double longueur = 20;
        tortue.accelerer();
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 4; j++) {
                tortue.avancer(longueur);
                tortue.tournerADroite(90);
            }
            longueur += 5;
        }
    }
}
