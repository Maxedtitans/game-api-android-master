package marsintrudersoopd;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;
import java.util.ArrayList;

public class Vijand extends MoveableGameObject implements IAlarm{
    GameManager gameManager;
    EnemyContainer enemycontainer;
    private boolean kanSchieten;
    private Alarm myAlarm;

    public Vijand(GameManager gameManager, EnemyContainer enemycontainer, boolean kanSchieten){
        setSprite("alien");
        this.gameManager = gameManager;
        this.enemycontainer = enemycontainer;
        this.kanSchieten = kanSchieten;
        if (kanSchieten) {
            myAlarm = new Alarm(3, 60, this);
            myAlarm.startAlarm();
        }
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

    public void shoot() {
       Bullet bullet = new Bullet();
       gameManager.addGameObject(bullet, this.getX() + getFrameWidth() / 2, this.getY() + getFrameHeight() + 4);
       bullet.setDirectionSpeed(180, 5);
       myAlarm.restartAlarm();
    }

    @Override
    public void update() {
        super.update();
        ArrayList<GameObject> gebotst = getCollidedObjects();
        if (gebotst != null){
            for(GameObject g : gebotst){
                if (g instanceof Bullet){
                    gameManager.deleteGameObject(g);
                    gameManager.deleteGameObject(this);
                    enemycontainer.vijanden.remove(this);
                }
            }
        }
    }

    @Override
    public void triggerAlarm(int alarmID) {
        shoot();
    }
}
