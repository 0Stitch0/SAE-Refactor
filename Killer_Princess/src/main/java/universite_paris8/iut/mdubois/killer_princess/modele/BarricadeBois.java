package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public class BarricadeBois extends Destructible {
    private static final int degatInflig= 2;
    private static final int intervalAttaque= 60; // 1 attaque par seconde
    private int cooldown= 0;

    public BarricadeBois(double x, double y, Jeu partie) {
        super(x, y, partie, 20, degatInflig, "BARRICADE_BOIS", 10, 20);
    }


    @Override
    public void attaqueE(ArrayList<Ennemi> ennemiSurCase) {
        double caseFaceX= this.getX()+25;
        double caseFaceY= this.getY();

        if(cooldown>0){
            cooldown--;
            return;
        }
        for(Ennemi ennemi : ennemiSurCase){
            if(Math.abs(ennemi.getX()-caseFaceX)<1 && Math.abs(ennemi.getY()-caseFaceY)<=0){
                ennemi.enleverPdv(degatInflig);
                cooldown= intervalAttaque;
            }
        }
    }
}