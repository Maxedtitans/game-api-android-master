package marsintrudersoopd;

//Boolean landscape set to false in: "android.gameengine.icadroids > Engine > GameEngine".

import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.input.OnScreenButtons;
import android.gameengine.icadroids.input.TouchInput;


public class GameManager extends GameEngine {
    protected Player player;
    protected EnemyContainer enemycontainer;
    protected EnemyBoss boss;
    private boolean killedAliens = false;

    @Override
    protected void initialize() {
        // Set up control mechanisms to use
        TouchInput.use = true;
        OnScreenButtons.use = true;

        PowerUpsController controller = new PowerUpsController(this);
        enemycontainer = new EnemyContainer(this);
        player = new Player(this, enemycontainer);
        this.addGameObject(this.player, getScreenWidth()/2, 300);
    }

    public void update() {
        System.out.println(enemycontainer.vijanden.size());
        System.out.println(killedAliens);
        super.update();
        enemycontainer.update();
        if (enemycontainer.vijanden.size() == 0 && killedAliens == false){
            boss = new EnemyBoss(this);
            addGameObject(boss, 65, 50);
            killedAliens = true;
        }
    }
}