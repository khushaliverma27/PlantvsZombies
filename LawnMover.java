package sample;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


import java.io.Serializable;

public class LawnMover implements Serializable {

    private int LocationX;
    private int LocationY;
    private boolean upgraded = false;
    public boolean used = false;
    private float speed;
    public ImageView img;

    public LawnMover(ImageView im , int Y){
        img = im;
        LocationX = 0;
        LocationY = Y;

    }


    public boolean isUpgraded(){
        return upgraded;
    }

    public float getSpeed(){
        return speed;
    }

    public boolean checkUsed(){
        return used;
    }

    public void UseMower(){
        this.used = true;
        Timeline timelinenew = new Timeline(new KeyFrame(Duration.millis(10), (evt) -> {
            img.setTranslateX(img.getTranslateX() + 1 );
        }));
        timelinenew.setCycleCount(Animation.INDEFINITE);
        timelinenew.play();
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(288), (evt) -> {
            LocationX++;
        }));
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();



    }
    public int getLocationX(){
        return LocationX;
    }

    public int getLocationY() {
        return LocationY;
    }
}
