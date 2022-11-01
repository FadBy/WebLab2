package marat.web.lab2.figures;

public class VoidFigure extends Figure {
    @Override
    public boolean checkHit(double x, double y, double r) {
        return false;
    }
}
