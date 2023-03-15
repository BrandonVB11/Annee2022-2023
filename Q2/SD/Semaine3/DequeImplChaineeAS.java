/*
@author:  Van Bellinghen Brandon
 */
public class DequeImplChaineeAS<E> implements Deque<E>{


    private Noeud tete ;
    private Noeud queue ;
    private int taille ;

    public DequeImplChaineeAS(){
        tete=new Noeud(null);
        queue=new Noeud(null);
        tete.suivant=queue;
        queue.precedent=tete;
        taille=0;
    }

    public int taille() {
        return this.taille ;
    }

    public boolean estVide() {
        return (taille==0) ;
    }

    public void ajouterEnPremier(E element) {
        Noeud nouveau = new Noeud(element);
        nouveau.suivant=tete.suivant;
        nouveau.precedent=tete;
        tete.suivant.precedent=nouveau;
        tete.suivant=nouveau;
        taille++;
    }

    public E retirerPremier() {
        //TODO
        if (estVide()){
            throw new DequeVideException();
        }
        Noeud baladeur=tete.suivant;
        tete.suivant=baladeur.suivant;
        baladeur.suivant.precedent=tete;
        taille--;
        return baladeur.element;
    }

    public void ajouterEnDernier(E element) {
        //TODO
        Noeud nouveau = new Noeud(element);
        nouveau.suivant=queue;
        nouveau.precedent=queue.precedent;
        queue.precedent.suivant=nouveau;
        queue.precedent=nouveau;
        taille++;
    }

    public E retirerDernier() throws DequeVideException {
        //TODO
        if (estVide()){
            throw new DequeVideException();
        }
        Noeud baladeur=queue.precedent;
        queue.precedent=baladeur.precedent;
        baladeur.precedent.suivant=queue;
        taille--;
        return baladeur.element;
    }

    public E premier()throws DequeVideException {
        //TODO
        if (estVide()){
            throw new DequeVideException();
        }
        return tete.suivant.element;
    }

    public E dernier()throws DequeVideException {
        //TODO
        if (estVide()){
            throw new DequeVideException();
        }
        return queue.precedent.element;
    }


    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    // tete 'a' 'b' 'c' queue : ['a','b','c']
    public DequeImplChaineeAS(Object[] table) {
        if(table == null)
            throw new IllegalArgumentException();
        taille = 0 ;
        tete = new Noeud(null) ;
        queue = new Noeud(null) ;
        tete.suivant=queue;
        queue.precedent=tete;
        if(table.length==0)
            return;
        for (int i = table.length-1; i>=0;i--) {
            this.ajouterTest((E) table[i]) ;
        }
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String toString(){
        String aRenvoyer="";
        Noeud baladeur=tete.suivant;
        int cpt = 0;
        while(baladeur!=queue) {
            cpt++;
            if(cpt>taille){
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
            }
            aRenvoyer+=baladeur.element;
            if (baladeur.suivant != queue)
                aRenvoyer += " " ;
            baladeur=baladeur.suivant;
        }
        return aRenvoyer;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public String parcoursInverse(){
        String aRenvoyer="";
        Noeud baladeur=queue.precedent;
        int cpt = 0;
        while(baladeur!=tete) {
            cpt++;
            if(cpt>taille){
                aRenvoyer = "boucle infinie dans toString(), chainage a verifier";
            }
            aRenvoyer+=baladeur.element;

            if (baladeur.precedent != tete)
                aRenvoyer += " " ;
            baladeur=baladeur.precedent;
        }
        return aRenvoyer;
    }

    // A NE PAS MODIFIER --> POUR LES TESTS!!!
    public void ajouterTest(E element) {
        Noeud nouveauNoeud = new Noeud(element) ;
        nouveauNoeud.suivant = tete.suivant;
        nouveauNoeud.precedent = tete;
        tete.suivant.precedent = nouveauNoeud;
        tete.suivant = nouveauNoeud;
        taille++;
    }


    // classe interne
    private class Noeud{
        private E element;
        private Noeud precedent;
        private Noeud suivant;

        private Noeud(E element){
            this.element = element;
            this.precedent = null ;
            this.suivant = null;
        }

        private Noeud(E element, Noeud precedent, Noeud suivant){
            this.element = element;
            this.precedent = precedent ;
            this.suivant = suivant;
        }
    }
}
