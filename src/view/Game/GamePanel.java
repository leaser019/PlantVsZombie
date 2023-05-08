package view.Game;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.InputForGame.MyKeyBoardListener;
import controller.InputForGame.MyMouseListener;
import model.Helper.IMouse;
import model.Managers.PlantManager;
import model.Managers.ZombieManager;
import model.Plant.Plant;
import view.UI.CardBar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class GamePanel extends JPanel implements IMouse {
    private Game game;
    private ZombieManager zombieManager;
    private PlantManager plantManager;
    private Image backGround;
    private MyKeyBoardListener keyBoardListener;
    private MyMouseListener mouseListener;
    private CardBar cardBar;
    private Plant selectedPlant;
    private int mouseX = 0;
    private int mouseY = 0;

    public GamePanel() {
        this.init();
    }

    public void init() {
        cardBar = new CardBar(116, 15, 450, 80, this);
        zombieManager = new ZombieManager(this);
        plantManager = new PlantManager(this);

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
        drawSelectedPlant(g);
        drawHightLight(g);
    }

    private void drawHightLight(Graphics g){
        if(selectedPlant!=null){
            g.setColor(Color.RED);
            g.drawRect(mouseX, mouseY, 111, 120);
        }
    }

    private void drawSelectedPlant(Graphics g) {
        if (selectedPlant != null) {
            g.drawImage(plantManager.getPlantImg()[selectedPlant.getPlantType()], mouseX, mouseY, null);
            System.out.println("DONE");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.render(g);

    }

    public void updateGame() {
        zombieManager.update();
        plantManager.update();
    }

    public void initInput() {
        keyBoardListener = new MyKeyBoardListener(game);
        mouseListener = new MyMouseListener(game);
        this.addKeyListener(keyBoardListener);
        this.addMouseListener(mouseListener);
        this.addMouseMotionListener(mouseListener);
    }

    public PlantManager getPlantManager() {
        return this.plantManager;
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
        System.out.println("left");
        if (y <= 250) {
            cardBar.mouseClicked(x, y);
        } else {
            if (selectedPlant != null) {
                if (checkPlant(mouseX, mouseY) == null) {
                    plantManager.addPlant(selectedPlant, mouseX, mouseY);
                    selectedPlant = null;
                }
            }
            else{
                Plant p =checkPlant(mouseX, mouseY);
                if(p==null){
                    return;
                }else{
                    cardBar.displayPlant(p);
                }
            }
        }
    }

    private Plant checkPlant(int x, int y) {
        return this.plantManager.checkPlantAt(x,y);
    }

    public void mousePressed(int x, int y) {
        if (y <= 250) {
            cardBar.mousePressed(x, y);
        }
    }

    public void mouseReleased(int x, int y) {
    }

    public void mouseDragged(int x, int y) {
    }

    public void mouseMoved(int x, int y) {
        if (y <= 250) {
            cardBar.mouseMoved(x, y);
        } else {
            mouseX = x ;
            mouseY = y ;
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

}
