package marsintruders;

//Boolean landscape set to false in: "android.gameengine.icadroids > Engine > GameEngine".

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;
import android.gameengine.icadroids.objects.GameObject;

import java.util.ArrayList;


public class GameManager extends GameEngine {
    protected Player player;
    protected EnemyContainer enemycontainer;

    ArrayList<GameObject> lives = new ArrayList<>();

    @Override
    protected void initialize() {
        // Set up control mechanisms to use
        TouchInput.use = true;
        OnScreenButtons.use = true;

        enemycontainer = new EnemyContainer(this);

        player = new Player(this, enemycontainer);
        this.addGameObject(this.player, getScreenWidth()/2, 300);


    }

    public void update() {
        super.update();
        enemycontainer.update();
    }
}
