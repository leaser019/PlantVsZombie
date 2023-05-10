/* Team Name: Chicken Team.
Group Number: G01 - L02.
Members:
    Võ Minh Khang - ITCSIU21136
    Nguyễn Hoàng Gia Ân - ITCSIU21161
    Nguyễn Trọng Nguyên - ITITIU21263
Choice of game: Plants and Zombies.
 Purpose: "Plants vs. Zombies" is a popular tower defense game 
where players use plants to defend their home from zombies. 
*/

package model.Object;

import java.awt.geom.Point2D;

public class Projectile {
    private Point2D.Float position;
    private int id;
    private int projectileType;
    private float xSpeed, ySpeed;
    private boolean active;

    public Projectile(float x, float y, float xSpeed, float ySpeed, int id, int projectileType) {
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
