/** Classe Suite

 */
import java.util.*;
import java.io.*;

public class Suite extends SuiteDeBase {

    // valeur numérique de MAXELT
    private static final int MAX = Elt.MAXELT.val();

    /** Constructeur vide */
    public Suite() {
        super();
    }

    /** Constructeur par recopie */
    public Suite(SuiteDeBase s) {
        super(s);
    }

    /** Constructeur à partir d'une String */
    public Suite(String st) {
        super(st);
    }

    /** Constructeur à partir d'un Elt et d'une Suite */
    public Suite(Elt t, Suite c) {
        super(t, c);
    }

    /** Construit la Suite réduite à (x) */
    public Suite(Elt x) {
        this();
        this.ajouter(x);
    }

    public Suite corps() {
        return (Suite) super.corps();
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        for (Elt e : this){
            result = result *prime + e.hashCode();
        }
        return result;
    }


    /** Renvoie la longueur de la Suite courante */
    public int longueur() {
        if(this.estVide()){
            return 0;
        }
        return 1 + corps().longueur();
    }



    /** renvoie TRUE si e a au moins une occurrence dans la Suite courante
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public boolean contient(Elt e){
        if (e == null) throw new IllegalArgumentException("Paramètre invalide");
        if (this.estVide())
            return false;
        if (this.tete().equals(e))
            return true;
        return this.corps().contient(e);
    }


    /** renvoie le nombre d'occurrences de e dans la Suite courante
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public int nombreOccur(Elt e){
        if (e == null) throw new IllegalArgumentException("Paramètre invalide");
        if (this.estVide()) return 0;
        if (this.tete().equals(e))
            return 1 + this.corps().nombreOccur(e);
        return this.corps().nombreOccur(e);
    }


    /** renvoie la position de la première occurrence de e dans la Suite courante ;
     * renvoie 0 si e n'a pas d'occurrence dans la Suite courante
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public int position(Elt e){
        if (e == null) throw new IllegalArgumentException("Paramètre invalide");
        if (!this.contient(e)) return 0;
        if (this.tete().equals(e)) return 1;
        return 1 + this.corps().position(e);
    }


    /** renvoie le i-ème élément de la Suite courante s'il existe ;
     * @throws IllegalArgumentException s'il n'exite pas de i-ème élément*/
    public Elt iEme(int i){
        if (this.estVide()) throw new IllegalArgumentException();
        if (i == 0) throw new IllegalArgumentException();
        if (i == 1) return this.tete();
        return this.corps().iEme(i-1);
    }


    /** renvoie le dernier élément de la Suite courante si elle est non vide,
     * @throws MathException si elle est vide*/
    public Elt dernier(){
        if (this.estVide()) throw new MathException("Suite vide");
        if (this.corps().estVide())
            return this.tete();
        return this.corps().dernier();
    }

    @Override
    /** renvoie true si la Suite courante est égale à s*/
    public boolean equals(Object o){
        if (o == null) return false;
        return o.hashCode() == this.hashCode();
    }


    /** renvoie true si la Suite courante est un préfixe de s
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public boolean prefixe(Suite s){
        if (s == null)														// mais une sous suite n'est pas forcéement un préfixe
            throw new IllegalArgumentException();
        if (this.estVide()){
            return true;
        }
        if (s.estVide()){
            return this.estVide();
        }
        if (this.tete().equals(s.tete()))
            return this.corps().equals(s.corps());
        return false;
    }


    /** renvoie true si la Suite courante est une sous-suite de s
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public boolean sousSuite(Suite s){
        if (s == null) throw new IllegalArgumentException();
        if (s.estVide())
            return this.estVide();
        if (this.estVide())
            return true;
        if (this.tete().equals(s.tete()))
            return this.corps().sousSuite(s.corps());
        return this.sousSuite(s.corps());
    }


    /** ajoute s à gauche de la Suite courante (au début de la suite)
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public void ajouter(Suite s){
        if (s == null) throw new IllegalArgumentException("Paramètre invalide");
        if (s.estVide()) return;
        this.ajouter(s.corps());
        this.ajouter(s.tete());

    }


    /** ajoute s à l'envers et à gauche de la Suite courante (à la fin de la suite)
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public void ajouterALEnvers(Suite s){
        if (s == null) throw new IllegalArgumentException();
        if (s.estVide()) return;
        this.ajouter(s.tete());
        this.ajouterALEnvers(s.corps());
    }


    /** renvoie la Suite courante inversée*/
    public Suite inverse(){
        Suite s = new Suite();
        s.ajouterALEnvers(this);
        return s;
    }



