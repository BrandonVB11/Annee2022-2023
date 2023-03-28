import java.util.Objects;

/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class RallyeAutomobile {

    private ListeSDImpl<String> ListePilotes;
    private ListeSDImpl<String> ClassementFinale;
    private ListeSDImpl<String> ListeDesAbandonts;

    public RallyeAutomobile(String[] lesPilotes){
        ListePilotes = new ListeSDImpl<String>();
        ClassementFinale = new ListeSDImpl<String>();
        ListeDesAbandonts = new ListeSDImpl<String>();
        if(lesPilotes.length == 0){
            throw new IllegalArgumentException();
        }else {
            for (int i = 0; i < lesPilotes.length ; i++) {
                    ListePilotes.insererEnQueue(lesPilotes[i]);
            }
        }
    }

    public String afficherCourse(){
        if(ListePilotes.estVide()){
            System.out.println("Tous les pilotes ont fini le Rallye de Belgique");
            return "Tous les pilotes ont fini le Rallye de Belgique";
        }
        System.out.println("Voici le classement actuel du Rallye de Belgique"+"\n"+ListePilotes.toString());
        return ListePilotes.toString();
    }

    public String afficherPremier(){
        if (ListePilotes.premier() == null){
            System.out.println("Tous les pilotes ont fini le Rallye de Belgique");
            return "Tous les pilotes ont fini le Rallye de Belgique";
        }
        System.out.println("Le pilote qui mene ce rallye est "+ListePilotes.premier());
        return ListePilotes.premier();
    }

    public boolean piloteDepasser(String pilote){
        String piloteDevant = ListePilotes.donnerPrecedent(pilote);
        if (pilote == null || pilote.equals(""))
            throw new IllegalArgumentException();
        if (!ListePilotes.contient(pilote) && !ClassementFinale.contient(pilote)){
            System.out.println(pilote+" n'est pas dans le rallye");
            return false;
        }
        if (ClassementFinale.contient(pilote)){
            System.out.println(pilote+" a fini le Rallye");
            return false;
        }
        if (ListeDesAbandonts.contient(pilote)){
            System.out.println(pilote+" est hors course de ce Rallye");
            return false;
        }
        if (ListePilotes.premier().equals(pilote)){
            System.out.println(pilote+"est leader de ce rallye");
            return false;
        }
        ListePilotes.permuter(piloteDevant,pilote);
        System.out.println( piloteDevant+" a été depasser par "+pilote +" pendant ce rallye");
        return true;
    }

    public boolean abandonnerLaCourse(String pilote){
        if (!ListePilotes.contient(pilote)){
            System.out.println(pilote+" n'est pas dans le rallye");
            return false;
        }
        if (ClassementFinale.contient(pilote)){
            System.out.println(pilote+"a fini le Rallye");
            return false;
        }
        if (ListeDesAbandonts.contient(pilote)){
            System.out.println(pilote+" est hors course de ce Rallye");
            return false;
        }
        System.out.println("Ce "+pilote + " est hors course du Rallye de Belgique à cause d'un problémé mécanique");
        ListePilotes.supprimer(pilote);
        ListeDesAbandonts.insererEnQueue(pilote);
        return true;
    }


    public int donnerPosition(String pilote){
        int compteur = 1;
        if (pilote == null || pilote.equals(""))
            throw new IllegalArgumentException();
        if (!ListePilotes.contient(pilote)){
            System.out.println(pilote+" n'est pas dans le rallye");
        }
        if (ClassementFinale.contient(pilote)){
            System.out.println(pilote+" a fini le Rallye");
        }
        if (ListeDesAbandonts.contient(pilote)){
            System.out.println(pilote+" est hors course de ce Rallye");
        }
        if (ListePilotes.premier().equals(pilote)){
            int premier = 1;
            System.out.println(pilote + " occupe la " + premier + " eme position de ce rallye");
        }
        if (ListePilotes.dernier().equals(pilote)){
            int dernier = ListePilotes.taille();
            System.out.println(pilote + " occupe la " + dernier + " eme position de ce rallye");
        }
        for (String position:ListePilotes) {
            if (!Objects.equals(position, pilote)) {
                compteur++;
            }
            if (position.equals(pilote))
                System.out.println(pilote + " occupe la " + compteur + " eme position de ce rallye");
        }
        return compteur;
    }

    public int franchirLigne(){
        String premier = ListePilotes.premier();
        ListePilotes.supprimer(premier);
        ClassementFinale.insererEnQueue(premier);
        System.out.println(premier + " a fini le Rallye de Belgique avec un bon temps");
        if (ListePilotes.estVide()){
            return 0;
        }
        return 1;
    }

    public boolean remettrePilote(String pilote){
        if (!ListeDesAbandonts.contient(pilote)){
            System.out.println(pilote+" n'a pas abandonné");
        }
        ListeDesAbandonts.supprimer(pilote);
        ListePilotes.insererEnQueue(pilote);
        return true;
    }

    public String afficherLesAbandons(){
        if (ListeDesAbandonts.estVide()){
            System.out.println("Aucun pilote est hors course");
            return "Aucun pilote est hors course";
        }
        System.out.println("Voici la liste des pilotes qui se sont retirés pendant le Rallye de Belgique");
        return "Voici la liste des pilotes qui se sont retirés pendant le Rallye de Belgique"+"\n"+ListeDesAbandonts.toString();
    }
    public String afficherClassement(){
        if(ClassementFinale.estVide()){
            System.out.println("Aucun pilote a fini le Rallye de Belgique");
            return "Aucun pilote a fini le Rallye de Belgique";
        }
        System.out.println("Voici le classement finale du Rallye de Belgique"+"\n"+ClassementFinale.toString());
        return ClassementFinale.toString();
    }

}
