package model.Zombie;

import static model.HelperMethod.Constant.Zombies.normalZombie;

public class normalZombie extends Zombie {

    public normalZombie(float x, float y, int iD) {
        super(x, y, iD, normalZombie);
    }
    
    
}