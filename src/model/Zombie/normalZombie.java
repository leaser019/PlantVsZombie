package model.Zombie;

import static model.Helper.Constant.Zombies.normalZombie;

import model.Object.Zombie;

public class normalZombie extends Zombie {

    public normalZombie(float x, float y, int iD) {
        super(x, y, iD, normalZombie);
    }
    
    
}
