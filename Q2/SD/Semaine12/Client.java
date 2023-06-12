/**
 *
 * @author Brandon Van Bellinghen
 *
 */
public class Client {

    private String nom;
    private String login;
    private int priorite;

    public Client (String nom,int priorite){
     if (nom == null && nom.equals("")){
         throw new IllegalArgumentException();
     }
     this.nom = nom;
     this.priorite = priorite;
    }

    public int getPriorite() {
        return priorite;
    }

    public String getNom() {
        return nom;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }

    @Override
    public String toString() {
        return '{'+ nom + '\'' +
                ", priorite=" + priorite +
                '}';
    }
}
