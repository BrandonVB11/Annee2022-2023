import java.util.Scanner;
/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class TriangleV2 {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