    /** renvoie une Suite contenant, une et une seule fois, tous les éléments de la Suite courante */
    public Suite reduite(){
        // si this.estVide() renvoie une suite vide
        if (this.estVide())
            return new Suite();
        //
        if (this.nombreOccur(tete()) > 1) return new Suite(this.corps().reduite());
        return new Suite(this.tete(), this.corps().reduite());
    }


    /**Renvoie la Suite courante de laquelle on a supprimé tous les éléments à partir du k-ième
     * Si la suite n'a pas k éléments, elle renvoie une copie de la suite.
     * @throws IllegalArgumentException en cas de paramètre invalide
     * */
    public Suite tronquee(int k){
        if (k <= 0) throw new IllegalArgumentException();
        if (this.estVide()) return new Suite(this);
        if (k == 1) return new Suite();
        return new Suite(this.tete(), this.corps().tronquee(k-1));
    }


    /** renvoie une copie de la Suite courante dans laquelle on a supprimé la première occurrence (éventuelle) de x
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public Suite moinsPremOcc(Elt x){
        // si l'occurrence n'existe pas
        if (x == null) throw new IllegalArgumentException();
        // si la suite est vide, renvoie une nouvelle suite vide
        if (this.estVide()) return new Suite();
        // si x == la tête, renvoie une nouvelle suite avec le corps
        if (x.equals(this.tete())) return new Suite(this.corps());
        // renvoie une nouvelle suite (tête, corps moins la première occurrence trouvée)
        return new Suite(this.tete(), this.corps().moinsPremOcc(x));
    }


    /** renvoie une copie de la Suite courante dans laquelle on a supprimé toutes les occurrences de x
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public Suite moinsToutesOcc(Elt x){
        if (x == null) throw new IllegalArgumentException("Paramètre invalide");
        if (this.estVide()) return new Suite();
        if (x.equals(this.tete()))
            return new Suite(this.corps().moinsToutesOcc(x));
        return new Suite(this.tete(), this.corps().moinsToutesOcc(x));
    }


    /** renvoie une Suite constituee de tous les Elt ayant plus d'une occurrence dans la Suite courante */
    public Suite doublons(){
        if (this.estVide()) return new Suite();
        if (this.corps().nombreOccur(this.tete()) == 1) return new Suite(this.tete(), this.corps().doublons());
        return new Suite(this.corps().doublons());
    }

    /** renvoie true ssi la Suite courante contient au moins k Elt distincts
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public boolean auMoinsK(int k){
        if (k < 0) throw new IllegalArgumentException();
        return this.reduite().longueur() >= k;
    }

    /** renvoie true ssi tous les element de la Suite sont distincts */
    public boolean tousDistincts(){
        return this.hashCode() == this.reduite().hashCode();
    }

    /** renvoie une copie de la Suite courante dans laquelle toutes les occurrences de x ont été remplacées par y
     * @throws IllegalArgumentException en cas de paramètre invalide*/
    public Suite substitut(Elt x, Elt y){
        if (x == null || y == null) throw new IllegalArgumentException();
        if (this.estVide()) return new Suite();
        if (this.tete().equals(x)) return new Suite (y, this.corps().substitut(x, y));
        return new Suite(this.tete(), this.corps().substitut(x, y));
    }

    /** renvoie true si la Suite courante est strictement croissante*/
    public boolean estTriee(){
        if (this.estVide()) return true;
        if (this.corps().estVide()) return true;
        if (this.tete().val() < this.corps().tete().val()) return this.corps().estTriee();
        return false;
    }


} // class Suite

