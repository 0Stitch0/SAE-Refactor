package universite_paris8.iut.mdubois.killer_princess.vue;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import universite_paris8.iut.mdubois.killer_princess.modele.Carte;
import java.net.URL;
import java.util.HashMap;

public class VueCarte {
    private HashMap<Integer, Image> tileImage;
    private Carte carte;
    @FXML
    private TilePane panneauTuile;
    private ImageView[][] imageViewsTiles;

    public VueCarte(TilePane panneauTuile, Carte carte){
        tileImage = new HashMap<>();
        this.carte = carte;
        this.panneauTuile = panneauTuile;
        this.panneauTuile.setPrefTileWidth(32);
        this.panneauTuile.setPrefTileHeight(32);
        this.panneauTuile.setPrefColumns(carte.getColonne()); // ajoute ici
        this.imageViewsTiles = new ImageView[carte.getLigne()][carte.getColonne()];
        initialaseTuile();
        affichage();
    }

    public void ajoutTuile(int id, String chemin){
        Image image = creerImage(chemin);
        if(image != null){
            tileImage.put(id, image);
        }
    }
    //sencé recup le chemin
    public Image creerImage(String chemin){
        URL urlIm= getClass().getResource(chemin);
        if(urlIm == null){
            System.out.println("Image non trouvée: "+chemin);
            return null;
        }
        return new Image(urlIm.toString());
    }

    //tile qui sont entre 10 et 19 compris = sol (10=fer, 11=sable, 12=herbe, ...)
    //tile entre 20 et 29 compris = obstacle (20=arbe, 21=buisson, 22=eau?...)
    //tile entre 30 et 39 compris = piege (30= trappe, 31=magma, ...)

    //va chercher les image dans ressources
    public void initialaseTuile(){
        ajoutTuile(10,"/universite_paris8/iut/mdubois/killer_princess/Tile/testePierre.png");
        ajoutTuile(100,"/universite_paris8/iut/mdubois/killer_princess/Tile/sable.png");
        ajoutTuile(12,"/universite_paris8/iut/mdubois/killer_princess/Tile/herbeFonce.png");
        ajoutTuile(13,"/universite_paris8/iut/mdubois/killer_princess/Tile/herbeClair.png");
        ajoutTuile(14,"/universite_paris8/iut/mdubois/killer_princess/Tile/herbeFleur.png");
        ajoutTuile(20, "/universite_paris8/iut/mdubois/killer_princess/Obstacle/arbreSeul.png");
        ajoutTuile(21, "/universite_paris8/iut/mdubois/killer_princess/Obstacle/buisson.png");
        ajoutTuile(11, "/universite_paris8/iut/mdubois/killer_princess/Tile/herbeFonce.png");
        ajoutTuile(9, "/universite_paris8/iut/mdubois/killer_princess/Tile/herbeFonce.png");
        ajoutTuile(8, "/universite_paris8/iut/mdubois/killer_princess/Tile/herbeFonce.png");
        ajoutTuile(7, "/universite_paris8/iut/mdubois/killer_princess/Tile/herbeFonce.png");
    }

    //remplace l'id par l'image dans Carte pour sont affichage
    public void affichage(){
        panneauTuile.getChildren().clear();
        for (int i = 0; i < carte.getLigne(); i++) {
            for (int j = 0; j < carte.getColonne(); j++) {
                int tileId = carte.getCase(i, j);
                Image image = tileImage.get(tileId);
                if (image != null) {
                    ImageView imageView = new ImageView(image);
                    imageView.setFitHeight(32);
                    imageView.setFitWidth(32);
                    imageViewsTiles[i][j] = imageView;
                    panneauTuile.getChildren().add(imageView);
                } else {
                    System.out.println("ID de tile inconnu: " + tileId + " à la position [" + i + ", " + j + "]");
                }
            }
        }
    }
}
