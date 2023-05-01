package model.Zombie;

import java.awt.Rectangle;

public class Zombie {
    private float x;
    private float y;
    private Rectangle bounds;
    private int health;
    private int ID;
    private int zombieType;

    
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public int getZombieType() {
        return zombieType;
    }

    public void setZombieType(int zombieType) {
        this.zombieType = zombieType;
    }
    public Zombie(float x, float y, int iD, int zombieType) {
        this.x = x;
        this.y = y;
        ID = iD;
        this.zombieType = zombieType;
        bounds = new Rectangle((int) x, (int) y, 62, 100);
    }

    public void move(float x, float y){
        this.x+=x;
        this.y+=y;
    }
    
   
}
