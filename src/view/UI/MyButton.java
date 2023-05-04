package view.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import model.HelperMethod.INeededMethod;

public class MyButton implements INeededMethod {
    int x;
    int y;
    private int width;
    private int height;
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
        drawBody(g);
        drawBorder(g);
        drawText(g);
    }

    public void drawBody(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }

    public void drawBorder(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
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

    @Override
    public void mouseOver(int x, int y) {
    }

    @Override
    public void mousePressed(int x, int y) {
    }
}
