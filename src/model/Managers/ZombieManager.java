/* Team Name: Chicken Team.
Group Number: G01 - L02.
Members:
    Võ Minh Khang - ITCSIU21136
    Nguyễn Hoàng Gia Ân - ITCSIU21161
    Nguyễn Trọng Nguyên - ITITIU21263
Choice of game: Plants and Zombies.
 Purpose: "Plants vs. Zombies" is a popular tower defense game where players use plants to defend their home from zombies. 
*/

package model.Managers;

import static model.Helper.Constant.Zombies.*;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import model.Object.Zombie;
import model.Zombie.bossZombie;
import model.Zombie.coneZombie;
import model.Zombie.finalZombie;
import model.Zombie.normalZombie;
import view.GUI.GameOver;
import view.GUI.GameWin;
import view.Game.GamePanel;

public class ZombieManager {
    private GameOver gameOver;
    private GamePanel gamePanel;
    private Image[] zombieImg;
    private ArrayList<Zombie> zombies = new ArrayList<>();

    public ZombieManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        zombieImg = new Image[4];
        // size 9*110,5*150
        this.initZombie();
        this.loadZombieImg();
    }

    public void initZombie() {
        int appearX = 1000;
        this.addZombie(appearX + getRandomNumber(1, 100), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(1, 100), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(1, 100), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(100, 300), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(100, 300), getRandomNumber(1, 4) * 105,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(100, 300), getRandomNumber(1, 4) * 110,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(300, 1000), getRandomNumber(1, 4) * 110,
                finalZombie);
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                getRandomNumber(normalZombie, coneZombie));
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                coneZombie);
        this.addZombie(appearX + getRandomNumber(300, 500), getRandomNumber(1, 4) * 110,
                normalZombie);
        this.addZombie(appearX + getRandomNumber(500, 1000), getRandomNumber(1, 4) * 110,
                finalZombie);

    }

    public void loadZombieImg() {
        zombieImg[0] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie1.gif");
        zombieImg[1] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\zombie2.gif");
        zombieImg[2] = Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\finalZombie.gif");
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
    }

    public void update() {
        int zombieKilled = 0;
        int numZombie = this.zombies.size();
        for (Zombie zombie : zombies) {
            if (zombie.getAlive()) {
                zombie.move(getSpeed(zombie.getZombieType()), 0f);
                this.exit(zombie);
            }
            if (!zombie.getAlive()) {
                zombieKilled++;
            }
            if (zombieKilled == numZombie) {
                this.winGame();
            }
        }
    }

    private void winGame() {
        GameWin gw = new GameWin();
        gamePanel.getGame().dispose();
    }

    public void exit(Zombie zombie) {
        if (zombie.getX() <= 0) {
            this.gameOver = new GameOver();
            gamePanel.getGame().setVisible(false);
            gamePanel.getGame().getGameTheard().interrupt();
        }
    }

    public int getRandomNumber(int a, int b) {
        Random rand = new Random();
        int ranNum = rand.nextInt(b) + a;
        return ranNum;
    }

    public ArrayList<Zombie> getZombies() {
        return zombies;
    }
}
