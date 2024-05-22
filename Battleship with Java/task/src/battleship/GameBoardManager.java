package battleship;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameBoardManager {
    private Scanner scanner;
    private GameBoard gameBoard;

    public GameBoardManager(GameBoard gameBoard) {
        this.scanner = new Scanner(System.in);
        this.gameBoard = this.gameBoard;
    }

    public void placeShipOnBoard() {
        System.out.println("Enter the coordinates of the ship (e.g., F7 F3):");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        if (parts.length == 2) {
            int[] start = convertCoordinates(parts[0]);
            int[] end = convertCoordinates(parts[1]);

            Coordinate startCoordinate = new Coordinate(start[0], start[1]);
            Coordinate endCoordinate = new Coordinate(end[0], end[1]);

            List<Coordinate> shipCoordinates = generateShipCoordinates(startCoordinate, endCoordinate);

            int length = calculateLength(start, end) + 1;

            Ship ship = new Ship("Battleship", length);
            ship.placeShip(shipCoordinates);
        } else {
            System.out.println("You should enter two coordinates");
        }
    }

    private int[] convertCoordinates(String coordinates) {
        int row = coordinates.charAt(0) - 'A';
        int col = Integer.parseInt(coordinates.substring(1)) - 1;
        return new int[]{row, col};
    }

    private int calculateLength(int[] start, int[] end) {
        return Math.abs(end[0] - start[0]) + Math.abs(end[1] - start[1]);
    }

    private List<Coordinate> generateShipCoordinates(Coordinate start, Coordinate end) {
        List<Coordinate> coordinates = new ArrayList<>();
        if (start.row == end.row) { // Horizontal
            for (int col = Math.min(start.column, end.column); col <= Math.max(start.column, end.column); col++) {
                coordinates.add(new Coordinate(start.row, col));
            }
        } else if (start.column == end.column) { // Vertical
            for (int row = Math.min(start.row, end.row); row <= Math.max(start.row, end.row); row++) {
                coordinates.add(new Coordinate(row, start.column));
            }
        }
        return coordinates;
    }
}