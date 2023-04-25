/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class CoteCommentee {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args){
        System.out.println(" Entrez votre cote :");
        double cote = scanner.nextDouble();

        if (cote<10){
            System.out.println( " l'etudiant n'a pas validé l'UE ");
        }else{
            if (10<=cote && cote<=14){
                System.out.println("l'etudiant a validé l'UE");
            }else{
                if (14<=cote && cote<=16){
                    System.out.println("l'etudiant a validé l'UE avec une belle cote ");
                }else{
                    if (cote>=16){
                        System.out.println("l'etudiant a validé l'UE avec une tres belle cote ");
                    }
                }
            }
        }
    }
}
