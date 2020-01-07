package util;

import model.Galaxy;
import model.Planet;

public class Generator {

    public static Planet generatePlanet() {
        Planet planet = new Planet();
        planet.setTitle("P" + generateNumber(100, 999));
        planet.setWeight(generateNumber(150, 999));
        planet.setX(generateNumber(0, 1000));
        planet.setY(generateNumber(0, 1000));
        planet.setZ(generateNumber(0, 1000));
        return planet;
    }

    public static Galaxy generateGalaxy() {
        Galaxy galaxy = new Galaxy();
        galaxy.setTitle("G" + generateNumber(100, 999));
        for (int j = 0; j < ((int)(5 + Math.random()*(6))); j++) {
            galaxy.addPlanet(Generator.generatePlanet());
        }
        return galaxy;
    }

    private static int generateNumber(int a, int b) {
        return (int) (a + Math.random() * (b - a + 1));
    }
}
