import java.util.HashMap;

public class Equipe {

    private Noeud tete, queue;
    private HashMap<String, Noeud> mapEquipierNoeud;

    /**
     * cree une liste vide
     */
    public Equipe() {
        mapEquipierNoeud = new HashMap<String, Noeud>();
        tete = new Noeud();
        queue = new Noeud();
        tete.suivant = queue;
        queue.precedent = tete;
    }

    /**
     * verifie la presence d'un equipier dans la liste
     * @param equipier l'equipier verifie
     * @return true si l'equipier est present, false sinon
     */
    public boolean contient (String equipier){
        if(equipier==null||equipier.length()==0)
            throw new IllegalArgumentException();
        
        return mapEquipierNoeud.containsKey(equipier);
    }

    /**
     * ajoute un nouvel equipier en fin de liste a condition qu'il ne soit pas deja present
     * @param nouvelEquipier l'equipier a ajouter
     * @return true si l'ajout a pu se faire, false sinon
     */
    public boolean ajouterEnFin(String nouvelEquipier){
        if(nouvelEquipier==null||nouvelEquipier.length()==0)
            throw new IllegalArgumentException();
        if (mapEquipierNoeud.containsKey(nouvelEquipier)) return false;
        Noeud nvNoeud = new Noeud(nouvelEquipier);
        nvNoeud.precedent = queue.precedent;
        nvNoeud.suivant = queue;
        queue.precedent.suivant = nvNoeud;
        queue.precedent = nvNoeud;
        mapEquipierNoeud.put(nouvelEquipier, nvNoeud);
        return true;
    }

    /**
     * supprime tous les equipiers de la liste qui se trouvent apres l'equipier passe en parametre
     * ne fait aucune suppression si l'equipier ne fait pas partie de la liste ou s'il est le dernier
     * @param equipier l'equipier apres lequel les suppressions sont effectuees
     * @return true si au moins une suppression a ete faite, false sinon
     */
    public boolean tronquerApres(String equipier){
        if(equipier==null||equipier.length()==0)
            throw new IllegalArgumentException();
        if(!mapEquipierNoeud.containsKey(equipier)){
            return false;
        }
        Noeud noeud = mapEquipierNoeud.get(equipier);
        if (noeud.suivant == queue) return false;

        Noeud baladeur = noeud.suivant;
        baladeur.suivant = queue;
        queue.precedent = noeud;
        while (baladeur != null){
            mapEquipierNoeud.remove(baladeur.equipier);
            baladeur = baladeur.suivant;
        }
        return true;
    }

    /**
     * renvoie le nombre d'equipiers de l'equipe
     * @return le nombre d'equipiers de l'equipe
     */
    public int nombreEquipiers () {
        return mapEquipierNoeud.size();
    }


    //A NE PAS MODIFIER
    // pour les tests
    public Equipe(String[] tableACopier) {
        if(tableACopier==null)
            throw new IllegalArgumentException();
        mapEquipierNoeud = new HashMap<String, Noeud>();
        tete = new Noeud();
        Noeud prec = tete;
        for (int i = 0; i < tableACopier.length; i++) {
            Noeud nouveauNoeud = new Noeud(tableACopier[i]);
            mapEquipierNoeud.put(tableACopier[i], nouveauNoeud);
            nouveauNoeud.precedent = prec;
            prec.suivant = nouveauNoeud;
            prec = nouveauNoeud;
        }
        queue = new Noeud();
        queue.precedent = prec;
        prec.suivant = queue;
    }

    //A NE PAS MODIFIER
    // pour les tests
    public String teteQueue(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = tete.suivant;
            int cpt=0;
            while (baladeur != queue) {
                if(cpt==0)
                    aRenvoyer += baladeur.equipier;
                else
                    aRenvoyer += ","+baladeur.equipier;
                baladeur = baladeur.suivant;
                cpt++;
                if(cpt==100){
                    return "boucle infinie";
                }
            }
            return aRenvoyer+")";
        }catch (NullPointerException e){
            return "nullPointerException";
        }
    }

    public String toString(){
        return teteQueue();
    }

    //A NE PAS MODIFIER
    // pour les tests
    public String queueTete(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = queue.precedent;
            int cpt=0;
            while (baladeur != tete) {
                if(cpt==0)
                    aRenvoyer += baladeur.equipier;
                else
                    aRenvoyer += ","+baladeur.equipier;
                baladeur = baladeur.precedent;
                cpt++;
                if(cpt==100){
                    return "boucle infinie";
                }
            }
            return aRenvoyer+")";
        }catch (NullPointerException e){
            return "nullPointerException";
        }
    }

    // Classe interne Noeud
    private class Noeud{
        private String equipier;
        private Noeud suivant;
        private Noeud precedent;

        private Noeud() {
            this(null, null, null);
        }

        private Noeud(String equipier) {
            this(null, equipier, null);
        }

        private Noeud(Noeud precedent, String equipier, Noeud suivant) {
            this.equipier = equipier;
            this.suivant = suivant;
            this.precedent = precedent;
        }
    }

}
