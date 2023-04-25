/**
 *
 * @author Van Bellinghen Brandon
 *
 */
public class DuelGuerriers {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {

		int lancerDe1 = unEntierAuHasardEntre(1, 10);
		int lancerDe2 = unEntierAuHasardEntre(1, 10);
		int lancerDe3 = unEntierAuHasardEntre(1, 10);
		int lancerDe4 = unEntierAuHasardEntre(1, 10);

		/* Tirage au sort de la vie du bouclier de CogneDur */
		int lancerDe5 = unEntierAuHasardEntre(1, 5);

		int vieFF = lancerDe1;
		int vieCD = lancerDe2;
		int vieBouclier = lancerDe5;

		System.out.println("FrappeFort a " + vieFF + " point de vie ");
		System.out.println("CogneDurs a  " + vieCD + " point de vie posséde Le Bouclier Hylien qui a " + vieBouclier + " points de vie");
		int forceff = lancerDe3;
		int forcecd = lancerDe4;
		System.out.println("FrappeFort inflige " + forceff + " points de degat a CogneDur");
		int vieRestanteBouclier = vieBouclier - forceff;
		if (vieRestanteBouclier < 0) {
			vieRestanteBouclier = 0;
		}
		if (vieRestanteBouclier == 0) {
			System.out.println("FrappeFort a brisé le bouclier de CogneDur");
			System.out.println("CogneDur inflige " + forcecd + " points de degat a FrappeFort");
			int vieRestanteFF = vieFF - forcecd;
			if (vieRestanteFF < 0) {
				vieRestanteFF = 0;
			}
			if (vieRestanteFF == 0) {
				System.out.println("FrappeFort a "+vieRestanteFF+" points de vie");
				System.out.println("CogneDur est vainqueur");
			} else {
				System.out.println("FrappeFort a "+vieRestanteFF+" points de vie");
				System.out.println("FrappeFort inflige " + forceff + " points de degat a CogneDur");
				int vieRestanteCD = vieCD - forceff;
				if (vieRestanteCD < 0) {
					vieRestanteCD = 0;
				}
				if (vieRestanteCD == 0) {
					System.out.println("CogneDur a "+vieRestanteFF+" points de vie");
					System.out.println("FrappeFort est vainqueur");
				} else {
					System.out.println("CogneDur a "+vieRestanteFF+" points de vie");
					if (vieRestanteCD < vieRestanteFF) {
						System.out.println("FrappeFort est vainqueur");
					} else {
						if (vieRestanteCD == vieRestanteFF) {
							System.out.println("FrappeFort et CogneDur terminent ex-aequos");
						} else {
							System.out.println("CogneDur est vainqueur");
						}
					}
				}
			}
		} else {
			System.out.println("Le Bouclier Hylien de CogneDur a "+vieRestanteBouclier+" points de vie");
			System.out.println("CogneDur inflige " + forcecd + " points de degat a FrappeFort");
			int vieRestanteFF = vieFF - forcecd;
			if (vieRestanteFF < 0) {
				vieRestanteFF = 0;
			}
			if (vieRestanteFF == 0) {
				System.out.println("FrappeFort a "+vieRestanteFF+" points de vie");
				System.out.println("CogneDur est vainqueur");
			} else {
				System.out.println("FrappeFort a "+vieRestanteFF+" points de vie");
				System.out.println("FrappeFort inflige " + forceff + " points de degat a CogneDur");
				int vieRestanteCD = vieCD - forceff;
				if (vieRestanteCD < 0) {
					vieRestanteCD = 0;
				}
				if (vieRestanteCD == 0) {
					System.out.println("CogneDur a "+vieRestanteFF+" points de vie");
					System.out.println("FrappeFort est vainqueur");
				} else {
					System.out.println("CogneDur a "+vieRestanteFF+" points de vie");
					if (vieRestanteCD < vieRestanteFF) {
						System.out.println("FrappeFort est vainqueur");
					} else {
						if (vieRestanteCD == vieRestanteFF) {
							System.out.println("FrappeFort et CogneDur terminent ex-aequos");
						} else {
							System.out.println("CogneDur est vainqueur");
						}
					}
				}
			}
		}
	}
		// A COMPLETER


	public static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
		double nombreReel;
		int resultat;

		nombreReel = Math.random();
		resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
		return resultat;
	}



}
