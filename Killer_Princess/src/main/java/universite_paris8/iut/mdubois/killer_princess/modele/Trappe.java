package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public class Trappe extends Piege{
    private static final int degatInflig = 1000;

    public Trappe(double x, double y, Jeu partie){
        super(x, y, partie, 20, degatInflig, "TRAPPE", 10, 20);
    }

    @Override
    public void attaqueE(ArrayList<Ennemi> ennemiSurCase) {
        double caseFaceX = this.getX() + 10;
        double caseFaceY = this.getY();
        for(Ennemi ennemi : ennemiSurCase){
            if(Math.abs(ennemi.getX()-caseFaceX)<1 && Math.abs(ennemi.getY()-caseFaceY)<=0){
                ennemi.enleverPdv(degatInflig);
            }
        }
    }
    public boolean enPlace(){
        return true;
    }
}