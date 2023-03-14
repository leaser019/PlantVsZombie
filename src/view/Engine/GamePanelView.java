package view.Engine;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import java.awt.Toolkit;
import java.awt.Font;

public class GamePanelView extends JFrame{
    public GamePanelView(){
        setSize(805,605);
        setTitle("Plants Vs Zombie Clone");
        setIconImage(Toolkit.getDefaultToolkit().getImage(
                "lib\\image\\dausht0-74037f3a-028d-4ed0-ac0a-c39ccc4e7a34.png"));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);
        
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        JLabel lblNewLabel = new JLabel("Graph");
        JTextField textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        textField_1.setBounds(59, 52, 231, 25);
        lblNewLabel.setBounds(0, 0, 776, 531);
        lblNewLabel.setIcon(new ImageIcon("lib\\image\\mainBG.png"));
        jPanel.add(lblNewLabel,BorderLayout.CENTER);
        this.add(jPanel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new GamePanelView();
    }
}
