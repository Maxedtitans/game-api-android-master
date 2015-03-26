package marsintrudersoopd;


public class LivePowerUp extends PowerUps {

    public LivePowerUp(){
        setSprite("heart");
    }

    @Override
    public void applyPowerUp(Player player) {
        player.setLives(player.getLives() + 1);
    }
}
