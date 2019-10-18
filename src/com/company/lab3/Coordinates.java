package com.company.lab3;

import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;

    int getX() {
        return x;
    }
    void setX(int x) {
        this.x = x;
    }
    int getY() {
        return y;
    }
    void setY(int y) {
        this.y = y;
    }

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Coordinates() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinates)) return false;
        Coordinates that = (Coordinates) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                "} ";
    }
}