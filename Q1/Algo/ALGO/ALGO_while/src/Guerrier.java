
public class Guerrier {
	
	private String nom;
	private int pointsDeVie;
	
	public Guerrier(String nom, int pointsDeVie) {
		this.nom = nom;
		this.pointsDeVie = pointsDeVie;
	}

	public String getNom() {
		return nom;
	}

	
	public int getPointsDeVie() {
		return pointsDeVie;
	}

	public void setPointsDeVie(int pointsDeVie) {
		this.pointsDeVie = pointsDeVie;
	}

	public int retirerPointsDeVie(int pointsDeVie){
		return getPointsDeVie() - pointsDeVie;
	}

	public boolean estVivant(){
		if (getPointsDeVie() < 0){
			return false;
		}
		return true;
	}
	public String toString() {
		return "" + nom + " a " + pointsDeVie + " points de vie";
	}
	
	
	
	
	
	
	
}
