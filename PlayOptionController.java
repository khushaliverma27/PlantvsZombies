package PlayUser;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.SceneView;

public class PlayOptionController {

    public void handleNewUser(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("../EnterGame/UserInfo.fxml"));
            SceneView sceneviewmanager = new SceneView();
            Stage sceneStage = sceneviewmanager.getMainStage();
            sceneStage.setTitle("Plants VS Zombies");
            Scene scene = new Scene(root, 600, 400);
            sceneStage.setScene(scene);
            sceneStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleResume(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("../EnterGame/ExistUserInfo.fxml"));
            SceneView sceneviewmanager = new SceneView();
            Stage sceneStage = sceneviewmanager.getMainStage();
            sceneStage.setTitle("Plants VS Zombies");
            Scene scene = new Scene(root, 600, 400);
            sceneStage.setScene(scene);
            sceneStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleBack(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("../Scene2/Scene2.fxml"));
            SceneView sceneviewmanager = new SceneView();
            Stage sceneStage = sceneviewmanager.getMainStage();
            sceneStage.setTitle("Plants VS Zombies");
            Scene scene = new Scene(root, 600, 400);
            sceneStage.setScene(scene);
            sceneStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
