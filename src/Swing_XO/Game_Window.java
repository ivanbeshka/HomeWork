package Swing_XO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.sleep;

public class Game_Window extends JFrame {

    private static final int WIN_HEIGHT = 600;
    private static final int WIN_WIDTH = 600;
    private static final int WIN_POS_X = 700;
    private static final int WIN_POS_Y = 300;

    Settings_Window settingsWindow;

    JButton[][] btns;

    public Game_Window() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(WIN_POS_X, WIN_POS_Y, WIN_WIDTH, WIN_HEIGHT);
        setTitle("Крестики-нолики");

        JPanel controlPanel = new JPanel(new GridLayout(1, 3));
        JButton btnStartGame = new JButton("Start new game");
        JButton btnSettings = new JButton("Settings");
        JButton btnExit = new JButton("Exit");


        controlPanel.add(btnStartGame);
        controlPanel.add(btnSettings);
        controlPanel.add(btnExit);
        add(controlPanel, BorderLayout.SOUTH);

        settingsWindow = new Settings_Window(this);

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnSettings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(true);
            }
        });

        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsWindow.setVisible(false);
                startNewGame();
            }
        });
        setVisible(true);

    }

    private void startNewGame() {

        Font font = new Font("Arial", Font.BOLD, 24);
        btns = new JButton[Logic.SIZE][Logic.SIZE];
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(Logic.SIZE, Logic.SIZE));

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                btns[i][j] = new JButton();
                btns[i][j].setFont(font);

                final int y = i;
                final int x = j;

                btns[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (Logic.isCellValid(x, y)) {
                            System.out.println(x + " " + y);
                            Logic.map[y][x] = Logic.DOT_X;
                            Logic.humanWent = false;
                        }
                    }
                });
                jPanel.add(btns[i][j]);
            }
        }
        add(jPanel);
        setVisible(true);
        start();
    }

    void start() {
        Logic.initMap();
        Logic.printMap();
        printMap();
        System.out.println("Игра началась");

        while (true) {

            do {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (!Logic.humanWent);

            Logic.humanWent = false;
            System.out.println("Человек сходил");
            Logic.printMap();
            printMap();

            if (Logic.checkWin(Logic.DOT_X)) {
                System.out.println("Игрок победил");
                return;
            }

            if (Logic.isFull()) {
                System.out.println("Ничья");
                return;
            }

            Logic.aiTurn();
            System.out.println("Компьютер сходил");
            Logic.printMap();
            printMap();

            if (Logic.checkWin(Logic.DOT_O)) {
                System.out.println("Компьютер победил");
                return;
            }

            if (Logic.isFull()) {
                System.out.println("Ничья");
                return;
            }

        }
    }

    private void printMap() {

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                btns[i][j].setText("" + Logic.map[i][j]);
            }
        }

    }
}
