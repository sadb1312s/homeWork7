package com.company.shapes;

import java.util.Objects;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint(String label, double x,double y){
        super(x,y);
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "x=" + x +
                ", y=" + y +
                ", label="+label+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LabeledPoint that = (LabeledPoint) o;
        return Objects.equals(label, that.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), label);
    }

    public LabeledPoint clone() throws CloneNotSupportedException {
        return (LabeledPoint) super.clone();
    }
}
