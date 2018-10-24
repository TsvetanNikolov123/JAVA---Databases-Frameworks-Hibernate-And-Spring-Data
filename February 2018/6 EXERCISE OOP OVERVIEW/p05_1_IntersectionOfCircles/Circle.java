package p05_1_IntersectionOfCircles;

public class Circle {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean intercepts(Circle other){
        double a = other.center.getX() -this.center.getX();
        double b = other.center.getY() -this.center.getY();

        double distanceBetweenCenters = Math.sqrt(a*a-b*b);
        return distanceBetweenCenters <= this.radius + other.radius;
    }
}
