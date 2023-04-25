/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class CalculBMI {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez votre poids : ");
        int poids = scanner.nextInt();
        System.out.print(("Entrez votre taille : "));
        double taille = scanner.nextDouble();
        double bmi = poids/(taille*taille);
            if (bmi < 20){
                System.out.print("votre etat est mince");
                System.out.print(",");
                System.out.print("Votre bmi : "+ bmi);
            }else {
                if (bmi < 25){
                    System.out.print("votre etat est normale");
                    System.out.print(",");
                    System.out.print("Votre bmi : "+ bmi);
                }else {
                    if (bmi < 30){
                        System.out.print("votre etat est embonpoint");
                        System.out.print(",");
                        System.out.print("Votre bmi : "+ bmi);
                    }else {
                        System.out.print("votre etat est obèse");
                        System.out.print(",");
                        System.out.print("Votre bmi : "+ bmi);
                    }
                }
            }
        }
}
