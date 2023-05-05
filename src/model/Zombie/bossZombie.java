package model.Zombie;
import static model.Helper.Constant.Zombies.bossZombie;
public class bossZombie extends Zombie {

    public bossZombie(float x, float y, int iD) {
        super(x, y, iD, bossZombie);
    }
    
}
