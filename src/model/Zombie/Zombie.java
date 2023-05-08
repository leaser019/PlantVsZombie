package model.Zombie;

import java.awt.Rectangle;

public abstract class Zombie {
    private float x;
    private float y;
    private Rectangle bounds;
    private int health;
    private int ID;
    private int zombieType;
    private int maxHealth;
    private float speed;
    private float maxSpeed;
    protected boolean alive;

    public Zombie(float x, float y, int iD, int zombieType) {
        this.x = x;
        this.y = y;
        ID = iD;
        this.zombieType = zombieType;
        alive = true;
        bounds = new Rectangle((int) x, (int) y, 62, 100);
        setStartHealth();
        setStartSpeed();
    }

    private void setStartSpeed() {
        this.speed = model.Helper.Constant.Zombies.getSpeed(zombieType);
        this.maxSpeed = this.speed;
    }

    private void setStartHealth() {
        this.health = model.Helper.Constant.Zombies.getStartHealth(this.zombieType);
        this.maxHealth = this.health;
    }

    public float getHealthBar() {
        return this.health / (float) this.maxHealth;
    }

    public void checkAlive() {
        if (this.health <= 0) {
            this.alive = false;
        }
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean getAlive() {
        return alive;
    }
}
