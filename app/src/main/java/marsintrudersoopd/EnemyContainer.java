package marsintrudersoopd;

import android.gameengine.icadroids.objects.MoveableGameObject;
import java.util.ArrayList;


public class EnemyContainer extends MoveableGameObject{
    public ArrayList<Vijand> vijanden = new ArrayList<>();
    private final int ROWS = 4;
    private final int ENEMYROW = 5;
    GameManager gameManager;
    boolean isRechterkantScherm = false;

    public EnemyContainer (GameManager gameManager){
        int teller = 0;
        this.gameManager = gameManager;
        for (int i = 1; i  <= ROWS; i++) {
            if (i < ROWS) {
                for (int j = 0; j < ENEMYROW; j++) {
                    vijanden.add(new Vijand(gameManager, this, false));
                    gameManager.addGameObject(vijanden.get(teller), (20 + 50 * j), 30 * i);
                    teller++;
                }
            }
            else {
                for (int j = 0; j < ENEMYROW; j++) {
                    if (j % 2 == 0) {
                        vijanden.add(new Vijand(gameManager, this, true));
                    }
                    else {
                        vijanden.add(new Vijand(gameManager, this, false));
                    }
                    gameManager.addGameObject(vijanden.get(teller), (20 + 50 * j), 30 * i);
                    teller++;
                }
            }
        }
    }

    public void naarLinks(){
        for(Vijand vijand : vijanden){
            vijand.setX(vijand.getX() - 1);
        }
    }

    public void naarRechts(){
        for(Vijand vijand : vijanden){
            vijand.setX(vijand.getX() + 1);
        }
    }

    public void naarBeneden(){
        for(Vijand vijand : vijanden){
            vijand.setY(vijand.getY() + 15);
        }
    }

    public int getLinkerX(){
        int meestLinks = gameManager.getScreenWidth();
        for (Vijand vijand : vijanden){
            if (vijand.getX() < meestLinks){
                meestLinks = vijand.getX();
            }
        }
        return meestLinks;
    }

    public int getRechterX(){
        int meestRechts = 0;
        for (Vijand vijand : vijanden){
            if (vijand.getX() > meestRechts){
                meestRechts = vijand.getX();
            }
        }
        return meestRechts;
    }

    public void resetEnemies(){
        for (Vijand vijand: vijanden){
            vijand.setY(vijand.getY() - gameManager.getScreenHeight()/3);
        }
    }

    @Override
    public void update(){
        if (vijanden.size() > 0) {
            if (getRechterX() + vijanden.get(0).getFrameWidth() <= gameManager.getScreenWidth() - 10 && isRechterkantScherm == false) {
                naarRechts();
                if (getRechterX() + vijanden.get(0).getFrameWidth() == 311) {
                    naarBeneden();
                    isRechterkantScherm = true;
                }
            }
            if (isRechterkantScherm == true) {
                naarLinks();
                if (getLinkerX() == 7) {
                    naarBeneden();
                    isRechterkantScherm = false;
                }
            }
        }
    }
}
