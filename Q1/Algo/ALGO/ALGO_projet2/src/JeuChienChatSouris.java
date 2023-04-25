public class JeuChienChatSouris {

    public static void main(String[] args){

        PlateauJeuChienChatSouris jeu = new PlateauJeuChienChatSouris();
        int positionSouris = 4;
        int positionChat = 2;
        int positionChien = 1;
        int compteur = 0;

        jeu.afficherInformation("Bienvenue dans le jeu du chat et de la souris");
        jeu.placerSouris(4);
        jeu.placerChat(2);
        jeu.placerChien(1);

        while (positionSouris < 16 && positionSouris > positionChat && positionChat > positionChien){

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

            /* Victoire Chien */
            if (positionChien >= positionChat) {
                jeu.supprimerChat();
                jeu.afficherInformation("Le Chien a sauvé la souris, victoire du chien et la souris");
                return;
            }

            /* Victoire Souris */
            if (positionSouris == 16){
                jeu.afficherInformation("La souris est dans son repere");
                return;
            }

            compteur++;

            /* Tour du Chien */
            if (compteur == 2){
                jeu.afficherInformation("C'est au tour du chien car il s est reveillé");
                valeurDe = jeu.lancerDe();
                positionChien += valeurDe;
                jeu.supprimerChien();
                if (positionChien > 16) {
                    positionChien = 16;
                }
                jeu.placerChien(positionChien);

                /* Victoire Chien */
                if (positionChien >= positionChat) {
                    jeu.supprimerChat();
                    jeu.afficherInformation("Le Chien a sauvé la souris, victoire du chien et la souris");
                    return;
                }

                /* Victoire Souris */
                if (positionSouris == 16){
                    jeu.afficherInformation("La souris est dans son repere");
                    return;
                }
            }
        }
    }
}
