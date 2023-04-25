/**
 *
 * author Brandon Van Bellinghen
 *
 */
public class Deliberation {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);


    public static void main(String[] args) {
        double moyenneClasse = 0;
        for (int i = 0; i<25; i++){
            System.out.println("L'eleve n° : "+(i+1));
            moyenneClasse += methodeCotes(10)/25;
        }
        System.out.println("La moyenne de la classe est de : "+moyenneClasse+"/20.");

    }

    public static double methodeCotes(int nombreEleve){
        double moyenneElv = 0;
        int cote = 0;
        for (int i = 0; i < nombreEleve; i++){
            System.out.println("Entrez une nouvelle cote : ");
            cote += Utilitaires.lireReelComprisEntre(0, 20,"Il doit être compris entre 0 et 20");
            moyenneElv = cote/nombreEleve;
        }

        return moyenneElv;

    }

}