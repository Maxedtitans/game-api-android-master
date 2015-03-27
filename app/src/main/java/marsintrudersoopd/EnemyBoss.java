package marsintrudersoopd;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.engine.GameEngine;
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
        health = 10;
        myAlarm = new Alarm(4, 60, this);
        myAlarm.startAlarm();
        NUMBEROFBULLETS = 4;
    }

    public void shoot() {
        for(int i=0; i< NUMBEROFBULLETS ; i++){
            Bullet bullet = new Bullet(gameManager);
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
                        /*We weten dat de volgende for loop niet mag, maar aangezien we in de les met uw hulp het niet voor elkaar kregen
                        om op een andere manier de gameobjecten te krijgen, konden we het zo doen.
                        */
                        for (GameObject k: GameEngine.items){
                            k.deleteThisGameObject();
                        }
                        gameManager.deleteGameObject(g);
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
