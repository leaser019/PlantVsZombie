package controller.Menu;

import java.awt.*;
import java.awt.event.*;

import view.MenuView;

public class MenuController implements ActionListener {
    private MenuView menuView;
    public MenuController (MenuView menuView){
        this.menuView = menuView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String button = e.getActionCommand();
        if(button.equals("Exit")){
            this.menuView.exitTab();
        }
        // throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
