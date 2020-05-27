package model;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import util.Generator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Universe {

    private String title;
    private ArrayList<Galaxy> galaxies = new ArrayList<>();

    private Timer timer = new Timer();

    public Universe() {
        this.title = "";
    }

    public Universe(String title) {
        this.title = title;
    }

    public Universe(String title, Galaxy galaxies) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Galaxy> getGalaxies() {
        return new ArrayList<>(galaxies);
    }

    public void addGalaxy(Galaxy galaxy) {
        this.galaxies.add(galaxy);
    }

    public int searchGalaxy(Galaxy galaxy) {
        for (int i = 0; i < galaxies.size(); i++) {
            if (galaxy.equals(galaxies.get(i)))
                return i;
        }
        return -1;
    }

    public int searchGalaxy(String title) {
        for (int i = 0; i < galaxies.size(); i++) {
            if (title.equals(galaxies.get(i).getTitle()))
                return i;
        }
        return -1;
    }

    public int[] searchPlanet(Planet planet) {
        for (int i = 0; i < galaxies.size(); i++) {
            int j = galaxies.get(i).searchPlanet(planet);
            if (j != -1)
                return new int[]{i, j};
        }
        return null;
    }

    public int[] searchPlanet(String title) {
        for (int i = 0; i < galaxies.size(); i++) {
            int j = galaxies.get(i).searchPlanet(title);
            if (j != -1)
                return new int[]{i, j};
        }
        return null;
    }

    public boolean removeGalaxy(String title) {
        int x = searchGalaxy(title);
        if (x == -1)
            return false;
        return galaxies.remove(x) != null;
    }

    public boolean removePlanet(String gTitle, String pTitle) {
        int x = searchGalaxy(gTitle);
        if (x == -1)
            return false;
        int y = galaxies.get(x).searchPlanet(pTitle);
        if (y == -1)
            return false;
        return galaxies.get(x).removePlanet(pTitle);
    }

    public void behavior(boolean has) {
        if (has) {
            timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    for (int i = 0; i < ((int) (5 + Math.random() * (6))); i++) {
                        addGalaxy(Generator.generateGalaxy());
                    }
                }
            }, 0, 30 * 1000);
        } else
            timer.cancel();
    }

    public static Universe parseXML(String fileName) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(fileName);
        Universe universe = new Universe();
        Element elementUniverse = (Element) document.getElementsByTagName("Universe").item(0);
        universe.setTitle(elementUniverse.getElementsByTagName("Title").item(0).getTextContent());
        NodeList galaxyNL = document.getElementsByTagName("Galaxy");
        for (int i = 0; i < galaxyNL.getLength(); i++) {
            Galaxy galaxy = new Galaxy();
            Element elementGalaxy = (Element) galaxyNL.item(i);
            galaxy.setTitle(elementGalaxy.getElementsByTagName("Title").item(0).getTextContent());

            String spec = elementGalaxy.getAttribute("spec");

            NodeList planetNL = elementGalaxy.getElementsByTagName("Planet");
            for (int j = 0; j < planetNL.getLength(); j++) {
                Planet planet = new Planet();
                Element elementPlanet = (Element) planetNL.item(j);

                planet.setTitle(elementPlanet.getElementsByTagName("Title").item(0).getTextContent());
                planet.setWeight(Integer.parseInt(elementPlanet.getElementsByTagName("Weight").item(0).getTextContent()));

                Element elementCoordinates = (Element) elementGalaxy.getElementsByTagName("Coordinates").item(j);
                planet.setX(Integer.parseInt(elementCoordinates.getElementsByTagName("x").item(0).getTextContent()));
                planet.setY(Integer.parseInt(elementCoordinates.getElementsByTagName("y").item(0).getTextContent()));
                planet.setZ(Integer.parseInt(elementCoordinates.getElementsByTagName("z").item(0).getTextContent()));

                galaxy.addPlanet(planet);
            }
            universe.addGalaxy(galaxy);
        }
        return universe;
    }

    public static ArrayList<ArrayList<String>> group(String[] word){
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        boolean[] arrBoo = new boolean[word.length];
        for (int i = 0; i < word.length; i++) {
            if(!arrBoo[i]){
                ArrayList<String> arr = new ArrayList<>();
                arr.add(word[i]);
                arrBoo[i] = true;
                for (int j = i+1; j < arrBoo.length; j++) {
                    if (word[i].equals(word[j])){
                        arr.add(word[j]);
                        arrBoo[j] = true;
                    }
                }
                res.add(arr);
            }
        }
        return res;
    }

    public static ArrayList<ArrayList<Element>> groupPlanet(String fileName) throws ParserConfigurationException, IOException, SAXException {
        ArrayList<ArrayList<Element>> res = new ArrayList<>();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(fileName);
        NodeList planetNL = document.getElementsByTagName("Planet");
        boolean[] boo = new boolean[planetNL.getLength()];
        for (int i = 0; i < planetNL.getLength(); i++) {
            if (!boo[i]) {
                ArrayList<Element> gruopPlanet = new ArrayList<>();
                Element element = (Element) planetNL.item(i);
                String title = element.getElementsByTagName("Title").item(0).getTextContent();
                gruopPlanet.add(element);
                boo[i] = true;
                for (int j = i + 1; j < boo.length; j++) {
                    Element element1 = (Element) planetNL.item(j);
                    String title1 = element1.getElementsByTagName("Title").item(0).getTextContent();
                    if (title.equals(title1)) {
                        gruopPlanet.add(element1);
                        boo[j] = true;
                    }
                }
                res.add(gruopPlanet);
            }
        }
        return res;
    }

    public static void writeXML(String fileName, ArrayList<ArrayList<Element>> arr) throws ParserConfigurationException, TransformerException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.newDocument();

        Element universeGroup = document.createElement("UniverseGroup");
        document.appendChild(universeGroup);

        for (int i = 0; i < arr.size(); i++) {
            Element group = document.createElement("Group");
            universeGroup.appendChild(group);

            Element element = arr.get(i).get(0);
            String tagName = element.getElementsByTagName("Title").item(0).getTextContent();
            Attr nameGrup = document.createAttribute("name");
            nameGrup.setValue(tagName);
            group.setAttributeNode(nameGrup);

            for (int j = 0; j < arr.get(i).size(); j++) {
                Element planet = arr.get(i).get(j);
                planet = (Element) document.importNode(planet, true);
                group.appendChild(planet);

                /*Element planet = document.createElement(arr.get(i).get(j).getTagName());
                group.appendChild(planet);

                Element title = document.createElement("Title");
                title.appendChild(document.createTextNode(arr.get(i).get(j).getElementsByTagName("Title").item(0).getTextContent()));
                planet.appendChild(title);

                Element weight = document.createElement("Weight");
                weight.appendChild(document.createTextNode(arr.get(i).get(j).getElementsByTagName("Weight").item(0).getTextContent()));
                planet.appendChild(weight);

                Element coordinates = document.createElement("Coordinates");
                planet.appendChild(coordinates);

                Element x = document.createElement("x");
                x.appendChild(document.createTextNode(arr.get(i).get(j).getElementsByTagName("x").item(0).getTextContent()));
                coordinates.appendChild(x);

                Element y = document.createElement("y");
                y.appendChild(document.createTextNode(arr.get(i).get(j).getElementsByTagName("y").item(0).getTextContent()));
                coordinates.appendChild(y);

                Element z = document.createElement("z");
                z.appendChild(document.createTextNode(arr.get(i).get(j).getElementsByTagName("z").item(0).getTextContent()));
                coordinates.appendChild(z);*/
            }
        }
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        // красивый вывод
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(fileName);
        transformer.transform(domSource, streamResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universe universe = (Universe) o;
        return Objects.equals(title, universe.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    /*@Override
    public String toString() {
        return new Gson().toJson(this);
    }*/
}
