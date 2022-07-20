package src.com.huntersadventure.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView {
    JFrame window;
    JPanel titlePanel, startButtonPanel, mainTextPanel, choicePanel;
    JLabel titleLabel;
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    TitleScreenHandler tsHandler = new TitleScreenHandler();

    Container content;

    Font titleFont = new Font("Arial Black", Font.BOLD, 40);
    Font startFont = new Font("Arial Black", Font.BOLD, 17);


    public GameView() {
        window = new JFrame();
        window.setSize(900, 700);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Adds close functionality to window
        window.getContentPane().setBackground(Color.black); //Sets background color of window to black
        window.setLayout(null);
        //Makes JFrame window visible to user
        content = window.getContentPane();

        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 700, 100);
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
        startButton.addActionListener(tsHandler);


        titlePanel.add(titleLabel);
        startButtonPanel.add(startButton);
        content.add(titlePanel);
        content.add(startButtonPanel);

        window.setVisible(true);

    }

    @SuppressWarnings("DuplicatedCode")
    public void gameScreen(){
        titlePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(150,100,600,250);
        mainTextPanel.setBackground(Color.black);
        mainTextPanel.setBorder(BorderFactory.createLineBorder(Color.white));
        content.add(mainTextPanel);

        mainTextArea = new JTextArea();
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(startFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);

        choicePanel = new JPanel();
        choicePanel.setBounds(300,400,300,150);
        choicePanel.setBackground(Color.black);
        content.add(choicePanel);

        choice1 = new JButton("GO [north, south, east, west]");
        choice1.setOpaque(false);
        choice1.setContentAreaFilled(false);
        choice1.setBorderPainted(false);
        choice1.setForeground(Color.white);
        choice1.setFont(startFont);
        choicePanel.add(choice1);

        choice2 = new JButton("GET [item]");
        choice2.setOpaque(false);
        choice2.setContentAreaFilled(false);
        choice2.setBorderPainted(false);
        choice2.setForeground(Color.white);
        choice2.setFont(startFont);
        choicePanel.add(choice2);

        choice3 = new JButton("LOOK (inspect current area)");
        choice3.setOpaque(false);
        choice3.setContentAreaFilled(false);
        choice3.setBorderPainted(false);
        choice3.setForeground(Color.white);
        choice3.setFont(startFont);
        choicePanel.add(choice3);

        choice4 = new JButton("USE [item, spell]");
        choice4.setOpaque(false);
        choice4.setContentAreaFilled(false);
        choice4.setBorderPainted(false);
        choice4.setForeground(Color.white);
        choice4.setFont(startFont);
        choicePanel.add(choice4);

    }

    public class TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event) {
            gameScreen();

        }
    }


}
