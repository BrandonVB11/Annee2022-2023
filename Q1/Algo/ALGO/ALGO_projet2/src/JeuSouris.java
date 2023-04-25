public class JeuSouris {

	public static void main(String[] args) {

		int positionSouris = 1;
		PlateauJeuSouris jeu = new PlateauJeuSouris();
		jeu.afficherInformation("Vas-y !");
		jeu.placerSouris(positionSouris);

		while (positionSouris < 16){

			/* Deplacement de la souris */
			int lanceDe = jeu.lancerDe();
			positionSouris += lanceDe;
			jeu.supprimerSouris();
			if (positionSouris > 16){
				positionSouris = 16;
			}
			jeu.placerSouris(positionSouris);

			/* Condition de raccourci */
			if (positionSouris == 10){
				jeu.supprimerSouris();
				jeu.placerSouris(16);
				jeu.afficherInformation("La souris prend son raccourci et entre dans son repere");
				return;
			}

			/* Condition de victoire */
			if (positionSouris == 16){
				jeu.afficherInformation("La souris est dans son repere");
			}
		}
	}
}
