
package test2;


import android.gameengine.icadroids.engine.GameEngine;
import android.gameengine.icadroids.objects.MoveableGameObject;
import android.gameengine.icadroids.objects.collisions.ICollision;

/**
 * Created by Sjuulius on 18-3-2015.
 */
public class Bullet extends MoveableGameObject{
   protected int x;
   protected int y;

   public Bullet (int x, int y){
      this.x = x;
      this.y = y;
   }

}
