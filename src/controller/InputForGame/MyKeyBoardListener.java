package controller.InputForGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import view.Game.Game;

public class MyKeyBoardListener implements KeyListener {
    private Game game;

    public MyKeyBoardListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ALT && e.getKeyCode() == KeyEvent.VK_F4) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
