package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.*;

public class Bfs {
    //utiliser par certain ennemi
    //ducoup va faire un chemin de la où (point de spawn) et l'ennemi va passer
    //sur des pieges et espace ou y a pas d'obstacle donc ennemi se "prend" tout sauf les obstacles
    //du moment que chemin/tile dif de obstacle alors peut y aller ??

//sommet source = y et x = coordo de ennemie
//sommet cible = une tile en particulier pour le moment via un id special (a voir pour plusieur)
//grille = carte
//arraylist parcourt

    private Carte carte;
    private Case source;
    private ArrayList<Case> parcours;
    private Map<Case, Case> predecesseurs;

    public Bfs(Carte g, Case source) {
        this.carte = g;
        this.source = source;
        parcours = new ArrayList<>();
        predecesseurs = new HashMap<Case, Case>();
        algoBFS();
    }

    /// execute algo BFS du graphe a partire du som source, rempli liste parcours avec sommet
    /// dans ordre de visite, remplit la map predec en indiqu quel et le predec de chaque som
    /// el predec du somm source est le som null
    // donc devrai faire la meme mais a la place de somme c'est des case
    private void algoBFS() {
        LinkedList<Case> fifo = new LinkedList<>();
        Case sCourant;
        fifo.add(this.source);
        parcours.add(this.source);
        this.predecesseurs.put(this.source, null);
        while(!fifo.isEmpty()){
            sCourant=fifo.poll();
            for(Case sVoisin : this.carte.adjacents(sCourant)){
                if(!parcours.contains(sVoisin)){
                    this.parcours.add(sVoisin);
                    this.predecesseurs.put(sVoisin, sCourant);
                    fifo.add(sVoisin);

                }
            }
        }

    }

    ///retour liste donne suite des somm depuis al cible jusqu'a a la cible
    //nous doit rerout la liste des case depuis la cible (case id 100) jusqu'a apoint de spawn de En
    ///retourn le chemin sous forme de liste de somme
    //donc nous retourne le chemin sous  liste de case
    public ArrayList<Case> cheminVersSource(Case cible) {
        ArrayList<Case> chemin = new ArrayList<>();
        chemin.add(cible);
        Case courant=cible;
        while(!courant.equals(this.source)){
            courant=this.predecesseurs.get(courant);
            chemin.add(courant);
        }
        return chemin;
    }

    public ArrayList<Case> getParcours() {
        return parcours;
    }

    public Map<Case, Case> getPredecesseurs() {
        return predecesseurs;
    }


    ///de base mis a jour quand change source suite a clic droit
    //nous c'est le point de spawn de En
    public void setSource(Case source) {
        this.source = source;
        clear();
        algoBFS();
    }

    public void setG(Carte carte) {
        this.carte = carte;
        clear();
        algoBFS();
    }

    private void clear() {
        this.parcours.clear();
        this.predecesseurs.clear();
    }
}