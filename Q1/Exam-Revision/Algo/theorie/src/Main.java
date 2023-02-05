import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        for (int i = 0; i <= 9; i++) {
            if (i < 2)
                System.out.println('v');
            else if (i > 8)
                System.out.println('j');
            else if (i < 4)
                System.out.println('r');
            else
                System.out.println('b');
        }

        for (char i = 'A'; i <= 'D'; i++) {
            System.out.println(i);
            for (int j = 1; j <= 4; j++) {
                System.out.println(j);
            }

        }


    }
}
