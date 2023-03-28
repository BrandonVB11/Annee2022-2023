/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class GestionRallyeAutomobile {

    private static MonScanner scanner = new MonScanner("pilotes.txt");

    public static void main(String[] args) {
        System.out.println("*********************************************");
        System.out.println("Programme de gestion d'un Rallye Automobile");
        System.out.println("********************************************");

        System.out.println("Entrez le nombre de pilote :");

        int nbrePilote = 0;
        nbrePilote = scanner.nextInt();
        String[] tablePilote = new String[nbrePilote];
        for (int i = 1; i <= nbrePilote; i++) {
            System.out.println("Donnez le nom du pilote " + i+" :");
            String nomPilote = scanner.next();
            System.out.println();
            tablePilote[i-1] = nomPilote;
        }

        RallyeAutomobile course = new RallyeAutomobile(tablePilote);

        int choix = 0;

        do {
            System.out.println("======================================");
            System.out.println("Bienvenue au Rallye de Belgique 2023");
            System.out.println("======================================");
            System.out.println("1 -> Afficher toute la course");
            System.out.println("2 -> Afficher le pilote en tête");
            System.out.println("3 -> Enregistrer un dépassement");
            System.out.println("4 -> Retirer un pilote de la course");
            System.out.println("5 -> Donner la position d’un pilote");
            System.out.println("6 -> Faire franchir la ligne d’arrivée au pilote de tête");
            System.out.println("7 -> Remettre un pilote dans la course (après un autre pilote)");
            System.out.println("8 -> Afficher les pilotes hors course");
            System.out.println("9 -> Afficher le classement\n");
            System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    course.afficherCourse();
                    break;
                case 2:
                    course.afficherPremier();
                    break;
                case 3:
                    System.out.println("Entrez le pilote qui va depasser");
                    String piloteDepasser = scanner.next();
                    System.out.println();
                    course.piloteDepasser(piloteDepasser);
                    break;
                case 4:
                    System.out.println("Entrez le pilote qu se retire");
                    String piloteRetire = scanner.next();
                    System.out.println();
                    course.abandonnerLaCourse(piloteRetire);
                    break;
                case 5:
                    System.out.println("Entrez le pilote que vous voulez savoir la position");
                    String positionPilote = scanner.next();
                    System.out.println();
                    course.donnerPosition(positionPilote);
                    break;
                case 6:
                    if (course.franchirLigne() == 0){
                        return;
                    }
                    break;
                case 7:
                    System.out.println("Entrez le pilote que vous voulez remettre en Course");
                    String piloteRemis = scanner.next();
                    System.out.println();
                    course.remettrePilote(piloteRemis);
                    break;
                case 8:
                    course.afficherLesAbandons();
                    break;
                case 9:
                    course.afficherClassement();
                    break;
                default:
                    break;
            }

        } while (choix >= 1 && choix <= 9);
    }
}
