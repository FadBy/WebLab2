package marat.web.lab2;

import marat.web.lab2.figures.Figure;

import java.util.Arrays;
import java.util.Map;

public class Graph {
    private final Figure[] quarters;

    public Graph(Figure[] quarters) {
        if (quarters.length != 4) {
            throw new IllegalArgumentException("quarters must have exact 4 elements");
        }
        this.quarters = quarters;
    }

    public boolean checkHit(double x, double y, double r) {
        for (Figure figure : quarters) {
            if (figure.checkHit(x, y, r)) {
                return true;
            }
        }
        return false;
    }

}
