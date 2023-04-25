import java.util.Scanner;
/**
 *
 * @author Van Bellinghen Brandon
 *
 */

public class Losange {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();

        //j'ai cree des variables en plus seulment pour mieux visualiser le code et mieux le comprendre, je sais que certaines de celle ci ne sont pas utiles
        int j, e;
        int x = 0;
        int c = n;

        //1ere partie du losange
        for (int i = n; i > 0; i--) {
            for (j = i; j > 0; j--) {
                System.out.print("X");
            }
            for (int k = 1; k <= (n - i); k++) {
                System.out.print(" ");
            }
            for (j = 1; j <= x; j++) {
                System.out.print(' ');
            }
            for (int a = 1; a <= c; a++) {
                System.out.print('X');
            }
            System.out.println();
            x++;
            c--;
        }

        //2eme partie du losange
        for (int i = 1; i <= n; i++) {
            for (int y = 1; y <= i; y++) {
                System.out.print("X");
            }
            for (e = 1; e <= (n - i) * 2; e++) {
                System.out.print(' ');
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("X");
            }
            System.out.println();
        }

    }
}