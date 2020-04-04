package com.company.shapes;

import java.util.Objects;

public abstract class Shape {
    public Point center;

    public Shape(Point center) {
        this.center = center;
    }

    public void moveBy(double dx, double dy){
        center.x += dx;
        center.y += dy;
    }

    public abstract Point getCenter();

    public abstract Shape clone();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(center,shape.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center);
    }
}
