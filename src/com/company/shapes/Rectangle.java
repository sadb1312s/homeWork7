package com.company.shapes;

import java.util.Objects;

public class Rectangle extends Shape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft,double width,double height) {
        super(topLeft);

        this.height = height;
        this.width = width;

        super.moveBy(this.width/2,this.height/2);
        this.topLeft = topLeft;
    }

    @Override
    public Point getCenter() {
        return super.center;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "topLeft=" + topLeft +
                ", width=" + width +
                ", height=" + height +
                ", center=" + center +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0 &&
                Double.compare(rectangle.height, height) == 0 &&
                Objects.equals(topLeft, rectangle.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), topLeft, width, height);
    }

    public Rectangle clone(){
        try {
            Point newTopLeft = topLeft.clone();
            return new Rectangle(newTopLeft,width,height);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
