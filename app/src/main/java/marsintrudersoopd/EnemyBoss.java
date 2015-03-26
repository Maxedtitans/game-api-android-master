package marsintrudersoopd;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;
import java.util.ArrayList;

public class EnemyBoss extends MoveableGameObject implements IAlarm{
    private Alarm myAlarm;
    GameManager gameManager;
    private int health;
    private int NUMBEROFBULLETS;

    public EnemyBoss(GameManager gameManager){
        this.gameManager = gameManager;
        setSprite("finalboss");
        health = 5;
        myAlarm = new Alarm(4, 60, this);
        myAlarm.startAlarm();
        NUMBEROFBULLETS = 4;
    }

    public void shoot() {
        for(int i=0; i< NUMBEROFBULLETS ; i++){
            Bullet bullet = new Bullet();
            gameManager.addGameObject(bullet, this.getX() + i * 65, this.getY() + getFrameHeight() + 4);
            bullet.setDirectionSpeed(180, 5);
        }
        myAlarm.restartAlarm();
    }

    @Override
    public void update() {
        super.update();
        ArrayList<GameObject> gebotst = getCollidedObjects();
        if (gebotst != null) {
            for (GameObject g : gebotst) {
                if (g instanceof Bullet) {
                    if (health > 0){
                        health--;
                        gameManager.deleteGameObject(g);
                    }
                    if (health == 0){
                        gameManager.deleteGameObject(g);
                        gameManager.deleteGameObject(this);
                    }
                }
            }
        }
    }

    @Override
    public void triggerAlarm(int alarmID) {
        shoot();
    }
}
