/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class DessinFleur {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        for (int i = 0; i <4 ; i++) {
            tortue.accelerer();
            tortue.dessinerUnTriangle(100);
            tortue.tournerAGauche(90);
        }
    }
}
