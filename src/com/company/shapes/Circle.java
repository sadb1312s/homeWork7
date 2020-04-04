package com.company.shapes;

import java.util.Objects;

public class Circle extends Shape {
    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }


    @Override
    public Point getCenter() {
        return super.center;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),radius);
    }

    public Circle clone(){
        try {
            Point newCenter = super.center.clone();
            return new Circle(newCenter,radius);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
