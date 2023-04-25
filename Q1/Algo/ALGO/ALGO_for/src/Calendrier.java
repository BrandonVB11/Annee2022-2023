/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class Calendrier {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Entrez votre nombre de jour ( soit 28,29,30,31 )");
        int nombreJour = scanner.nextInt();
        System.out.println("Entrez le jour quand le mois commence ( 1 = lundi , etc)");
        int premierJour = scanner.nextInt();
        System.out.println(" Lu " + "  " + " Ma" + "  " + " Me " + "  " + " Je " + "  " + " Ve " + "  " + " Sa " + "  " + " Di ");
        for (int i = 1; i < nombreJour + 1; i++) {
            if (premierJour == 1) {
                System.out.print("   " + i + "  ");
                if (i == 7)
                    System.out.print("\n");
                if (i == 14)
                    System.out.print("\n");
                if (i == 21)
                    System.out.print("\n");
                if (i == 28)
                    System.out.print("\n");
            } else {
                if (premierJour == 2) {
                    System.out.print("  " + "  " + i + " ");
                    if (i == 6)
                        System.out.print("\n");
                    if (i == 13)
                        System.out.print("\n");
                    if (i == 20)
                        System.out.print("\n");
                    if (i == 27)
                        System.out.print("\n");
                } else {
                    if (premierJour == 3) {
                        System.out.print("  " + "  " + "  " + "  " + i + "  ");
                        if (i == 5)
                            System.out.print("\n");
                        if (i == 12)
                            System.out.print("\n");
                        if (i == 19)
                            System.out.print("\n");
                        if (i == 26)
                            System.out.print("\n");
                    } else {
                        if (premierJour == 4) {
                            System.out.print("  " + "  " + "  " + "  " + "  " + "  " + i + "  ");
                            if (i == 4)
                                System.out.print("\n");
                            if (i == 11)
                                System.out.print("\n");
                            if (i == 18)
                                System.out.print("\n");
                            if (i == 25)
                                System.out.print("\n");
                        } else {
                            if (premierJour == 5) {
                                System.out.print("  " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + i + "  ");
                                if (i == 3)
                                    System.out.print("\n");
                                if (i == 10)
                                    System.out.print("\n");
                                if (i == 17)
                                    System.out.print("\n");
                                if (i == 24)
                                    System.out.print("\n");
                            } else {
                                if (premierJour == 6) {
                                    System.out.print("  " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + i + "  ");
                                    if (i == 2)
                                        System.out.print("\n");
                                    if (i == 9)
                                        System.out.print("\n");
                                    if (i == 16)
                                        System.out.print("\n");
                                    if (i == 23)
                                        System.out.print("\n");
                                    if (i == 30)
                                        System.out.print("\n");
                                } else {
                                    if (premierJour == 7) {
                                        System.out.print("  " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + "  " + i + "  ");
                                        if (i == 1)
                                            System.out.print("\n");
                                        if (i == 8)
                                            System.out.print("\n");
                                        if (i == 15)
                                            System.out.print("\n");
                                        if (i == 22)
                                            System.out.print("\n");
                                        if (i == 29)
                                            System.out.print("\n");
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }
    }
}
