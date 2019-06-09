package Swing_XO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Map extends JPanel {

    private final Game_Window gameWindow;

    public static final int HUMAN_VS_AI = 0;
    public static final int HUMAN_VS_HUMAN = 1;

    int[][] field;
    int fieldSize;
    int winLength;

    int cellHeight;
    int cellWidth;

    boolean isInit = false;

    public Map(Game_Window gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                update(e);
            }
        });


    }

    private void update(MouseEvent e) {
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;

        System.out.println(cellX + " " + cellY);
        if (!Logic.gameFinished) {
            Logic.setHumanXY(cellX, cellY);
        } else {
            gameWindow.showResult();
        }

        repaint();
    }

    public void startNewGame(int mode, int fieldSize, int winLength) {

        this.fieldSize = fieldSize;
        this.winLength = winLength;

        field = new int[fieldSize][fieldSize];
        isInit = true;

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render(Graphics g) {
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellHeight = panelHeight / fieldSize;
        cellWidth = panelWidth / fieldSize;

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;

            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;

            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                if(Logic.map[i][j] == Logic.DOT_X){
                    drawX(g,j,i);
                }
                if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g,j,i);
                }
            }
        }
    }

    private void drawO(Graphics g, int cellX, int cellY) {
        int indent = 2;

        g.drawLine(indent + cellX*cellWidth,indent+cellY*cellHeight,
                cellX*cellWidth+cellWidth-indent*2,indent+cellY*cellHeight+cellHeight-indent*2);

        g.drawLine(indent + cellX*cellWidth,indent+cellY*cellHeight + cellHeight-indent*2,
                cellX*cellWidth+cellWidth-indent*2,indent+cellY*cellHeight);

    }

    private void drawX(Graphics g, int cellX, int cellY) {
        g.drawOval(4+cellX*cellWidth,4+cellY*cellHeight,cellWidth-8,cellHeight-8);
    }
}
