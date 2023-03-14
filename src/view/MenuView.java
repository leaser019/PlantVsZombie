package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JEditorPane;
import java.awt.Toolkit;
import java.awt.Font;
import javafx.application.Application;

public class MenuView extends JFrame{

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
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "GameProject\\src\\view\\image\\png-clipart-plants-vs-zombies-256-icon-plants-vs-zombies-thumbnail - Edited.png"));
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
        panel.add(comingSoonTab);

        JPanel optionTab = new JPanel();
        optionTab.setBounds(546, 405, 95, 97);
        panel.add(optionTab);

        JPanel helpTab = new JPanel();
        helpTab.setBounds(651, 405, 48, 97);
        panel.add(helpTab);

        JPanel exitTab = new JPanel();
        exitTab.setBounds(709, 405, 67, 97);
        panel.add(exitTab);
        setResizable(false);

        setVisible(true);

    }
    public void startAdventure(){

    }
    public void comingSoon(){

    }
    public void optionTab(){

    }
    public void helpTab(){

    }
    public void exitTab(){
        
    }
}
