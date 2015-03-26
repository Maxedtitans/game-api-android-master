package marsintrudersoopd;

import android.gameengine.icadroids.alarms.Alarm;
import android.gameengine.icadroids.alarms.IAlarm;

import java.util.Random;

public class PowerUpsController implements IAlarm{

    private Alarm myAlarm;
    private GameManager gameManager;
    private Random r = new Random();

    public PowerUpsController(GameManager gameManager){
        this.gameManager = gameManager;
        myAlarm = new Alarm(5, 250, this);
        myAlarm.startAlarm();
    }

    @Override
    public void triggerAlarm(int alarmID) {
        int willekeurigPowerUp = r.nextInt(2);
        int willekeurigSchermBreedte = r.nextInt(gameManager.getScreenWidth());
        PowerUps powerUp;
        if(willekeurigPowerUp == 0){
            powerUp = new WeaponPowerUp();
        }
        else {
            powerUp = new LivePowerUp();
        }
        gameManager.addGameObject(powerUp, willekeurigSchermBreedte, 20);
        powerUp.setDirectionSpeed(180, 5);
        myAlarm.restartAlarm();
    }
}
