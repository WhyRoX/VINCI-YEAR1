public class ParticipantsV3 {

    private String[] tableParticipants;
    private int nombreInscrits; 	// taille logique

    // Les nombreInscrits participants occupent les nombreInscrits premieres
    // cases du tableau (pas de trou)
    // la table est triee par ordre alphabetique

    /**
     * construit un objet Participants
     * au depart, il n'y a pas d'inscrit
     * @param nombreMaxParticipants le nombre maximum de participants
     */
    public ParticipantsV3(int nombreMaxParticipants) {
        if (nombreMaxParticipants < 1)
            throw new IllegalArgumentException();
        this.tableParticipants = new String[nombreMaxParticipants];
        this.nombreInscrits = 0;
    }

    /**
     * renvoie le nombre de participants actuellement inscrits
     * @return le nombre de participants actuellement inscrits
     */
    public int getNombreInscrits() {
        return this.nombreInscrits;
    }


    private int trouverIndiceParticipant(String participant){
        //methode private
        //recherche a quel indice se trouve le participant passe en parametre
        //renvoie -1 si le participant n'est pas present
        for (int i = 0; i < nombreInscrits; i++) {
            if(tableParticipants[i].equals(participant))
                return i;
            if(tableParticipants[i].compareTo(participant) > 0)
                return -1;
        }
        return -1;
    }

    /**
     * verifie la presence du participant
     * @param participant le nom du participant recherche
     * @return true si le participant est present, false sinon
     */
    public boolean contientParticipant(String participant){
        //TODO

        //Prenez connaissance de la methode trouverIndice()
        // ET UTILISEZ-LA !

        return trouverIndiceParticipant(participant) != -1;

    }

    /**
     * ajoute un participant a la table des participants
     * a condition qu'il ne soit pas deja present
     * et a condition que le nombre maximum de participants ne soit pas atteint
     * @param participant le participant a ajouter
     * @return true si l'ajout a pu se faire, false sinon
     */
    public boolean ajouterUnParticipant(String participant) {
        if(participant == null || participant.length() == 0)
            throw new IllegalArgumentException();

        if (contientParticipant(participant)) {
            return false;
        }


        if (nombreInscrits < tableParticipants.length) {
            int index = nombreInscrits - 1;
            while (index >= 0 && tableParticipants[index].compareTo(participant) > 0) {
                tableParticipants[index + 1] = tableParticipants[index];
                index--;
            }
            tableParticipants[index + 1] = participant;
            nombreInscrits++;
            return true;
        } else {
            return false;
        }
    }
    public boolean ajouterUnParticipant2(String participant) {
        if (participant == null || participant.length() == 0)
            throw new IllegalArgumentException();


        if (contientParticipant(participant)) {
            return false;
        }
        if (nombreInscrits < tableParticipants.length) {
            int low = 0;
            int high = nombreInscrits - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                int comparison = tableParticipants[mid].compareTo(participant);

                if (comparison < 0) {
                    low = mid + 1;
                } else if (comparison > 0) {
                    high = mid - 1;
                } else {
                    return false;
                }
            }

            for (int i = nombreInscrits - 1; i >= low; i--) {
                tableParticipants[i + 1] = tableParticipants[i];
            }

            tableParticipants[low] = participant;
            nombreInscrits++;
            return true;
        } else {
            return false;
        }
    }

    /**
     * supprime le participant passe en parametre
     * @param participant Le participant a supprimer
     * @return true si la suppression a pu etre faite, false sinon
     */
    public boolean supprimerUnParticipant(String participant) {
        if(participant == null || participant.length() == 0)
            throw new IllegalArgumentException();

        int index = trouverIndiceParticipant(participant);

        if (index != -1) {
            for (int i = index; i < nombreInscrits - 1; i++) {
                tableParticipants[i] = tableParticipants[i + 1];
            }
            tableParticipants[nombreInscrits - 1] = null;
            nombreInscrits--;
            return true;
        } else {
            return false;
        }

        // Pensez a utiliser la methode trouverIndiceParticipant()

        // Si cela ne va pas, refaites le QCM classe ParticipantsV2 sur moovin
        // de la semaine table non triee


    }


    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public ParticipantsV3(int nombreParticipants, String[] tableARecopier) {
        this.tableParticipants = new String[nombreParticipants];
        this.nombreInscrits = tableARecopier.length;
        for (int i = 0; i < nombreInscrits; i++)
            this.tableParticipants[i] = tableARecopier[i];
    }

    // A NE PAS MODIFIER
    // VA SERVIR POUR LES TESTS
    public String toString() {
        if(nombreInscrits==0)
            return "[]";
        String aRenvoyer = "["+tableParticipants[0];
        for (int i = 1; i < nombreInscrits; i++)
            aRenvoyer = aRenvoyer + ", " + this.tableParticipants[i];
        return aRenvoyer+"]";
    }



}
