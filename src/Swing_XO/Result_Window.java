package Swing_XO;

import javax.swing.*;
import java.awt.*;

public class Result_Window extends JFrame {

    private final Game_Window gameWindow;
    String winner = "...";

    private static final int WIN_HEIGHT = 230;
    private static final int WIN_WIDTH = 350;

    JLabel label = new JLabel(winner);

    public Result_Window(Game_Window gameWindow) {
        this.gameWindow = gameWindow;
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setTitle("Результат");

        Rectangle gameWindowBounds = gameWindow.getBounds();
        int posX = (int) (gameWindowBounds.getCenterX() - WIN_WIDTH / 2);
        int posY = (int) (gameWindowBounds.getCenterY() - WIN_HEIGHT / 2);

        setLocation(posX,posY);

        add(label);
        setVisible(false);
    }

    public void setWinner(String winner){
        this.winner = winner;
        label.setText(winner);
    }
}
