package model.Object;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Float;

public class Projectile {
    private Point2D.Float pos;
    private int id;
    private int projectileType;
    private boolean active;

    public Projectile(Float pos, int id, int projectileType) {
        this.pos = pos;
        this.id = id;
        this.projectileType = projectileType;
        this.active = true;
    }

    public Point2D.Float getPos() {
        return pos;
    }

    public void setPos(Point2D.Float pos) {
        this.pos = pos;
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
