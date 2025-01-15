public class JeuChatSouris {

    public static void main(String[] args){


        int positionSouris = 3;
        int positionChat = 1;
        PlateauJeuChatSouris jeu = new PlateauJeuChatSouris();
        jeu.afficherInformation("Let's gooooo !!!");
        jeu.placerSouris(positionSouris);
        jeu.placerChat(positionChat);
        while (true) {
            positionSouris += jeu.lancerDe();
            jeu.afficherInformation("Souris, à toi");
            if (positionSouris > 16) {
                positionSouris = 16;
                jeu.supprimerSouris();
                jeu.placerSouris(positionSouris);
                jeu.afficherInformation("GG à la souris, chat tu pleures");
                break;
            }

            jeu.supprimerSouris();
            jeu.placerSouris(positionSouris);

            jeu.afficherInformation("Au tour du chat");
            positionChat += jeu.lancerDe();
            jeu.supprimerChat();
            jeu.placerChat(positionChat);

            if (positionChat >= positionSouris) {
                jeu.supprimerSouris();
                jeu.afficherInformation("Bon app au chat, finito");
                break;
            }
        }


        // A COMPLETER
    }


}
