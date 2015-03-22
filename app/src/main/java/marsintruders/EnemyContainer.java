package marsintruders;

import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;

import java.util.ArrayList;

/**
 * Created by Sjuulius on 20-3-2015.
 */

public class EnemyContainer extends MoveableGameObject{
    public ArrayList<Vijand> vijanden = new ArrayList<>();
    private final int ROWS = 2;
    private final int ENEMYS = 9;

    public EnemyContainer (GameManager gameManager){
        int teller = 0;
        for (int i = 1; i  < 5; i++) {
            for (int j = 0; j < 6; j++) {
                vijanden.add(new Vijand(gameManager, this));
                gameManager.addGameObject(vijanden.get(teller), (10 + 50 * j), 30 * i);
                teller++;
            }
        }
    }

    public void naarLinks(){
        for(Vijand vijand : vijanden){
            vijand.setX(vijand.getX() - 5);
        }
    }

    public void naarRechts(){
        for(Vijand vijand : vijanden){
            vijand.setX(vijand.getX() + 5);
        }
    }
}
