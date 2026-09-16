package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.ArrayList;

public class Canon extends Tour {
    private static final int DEGAT = 3;
    private static final int INTERVALLE = 60;
    private int cooldown = 0;
    private Ennemi cibleActuelle = null; // ennemi visé pour l'animation

    public Canon(double x, double y, Jeu partie) {
        super(x, y, partie, 10, 20, "CANON", 75, 2, 3);
    }

    public Ennemi getCibleActuelle() {
        return cibleActuelle;
    }

    @Override
    public void attaqueE(ArrayList<Ennemi> ennemiSurCase) {
        cibleActuelle = null;

        if (cooldown > 0) {
            cooldown--;
            return;
        }

        double rayonPixels = 3 * 32; // 3 cases en pixels

        for (Ennemi ennemi : ennemiSurCase) {
            double dx = ennemi.getX() - this.getX();
            double dy = ennemi.getY() - this.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);

            if (distance <= rayonPixels) {
                ennemi.enleverPdv(DEGAT);
                cibleActuelle = ennemi; // mémorise la cible pour l'animation
                cooldown = INTERVALLE;
                return; // 1 seul ennemi à la fois
            }
        }
    }

}