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

package view.Game;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static model.Helper.Constant.GameWindow.*;
import controller.InputForGame.MyKeyBoardListener;
import controller.InputForGame.MyMouseListener;
import model.Helper.IMouse;
import model.Managers.PlantManager;
import model.Managers.ProjectileManager;
import model.Managers.ZombieManager;
import model.Object.Plant;
import model.Object.Zombie;
import view.UI.CardBar;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class GamePanel extends JPanel implements IMouse {
    private Game game;
    private JLabel jLabel;
    private ZombieManager zombieManager;
    private PlantManager plantManager;
    private ProjectileManager projectileManager;
    private Image backGround;
    private MyKeyBoardListener keyBoardListener;
    private MyMouseListener mouseListener;
    private CardBar cardBar;
    private Plant selectedPlant;
    private boolean pauseGame;
    private int mouseX = 0;
    private int mouseY = 0;
    private static int checkTime = 0;

    public GamePanel() {
        this.init();
    }

    public void init() {
        this.pauseGame = false;
        cardBar = new CardBar(10, 10, 450, 80, this);
        zombieManager = new ZombieManager(this);
        plantManager = new PlantManager(this);
        projectileManager = new ProjectileManager(this);
    }

    public void setBackGround(Graphics g) {
        backGround = new ImageIcon("lib\\image\\GameBackground.png").getImage();
        g.drawImage(backGround, 0, 0, null);
    }

    public void render(Graphics g) {
        this.setBackGround(g);
        cardBar.draw(g);
        zombieManager.draw(g);
        plantManager.draw(g);
        projectileManager.draw(g);
        drawSelectedPlant(g);
        hugeZombieTime(g);

    }

    private void drawSelectedPlant(Graphics g) {
        if (selectedPlant != null) {
            g.drawImage(plantManager.getPlantImg()[selectedPlant.getPlantType()], mouseX, mouseY, null);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.render(g);

    }

    public void updateGame() {
        if (!pauseGame) {
            zombieManager.update();
            plantManager.update();
            projectileManager.update();
        }
    }

    public void initInput() {
        keyBoardListener = new MyKeyBoardListener(game);
        mouseListener = new MyMouseListener(game);
        this.addKeyListener(keyBoardListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
    }

    public void hugeZombieTime(Graphics g) {
        int xHugeZombie = 120;
        int yHugeZombie = 80;
        if (checkTime >= 20 && checkTime <= 25) {
            g.drawImage(Toolkit.getDefaultToolkit().getImage(
                    "lib\\image\\hugeZombie.png"), xHugeZombie, yHugeZombie, null);
        }
    }

    public void setPauseGame(boolean pause) {
        this.pauseGame = pause;
    }

    public void setCheckTime(int num) {
        this.checkTime += num;
    }

    public PlantManager getPlantManager() {
        return this.plantManager;
    }

    public boolean isGamePause() {
        return pauseGame;
    }

    public void setSelectedPlant(Plant selectedPlant) {
        this.selectedPlant = selectedPlant;
    }

    public int getMouseX() {
        return mouseX;
    }

    public void setMouseX(int mouseX) {
        this.mouseX = mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public void setMouseY(int mouseY) {
        this.mouseY = mouseY;
    }

    public void mouseClicked(int x, int y) {
        if (y <= 120) {
            cardBar.mouseClicked(x, y);
        } else {
            if (selectedPlant != null) {
                if (checkPlant(mouseX, mouseY) == null) {
                    plantManager.addPlant(selectedPlant, mouseX, mouseY);
                    selectedPlant = null;
                }
            } else {
                Plant p = checkPlant(mouseX, mouseY);
                if (p == null) {
                    return;
                } else {
                    cardBar.displayPlant(p);
                }
            }
        }
    }

    private Plant checkPlant(int x, int y) {
        return this.plantManager.checkPlantAt(x, y);
    }

    public void mousePressed(int x, int y) {
        if (y <= 120) {
            cardBar.mousePressed(x, y);
        }
    }

    public void mouseReleased(int x, int y) {
    }

    public void mouseDragged(int x, int y) {
    }

    public void mouseMoved(int x, int y) {
        if (y <= 120) {
            cardBar.mouseMoved(x, y);
        } else {
            mouseX = x - 30;
            mouseY = y - 30;
        }
    }

    public void mouseEntered(int x, int y) {
    }

    @Override
    public void mouseOver(int x, int y) {
    }

    @Override
    public void mouseExited(int x, int y) {
    }

    public ZombieManager getZombieManager() {
        return this.zombieManager;
    }

    public void shootZombie(Plant plant, Zombie zombie) {
        projectileManager.newProjectile(plant, zombie);
    }

    public Game getGame() {
        return game;
    }

}
