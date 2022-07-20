import javax.swing.*;
import java.awt.*;

public class Main {
    JFrame window;
    JPanel titlePanel, startButtonPanel;
    JLabel titleLabel;
    JButton startButton;
    Container content;

    Font titleFont = new Font("Arial Black", Font.BOLD, 40);
    Font startFont = new Font("Arial Black", Font.BOLD, 17);


    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        window = new JFrame();
        window.setSize(900, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Adds close functionality to window
        window.getContentPane().setBackground(Color.black); //Sets background color of window to black
        window.setLayout(null);
         //Makes JFrame window visible to user
        content = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100,100,700,100);
        titlePanel.setBackground(Color.black);
        titlePanel.setBorder(BorderFactory.createLineBorder(Color.white));
        titleLabel = new JLabel("A HUNTER'S ADVENTURE");
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(titleFont);


        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(350, 500, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("BEGIN YOUR HUNT");
        startButton.setOpaque(false);
        startButton.setContentAreaFilled(false);
        startButton.setBorderPainted(false);
        startButton.setForeground(Color.white);
        startButton.setFont(startFont);


        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        content.add(titlePanel);
        content.add(startButtonPanel);

        window.setVisible(true);

    }
}
