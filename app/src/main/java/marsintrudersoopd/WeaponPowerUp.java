package marsintrudersoopd;

public class WeaponPowerUp extends PowerUps {

    public WeaponPowerUp(){
        setSprite("smallgun");
    }

    @Override
    public void applyPowerUp(Player player) {
        player.setShootingTime(player.getShootingTime() - 2);
    }
}
