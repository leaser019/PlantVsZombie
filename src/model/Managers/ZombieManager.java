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

import static model.Helper.Constant.Zombies.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import model.Object.Zombie;
import model.Zombie.bossZombie;
import model.Zombie.coneZombie;
import model.Zombie.finalZombie;
import model.Zombie.normalZombie;
import view.GUI.GameWin;
import view.Game.GamePanel;

public class ZombieManager {
    private static int numZombie = 0;
    private static int zombieKilled = 0;
    private GameWin gameOver;
    private GamePanel gamePanel;
    private Image[] zombieImg;
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public ZombieManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        zombieImg = new Image[4];
        // size 9*110,5*150
        this.addZombie(1000, 100, normalZombie);
        this.addZombie(1000, 2 * 100, coneZombie);
        this.addZombie(1000, 3 * 100, coneZombie);
        this.addZombie(1000, 3 * 100, normalZombie);
        this.addZombie(2000, 4 * 100, finalZombie);
        // this.addZombie(10, 222, normalZombie);

        this.loadZombieImg();
    }

    public void loadZombieImg() {
        zombieImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie1.png");
        zombieImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie2.png");
        zombieImg[2] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\finalZombie.png");
        zombieImg[3] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\bossZombie.png");
    }

    public void draw(Graphics g) {
        for (Zombie zombie : zombies) {
            if (zombie.getAlive()) {
                this.drawZombie(zombie, g);
            }
        }
    }

    private void drawHealthBar(Zombie z, Graphics g) {
        g.setColor(Color.RED);
        g.fillRect((int) z.getX(), (int) z.getY() - 10, (int) (50 * z.getHealthBar()), 5);
    }

    private void drawZombie(Zombie zombie, Graphics g) {

        g.drawImage(zombieImg[zombie.getZombieType()], (int) zombie.getX(), (int) zombie.getY(), null);

    }

    public void addZombie(int x, int y, int zombieType) {
        switch (zombieType) {
            case normalZombie:
                zombies.add(new normalZombie(x, y, 0));
                break;
            case coneZombie:
                zombies.add(new coneZombie(x, y, 0));
                break;
            case bossZombie:
                zombies.add(new bossZombie(x, y, 0));
                break;
            case finalZombie:
                zombies.add(new finalZombie(x, y, 0));
                break;
        }
        numZombie++;
    }

    public void update() {

        for (Zombie zombie : zombies) {
            if (zombie.getAlive()) {
                zombie.move(getSpeed(zombie.getZombieType()), 0f);
                this.exit(zombie);
            }else{
                zombieKilled++;
            }
            if(zombieKilled==numZombie){
                this.winGame();
            }

        }
    }

    private void winGame() {
        this.gamePanel.getGame().winGame();
    }

    public void exit(Zombie zombie) {
        if (zombie.getX() <= 0) {
            this.gameOver = new GameWin();
            gamePanel.getGame().setVisible(false);
            gamePanel.getGame().getGameTheard().interrupt();
        }
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
}
