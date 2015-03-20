package marsintruders;

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;


public class GameManager extends GameEngine {
    protected Player player;
    protected Vijand vijand;
    protected EnemyContainer enemycontainer;


    @Override
    protected void initialize() {
        // Set up control mechanisms to use
        TouchInput.use = true;
        OnScreenButtons.use = true;

        player = new Player(this);
        this.addGameObject(this.player, getScreenWidth()/2, 200);

        enemycontainer = new EnemyContainer(this);
    }

    public void update() {
        super.update();
    }
}
