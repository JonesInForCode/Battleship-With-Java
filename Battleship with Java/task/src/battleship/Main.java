package battleship;

public class Main {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        GameBoardManager manager = new GameBoardManager(gameBoard);
        gameBoard.printBoard();
        manager.placeShipOnBoard();
        gameBoard.printBoard();
    }
}
