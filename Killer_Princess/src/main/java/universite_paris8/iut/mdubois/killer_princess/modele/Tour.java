package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public abstract class Tour extends Destructible {
    int portee;

    public Tour(double x, double y, Jeu partie, int vie, int degat, String nom, int prime, int cout, int portee){
        super( x, y, partie,  vie, degat, nom, prime, cout);
        this.portee = portee;
    }

    public void amelioration(){
        super.amelioration();
        this.setPortee(this.portee+2);
    }

    public void setPortee(int portee) {
        this.portee = portee;
    }

    public int getPortee() {
        return portee;
    }

    public boolean enPlace(){
        return true;
    }
}
