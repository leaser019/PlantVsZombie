package view.UI;

import java.awt.Color;
import java.awt.Graphics;

import model.Managers.PlantManager;
import view.Game.GamePanel;

public class CardBar  {
    private int x, y, width, height;
    private MyButton[] plantButtons;
    private PlantManager plantManager;
    private GamePanel gamePanel;

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
        int w = 65;
        int h = 70;
        int x = 110;
        int y = 13;
        int addOn = 10;
        int offSet = ((int) 1.9f * w) + addOn;

        for (int i = 0; i < plantButtons.length; i++) {
            plantButtons[i] = new MyButton("", x + (offSet * i), y, w, h);
        }
    }

    public void draw(Graphics g) {
        // g.setColor(Color.WHITE);
        // g.fillRect(x, y, width, height);
        drawButton(g);
    }

    public void drawButton(Graphics g) {

        for (int i = 0; i < plantButtons.length; i++) {
            g.drawImage(gamePanel.getPlantManager().getPlantCardImg()[i], plantButtons[i].x, plantButtons[i].y, null);
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

}
