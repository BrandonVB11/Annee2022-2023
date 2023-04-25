/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class CoteExamen {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Entrez votre cote ALGO: ");
        double cote1 = scanner.nextDouble();
        System.out.print("Entrez votre cote APOO : ");
        double cote2 = scanner.nextDouble();
        if (cote1 > cote2){
            System.out.println("Votre meilleur note est votre cote ALGO");
            System.out.print(cote1);
            System.out.print("/");
            System.out.print("20");
        }else {
            if (cote2 > cote1){
                System.out.println("Votre meilleur note est votre cote APOO");
                System.out.print(cote2);
                System.out.print("/");
                System.out.print("20");
            }else {
                if (cote2 == cote1){
                    System.out.println("Vos 2 cotes sont egaux");
                    System.out.print(cote2);
                    System.out.print("/");
                    System.out.print("20");
                    System.out.print(",");
                    System.out.print(cote1);
                    System.out.print("/");
                    System.out.print("20");
                }
            }
        }
    }
}
