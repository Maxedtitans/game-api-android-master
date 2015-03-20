package marsintruders;

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;

import java.util.ArrayList;


/**
 * Created by Sjuulius on 18-3-2015.
 */
public class GameManager extends GameEngine {
    protected Player player;
    protected Vijand vijand;
    protected Vijand vijand2;
    protected Vijand vijand3;

    @Override
    protected void initialize() {
        // Set up control mechanisms to use
        TouchInput.use = true;
        OnScreenButtons.use = true;

        player = new Player(this);
        player.setSprite("ship");
        this.addGameObject(this.player, getScreenWidth()/2, 200);

        vijand = new Vijand(this);
        vijand2 = new Vijand(this);
        vijand3 = new Vijand(this);
        this.addGameObject(vijand, 150, 50);
        this.addGameObject(vijand2, 200, 50);
        this.addGameObject(vijand3, 250, 50);

        ArrayList<Vijand> vijanden =  new ArrayList<>();
        vijanden.add(vijand);
        vijanden.add(vijand2);
        vijanden.add(vijand3);


    }
    public void update() {
        super.update();

    }
}
