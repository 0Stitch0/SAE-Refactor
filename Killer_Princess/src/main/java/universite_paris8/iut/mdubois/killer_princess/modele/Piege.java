package universite_paris8.iut.mdubois.killer_princess.modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.ArrayList;

public abstract class Piege extends Entite {
    private int cout;
    private int degat;
    private double x, y;
    private int niveau;
    private int nivMax;
    private String nom;
    private final ObservableMap<Object, Object> properties = FXCollections.observableHashMap();
    public final ObservableMap<Object, Object> getProperties() {
        return this.properties;
    }

    public Piege(double x, double y,Jeu partie, int vie, int degat, String nom, int prime, int cout){
        super(x, y, partie, vie, degat, nom, prime);
        this.x = x;
        this.y = y;
        this.nom = nom;
        this.cout = cout;
        this.niveau = 1;
        this.nivMax = 3;
    }

    public Ennemi EnnemisLePlusProche(ArrayList<Ennemi> ennemis) {
        Ennemi eProche = ennemis.get(0);

        for (int i=1; i<ennemis.size(); i++) {
            if(ennemis.get(i).getY()<eProche.getY()){
                eProche = ennemis.get(i);
            }
        }
        return eProche;
    }

    public void amelioration(){
        this.setDegat(this.getDegat()+2);
        this.setNiveau(this.getNiveau()+1);
    }

    public int getNiveau(){
        return this.niveau;
    }

    public void setNiveau(int niveau){
        this.niveau = niveau;
    }

    public double getY(){
        return y;
    }

    public double getX(){
        return x;
    }

    public void setX(double x){
        this.x=x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getCoutAmelioration(){
        return this.cout;
    }

    public int getNivMax(){
        return this.nivMax;
    }

    public int getCout(){
        return this.cout;
    }

    public int prixVente(){
        return this.cout / 2;
    }

    public int getDegat(){
        return degat;
    }

    public void setDegat(int degat) {
        this.degat = degat;
    }
    public String getNom(){
        return this.nom;
    }

    public abstract boolean enPlace();

    /**
     * tous les pieges on une attaque qui se differencie
     */
    public abstract void attaqueE(ArrayList<Ennemi> ennemiSurCase);
}