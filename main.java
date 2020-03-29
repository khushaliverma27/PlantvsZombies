package sample;

import javafx.application.Application;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import view.SceneView;

import java.util.Iterator;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            //Parent root = FXMLLoader.load(getClass().getResource("/view/sample1.fxml"));
            Parent root = FXMLLoader.load(Main.class.getResource("/sample/sample.fxml"));
            SceneView sceneviewmanager = new SceneView();
            primaryStage = sceneviewmanager.getMainStage();
            primaryStage.setTitle("Plants VS Zombies");
            Scene scene = new Scene(root, 600, 400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() throws Exception{
        System.exit(0);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
