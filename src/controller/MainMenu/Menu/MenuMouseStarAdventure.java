package controller.MainMenu.Menu;

import java.awt.*;
import java.awt.event.*;

import view.MainMenu.MenuView;

public class MenuMouseStarAdventure implements MouseListener {
    private MenuView menuView;

    public MenuMouseStarAdventure(MenuView menuView) {
        this.menuView = menuView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isPopupTrigger() == false) {
            this.menuView.startAdventure();
        }
        // throw new UnsupportedOperationException("Unimplemented method
        // 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'mouseExited'");
    }

}
