package marsintrudersoopd;

import android.gameengine.icadroids.objects.GameObject;
import android.gameengine.icadroids.objects.MoveableGameObject;
import java.util.ArrayList;

public abstract class PowerUps extends MoveableGameObject{

    public abstract void applyPowerUp(Player player);

    @Override
    public void update() {
        super.update();
        ArrayList<GameObject> gebotst = getCollidedObjects();
        if (gebotst != null){
            for(GameObject g : gebotst){
                if (g instanceof Player){
                    applyPowerUp((Player)g);
                    deleteThisGameObject();
                }
            }
        }
    }
}
