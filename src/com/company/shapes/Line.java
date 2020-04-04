package com.company.shapes;

import java.util.List;
import java.util.Objects;

public class Line extends Shape {
    private Point to;

    public Line(Point from,Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point getCenter() {
        return super.center;
    }

    @Override
    public String toString() {
        return "Line{" +
                "from=" + center +
                ", to=" + to +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Line line = (Line) o;
        return Objects.equals(to, line.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), to);
    }

    @Override
    public Line clone() {
        try {
            Point newFrom = super.center.clone();
            Point newTo = to.clone();
            return new Line(newFrom,newTo);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
