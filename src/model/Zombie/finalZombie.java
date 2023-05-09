package model.Zombie;
import static model.Helper.Constant.Zombies.finalZombie;

import model.Object.Zombie;
public class finalZombie extends Zombie {

    public finalZombie(float x, float y, int iD) {
        super(x, y, iD, finalZombie);
    }
    
}
