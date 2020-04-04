package com.company.items;

import java.util.Objects;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount){
        super(description,price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;

        if( o instanceof Item && getClass() != o.getClass()) {
            return super.equals(o);

        }else {
            if(getClass() == o.getClass()) {
                DiscountedItem that = (DiscountedItem) o;
                return Double.compare(that.discount, discount) == 0;
            }else {
                return false;
            }
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}
