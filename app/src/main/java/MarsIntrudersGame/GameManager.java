package MarsIntrudersGame;

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;
/**
 * Created by Sjuulius on 18-3-2015.
 */
public class GameManager extends GameEngine {
    protected Player player;
    protected Vijand vijand;

    @Override
    protected void initialize() {
        // Set up control mechanisms to use
        TouchInput.use = true;
        OnScreenButtons.use = true;

        player = new Player(this);
        player.setSprite("alien");
        this.addGameObject(this.player, getScreenWidth()/2, 200);

        vijand = new Vijand(this);
        vijand.setSprite("strawberry");
        this.addGameObject(vijand, 200, 50);
    }
    public void update() {
        super.update();
    }

}
