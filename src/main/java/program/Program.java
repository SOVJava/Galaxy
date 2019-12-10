package program;

import model.Universe;

public class Program {
    public static void main(String[] args) {
        /*Galaxy g1 = new Galaxy("G1");
        g1.addPlanet(new Planet("P333", 515,100,150,130));
        g1.addPlanet(new Planet("P334", 510,2,3,90));
        g1.addPlanet(new Planet("P754",435,50,10,300));
        g1.addPlanet(new Planet("P112",600,80,99,314));
        g1.addPlanet(new Planet("P115",601,89,999,514));
        g1.addPlanet(Generator.generatePlanet());

        Galaxy g2 = new Galaxy("G2");
        g2.addPlanet(Generator.generatePlanet());
        g2.addPlanet(Generator.generatePlanet());
        g2.addPlanet(new Planet("P555",600,89,599,300));

        System.out.println(g1.getPlanets());
        System.out.println(g2.getPlanets());

        int x1 = g1.searchPlanet("P334");
        System.out.println(x1);
        int x2 = g1.searchPlanet("P335");
        System.out.println(x2);

        if (!g1.removePlanet("P334"))
            System.out.println("Планеты нет");
        else System.out.println("Планета удалена");

        if (!g1.removePlanet(new Planet("P111",600,80,99,314)))
            System.out.println("Планеты нет");
        else System.out.println("Планета удалена");

        //String y = galaxy1.behavior();
        //System.out.println(y);

        Universe u1 = new Universe();
        u1.addGalaxy(g1);
        u1.addGalaxy(g2);

        int gal1 = u1.searchGalaxy(g1);
        System.out.println(gal1);
        int gal2 = u1.searchGalaxy("G2");
        System.out.println(gal2);

        int[] pl1 = u1.searchPlanet(new Planet("P754",435,50,10,300));
        System.out.println(Arrays.toString(pl1));
        int[] pl2 = u1.searchPlanet("P115");
        System.out.println(Arrays.toString(pl2));*/

        Universe u1 = new Universe();
        u1.behavior();

        System.out.println(u1.getGalaxies().get(0).getPlanets());
        System.out.println(u1.getGalaxies());

    }
}
