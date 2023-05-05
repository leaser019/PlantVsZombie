package controller.InputForGame;

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
        if(e.getButton()==MouseEvent.BUTTON1)
        game.getGamePanel().mouseClicked(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        game.getGamePanel().mousePressed(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        game.getGamePanel().mouseReleased(e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        game.getGamePanel().mouseDragged(e.getX(), e.getY());

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        game.getGamePanel().mouseMoved(e.getX(), e.getY());

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        game.getGamePanel().mouseEntered(e.getX(), e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
