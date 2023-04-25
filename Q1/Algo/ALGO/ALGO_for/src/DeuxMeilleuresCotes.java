/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class DeuxMeilleuresCotes {
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 1; i < 6; i++) {
            System.out.print("Entrez la cote n°" + i + ": ");
            int cote = scanner.nextInt();
            if (cote>max1) {
                max2 = max1;
                max1 = cote;
            }else {
                if (cote>max2){
                    max2 = cote;
                }
            }
        }
        System.out.println("les 2 notes max sont "+max1+" et "+max2);
    }
}
