import java.util.HashMap;

public class Equipe {

    private Noeud tete, queue;
    private HashMap<String, Noeud> mapEquipierNoeud;

    /**
     * cree une nouvelle liste avec le chef d'equipe en tete
     * @param chefEquipe
     */
    public Equipe(String chefEquipe) {
        if(chefEquipe==null||chefEquipe.length()==0)
            throw new IllegalArgumentException();
        mapEquipierNoeud = new HashMap<>();
        Noeud nvNoeud = new Noeud(chefEquipe);
        tete = nvNoeud;
        queue = nvNoeud;
        mapEquipierNoeud.put(chefEquipe,nvNoeud);
    }

    /**
     * insere un nouvel equipier dans la liste a condition qu'il ne soit pas deja present
     * ce nouvel equipier est place directement apres le chef d'equipe
     * @param nouvelEquipier
     * @return true si l'ajout a pu etre fait, false sinon
     */
    public boolean insererApresChef(String nouvelEquipier){
        if(nouvelEquipier==null||nouvelEquipier.length()==0)
            throw new IllegalArgumentException();
        if (mapEquipierNoeud.containsKey(nouvelEquipier)) return false;
        Noeud nvNoeud = new Noeud(nouvelEquipier);
        nvNoeud.suivant = tete.suivant;
        tete.suivant = nvNoeud;
        nvNoeud.precedent = tete;
        if (nvNoeud.suivant == null) nvNoeud = queue;
        else nvNoeud.suivant.precedent = nvNoeud;
        mapEquipierNoeud.put(nouvelEquipier,nvNoeud);
       return true;
    }

    /**
     * supprime tous les equipiers de la liste a partir de l'equipier passe en parametre
     * ne fait aucune suppression si l'equipier est le chef d'equipe
     * ou si l'equipier ne fait pas partie de la liste
     * @param equipier l'equipier a partir duquel les suppressions sont effectuees
     * @return true si au moins une suppression a ete faite, false sinon
     */
    public boolean tronquerAPartir(String equipier){
        if(equipier==null||equipier.length()==0)
            throw new IllegalArgumentException();
        if(!mapEquipierNoeud.containsKey(equipier)){
            return false;
        }
        Noeud noeud = mapEquipierNoeud.get(equipier);
        if(noeud==tete){
            return false;
        }
        Noeud avant = noeud.precedent;
        avant.suivant = null;
        queue = avant;
        while (noeud != null) {
            mapEquipierNoeud.remove(noeud.equipier);
            noeud = noeud.suivant;
        }

        // supprimer egalement l'equipier

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
        if(tableACopier==null||tableACopier.length==0)
            throw new IllegalArgumentException();
        mapEquipierNoeud = new HashMap<String, Noeud>();
        tete = new Noeud(tableACopier[0]);
        mapEquipierNoeud.put(tableACopier[0],tete);
        Noeud prec = tete;
        for (int i = 1; i < tableACopier.length; i++) {
            Noeud nouveauNoeud = new Noeud(tableACopier[i]);
            mapEquipierNoeud.put(tableACopier[i], nouveauNoeud);
            nouveauNoeud.precedent = prec;
            prec.suivant = nouveauNoeud;
            prec = nouveauNoeud;
        }
        queue = prec;
    }

    //A NE PAS MODIFIER
    // pour les tests
    public String teteQueue(){
        try{
            String aRenvoyer = "(";
            Noeud baladeur = tete;
            int cpt=0;
            while (baladeur != null) {
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
            Noeud baladeur = queue;
            int cpt=0;
            while (baladeur != null) {
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
