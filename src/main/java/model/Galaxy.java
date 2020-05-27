package model;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Galaxy {
    private String title;
    private ArrayList<Planet> planets = new ArrayList<>();

    public Galaxy() {
        this.title="";
    }

    public Galaxy(String title) {
        this.title = title;
    }

    public Galaxy(String title, Planet planet) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public ArrayList<Planet> getPlanets() {
        return new ArrayList<>(planets);
    }

    public int searchPlanet (Planet pl){
        for (int i = 0; i <planets.size() ; i++) {
            if(pl.equals(planets.get(i)))
                return i;
        }
        return -1;
    }

    public int searchPlanet (String title){
        for (int i = 0; i < planets.size(); i++) {
            if (title.equals(planets.get(i).getTitle()))
                return i;
        }
        return -1;
    }

    public boolean removePlanet(Planet planet){
        return planets.remove(planet);
    }

    public boolean removePlanet(String title){
        int i = searchPlanet(title);
        if (i==-1)
            return false;
        return planets.remove(i) != null;
    }

    public void addPlanet(Planet planet){
        this.planets.add(planet);
    }

    public String behavior(){
        String res = "";
        for (int i = 0; i < planets.size() ; i++) {
            res += i+1 + " "+ planets.get(i).behavior() + "\n";
        }
        return res;
    }

    public static Galaxy parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(fileName);
        Galaxy galaxy = new Galaxy();

        Element elementGalaxy = (Element) document.getElementsByTagName("Galaxy").item(0);
        galaxy.setTitle(elementGalaxy.getElementsByTagName("Title").item(0).getTextContent());

        NodeList planetNL = document.getElementsByTagName("Planet");

        for (int i = 0; i < planetNL.getLength(); i++) {
            Planet planet = new Planet();
            Element element = (Element) planetNL.item(i);
            planet.setTitle(element.getElementsByTagName("Title").item(0).getTextContent());
            planet.setWeight(Integer.parseInt(element.getElementsByTagName("Weight").item(0).getTextContent()));

            Element coordinates = (Element) document.getElementsByTagName("Coordinates").item(i);
            planet.setX(Integer.parseInt(coordinates.getElementsByTagName("x").item(0).getTextContent()));
            planet.setY(Integer.parseInt(coordinates.getElementsByTagName("y").item(0).getTextContent()));
            planet.setZ(Integer.parseInt(coordinates.getElementsByTagName("z").item(0).getTextContent()));
            galaxy.addPlanet(planet);
        }
        return galaxy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Galaxy galaxy = (Galaxy) o;
        return Objects.equals(title, galaxy.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
