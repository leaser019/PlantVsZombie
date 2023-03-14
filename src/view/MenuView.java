package view;

import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Menu.MenuController;
import controller.Menu.MenuMouseComingSoon;
import controller.Menu.MenuMouseExitController;

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

        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "src\\view\\image\\dausht0-74037f3a-028d-4ed0-ac0a-c39ccc4e7a34.png"));
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
        lblNewLabel.setIcon(new ImageIcon("src\\view\\image\\Captureoldmode.png"));
        panel.add(lblNewLabel);

        panel.add(textField_1);
        textField_1.setColumns(10);

        JPanel startAdventure = new JPanel();
        startAdventure.setBounds(407, 36, 320, 106);
        
        panel.add(startAdventure);

        JPanel comingSoonTab = new JPanel();
        comingSoonTab.setBounds(407, 152, 295, 243);
        comingSoonTab.addMouseListener(menuMouseComingSoon);
        panel.add(comingSoonTab);

        JPanel optionTab = new JPanel();
        optionTab.setBounds(546, 405, 95, 97);

        panel.add(optionTab);

        JPanel helpTab = new JPanel();
        helpTab.setBounds(651, 405, 48, 97);

        panel.add(helpTab);

        JPanel exitTab = new JPanel();
        exitTab.setBounds(709, 405, 67, 97);
        exitTab.setLayout(new BorderLayout());
        exitTab.addMouseListener(menuMouseExitController);
        panel.add(exitTab);

        // JButton jButton_Exit = new JButton("Exit");
        // exitTab.add(jButton_Exit, BorderLayout.CENTER);
        // jButton_Exit.setVisible(true);
        // jButton_Exit.setContentAreaFilled(false);
        // jButton_Exit.setOpaque(false);
        // jButton_Exit.setPreferredSize(new Dimension(0, 0));
        // jButton_Exit.setBackground(new Color(0, 0, 0, 0));
        // jButton_Exit.addActionListener(menuController);

        // JButton jButton_Help = new JButton("Help");
        // helpTab.add(jButton_Help, BorderLayout.CENTER);
        // jButton_Help.setVisible(true);
        // jButton_Help.setContentAreaFilled(false);
        // jButton_Help.setOpaque(false);
        // jButton_Help.setPreferredSize(new Dimension(0, 0));
        // jButton_Help.setBackground(new Color(0, 0, 0, 0));
        // jButton_Help.addActionListener(menuController);

        // JButton jButton_Option = new JButton("Option");
        // optionTab.add(jButton_Option, BorderLayout.CENTER);
        // jButton_Option.setVisible(true);
        // jButton_Option.setContentAreaFilled(false);
        // jButton_Option.setOpaque(false);
        // jButton_Option.setPreferredSize(new Dimension(0, 0));
        // jButton_Option.setBackground(new Color(0, 0, 0, 0));
        // jButton_Option.addActionListener(menuController);

        // JButton jButton_ComingSoon = new JButton("ComingSoon");
        // comingSoonTab.add(jButton_ComingSoon, BorderLayout.CENTER);
        // jButton_ComingSoon.setVisible(true);
        // jButton_ComingSoon.setContentAreaFilled(false);
        // jButton_ComingSoon.setOpaque(false);
        // jButton_ComingSoon.setPreferredSize(new Dimension(0, 0));
        // jButton_ComingSoon.setBackground(new Color(0, 0, 0, 0));
        // jButton_ComingSoon.addActionListener(menuController);

        // JButton jButton_StartAdventure = new JButton("StartAdventure");
        // startAdventure.add(jButton_StartAdventure, BorderLayout.CENTER);
        // jButton_StartAdventure.setVisible(true);
        // jButton_StartAdventure.setContentAreaFilled(false);
        // jButton_StartAdventure.setOpaque(false);
        // jButton_StartAdventure.setPreferredSize(new Dimension(0, 0));
        // jButton_StartAdventure.setBackground(new Color(0, 0, 0, 0));
        // jButton_StartAdventure.addActionListener(menuController);

        // exitTab.remove(btnNewButton);
        // exitTab.revalidate();
        // exitTab.repaint();

        setVisible(true);

    }

    public void startAdventure() {

    }

    public void comingSoon() {

    }

    public void optionTab() {

    }

    public void helpTab() {

    }

    public void exitTab() {
        System.exit(0);
    }
}
