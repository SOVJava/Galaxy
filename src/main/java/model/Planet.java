package model;

import com.google.gson.Gson;

import java.util.Objects;

public class Planet{
    private String title;
    private int weight;
    private Coordinates coordinates;

    public Planet() {
        this.title = "";
        this.coordinates = new Coordinates();
    }

    public Planet(String title) {
        this.title = title;
    }

    public Planet(String title, int weight) {
        this.title = title;
        this.weight = weight;
        this.coordinates = new Coordinates();
    }

    public Planet(String title, int weight, int x, int y, int z) {
        this.title = title;
        this.weight = weight;
        this.coordinates = new Coordinates(x,y,z);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getX() {
        return this.coordinates.getX();
    }
    public void setX(int x) {
        this.coordinates.setX(x);
    }
    public int getY() {
        return this.coordinates.getY();
    }
    public void setY(int y) {
        this.coordinates.setY(y);
    }
    public int getZ() {
        return this.coordinates.getZ();
    }
    public void setZ(int z) {
        this.coordinates.setZ(z);
    }

    public Coordinates getCoordinates(){
        return coordinates;
    }

    public Planet behavior(){
        coordinates.moveK();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return weight == planet.weight &&
                title.equals(planet.title) &&
                coordinates.equals(planet.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, weight, coordinates);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
