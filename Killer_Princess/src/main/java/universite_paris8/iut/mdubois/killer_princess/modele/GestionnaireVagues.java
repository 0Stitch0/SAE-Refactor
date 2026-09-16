package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public class GestionnaireVagues {
    private ArrayList<Vague> vagues;
    private int vagueActuelle=0;

    public GestionnaireVagues() {
        this.vagues = new ArrayList<>();
        genererVagues();
    }

    public ArrayList<Vague> getVagues() {
        return this.vagues;
    }

    //Génère les ennemis qui vont spawn dans l'ordre qu'on veut
    public void genererVagues() {

        //VAGUE 1 - "Les éclaireurs" : 2 groupes légers
        //Crée une vague
        Vague v1 = new Vague(1);

        //Crée le nombre de Groupe de vagues qu'on ve
        GroupeParVague g1 = new GroupeParVague(11);
        GroupeParVague g2 = new GroupeParVague(9);

        //Ajoute les ennemis et leur nombre à notre guis
        g1.ajouterEnnemi("GOBELIN", 2);
        g2.ajouterEnnemi("GOBELIN", 1);
        g2.ajouterEnnemi("CHEVALIER", 1);

        //Ajoute chaque groupes à la vague cré
        v1.ajouterGroupe(g1);
        v1.ajouterGroupe(g2);
        this.vagues.add(v1);       //ajoute la vague créée à la liste des vagues du Gestionnaire de vagues

        //VAGUE 2 - "La chevauchée" : chevaliers + premier Shrek
        Vague v2 = new Vague(2);
        GroupeParVague g3 = new GroupeParVague(9);
        GroupeParVague g4 = new GroupeParVague(8);
        g3.ajouterEnnemi("GOBELIN", 2);
        g3.ajouterEnnemi("CHEVALIER", 1);
        g4.ajouterEnnemi("CHEVALIER", 2);
        g4.ajouterEnnemi("SHREK", 1);
        v2.ajouterGroupe(g3);
        v2.ajouterGroupe(g4);
        this.vagues.add(v2);

        //VAGUE 3 - "L'ogre et le prince" : Shrek + surprise Prince
        Vague v3 = new Vague(3);
        GroupeParVague g5 = new GroupeParVague(9);
        GroupeParVague g6 = new GroupeParVague(8);
        GroupeParVague g7 = new GroupeParVague(9);
        g5.ajouterEnnemi("GOBELIN", 2);
        g5.ajouterEnnemi("CHEVALIER", 1);
        g6.ajouterEnnemi("SHREK", 1);
        g6.ajouterEnnemi("PRINCE", 1);
        g7.ajouterEnnemi("CHEVALIER", 1);
        g7.ajouterEnnemi("GOBELIN", 2);
        v3.ajouterGroupe(g5);
        v3.ajouterGroupe(g6);
        v3.ajouterGroupe(g7);
        this.vagues.add(v3);

        //VAGUE 4 - "L'armée royale" : tout le monde sauf l'invincible
        Vague v4 = new Vague(4);
        GroupeParVague g8 = new GroupeParVague(8);
        GroupeParVague g9 = new GroupeParVague(8);
        GroupeParVague g10 = new GroupeParVague(7);
        g8.ajouterEnnemi("GOBELIN", 2);
        g8.ajouterEnnemi("CHEVALIER", 2);
        g9.ajouterEnnemi("SHREK", 1);
        g9.ajouterEnnemi("PRINCE", 1);
        g10.ajouterEnnemi("CHEVALIER", 2);
        g10.ajouterEnnemi("GOBELIN", 2);
        v4.ajouterGroupe(g8);
        v4.ajouterGroupe(g9);
        v4.ajouterGroupe(g10);
        this.vagues.add(v4);

        //VAGUE 5 - "Vague demi-finale" : boss final seul après
        Vague v5 = new Vague(5);
        GroupeParVague g11 = new GroupeParVague(8);
        GroupeParVague g12 = new GroupeParVague(7);
        GroupeParVague g13 = new GroupeParVague(7);
        GroupeParVague g14 = new GroupeParVague(6);
        g11.ajouterEnnemi("GOBELIN", 2);
        g11.ajouterEnnemi("CHEVALIER", 2);
        g12.ajouterEnnemi("SHREK", 1);
        g12.ajouterEnnemi("PRINCE", 1);
        g13.ajouterEnnemi("CHEVALIER", 2);
        g13.ajouterEnnemi("PRINCE", 1);
        v5.ajouterGroupe(g11);
        v5.ajouterGroupe(g12);
        v5.ajouterGroupe(g13);
        v5.ajouterGroupe(g14);
        this.vagues.add(v5);

        //VAGUE 6 - "Le prétendant invincible" : boss final seul en dernier (x4)
        Vague v6 = new Vague(5);
        GroupeParVague g15 = new GroupeParVague(9);
        GroupeParVague g16 = new GroupeParVague(8);
        GroupeParVague g17 = new GroupeParVague(7);
        GroupeParVague g18 = new GroupeParVague(6);
        v6.ajouterGroupe(g15);
        v6.ajouterGroupe(g16);
        v6.ajouterGroupe(g17);
        v6.ajouterGroupe(g18);
        this.vagues.add(v6);
    }

    public Vague getVagueActuelle() {
        if (this.vagueActuelle >= this.vagues.size()) {
            return this.vagues.get(this.vagues.size() - 1); // dernière vague
        }
        return this.vagues.get(this.vagueActuelle);
    }

    public boolean vagueTerminee() {
        Vague v = getVagueActuelle();
        return v.vagueTerminee();
    }

    public void vagueSuivante() {
        if (vagueTerminee()) {
            if (this.vagueActuelle < this.vagues.size() - 1) {
                this.vagueActuelle++;
            }
        }
    }

    public int getNbTotalVagues() {
        return this.vagues.size();
    }
}