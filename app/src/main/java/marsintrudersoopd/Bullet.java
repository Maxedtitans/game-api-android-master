package marsintrudersoopd;

import android.gameengine.icadroids.objects.MoveableGameObject;

public class Bullet extends MoveableGameObject{
    GameManager gameManager;

    public Bullet (GameManager gameManager){
        this.gameManager = gameManager;
        setSprite("shot");
    }


    @Override
    public void update(){
        super.update();
        if (this.getY() < 0 || this.getY() > gameManager.getScreenHeight()){
            deleteThisGameObject();
        }
    }
}
