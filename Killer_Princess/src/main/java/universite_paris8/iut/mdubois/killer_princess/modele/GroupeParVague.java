package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public class GroupeParVague {
    private ArrayList<String> typesEnnemis;
    private int idEntree;

    public GroupeParVague(int idEntree) {
        this.typesEnnemis = new ArrayList<>();
        this.idEntree = idEntree;
    }

    public void ajouterEnnemi(String type, int nb) {
        for (int i = 0; i < nb; i++) {
            this.typesEnnemis.add(type);
        }
    }

    public ArrayList<String> getTypesEnnemis() {
        return this.typesEnnemis;
    }

    public int getIdEntree() {
        return this.idEntree;
    }
}