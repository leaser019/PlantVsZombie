package controller.GUI.GameOver;

import java.awt.event.*;

import view.GUI.GameOver;

public class GameOverMouseListener implements MouseListener {
    private GameOver go;

    public GameOverMouseListener(GameOver go) {
        this.go = go;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.go.backToMenu();
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

}
