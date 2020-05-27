package model;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Objects;

public class Planet {
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

    public static Planet parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder bilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = bilder.parse(fileName);
        Element elementPlanet = (Element) document.getElementsByTagName("Planet").item(0);
        Planet planet = new Planet();
        planet.setTitle(elementPlanet.getElementsByTagName("Title").item(0).getTextContent());
        planet.setWeight(Integer.parseInt(elementPlanet.getElementsByTagName("Weight").item(0).getTextContent()));

        Element coordinates = (Element) document.getElementsByTagName("Coordinates").item(0);

        planet.setX(Integer.parseInt(coordinates.getElementsByTagName("x").item(0).getTextContent()));
        planet.setY(Integer.parseInt(coordinates.getElementsByTagName("y").item(0).getTextContent()));
        planet.setZ(Integer.parseInt(coordinates.getElementsByTagName("z").item(0).getTextContent()));
        return planet;
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
