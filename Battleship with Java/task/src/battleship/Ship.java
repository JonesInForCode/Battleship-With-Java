package battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String type;
    private int length;
    private List<Coordinate> coordinates;
    private int hits;
    private boolean sunk;

    public Ship(String type, int length) {
        this.type = type;
        this.length = length;
        this.coordinates = new ArrayList<>();
        this.hits = 0;
        this.sunk = false;
    }
    public void placeShip(List<Coordinate> placementCoordinates) {
        this.coordinates.addAll(placementCoordinates);
    }

    }

