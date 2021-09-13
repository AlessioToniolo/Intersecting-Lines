public class Intersecting {
    public Line spyToCamera;

    public Intersecting(Line spyToCamera) {
        this.spyToCamera = spyToCamera;
    }

    // DOUBLE LINE FUNCTIONS

    // Gets true/false if a singular line is parallel with another line
    public Boolean isParallel(Line line1, Line line2) {
        boolean out = false;

        if (line1.getSlope() == line2.getSlope()) {
            out = true;
        }

        return out;
    }

    // Gets true/false if a singular line is parallel and has the same intercept as another line
    public Boolean isSame(Line line1, Line line2) {
        boolean out = false;

        if (line1.getSlope() == line2.getSlope() && line1.getIntercept() == line2.getIntercept()) {
            out = true;
        }

        return out;
    }

    public Boolean isIntersecting(Line wall) {
        boolean seen = true;

        double x = (spyToCamera.getIntercept() - wall.getIntercept()) / (wall.getSlope()-spyToCamera.getSlope());
        double y = wall.getSlope()*x+ wall.getIntercept();

        if (wall.inBounds(x, y) && spyToCamera.inBounds(x, y)) {
            seen = false;
        }

        return seen;
    }
}