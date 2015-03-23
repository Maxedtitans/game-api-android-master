package marsintruders;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;


/**
 * Created by Sjuulius on 18-3-2015.
 * @author Mart Geluk
 */
public class Player extends MoveableGameObject implements IAlarm {
    marsintruders.GameManager gameManager;
    public static int score;
    private Alarm myAlarm;
    private boolean ingedrukt = false;
    private int lives;

    public Player(GameManager gamemanager){
        this.gameManager = gamemanager;
        setSprite("ship");
        score = 0;
        lives = 3;

        myAlarm = new Alarm(2, 15, this);
        myAlarm.startAlarm();
    }
    /**
     * Called when the application starts. You can override this method to do initialization
     * at the <i>very start of the game</i>. Therefore it is only useful for objects that are
     * always present in the game, from start of the game.
     * These objects must be created in the constructor of your game.
     */
    @Override
    public void intialize() {
        super.intialize();
    }

    /**
     * Set a (new) start position which the objects jumps to when using
     * 'jumpToStartPosition()'.
     *
     * @param x The start X position
     * @param y The start Y position
     */
    @Override
    public void setStartPosition(int x, int y) {
        super.setStartPosition(x, y);
    }

    /**
     * The update-method will be called every cycle of the game loop.
     * Override this method to give an object any time driven behaviour.
     * <br />
     * Note: Always call <i>super.update()</i> first in your overrides,
     * because the default update does some important actions, like
     * moving athe object.
     *
     * @see android.gameengine.icadroids.objects.GameObject#update()
     */
    @Override
    public void update() {
        super.update();
        if (OnScreenButtons.dPadRight)
        {
            if (gameManager.player.getX() < gameManager.getScreenWidth() - getFrameWidth()) {
                gameManager.player.setX(gameManager.player.getX() + 10);
            }
        }
        if (OnScreenButtons.dPadLeft)
        {
            if (gameManager.player.getX() > 0) {
                gameManager.player.setX(gameManager.player.getX() - 10);
            }
        }
        if (OnScreenButtons.buttonA){
           if (ingedrukt == true){
               Bullet bullet = new Bullet(gameManager.player.getX(), gameManager.player.getY());
               gameManager.addGameObject(bullet, gameManager.player.getX() + 10, gameManager.player.getY());
               bullet.setDirectionSpeed(0, 8);
               myAlarm.restartAlarm();
               ingedrukt = false;
           }
        }

        ArrayList<GameObject> gebotst = getCollidedObjects();
        if (gebotst != null){
            for(GameObject g : gebotst){
                if (g instanceof Vijand || g instanceof Bullet){
                    lives--;
                    System.out.println("Je bent gedood, levens over: " + lives);
                }
            }
        }
        if (lives <= 0){
           System.out.println("GAME OVER!");
        }
    }


    @Override
    public void triggerAlarm(int alarmID) {
        ingedrukt = true;
    }

}
