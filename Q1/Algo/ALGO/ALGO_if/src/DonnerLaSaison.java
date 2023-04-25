/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class DonnerLaSaison {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Bievenue sur cette application qui vous dira la saison selon la date que vous allez donner.");
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println("Entrez le jour : ");
        int jour = scanner.nextInt();
        System.out.println("Entrez le mois : ");
        int mois = scanner.nextInt();
        if (mois < 3){
            System.out.print(jour);
            System.out.print("/");
            System.out.print(mois);
            System.out.print(" --> ");
            System.out.print("Hiver");
        }else {
            if (mois == 3){
                if (jour < 21){
                    System.out.print(jour);
                    System.out.print("/");
                    System.out.print(mois);
                    System.out.print(" --> ");
                    System.out.print("Hiver");
                }else {
                    System.out.print(jour);
                    System.out.print("/");
                    System.out.print(mois);
                    System.out.print(" --> ");
                    System.out.print("Printemps");
                }
            }
            if (mois >= 4 && mois < 6){
                System.out.print(jour);
                System.out.print("/");
                System.out.print(mois);
                System.out.print(" --> ");
                System.out.print("Printemps");
            }else {
                if (mois == 6){
                    if (jour < 21){
                        System.out.print(jour);
                        System.out.print("/");
                        System.out.print(mois);
                        System.out.print(" --> ");
                        System.out.print("Printemps");
                    }else {
                        System.out.print(jour);
                        System.out.print("/");
                        System.out.print(mois);
                        System.out.print(" --> ");
                        System.out.print("Eté");
                    }
                }
                if (mois >= 7 && mois < 9){
                    System.out.print(jour);
                    System.out.print("/");
                    System.out.print(mois);
                    System.out.print(" --> ");
                    System.out.print("Eté");
                }else {
                    if (mois == 9) {
                        if (jour < 21) {
                            System.out.print(jour);
                            System.out.print("/");
                            System.out.print(mois);
                            System.out.print(" --> ");
                            System.out.print("Eté");
                        } else {
                            System.out.print(jour);
                            System.out.print("/");
                            System.out.print(mois);
                            System.out.print(" --> ");
                            System.out.print("Automme");
                        }
                    }
                    if (mois >= 10 && mois < 12){
                        System.out.print(jour);
                        System.out.print("/");
                        System.out.print(mois);
                        System.out.print(" --> ");
                        System.out.print("Automme");
                    }else {
                        if (mois == 12){
                            if (jour < 21) {
                                System.out.print(jour);
                                System.out.print("/");
                                System.out.print(mois);
                                System.out.print(" --> ");
                                System.out.print("Automme");
                            }else{
                                System.out.print(jour);
                                System.out.print("/");
                                System.out.print(mois);
                                System.out.print(" --> ");
                                System.out.print("Hiver");
                            }
                        }
                    }
                }
            }
        }
    }
}

