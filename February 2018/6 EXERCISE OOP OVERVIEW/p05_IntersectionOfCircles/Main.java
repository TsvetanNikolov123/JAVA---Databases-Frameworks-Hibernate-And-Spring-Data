package p05_IntersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().trim().split("\\s+");
        Circle circleA = getCircle(input);

        String[] input1 = reader.readLine().trim().split("\\s+");
        Circle circleB = getCircle(input1);

        boolean circlesIntersect = circleA.getCenter().distanceTo(circleB.getCenter()) <=
                circleA.getRadius() + circleB.getRadius();

        if (circlesIntersect) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static Circle getCircle(String[] input) throws IOException {
        int[] data = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            data[i] = Integer.parseInt(input[i]);
        }

        Point center = new Point();
        center.setX(data[0]);
        center.setY(data[1]);

        Circle circle = new Circle(center, data[2]);
        return circle;
    }
}

