package marsintrudersoopd;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.ArrayList;

public class Player extends MoveableGameObject implements IAlarm {
    GameManager gameManager;
    EnemyContainer enemycontainer;
    private Alarm myAlarm;
    private boolean pressedButton = false;
    private int lives;
    private int shootingTime;

    public Player(GameManager gamemanager, EnemyContainer enemycontainer){
        this.gameManager = gamemanager;
        this.enemycontainer = enemycontainer;
        setSprite("ship");
        lives = 3;
        shootingTime = 15;
        myAlarm = new Alarm(2, shootingTime, this);
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
           if (pressedButton == true){
               Bullet bullet = new Bullet();
               gameManager.addGameObject(bullet, gameManager.player.getX() + 10, gameManager.player.getY() - 23);
               bullet.setDirectionSpeed(0, 8);
               myAlarm.restartAlarm();
               pressedButton = false;
           }
        }

        ArrayList<GameObject> gebotst = getCollidedObjects();
        if (gebotst != null){
            for(GameObject g : gebotst){
                if (g instanceof Bullet || g instanceof Vijand){
                    if (g instanceof Vijand) {
                        enemycontainer.resetEnemies();
                    }
                }
                lives--;
                gameManager.deleteGameObject(g);
            }
        }
        if (lives <= 0){
           //System.out.println("GAME OVER!");
        }
    }

    public void setLives(int lives){
        this.lives = lives;
    }

    public int getLives(){
        return lives;
    }
    public void setShootingTime(int shootingTime){
        if(this.shootingTime >= 5) {
            myAlarm.setTime(shootingTime);
            this.shootingTime = shootingTime;
        }
    }

    public int getShootingTime(){
        return shootingTime;
    }

    @Override
    public void triggerAlarm(int alarmID) {
        pressedButton = true;
    }

    @Override
    public void drawGameObject(Canvas canvas) {
        super.drawGameObject(canvas);
        Paint blackLetters=new Paint();
        blackLetters.setColor(Color.BLACK);
        blackLetters.setTextSize(20);
        canvas.drawText("Levens: "+ lives, 7, 15, blackLetters );
    }
}
