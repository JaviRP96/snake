import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Clase que representa el panel donde se dibuja el tablero de juego.
 */
public class BoardDrawing extends JPanel {

    int b = 0;
    int row = 8;
    int col = 8;
    ArrayList<Rectangle> cells;
    int[] cellnos;

    BoardScreen bs;

    /**
     * Constructor de la clase BoardDrawing.
     * @param row Número de filas del tablero.
     * @param col Número de columnas del tablero.
     * @param bs Objeto BoardScreen al que está asociado el tablero.
     */
    public BoardDrawing(int row, int col, BoardScreen bs) {
        this.bs = bs;
        this.row = row;
        this.col = col;

        cells = new ArrayList<Rectangle>();
        cellnos = new int[row * col];

        // Inicializar las celdas del tablero
        initializeCells();

        // Inicializar los portales del tablero
        initializePortals();
    }

    /**
     * Método que inicializa las celdas del tablero.
     */
    private void initializeCells() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int cellWidth = 0;
                int xOffset = 0;
                int cellHeight = 0;
                int yOffset = 0;
                Rectangle latest = new Rectangle(
                        xOffset + (j * cellWidth),
                        yOffset + (i * cellHeight),
                        cellWidth,
                        cellHeight);
                cells.add(latest);
            }
        }
    }

    /**
     * Método que inicializa los portales del tablero.
     */
    private void initializePortals() {
        int noPorts = 8;
        bs.portals = new ArrayList<Portal>(noPorts);
        for (int i = 0; i < noPorts; i++) {
            Portal temp = new Portal(row * col);
            bs.portals.add(temp);
        }
    }

    /**
     * Método que dibuja el tablero y los elementos del juego.
     * @param g Objeto Graphics para dibujar.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Dibujar las celdas del tablero
        drawCells(g2d);

        // Dibujar los elementos del juego (jugadores, portales, etc.)
        drawGameElements(g2d);
    }

    /**
     * Método que dibuja las celdas del tablero.
     * @param g2d Objeto Graphics2D para dibujar.
     */
    private void drawCells(Graphics2D g2d) {
        // Dibujar las celdas del tablero
        // ...
    }

    /**
     * Método que dibuja los elementos del juego.
     * @param g2d Objeto Graphics2D para dibujar.
     */
    private void drawGameElements(Graphics2D g2d) {
        // Dibujar jugadores, portales, etc.
        // ...
    }

    /**
     * Método para garantizar la posición de un jugador en el tablero, teniendo en cuenta los portales.
     * @param pnos Índice del jugador.
     * @return Mensaje indicando si el jugador subió por una escalera o si fue atrapado por una serpiente.
     */
    public String ensurePlayerPosition(int pnos) {
        String message = "";
        for (Portal port : bs.portals) {
            if (bs.players.get(pnos).getPosition() == port.returnStart()) {
                bs.players.get(pnos).setPosition(port.returnEnd());
                if (port.returnNature() == 1) {
                    message += "You are up through ladder at position " + port.returnStart();
                } else if (port.returnNature() == -1) {
                    message += "Snake at " + port.returnStart() + " got you.";
                }
            }
        }
        return message;
    }

    /**
     * Método para establecer la posición de un jugador en el tablero.
     * @param a Número de pasos que el jugador avanza.
     * @param pnos Índice del jugador.
     */
    public void setPlayer(int a, int pnos) {
        bs.players.get(pnos).incPosition(a);
    }
    

}