public class Poule {

    public static Tortue tortue = new Tortue();

    public static void main(String[] args) {
        tortue.accelerer();

        /* corps de la poule */
        for (int i = 0; i < 4; i++) {
            tortue.avancer(100);
            tortue.tournerADroite(90);
        }

        tortue.avancer(80);
        tortue.tournerAGauche(90);

        /* la tête de la poule */
        for (int i = 0; i < 360; i++) {
            tortue.avancer(0.75);
            tortue.tournerADroite(1);
        }

        for (int i=0;i<150; i++){
            tortue.avancer(0.75);
            tortue.tournerADroite(1);
        }

        /* bec de la poule */
        tortue.definirCouleur("rouge");
        tortue.tournerAGauche(30);
        tortue.avancer(25);
        tortue.tournerADroite(130);
        tortue.avancer(15);

        tortue.definirCouleur("noir");
        tortue.avancer(20);
        tortue.tournerADroite(20);
        tortue.avancer(10);
        tortue.tournerADroite(90);
        tortue.avancer(20);
        tortue.definirCouleur("blanc");

        /* oeil de la poule */
        for (int i = 0; i < 360; i++) {
            tortue.avancer(0.1);
            tortue.tournerAGauche(1);
        }

        tortue.tournerADroite(90);
        tortue.avancer(1);
        tortue.tournerADroite(90);
        tortue.definirCouleur("noir");
        tortue.avancer(50);
        tortue.tournerADroite(90);
        tortue.avancer(39);
        tortue.tournerADroite(90);
        tortue.definirCouleur("blanc");
        tortue.avancer(32);
        tortue.tournerAGauche(90);
        tortue.avancer(20);
        tortue.tournerADroite(90);

        for (int i=0;i<90; i++){
            tortue.avancer(0.75);
            tortue.tournerADroite(1);
        }

        /* chapeau de paille de la poule */
        tortue.definirCouleur("jaune");
        tortue.avancer(40);
        tortue.tournerAGauche(180);
        tortue.avancer(80);
        tortue.tournerADroite(180);
        tortue.avancer(20);
        tortue.tournerAGauche(90);

        for (int i=0;i<180; i++){
            tortue.avancer(0.4);
            tortue.tournerADroite(1);
        }

        tortue.definirCouleur("noir");
        tortue.avancer(145);

        /* nid de la poule */
        tortue.tournerADroite(90);
        tortue.definirCouleur("jaune");
        tortue.avancer(200);
        tortue.tournerAGauche(90);
        tortue.avancer(20);
        tortue.tournerAGauche(90);
        tortue.avancer(200);
        tortue.tournerAGauche(90);
        tortue.avancer(20);
    }
}
