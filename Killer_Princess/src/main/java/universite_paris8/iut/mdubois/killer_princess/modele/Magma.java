package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public class Magma extends Piege {
    private static final int DEGAT = 1;
    private static final int INTERVALLE = 30; // attaque toutes les demi-secondes
    private int cooldown = 0;
    private ArrayList<Ennemi> ennemisQuiOntMarche = new ArrayList<>();

    public Magma(double x, double y, Jeu partie) {
        super(x, y, partie, 20, 10, "MAGMA", 10, 20);
    }

    public boolean enPlace() {
        return true;
    }

    @Override
    public void attaqueE(ArrayList<Ennemi> ennemiSurCase) {
        if (estEnCooldown()) return;

        enregistrerEnnemisQuiMarchent(ennemiSurCase);
        boolean aAttaque = infligerDegatsZone(ennemiSurCase);

        if(aAttaque){
            cooldown = INTERVALLE;
        }
    }

    /**
     * verif si le cooldown est actif
     */
    private boolean estEnCooldown() {
        if(cooldown > 0){
            cooldown--;
            return true;
        }
        return false;
    }

    /**
     * enregiste les ennemis qui on marcher sur magma
     */
    private void enregistrerEnnemisQuiMarchent(ArrayList<Ennemi> ennemiSurCase){
        for(Ennemi ennemi : ennemiSurCase){
            if(estSurLaCase(ennemi) && !ennemisQuiOntMarche.contains(ennemi)){
                ennemisQuiOntMarche.add(ennemi);
            }
        }
    }

    /**
     * inflige les degats aux ennemmis sur et apres etre passe sur la case
     */
    private boolean infligerDegatsZone(ArrayList<Ennemi> ennemiSurCase){
        boolean aAttaque = false;
        for (Ennemi ennemi : ennemiSurCase){
            if(ennemisQuiOntMarche.contains(ennemi) && estDansZone(ennemi)){
                ennemi.enleverPdv(DEGAT);
                aAttaque = true;
            }
        }
        return aAttaque;
    }

    /**
     * dit si enemis sur case
      */
    private boolean estSurLaCase(Ennemi ennemi) {
        return Math.abs(ennemi.getX() - this.getX()) < 32 && Math.abs(ennemi.getY() - this.getY()) < 32;
    }

    /**
     * dit si ennemis dans les 4 cases apres le magma
      */
    private boolean estDansZone(Ennemi ennemi){
        if(Math.abs(ennemi.getY() - this.getY()) >= 32){
            return false;
        }
        return ennemi.getX() >= this.getX() && ennemi.getX() <= this.getX() + (4 * 32);
    }
}