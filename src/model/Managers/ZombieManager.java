package model.Managers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.Zombie.Zombie;
import model.Zombie.normalZombie;
import view.Scenes.Game.GamePanel;

public class ZombieManager {
    private GamePanel gamePanel;
    private Image[] zombieImg;
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public ZombieManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        zombieImg = new Image[2];
        this.addZombie(1000, 200);
        this.addZombie(1100, 400);
        this.loadZombieImg();
    }

    public void loadZombieImg() {
        zombieImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie1.png");
        zombieImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie2.png");
    }

    public void draw(Graphics g) {
        for (Zombie zombie : zombies) {
            this.drawZombie(zombie, g);
        }
    }

    private void drawZombie(Zombie zombie, Graphics g) {
        g.drawImage(zombieImg[0], (int) zombie.getX(), (int) zombie.getY(), null);
    }
    
    public void addZombie(int x,int y){
        zombies.add(new normalZombie(x, y, 0));
    }

    public void update() {
        for (Zombie zombie : zombies) {
            zombie.move(-0.05f,0f);
        }
    }
}
