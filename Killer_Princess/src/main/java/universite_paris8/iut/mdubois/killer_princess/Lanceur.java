package universite_paris8.iut.mdubois.killer_princess;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Lanceur  extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Lanceur.class.getResource("viewMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 965, 840);
        stage.setTitle("Killer Princess - Tower Defense");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}