package oop.HW2;

import java.util.ArrayList;
import java.util.List;

public class Shape {
    private final List<Point> vertices;
    private final Point center;
    private final double radius;

    public Shape() {
        this.vertices = new ArrayList<>();
        this.center = new Point(0, 0);
        this.radius = 0;
    }
    public Shape(String shapeString) {
        this.vertices = new ArrayList<>();
        String[] verticesString = shapeString.split(" ");
        for (int i = 0; i < verticesString.length; i++) {
            double x = Double.parseDouble(verticesString[i]);
            double y = Double.parseDouble(verticesString[i + 1]);
            Point temp = new Point(x, y);
            System.out.println(temp.toString());
            addVertex(temp);
            i++;
        }

        double centerX = 0;
        double centerY = 0;
        for (Point vertex : vertices) {
            centerX += vertex.getX();
            centerY += vertex.getY();
        }
        centerX /= vertices.size();
        centerY /= vertices.size();
        center = new Point(centerX, centerY);
        System.out.println(center.toString());


        double radius = Double.MAX_VALUE;
        for (Point vertex : vertices) {
            double r = Math.sqrt((vertex.getX() - centerX) * (vertex.getX() - centerX) + (vertex.getY() - centerY) * (vertex.getY() - centerY));
            if (r < radius) {
                radius = r;
            }
        }
        this.radius = radius;
        System.out.println(this.radius);
    }

    public void addVertex(Point vertex) {
        vertices.add(vertex);
    }

    public List<Point> getVertices() {
        return vertices;
    }

    public Point getCenter() {
        return center;
    }
    public double getRadius() {
        return radius;
    }
    public boolean cross(Shape that) {
        boolean in = false;
        boolean out = false;
        for (Point vertex : vertices) {
            if (vertex.distanceTo(that.getCenter()) <= that.getRadius()) {
                in = true;
            }
            if (vertex.distanceTo(that.getCenter()) >= that.getRadius()) {
                out = true;
            }
        }
        return in && out;
    }
    public int encircle(Shape that) {
        if (center.distanceTo(that.getCenter()) < radius) {
            return 2;
        } else if (cross(that)) {
            return 1;
        } else {
            return 0;
        }
    }
}
