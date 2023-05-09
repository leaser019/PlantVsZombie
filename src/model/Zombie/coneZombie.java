package model.Zombie;

import static model.Helper.Constant.Zombies.coneZombie;

import model.Object.Zombie;

public class coneZombie extends Zombie {

    public coneZombie(float x, float y, int iD) {
        super(x, y, iD, coneZombie);
    }
    
}
