package marsintruders;

//Boolean landscape set to false in: "android.gameengine.icadroids > Engine > GameEngine".

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;

/**
 * changed GameEnige value landscape to false for portrait instead of landscape
 */
public class GameManager extends GameEngine {
    protected Player player;
    protected EnemyContainer enemycontainer;


    @Override
    protected void initialize() {
        // Set up control mechanisms to use
        TouchInput.use = true;
        OnScreenButtons.use = true;

        player = new Player(this);
        this.addGameObject(this.player, getScreenWidth()/2, 300);

        enemycontainer = new EnemyContainer(this);
    }

    public void update() {
        super.update();
        enemycontainer.update();
    }
}
