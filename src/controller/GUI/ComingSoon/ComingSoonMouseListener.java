package controller.GUI.ComingSoon;

import java.awt.event.*;

import view.GUI.ComingSoon;

public class ComingSoonMouseListener implements MouseListener {
    private ComingSoon comingSoon;

    public ComingSoonMouseListener(ComingSoon comingSoon2) {
        this.comingSoon = comingSoon2;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        this.comingSoon.backToMenu();
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
