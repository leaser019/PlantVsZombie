package model.Object;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;

public class Projectile {
    private Point2D.Float position;
    private int id;
    private int projectileType;
    private float xSpeed, ySpeed;
    private boolean active;

    public Projectile(float x, float y,float xSpeed, float ySpeed, int id, int projectileType) {
        this.position = new Point2D.Float(x, y);
        this.id = id;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.projectileType = projectileType;
        this.active = true;
    }

    public void move() {
        position.x += xSpeed;
        position.y += ySpeed;
    }

    public Point2D.Float getPosition() {
        return position;
    }

    public void setPosition(Point2D.Float position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectileType() {
        return projectileType;
    }

    public void setProjectileType(int projectileType) {
        this.projectileType = projectileType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
