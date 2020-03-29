package GamePlay5;

import Characters.*;
import Exceptions.GameLostException;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
import view.SceneView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Level5 {
    @FXML
    public ProgressBar Bar1;

    @FXML
    public ImageView SunLane1,SunLane2,SunLane3,SunLane4,SunLane5;


    public void handleLetsRock() throws IOException, InterruptedException {
        initializelevel();
    }

    @FXML
    public Label labelsun;

    @FXML
    private Label nosun;

    @FXML
    private ImageView sun1;

    @FXML
    private Button letsrockbutton;

    @FXML
    private ImageView letsrockimage;


    @FXML
    public ImageView Zombie1, Zombie2, Zombie3, Zombie4, Zombie5, ZombieCap, ZombieCap2, ZombieDance;

    public IntegerProperty SunCollected = new SimpleIntegerProperty(50);

    ArrayList<Sun> sunsLevel1 = new ArrayList<Sun>();
    ArrayList<Zombie> list = new ArrayList<>();

    ArrayList<ImageView> images = new ArrayList<>();

    public void initializelevel() throws IOException, InterruptedException {

        AnchorPane ancr = new AnchorPane();
        labelsun.textProperty().bind(SunCollected.asString());

        letsrockimage.setVisible(false);
        letsrockbutton.setVisible(false);

        images.add(Zombie1);
        images.add(Zombie2);
        images.add(Zombie3);
        images.add(Zombie4);
        images.add(Zombie5);
        images.add(ZombieDance);
        images.add(ZombieCap);
        images.add(ZombieCap2);


        for (int i = 0; i < 5 ; i++) {

            spawnNormal(images.get(i));
        }
        list.add(new DancingZombie(3, ZombieDance));
        list.add(new CapZombie(2, ZombieCap));
        list.add(new CapZombie(4, ZombieCap2));


        int[] ar = new int[]{4, 2, 5, 0, 1, 3, 6, 7};

        Bar1.setProgress(0.05);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(Bar1.progressProperty(), 1.0);
        KeyFrame keyFrame = new KeyFrame(new Duration(120000), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();


        Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(6), (evt) -> {
            sun1.setVisible(true);
            Sun s1 = new Sun(sun1);
            s1.DropSun();
            sunsLevel1.add(s1);
        }));
        timeline1.setCycleCount(10);
        timeline1.play();

        Timeline time = new Timeline(new KeyFrame(Duration.seconds(15), (evt) -> {
            list.get(ar[i]).myImage.setX(-100);
            list.get(ar[i]).myImage.setY(-50);
            try {
                list.get(ar[i]).move();
            } catch (GameLostException e) {
                e.printStackTrace();
            }
            i++;
        }));
        time.setCycleCount(7);
        time.play();

    }

    public int i = 0;

    public void spawnNormal(ImageView i1) {

        list.add(new NormalZombie(i, i1));
        i++;

    }

    ArrayList<Plant> level1 = new ArrayList<Plant>();
    Plant CurrentPlant;

    public void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../PlayUser/LevelScreen.fxml"));
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

    @FXML
    public void handleSunClick() {
        SunCollected.set(SunCollected.get() + 50);
        sun1.setVisible(false);
    }
    @FXML
    public void handleSunClick1() {
        SunCollected.set(SunCollected.get() + 50);
        SunLane1.setVisible(false);
    }
    @FXML
    public void handleSunClick2() {
        SunCollected.set(SunCollected.get() + 50);
        SunLane2.setVisible(false);
    }
    @FXML
    public void handleSunClick3() {
        SunCollected.set(SunCollected.get() + 50);
        SunLane3.setVisible(false);
    }
    @FXML
    public void handleSunClick4() {
        SunCollected.set(SunCollected.get() + 50);
        SunLane4.setVisible(false);
    }
    @FXML
    public void handleSunClick5() {
        SunCollected.set(SunCollected.get() + 50);
        SunLane5.setVisible(false);
    }


    @FXML
    private ImageView Tile25;
    @FXML
    private ImageView Tile1;
    @FXML
    private ImageView Tile2;
    @FXML
    private ImageView Tile3;
    @FXML
    private ImageView Tile4;
    @FXML
    private ImageView Tile5;
    @FXML
    private ImageView Tile6;
    @FXML
    private ImageView Tile7;
    @FXML
    private ImageView Tile8;


    @FXML
    private ImageView Tile26;

    @FXML
    private ImageView Tile27;

    @FXML
    private ImageView Tile28;

    @FXML
    private ImageView Tile29;

    @FXML
    private ImageView Tile30;

    @FXML
    private ImageView Tile31;

    @FXML
    private ImageView Tile32;

    @FXML
    private ImageView Tile9;


    @FXML
    private ImageView Tile10;

    @FXML
    private ImageView Tile11;

    @FXML
    private ImageView Tile12;

    @FXML
    private ImageView Tile13;

    @FXML
    private ImageView Tile14;

    @FXML
    private ImageView Tile15;

    @FXML
    private ImageView Tile16;
    @FXML
    private ImageView Tile17;


    @FXML
    private ImageView Tile18;

    @FXML
    private ImageView Tile19;

    @FXML
    private ImageView Tile20;

    @FXML
    private ImageView Tile21;

    @FXML
    private ImageView Tile22;

    @FXML
    private ImageView Tile23;

    @FXML
    private ImageView Tile24;
    @FXML
    private ImageView Tile33;
    @FXML
    private ImageView Tile34;
    @FXML
    private ImageView Tile35;
    @FXML
    private ImageView Tile36;
    @FXML
    private ImageView Tile37;
    @FXML
    private ImageView Tile38;
    @FXML
    private ImageView Tile39;
    @FXML
    private ImageView Tile40;
    @FXML
    private ImageView pea;

    @FXML
    private ImageView PeaTile9;

    @FXML
    private ImageView PeaTile10;

    @FXML
    private ImageView PeaTile11;
    @FXML
    private ImageView PeaTile12;

    @FXML
    private ImageView PeaTile13;

    @FXML
    private ImageView PeaTile14;

    @FXML
    private ImageView PeaTile15;
    @FXML
    private ImageView PeaTile16;
    @FXML
    private ImageView PeaTile17;
    @FXML
    private ImageView PeaTile18;
    @FXML
    private ImageView PeaTile19;
    @FXML
    private ImageView PeaTile20;
    @FXML
    private ImageView PeaTile21;
    @FXML
    private ImageView PeaTile22;
    @FXML
    private ImageView PeaTile23;
    @FXML
    private ImageView PeaTile24;
    @FXML
    private ImageView PeaTile25;
    @FXML
    private ImageView PeaTile26;
    @FXML
    private ImageView PeaTile27;
    @FXML
    private ImageView PeaTile28;
    @FXML
    private ImageView PeaTile29;
    @FXML
    private ImageView PeaTile30;
    @FXML
    private ImageView PeaTile31;
    @FXML
    private ImageView PeaTile32;

    @FXML
    private ImageView PeaTile1;

    @FXML
    private ImageView PeaTile2;

    @FXML
    private ImageView PeaTile3;
    @FXML
    private ImageView PeaTile4;

    @FXML
    private ImageView PeaTile5;

    @FXML
    private ImageView PeaTile6;

    @FXML
    private ImageView PeaTile7;
    @FXML
    private ImageView PeaTile8;
    @FXML
    private ImageView PeaTile33;
    @FXML
    private ImageView PeaTile34;
    @FXML
    private ImageView PeaTile35;
    @FXML
    private ImageView PeaTile36;
    @FXML
    private ImageView PeaTile37;
    @FXML
    private ImageView PeaTile38;
    @FXML
    private ImageView PeaTile39;
    @FXML
    private ImageView PeaTile40;
    @FXML
    private ImageView SunFlower;
    @FXML
    private ImageView Walnut;


    @FXML
    private ImageView Cherry;
    @FXML
    public ImageView CherryLane1,CherryLane2,CherryLane3,CherryLane4,CherryLane5;

    int flag = 0;

    ArrayList<Plant> level4 = new ArrayList<Plant>();


    @FXML
    private void handleDrag(MouseEvent event) {
        if (SunCollected.get() < 100) {
            nosun.setVisible(true);

        } else {
            Dragboard db = pea.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            nosun.setVisible(false);
            flag = 0;
            SunCollected.set(SunCollected.get() - 100);
            cb.putImage(pea.getImage());

            db.setContent(cb);

            event.consume();
        }

    }

    @FXML
    private void handleDrag4(MouseEvent event) {
        if (SunCollected.get() < 100) {
            nosun.setVisible(true);
        } else {
            Dragboard db = Cherry.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            nosun.setVisible(false);
            flag = 3;
            SunCollected.set(SunCollected.get() - 150);
            cb.putImage(Cherry.getImage());

            db.setContent(cb);

            event.consume();
        }

    }


    @FXML
    private void handleDrag2(MouseEvent event) {
        if (SunCollected.get() < 50) {
            nosun.setVisible(true);
        } else {
            Dragboard db = SunFlower.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            nosun.setVisible(false);
            flag = 1;
            SunCollected.set(SunCollected.get() - 50);
            cb.putImage(SunFlower.getImage());

            db.setContent(cb);

            event.consume();
        }

    }

    @FXML
    private void handleDrag3(MouseEvent event) {
        if (SunCollected.get() < 100) {
            nosun.setVisible(true);
        } else {
            Dragboard db = Walnut.startDragAndDrop(TransferMode.ANY);
            ClipboardContent cb = new ClipboardContent();
            nosun.setVisible(false);
            flag = 2;
            SunCollected.set(SunCollected.get() - 50);
            cb.putImage(Walnut.getImage());

            db.setContent(cb);

            event.consume();
        }

    }


    @FXML
    private void handlePlantDrag(DragEvent event) {
        if (event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.ANY);
        }


    }

    @FXML
    private void handleDragDrop1(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile1.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile1);
        ImageView plb = new ImageView(SunFlower.getImage());
        Plant p2 = new Sunflower(plb, SunLane1);


        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile1.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();


        }
        else if (flag == 1) {
            CurrentPlant = p2;
            level4.add(p2);
            p2.attack();
        }

        CurrentPlant.setX(1);
        CurrentPlant.setY(1);

    }

    @FXML
    private void handleDragDrop2(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile2.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile2);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile2.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();


        }

        CurrentPlant.setX(2);
        CurrentPlant.setY(1);

    }

    @FXML
    private void handleDragDrop3(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile3.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile3);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile3.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(3);
        CurrentPlant.setY(1);

    }

    @FXML
    private void handleDragDrop4(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile4.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile4);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile4.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();


        }
        CurrentPlant.setX(4);
        CurrentPlant.setY(1);


    }

    @FXML
    private void handleDragDrop5(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile5.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile5);
        ImageView plc = new ImageView(CherryLane1.getImage());
        Plant p3 = new CherryBomb(plc);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile5.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        if(flag == 3){
            CurrentPlant = p3;
            level4.add(p3);
            p3.myImage.setVisible(true);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(500), (evt) -> {
                p3.myImage.setVisible(false);
            }));
            timeline1.setCycleCount(1);
            timeline1.play();


        }
        CurrentPlant.setX(5);
        CurrentPlant.setY(1);



    }

    @FXML
    private void handleDragDrop6(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile6.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile6);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile6.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();


        }
        CurrentPlant.setX(6);
        CurrentPlant.setY(1);


    }

    @FXML
    private void handleDragDrop7(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile7.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile7);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile7.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(7);
        CurrentPlant.setY(1);


    }

    @FXML
    private void handleDragDrop8(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile8.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile8);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile8.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();


        }
        CurrentPlant.setX(8);
        CurrentPlant.setY(1);



    }

    @FXML
    private void handleDragDrop33(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile33.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile33);
        ImageView plb = new ImageView(SunFlower.getImage());
        Plant p2 = new Sunflower(plb, SunLane5);


        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile33.setVisible(true);

            Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        else if (flag == 1) {
            CurrentPlant = p2;
            level4.add(p2);
            p2.attack();
        }
        CurrentPlant.setX(1);
        CurrentPlant.setY(5);



    }

    @FXML
    private void handleDragDrop34(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile34.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile34);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile34.setVisible(true);

            Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(2);
        CurrentPlant.setY(5);


    }

    @FXML
    private void handleDragDrop35(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile35.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile35);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile35.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(3);
        CurrentPlant.setY(5);


    }

    @FXML
    private void handleDragDrop36(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile36.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile36);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile36.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(4);
        CurrentPlant.setY(5);


    }

    @FXML
    private void handleDragDrop37(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile37.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile37);
        ImageView plc = new ImageView(CherryLane5.getImage());
        Plant p3 = new CherryBomb(plc);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile37.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        if(flag == 3){
            CurrentPlant = p3;
            level4.add(p3);
            p3.myImage.setVisible(true);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(500), (evt) -> {
                p3.myImage.setVisible(false);
            }));
            timeline1.setCycleCount(1);
            timeline1.play();


        }

        CurrentPlant.setX(3);
        CurrentPlant.setY(5);

    }

    @FXML
    private void handleDragDrop38(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile39.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile38);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile38.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(6);
        CurrentPlant.setY(5);

    }

    @FXML
    private void handleDragDrop40(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile40.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile40);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile40.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(8);
        CurrentPlant.setY(5);



    }

    @FXML
    private void handleDragDrop39(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile39.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile39);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile39.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(7);
        CurrentPlant.setY(5);

    }

    @FXML
    private void handleDragDrop25(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile25.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile25);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile25.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(8);
        CurrentPlant.setY(4);


    }

    @FXML
    private void handleDragDrop26(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile26.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile26);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile26.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(7);
        CurrentPlant.setY(4);

    }

    @FXML
    private void handleDragDrop27(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile27.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile27);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile27.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(6);
        CurrentPlant.setY(4);

    }

    @FXML
    private void handleDragDrop28(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile28.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile28);
        ImageView plc = new ImageView(CherryLane4.getImage());
        Plant p3 = new CherryBomb(plc);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile28.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        if(flag == 3){
            CurrentPlant = p3;
            level4.add(p3);
            p3.myImage.setVisible(true);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(500), (evt) -> {
                p3.myImage.setVisible(false);
            }));
            timeline1.setCycleCount(1);
            timeline1.play();


        }

        CurrentPlant.setX(5);
        CurrentPlant.setY(4);

    }

    @FXML
    private void handleDragDrop29(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile29.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile29);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile29.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(4);
        CurrentPlant.setY(4);


    }

    @FXML
    private void handleDragDrop30(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile30.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile30);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile30.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(3);
        CurrentPlant.setY(4);

    }

    @FXML
    private void handleDragDrop31(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile31.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile31);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile31.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(2);
        CurrentPlant.setY(4);


    }

    @FXML
    private void handleDragDrop32(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile32.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile32);
        ImageView plb = new ImageView(SunFlower.getImage());
        Plant p2 = new Sunflower(plb, SunLane4);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile32.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        else if (flag == 1) {
            CurrentPlant = p2;
            level4.add(p2);
            p2.attack();
        }
        CurrentPlant.setX(1);
        CurrentPlant.setY(4);

    }

    @FXML
    private void handleDragDrop9(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile9.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile9);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile9.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();
            p.move();

        }
        CurrentPlant.setX(8);
        CurrentPlant.setY(2);

    }

    @FXML
    private void handleDragDrop10(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile10.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile10);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile10.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(7);
        CurrentPlant.setY(2);


    }

    @FXML
    private void handleDragDrop11(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile11.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile11);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile11.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(6);
        CurrentPlant.setY(2);

    }

    @FXML
    private void handleDragDrop12(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile12.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile12);
        ImageView plc = new ImageView(CherryLane2.getImage());
        Plant p3 = new CherryBomb(plc);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile12.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        if(flag == 3){
            CurrentPlant = p3;
            level4.add(p3);
            p3.myImage.setVisible(true);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(500), (evt) -> {
                p3.myImage.setVisible(false);
            }));
            timeline1.setCycleCount(1);
            timeline1.play();


        }

        CurrentPlant.setX(5);
        CurrentPlant.setY(2);


    }

    @FXML
    private void handleDragDrop13(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile13.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile13);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile13.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(4);
        CurrentPlant.setY(2);

    }

    @FXML
    private void handleDragDrop14(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile14.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile14);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile14.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(3);
        CurrentPlant.setY(2);


    }

    @FXML
    private void handleDragDrop15(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile15.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile15);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile15.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(2);
        CurrentPlant.setY(2);

    }

    @FXML
    private void handleDragDrop16(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile16.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile16);
        ImageView plb = new ImageView(SunFlower.getImage());
        Plant p2 = new Sunflower(plb, SunLane2);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile16.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        else if (flag == 1) {
            CurrentPlant = p2;
            level4.add(p2);
            p2.attack();
        }

        CurrentPlant.setX(1);
        CurrentPlant.setY(2);

    }

    @FXML
    private void handleDragDrop17(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile17.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile17);
        ImageView plb = new ImageView(SunFlower.getImage());
        Sunflower p2 = new Sunflower(plb, SunLane3);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile17.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        else if (flag == 1) {
            CurrentPlant = p2;
            level4.add(p2);
            p2.attack();
        }

        CurrentPlant.setX(1);
        CurrentPlant.setY(3);

    }

    @FXML
    private void handleDragDrop18(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile18.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile18);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile18.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(2);
        CurrentPlant.setY(3);


    }

    @FXML
    private void handleDragDrop19(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile19.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile19);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile19.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(3);
        CurrentPlant.setY(3);


    }

    @FXML
    private void handleDragDrop20(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile20.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile20);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile20.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(4);
        CurrentPlant.setY(3);



    }

    @FXML
    private void handleDragDrop21(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile21.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile21);
        ImageView plc = new ImageView(CherryLane3.getImage());
        Plant p3 = new CherryBomb(plc);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile21.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        if(flag == 3){
            CurrentPlant = p3;
            level4.add(p3);
            p3.myImage.setVisible(true);
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.seconds(2), (evt) -> {
                p3.myImage.setVisible(false);
            }));
            timeline1.setCycleCount(1);
            timeline1.play();


        }
        CurrentPlant.setX(5);
        CurrentPlant.setY(3);



    }

    @FXML
    private void handleDragDrop22(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile22.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile22);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile22.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }

        CurrentPlant.setX(6);
        CurrentPlant.setY(3);

    }

    @FXML
    private void handleDragDrop23(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile23.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile23);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile23.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(7);
        CurrentPlant.setY(3);

    }

    @FXML
    private void handleDragDrop24(DragEvent event) {
        Image i = event.getDragboard().getImage();
        Tile24.setImage(i);
        ImageView pla = new ImageView(pea.getImage());
        Plant p1 = new PeaShooter(pla, PeaTile24);

        if (flag == 0) {
            CurrentPlant = p1;
            level4.add(p1);
            CurrentPlant.setX(0);
            CurrentPlant.setY(0);
            PeaTile24.setVisible(true);

            Characters.Pea p = CurrentPlant.returnPea();
            p.peaView.setX(-50);
            p.peaView.setY(0);
            p.move();
            Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(200), (evt) -> {
                checkCollision(p, list);
            }));
            timeline1.setCycleCount(Animation.INDEFINITE);
            timeline1.play();

        }
        CurrentPlant.setX(8);
        CurrentPlant.setY(3);


    }

    public void checkCollision(Pea obj1, ArrayList<Zombie> list) {

        for (int j = 0; j < list.size(); j++) {
            Zombie obj2 = list.get(j);
            if (obj2.isAlive()) {
                //System.out.println(obj2.getLocationX() +  "      Printing Location of zombie"  + (j + 1));
                if (obj1.LocationX == obj2.getLocationX() && obj1.LocationY == obj2.getLocationY()) {
                    //System.out.println("Collision Detected");
                    obj2.ZombieUpdate(15);
                    obj1.peaView.setVisible(false);

                }
                /*if(obj2.getLocationX() == -1 && !lane1.used){
                    lane1.UseMower();
                    lane1.used = true;
                }
                if(lane1.used = true){
                    for (Zombie z : Zombieslvl1
                         ) {
                        z.killZombie();

                    }

                }*/

            }

        }


    }

    @FXML
    public void handleRetreat(){
        for (int i=0; i<list.size(); i++){
            list.get(i).Retreat();
        }
    }
}
