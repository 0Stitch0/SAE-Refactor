package universite_paris8.iut.mdubois.killer_princess.modele;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Destructible extends Piege {
    private int vie;
    private IntegerProperty pdv;

    public Destructible(double x, double y, Jeu partie, int vie, int degat, String nom, int prime, int cout){
        super(x, y, partie, vie, degat, nom, prime, cout);
        this.pdv = new SimpleIntegerProperty(vie);
    }

    public void pdvPerdus(int degats){
        if (degats>0) {
            this.pdv.set(this.pdv.get() - degats);
        } else {
            System.out.println("valeur invalide");
        }
    }

    public boolean enPlace(){
        return this.pdv.get() > 0;
    }

    public int getVie() {
        return vie;
    }

    public int getDegat() {
        return super.getDegats();
    }

    public IntegerProperty getPdvProperty() {
        return this.pdv;
    }
}