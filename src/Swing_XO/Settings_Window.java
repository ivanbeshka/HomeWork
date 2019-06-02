package Swing_XO;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings_Window extends JFrame {

    private final Game_Window gameWindow;

    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;
    private static final int MIN_WIN_LEN = 3;
    private static final int MAX_WIN_LEN = 10;
    private static final int MIN_FIELD_SIZE = 3;
    private static final int MAX_FIELD_SIZE = 10;
    private static final String STR_WIN_LEN = "Длинна победной линии : ";
    private static final String STR_FIELD_SIZE = "Размер поля : ";

    private JRadioButton jrbHumanVsAi = new JRadioButton("Человек против компьютера", true);
    private JRadioButton jrbHumanVsHuman = new JRadioButton("Человек против Человека");
    private ButtonGroup gameMode = new ButtonGroup();

    private static JSlider slFieldSize;
    private static JSlider slWinLength;

    public Settings_Window(Game_Window gameWindow) {
        this.gameWindow = gameWindow;

        setSize(WIN_WIDTH, WIN_HEIGHT);
        setTitle("Settings");

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WIN_WIDTH / 2);
        int posY = (int) (gameWindowBounds.getCenterY() - WIN_HEIGHT / 2);
        setLocation(posX, posY);

        setLayout(new GridLayout(9, 1));

        addGameControlMode();

        addGameControlFieldWinLength();

        setVisible(false);
    }

    private void addGameControlFieldWinLength() {
        add(new JLabel("Выберите размер поля :"));
        JLabel jlbFieldSize = new JLabel(STR_FIELD_SIZE + MIN_FIELD_SIZE);
        add(jlbFieldSize);

        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentFieldSize = slFieldSize.getValue();
                jlbFieldSize.setText(STR_FIELD_SIZE + currentFieldSize);
                slWinLength.setMaximum(currentFieldSize);
            }
        });
        add(slFieldSize);

        add(new JLabel("Выберите размер победной линии :"));
        JLabel jlbWinLength = new JLabel(STR_WIN_LEN + MIN_WIN_LEN);
        add(jlbWinLength);

        slWinLength = new JSlider(MIN_WIN_LEN, MAX_WIN_LEN, MIN_WIN_LEN);
        slWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentWinLen = slWinLength.getValue();
                jlbWinLength.setText(STR_WIN_LEN + currentWinLen);
            }
        });
        add(slWinLength);
    }

    private void addGameControlMode() {
        add(new JLabel("Выберите режим игры :"));
        gameMode.add(jrbHumanVsAi);
        gameMode.add(jrbHumanVsHuman);
        add(jrbHumanVsAi);
        add(jrbHumanVsHuman);

    }

}
