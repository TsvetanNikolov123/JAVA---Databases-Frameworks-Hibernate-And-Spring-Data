package p05_1_IntersectionOfCircles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] circle1Input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();
        double[] circle2Input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Point circle1Center = new Point(circle1Input[0], circle1Input[1]);
        double circle1Radius = circle1Input[2];

        Point circle2Center = new Point(circle2Input[0], circle2Input[1]);
        double circle2Radius = circle2Input[2];

        Circle circle1 = new Circle(circle2Center, circle1Radius);
        Circle circle2 = new Circle(circle1Center, circle2Radius);

        if (circle1.intercepts(circle2)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
