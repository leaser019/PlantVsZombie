package controller.GUI.Menu;

import java.awt.event.*;

import view.GUI.MenuView;

public class MenuMouseOption implements MouseListener {
    private MenuView menuView;

    public MenuMouseOption (MenuView menuView) {
        this.menuView = menuView;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.isPopupTrigger() == false) {
            this.menuView.optionTab();
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

}
