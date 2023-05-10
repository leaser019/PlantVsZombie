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

package model.Managers;

import static model.Helper.Constant.Projectile.*;
import static model.Helper.Constant.Plants.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.Object.Plant;
import model.Object.Projectile;
import model.Object.Zombie;
import view.Game.GamePanel;

public class ProjectileManager {
    private GamePanel gamePanel;
    private ArrayList<Projectile> projectiles;
    private Image[] projectileImg;
    private static int id;

    public ProjectileManager(GamePanel gamePanel) {
        this.init();
        this.initInput();
        this.loadProjectileImg();
    }

    public void init() {
        this.id = 0;
        this.gamePanel = gamePanel;
    }

    public void initInput() {
        this.projectiles = new ArrayList<>();
        this.projectileImg = new Image[2];
    }

    public void loadProjectileImg() {
        projectileImg[0] = Toolkit.getDefaultToolkit().getImage("lib\\image\\greenBall.png");
        projectileImg[1] = Toolkit.getDefaultToolkit().getImage("lib\\image\\freezeBall.png");
    }

    public void draw(Graphics g) {
        for (Projectile projectile : projectiles) {
            this.drawProjectile(g, projectile);
        }
    }

    public void drawProjectile(Graphics g, Projectile projectile) {
        g.drawImage(projectileImg[projectile.getProjectileType()], (int) projectile.getPosition().x,
                (int) projectile.getPosition().y, null);
    }

    public void update() {
        for (Projectile projectile : projectiles) {
            projectile.move();
        }
    }

    public boolean isProjectileHitZombie(Projectile projectile) {
        for (Zombie zombie : gamePanel.getZombieManager().getZombies()) {
            if (zombie.getBounds().contains((int) projectile.getPosition().getX(),
                    (int) projectile.getPosition().getY())) {
                return true;
            }
        }
        return false;
    }

    public void newProjectile(Plant plant, Zombie zombie) {
        int type = this.getProjectile(plant);
        float speed = model.Helper.Constant.Projectile.getSpeed(type);

        int xDis = (int) Math.abs((float) plant.getX() - zombie.getX());
        int yDis = (int) Math.abs((float) plant.getY() - zombie.getY());
        float xPix = (float) xDis / (xDis + yDis);
        float xSpeed = xPix * speed;
        float ySpeed = xSpeed - speed;

        int xAddOn = 35;
        int yAddOn = 12;
        Projectile temp = new Projectile(plant.getX() + xAddOn, plant.getY() + yAddOn, xSpeed, ySpeed, id++, type);
        projectiles.add(temp);
    }

    public int getProjectile(Plant plant) {
        switch (plant.getPlantType()) {
            case peaShooter:
                return greenBall;
            case freezePea:
                return freezeBall;
        }
        return 0;
    }

}
