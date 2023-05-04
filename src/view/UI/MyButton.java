package view.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import model.HelperMethod.INeededMethod;

public class MyButton implements INeededMethod {
    private int x, y, width, height;
    private String text;
    private Rectangle bounds;

    public MyButton(String text, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.initBounds();
    }

    public void initBounds() {
        this.bounds = new Rectangle(x, y, width, height);
    }

    public void draw(Graphics g) {
        // Body
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
        // Border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        // Text
        drawText(g);
    }

    public void drawText(Graphics g) {
        int w = g.getFontMetrics().stringWidth(text);
        int h = g.getFontMetrics().getHeight();
        g.drawString(this.text, x - w / 2 + width / 2, y + h / 2 + height / 2);
    }

    public Rectangle getBound() {
        return bounds;
    }

    @Override
    public void mouseClicked(int x, int y) {
       
    }
}
