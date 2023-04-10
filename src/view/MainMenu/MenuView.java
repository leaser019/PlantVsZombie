package view.MainMenu;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Menu.MenuController;
import controller.Menu.MenuMouseComingSoon;
import controller.Menu.MenuMouseExitController;
import controller.Menu.MenuMouseHelp;
import controller.Menu.MenuMouseOption;
import controller.Menu.MenuMouseStarAdventure;
import view.Game.GamePanel;
import view.Game.Game;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JEditorPane;
import java.awt.Toolkit;
import java.awt.Font;

public class MenuView extends JFrame {

    private JPanel contentPane;
    private JTextField textField_1;
    private ComingSoon comingSoon;
    private Game gameWindow;
    private GamePanel gamePanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuView frame = new MenuView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MenuView() {

        MenuController menuController = new MenuController(this);
        MenuMouseExitController menuMouseExitController = new MenuMouseExitController(this);
        MenuMouseComingSoon menuMouseComingSoon = new MenuMouseComingSoon(this);
        MenuMouseHelp menuMouseHelp = new MenuMouseHelp(this);
        MenuMouseOption menuMouseOption = new MenuMouseOption(this);
        MenuMouseStarAdventure menuMouseStarAdventure = new MenuMouseStarAdventure(this);

        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\icon.png"));
        setTitle("Plants Vs Zombie Clone");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(805, 605);
        setLocationRelativeTo(null);
        // setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JMenuBar menuBar = new JMenuBar();

        JMenu mnNewMenu = new JMenu("File");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem("Exit");
        mnNewMenu.add(mntmNewMenuItem);
        mntmNewMenuItem.addActionListener(menuController);

        JEditorPane editorPane = new JEditorPane();
        mnNewMenu.add(editorPane);

        JMenu mnNewMenu_1 = new JMenu("Option");
        menuBar.add(mnNewMenu_1);

        JPanel panel = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        contentPane.add(menuBar, BorderLayout.NORTH);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Graph");
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        textField_1.setBounds(59, 52, 231, 25);
        lblNewLabel.setBounds(0, 0, 776, 531);
        lblNewLabel.setIcon(new ImageIcon("lib\\image\\Captureoldmode.png"));
        panel.add(lblNewLabel);

        panel.add(textField_1);
        textField_1.setColumns(10);

        JPanel startAdventure = new JPanel();
        startAdventure.setBounds(407, 36, 320, 106);
        startAdventure.addMouseListener(menuMouseStarAdventure);
        panel.add(startAdventure);

        JPanel comingSoonTab = new JPanel();
        comingSoonTab.setBounds(407, 152, 295, 243);
        comingSoonTab.addMouseListener(menuMouseComingSoon);
        panel.add(comingSoonTab);

        JPanel optionTab = new JPanel();
        optionTab.setBounds(546, 405, 95, 97);
        optionTab.addMouseListener(menuMouseOption);
        panel.add(optionTab);

        JPanel helpTab = new JPanel();
        helpTab.setBounds(651, 405, 48, 97);
        helpTab.addMouseListener(menuMouseHelp);
        panel.add(helpTab);

        JPanel exitTab = new JPanel();
        exitTab.setBounds(709, 405, 67, 97);
        exitTab.setLayout(new BorderLayout());
        exitTab.addMouseListener(menuMouseExitController);
        panel.add(exitTab);

        setVisible(true);

    }

    public void startAdventure() {
        new Game(gamePanel);
        dispose();
    }

    public void comingSoon() {
        ComingSoon frame = new ComingSoon();
        dispose();
        frame.setVisible(true);
    }

    public void optionTab() {
        ComingSoon frame = new ComingSoon();
        dispose();
        frame.setVisible(true);
    }

    public void helpTab() {
        ComingSoon frame = new ComingSoon();
        dispose();
        frame.setVisible(true);
    }

    public void exitTab() {
        System.exit(0);
    }
}
