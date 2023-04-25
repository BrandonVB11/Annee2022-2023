import java.util.Scanner;
/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Carre {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez la taille (n) : ");
        int n = scanner.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = n - 1; j > 0; j--){
                System.out.print("X");
            }
            System.out.println();
        }
    }
}
