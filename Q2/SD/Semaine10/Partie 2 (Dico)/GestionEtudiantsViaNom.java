import java.util.Comparator;
import java.util.TreeSet;
/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class GestionEtudiantsViaNom {

    private static MonScanner scanner = new MonScanner("InputA.txt");
    private static TreeSet<Etudiant> ensembleEtudiants = new TreeSet<Etudiant>(new ComparateurViaNom());


    public static void main(String[] args) {
        System.out.println("*********************");
        System.out.println("Gestion des etudiants");
        System.out.println("*********************");
        int choix = 0;
        do {
            System.out.println();
            System.out.println("1 -> ajouter un etudiant");
            System.out.println("2 -> afficher tous les etudiants");

            System.out.println();
            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    ajout();
                    break;
                case 2:
                    tous();
                    break;

                default:
                    break;
            }
        } while (choix >= 1 && choix <= 2);

    }

    private static void tous() {
        System.out.println();
        for (Etudiant etudiant : ensembleEtudiants) {
            System.out.println(etudiant.getNumeroMatricule() + " " + etudiant.getNom() + " " + etudiant.getPrenom());
        }
        System.out.println();
    }

    private static void ajout() {
        TreeSet<Etudiant> t = new TreeSet<Etudiant>();
        System.out.println();
        System.out.print("Entrez le numero de matricule : ");
        int numero = scanner.nextInt();
        System.out.print("Entrez le nom : ");
        String nom = scanner.next();
        System.out.print("Entrez le prenom : ");
        String prenom = scanner.next();
        ensembleEtudiants.add(new Etudiant(numero, nom, prenom));
        for (Etudiant etudiant : t) {
            System.out.println(etudiant);
        }
    }


    private static class ComparateurViaNom implements Comparator<Etudiant> {
        public int compare(Etudiant e1, Etudiant e2) {
            if (e1.getNom().equals(e2.getNom())){
                return e1.getPrenom().compareTo(e2.getPrenom());
            }
            return e1.getNom().compareTo(e2.getNom());
        }
    }
}

