package universite_paris8.iut.mdubois.killer_princess.modele;

import java.util.Objects;

public class Case {
    private int col, lig, poids;//lign =y, col=x

    public Case(int ligne, int colonne, int poids) {
        col= colonne;
        lig=ligne;
        this.poids=poids;
    }

    public Case(int ligne, int colonne) {
        col= colonne;
        lig=ligne;
    }

    public int getLigne() { //lign = y
        return lig;
    }

    public int getColonne() { //colonne = x
        return col;
    }
//pas besoin de poids dans BFS
//    public int getPoids() {
//        return poids;
//    }
//
//    public void setPoids(double poids) {
//      this.poids=poids;
//    }
    @Override
    public int hashCode() {
        // Deux sommets au même (x, y) sont le même sommet,
        // peu importe leur poids
        return Objects.hash(col, lig);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Case)) return false;
        Case other = (Case) obj;
        return this.col == other.col && this.lig == other.lig;
    }

    @Override
    public String toString() {
        return "Sommet(" + col + ", " + lig + ", poids=" + poids + ")";
    }

    //@Override
    public int compareTo(Case o) {
        // Tri par poids en priorité (utile pour Dijkstra / PriorityQueue)
        int cmp = Double.compare(this.poids, o.poids);
        if (cmp != 0) return cmp;

        // À poids égal, on compare x puis y pour garder un ordre stable
        cmp = Integer.compare(this.col, o.col);
        if (cmp != 0) return cmp;

        return Integer.compare(this.lig, o.lig);
    }


}

