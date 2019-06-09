package Swing_XO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game_Window extends JFrame {

    private static final int WIN_HEIGHT = 600;
    private static final int WIN_WIDTH = 600;
    private static final int WIN_POS_X = 700;
    private static final int WIN_POS_Y = 300;

    private static Settings_Window settingsWindow;
    private static Map field;

    public Game_Window() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setTitle("Крестики-нолики");

        JPanel controlPanel = new JPanel(new GridLayout(1,2));
        JButton btnStartGame = new JButton("Start new game");
        JButton btnExit = new JButton("Exit");

        field = new Map(this);
        add(field,BorderLayout.CENTER);


        controlPanel.add(btnStartGame);
        controlPanel.add(btnExit);
        add(controlPanel, BorderLayout.SOUTH);

        settingsWindow = new Settings_Window(this);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });
        setVisible(true);

    }

    public static void startNewGame(int mode, int fieldSize, int winLength) {
        field.startNewGame(mode, fieldSize, winLength);
    }

    public void showResult() {
        Result_Window resultWindow = new Result_Window(this);
        resultWindow.setWinner(Logic.winnerName);
        resultWindow.setVisible(true);
    }
}