/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class MeilleurParmi10Eleve {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int meilleurNote = 0;
        int participants = 0;
        int cote2 = 0;
        int secondMeilleur = 0;
        for (int i = 0; i < 11; i++) {
            System.out.println("Entrez le résultat du participant n°"+i+" sur 100 :");
            int cote = scanner.nextInt();
            cote2 = cote;
            if (cote >meilleurNote){
                meilleurNote = cote;
                participants = i;
            }
            if (meilleurNote == cote2){
                secondMeilleur = cote2;
            }
        }
        if (meilleurNote == secondMeilleur){
            System.out.println("il y a eu un ex-æquo");
            System.out.println("Mais Le meilleur partcipant est " + participants + " est la meilleur note est " + meilleurNote + "/100");
        }else {
            System.out.println("Le meilleur partcipant est " + participants + " est la meilleur note est " + meilleurNote + "/100");
        }
    }
}
