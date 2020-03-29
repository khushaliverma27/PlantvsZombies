package Scene2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SceneView;

public class Scene2Controller {

    public void handlePlay()
    {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("../PlayUser/PlayOption.fxml"));
            SceneView sceneviewmanager = new SceneView();
            Stage scene2Stage = sceneviewmanager.getMainStage();
            scene2Stage.setTitle("Plants VS Zombies");
            Scene scene = new Scene(root, 600, 400);
            scene2Stage.setScene(scene);
            scene2Stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleInstructions() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../GameOptions/Instructions.fxml"));
            SceneView sceneviewmanager = new SceneView();
            Stage scene2Stage = sceneviewmanager.getMainStage();
            scene2Stage.setTitle("Plants VS Zombies");
            Scene scene = new Scene(root, 600, 400);
            scene2Stage.setScene(scene);
            scene2Stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public void handleOptions()
        {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("../GameOptions/Options.fxml"));
                SceneView sceneviewmanager = new SceneView();
                Stage scene2Stage = sceneviewmanager.getMainStage();
                scene2Stage.setTitle("Plants VS Zombies");
                Scene scene = new Scene(root, 600, 400);
                scene2Stage.setScene(scene);
                scene2Stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void handleAlmanac()
        {
            try{
                Parent root = FXMLLoader.load(getClass().getResource("../GameOptions/Almanac1.fxml"));
                SceneView sceneviewmanager = new SceneView();
                Stage scene2Stage = sceneviewmanager.getMainStage();
                scene2Stage.setTitle("Plants VS Zombies");
                Scene scene = new Scene(root, 600, 400);
                scene2Stage.setScene(scene);
                scene2Stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void handleExit(){
        System.exit(0);
        }
}
