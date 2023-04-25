public class JeuChatSouris {

	public static void main(String[] args){

		PlateauJeuChatSouris jeu = new PlateauJeuChatSouris();
		int positionSouris = 3;
		int positionChat = 1;

		jeu.afficherInformation("Bienvenue dans le jeu du chat et de la souris");

		/* placement initiale */
		jeu.placerSouris(3);
		jeu.placerChat(1);

		while (positionSouris < 16 && positionSouris > positionChat){

			/* Tour Souris */
			jeu.afficherInformation("C'est le tour de la Souris");
			int valeurDe = jeu.lancerDe();
			positionSouris += valeurDe;
			jeu.supprimerSouris();

			/* Victoire Chat */
			if (positionSouris <= positionChat) {
				jeu.afficherInformation("Le chat à gagner");
				jeu.supprimerSouris();
				return;
			}

			if (positionSouris > 16){
				jeu.placerSouris(16);
				jeu.afficherInformation("Victoire Souris");
				return;
			}

			/* Victoire Souris */
			if (positionSouris == 16){
				jeu.afficherInformation("La souris est dans son repere");
			}
			jeu.placerSouris(positionSouris);

			/* Tour du Chat */
			jeu.afficherInformation("C'est au tour du chat");
			valeurDe = jeu.lancerDe();
			positionChat += valeurDe;
			jeu.supprimerChat();
			if (positionChat > 16) {
				positionChat = 16;
			}
			jeu.placerChat(positionChat);

			/* Victoire Chat */
			if (positionChat >= positionSouris) {
				jeu.supprimerSouris();
				jeu.afficherInformation("Le chat à gagner");
				return;
			}

			/* Victoire Souris */
			if (positionSouris == 16){
				jeu.afficherInformation("La souris est dans son repere");
			}
		}
	}
}
