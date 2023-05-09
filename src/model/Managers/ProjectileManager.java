package model.Managers;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.Helper.Constant.Projectile;
import view.Game.GamePanel;

public class ProjectileManager {
    private GamePanel gamePanel;
    private ArrayList<Projectile> projectiles;
    private Image[] projectileImg;

    public ProjectileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.projectiles = new ArrayList<>();
        projectileImg = new Image[2];
        this.loadProjectileImg();
    }

    public void loadProjectileImg(){
        projectileImg[0] = Toolkit.getDefaultToolkit().getImage("lib\\image\\greenBall.png");
        projectileImg[1] = Toolkit.getDefaultToolkit().getImage("lib\\image\\freezeBall.png");
    }

    public void draw(){

    }
    public void update(){

    }
}
