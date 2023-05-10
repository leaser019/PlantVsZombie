package view.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GUI.GameOver.GameOverMouseListener;

import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class GameOver extends JFrame {
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ComingSoon frame = new ComingSoon();
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
    public GameOver() {
       GameOverMouseListener MouseListener = new GameOverMouseListener(this);
        setResizable(false);
        setFont(new Font("Times New Roman", Font.PLAIN, 14));
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\icon.png"));
        setTitle("Plants Vs Zombie");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(805, 605);
        setLocationRelativeTo(null);
        // setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("lib\\image\\gameOver.png"));
        lblNewLabel.addMouseListener(MouseListener);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 797, Short.MAX_VALUE)
                                .addContainerGap()));
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                                .addContainerGap()));
        contentPane.setLayout(gl_contentPane);
        this.setVisible(true);
    }

    public void backToMenu() {
        this.dispose();
        try {
            MenuView frame = new MenuView();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
