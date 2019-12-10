package model;

import com.google.gson.Gson;

import java.util.Objects;

public class Coordinates {
    private int x;
    private int y;
    private int z;

    public Coordinates() {
        this.x = (int)(Math.random()*1000);
        this.y = (int)(Math.random()*1000);
        this.z = (int)(Math.random()*1000);
    }

    public Coordinates(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getZ() {
        return z;
    }
    public void setZ(int z) {
        this.z = z;
    }

    private static int rand(int a){
        int b = (int) ((a-10)+Math.random()*(20));
        return b;
    }

    public void moveK (){
        x=rand(x);
        y=rand(y);
        z=rand(z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x &&
                y == that.y &&
                z == that.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }


}

