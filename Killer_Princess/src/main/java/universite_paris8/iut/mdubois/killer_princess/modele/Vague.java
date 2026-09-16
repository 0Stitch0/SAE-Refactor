package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public class Vague {
    private int num;
    private ArrayList<String> ennemis;
    private ArrayList<GroupeParVague> listeGroupes;
    private int indexGroupeActuel;

    public Vague(int num) {
        this.num = num;
        ennemis = new ArrayList<>();
        this.indexGroupeActuel = 0;
        listeGroupes = new ArrayList<>();
    }

    public ArrayList<String> getEnnemis() {
        return ennemis;
    }

    public void ajouterGroupe(GroupeParVague groupe) {
        this.listeGroupes.add(groupe);
    }

    public int getNum() {
        return num;
    }

    public GroupeParVague appelrochainGroupe() {
        if (indexGroupeActuel >= listeGroupes.size()) {
            return null;
        }
        GroupeParVague groupe = listeGroupes.get(indexGroupeActuel);
        indexGroupeActuel++;
        return groupe;
    }

    public int getNombreDeGroupes(){
        return listeGroupes.size();
    }

    public boolean vagueTerminee() {
        return indexGroupeActuel >= listeGroupes.size();
    }
}
