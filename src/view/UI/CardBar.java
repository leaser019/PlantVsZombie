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

package view.UI;

import java.awt.Color;
import java.awt.Graphics;

import model.Helper.IMouse;
import model.Managers.PlantManager;
import model.Object.Plant;
import view.Game.GamePanel;

public class CardBar implements IMouse {
    private int x, y, width, height;
    private MyButton[] plantButtons;
    private PlantManager plantManager;
    private GamePanel gamePanel;
    private Plant selectedPlant;
    private Plant displayPlant;
    int w = 65;
    int h = 70;

    public CardBar(int x, int y, int width, int height, GamePanel gamePanel) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gamePanel = gamePanel;
        initButtons();
    }

    public void initButtons() {
        plantButtons = new MyButton[3];
        int x = 110;
        int y = 13;
        int addOn = 10;
        int step = ((int) 1.9f * w) + addOn;

        for (int i = 0; i < plantButtons.length; i++) {
            plantButtons[i] = new MyButton("", x + (step * i), y, w, h);
        }
    }

    public void draw(Graphics g) {
        drawButton(g);
        drawDisplayPlant(g);

    }

    private void drawDisplayPlant(Graphics g) {
        if (displayPlant != null) {
            // g.drawImage(gamePanel.getPlantManager().getPlantImg()[displayPlant.getPlantType()],
            // 0, 0,50,50, null);
            drawDisplayPlantRange(g);
        }
    }

    private void drawDisplayPlantRange(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawOval(displayPlant.getX(), displayPlant.getY(), 100, 100);
    }

    public void drawButton(Graphics g) {
        for (int i = 0; i < plantButtons.length; i++) {
            g.drawImage(gamePanel.getPlantManager().getPlantCardImg()[i], plantButtons[i].x, plantButtons[i].y, null);
            if (plantButtons[i].isMouseOver()) {
                g.setColor(Color.WHITE);
                g.drawRect(plantButtons[i].x, plantButtons[i].y, w, h);
            }
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public MyButton[] getPlantButtons() {
        return plantButtons;
    }

    public void setPlantButtons(MyButton[] plantButtons) {
        this.plantButtons = plantButtons;
    }

    public PlantManager getPlantManager() {
        return plantManager;
    }

    public void setPlantManager(PlantManager plantManager) {
        this.plantManager = plantManager;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(int x, int y) {
        for (int i = 0; i < plantButtons.length; i++) {
            if (plantButtons[i].getBound().contains(x, y)) {
                selectedPlant = new Plant(0, 0, -1, i);
                gamePanel.setSelectedPlant(selectedPlant);
                return;
            }
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        for (MyButton b : plantButtons) {
            if (b.getBound().contains(x, y)) {
                b.setMousePress(true);
            }
        }

    }

    @Override
    public void mouseOver(int x, int y) {

    }

    @Override
    public void mouseReleased(int x, int y) {

    }

    @Override
    public void mouseEntered(int x, int y) {

    }

    @Override
    public void mouseExited(int x, int y) {

    }

    @Override
    public void mouseDragged(int x, int y) {

    }

    @Override
    public void mouseMoved(int x, int y) {
        for (int i = 0; i < plantButtons.length; i++) {
            if (plantButtons[i].getBound().contains(x, y)) {
                plantButtons[i].setMouseOver(true);
            } else {
                plantButtons[i].setMouseOver(false);
            }
        }
    }

    public void displayPlant(Plant p) {
        this.displayPlant = p;
    }

}
