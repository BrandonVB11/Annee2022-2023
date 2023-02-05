import java.util.Scanner;

public class t {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int response;
        do{
            response = scanner.nextInt();
        }while (response < 1 || response > 12);
        System.out.println(response);
    }
}

