package battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    public enum ShipType {
        AIRCRAFT_CARRIER("Aircraft Carrier", 5),
        BATTLESHIP("Battleship", 4),
        SUBMARINE("Submarine", 3),
        CRUISER("Cruiser", 3),
        DESTROYER("Destroyer", 2);

        private final String type;
        private final int length;

        ShipType(String type, int length) {
            this.type = type;
            this.length = length;
        }

        public String getType() {
            return type;
        }

        public int getLength() {
            return length;
        }
    }

    private ShipType type;
    private List<Coordinate> coordinates;
    private int hits;
    private boolean sunk;

    public Ship(ShipType type) {
        this.type = type;
        this.coordinates = new ArrayList<>();
        this.hits = 0;
        this.sunk = false;
    }
    public void placeShip(List<Coordinate> placementCoordinates) {
        this.coordinates.addAll(placementCoordinates);
    }

    public ShipType getType() {
        return type;
    }

    public int getLength() {
        return type.getLength();
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void hit() {
        hits++;
        if (hits >= type.getLength()) {
            sunk = true;
        }
    }

    public boolean isSunk() {
        return sunk;
    }

    }

