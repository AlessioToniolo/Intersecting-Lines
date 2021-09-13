public class Line {
    public Coordinate start;
    public Coordinate end;

    public Line(Coordinate start, Coordinate end) {
        this.start = start;
        this.end = end;
    }

    public Boolean inBounds(double x, double y) {
        boolean out = false;

        if (isBetween(start.x, end.x, x) && isBetween(start.y, end.y, y)) {
            out = true;
        }
        
        return out;
    }

    //SINGLE LINE FUNCTIONS
    
    // Gets slope of a singular line
    public Double getSlope() {
        return (end.y - start.y) / (end.x - start.x);
    }

    // Gets y intercept of a singular line
    public Double getIntercept() {
        return getSlope()*(0-start.x) + start.y;
    }
    
    // Gets true/false if a singular line is vertical
    public Boolean isVertical() {
        boolean out = false;
        
        if (getSlope() == Double.POSITIVE_INFINITY) {
            out = true;
        }
        
        return out;
    }

    // Gets true/false if a value is in between two values
    public boolean isBetween(double a, double b, double test) {
        boolean out = false;

        if (a > b) {
            if (test >= b && test <= a) {
                return true;
            }
        } else {
            if (test >= a && test <= b) {
                return true;
            }
        }

        return out;
    }

}
