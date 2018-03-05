package p05_IntersectionOfCircles;

public class Point {
    private int x;
    private int y;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distanceTo(Point p) {
        double deltaX = Math.abs(x - p.x);
        double deltaY = Math.abs(y - p.y);
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
