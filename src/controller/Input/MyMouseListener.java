package controller.Input;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import model.Managers.ZombieManager;
import view.Game.Game;
import view.Game.GamePanel;

public class MyMouseListener implements MouseListener, MouseMotionListener {
    private ZombieManager zombieManager;
    private Game game;

    public MyMouseListener(Game game) {
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            System.out.println(e.getX());
            System.out.println(e.getY());
        } else if (e.getButton() == MouseEvent.BUTTON2) {
            System.out.println("Middle is clicked");
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            System.out.println("Right is clicked");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

}
