package controller.GUI.Menu;

import java.awt.event.*;

import view.GUI.MenuView;

public class MenuMouseHelp implements MouseListener {
    private MenuView menuView;

    public MenuMouseHelp (MenuView menuView) {
        this.menuView = menuView;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isPopupTrigger() == false) {
            this.menuView.helpTab();
        }
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
    
}
