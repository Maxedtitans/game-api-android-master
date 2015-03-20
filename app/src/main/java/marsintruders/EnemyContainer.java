package marsintruders;

import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;

import java.util.ArrayList;

/**
 * Created by Sjuulius on 20-3-2015.
 */
public class EnemyContainer extends MoveableGameObject{
    public ArrayList<Vijand> vijanden = new ArrayList<>();

    public EnemyContainer (GameManager gameManager){
        int teller = 0;
        for (int i = 1; i  < 3; i++) {
            for (int j = 0; j < 9; j++) {
                vijanden.add(new Vijand(gameManager));
                gameManager.addGameObject(vijanden.get(teller), (15 + 50 * j), 30 * i);
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

    @Override
    public void update() {
        update();

    }
}
