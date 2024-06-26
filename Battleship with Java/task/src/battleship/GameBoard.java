package battleship;

import java.util.List;


public class GameBoard {
    private final char[][] board;
    private final int size = 10;

    public GameBoard() {
        this.board = new char[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = '~';
            }
        }
    }

    public void printBoard() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int row = 0; row < size; row++) {
            System.out.print((char) ('A' + row) + " ");
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    public void placeShipOnBoard(List<Coordinate> shipCoordinates) {
        for (Coordinate coordinate : shipCoordinates) {
            board[coordinate.row][coordinate.column] = 'O';        }
    }
}
