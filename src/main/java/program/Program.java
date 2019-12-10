package program;

import model.Planet;
import model.Universe;
import util.Generator;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("Вас приветствует Виртуальный помошник.\n" +
                    "Нажмите 1 чтоб войти в панель планет,\n" + "нажмите 2 чтоб войти в панель галактик,\n" +
                    "нажмите 3 для входа в панель вселенной.\nВаш выбор: ");

            if (sc.hasNextInt()) {
                int number = sc.nextInt();

                switch (number) {
                    case 1:
                        number = 1;
                        System.out.println("1 - создать планету (по умолчанию),\n2 - создать планету через " +
                                "конструктор,\n3 - создать планету со случайными параметрами,\n" +
                                "4 - действия над планетой");
                        while (true) {
                            int pl = sc.nextInt();
                            if (pl > 0 && pl <= 3) {
                                switch (pl) {
                                    case 1:
                                        pl = 1;
                                        System.out.println("Планета без параметров: ");
                                        Planet planet = new Planet();
                                        System.out.println(planet);
                                        break;
                                    case 2:
                                        pl = 2;
                                        System.out.println("Имя планеты: ");
                                        String plTitle = sc.next();
                                        System.out.println("Вес планеты: ");
                                        int plWeight = sc.nextInt();
                                        System.out.println("Координата Х: ");
                                        int plX = sc.nextInt();
                                        System.out.println("Координата Y: ");
                                        int plY = sc.nextInt();
                                        System.out.println("Координата Z: ");
                                        int plZ = sc.nextInt();
                                        Planet planet1 = new Planet(plTitle, plWeight, plX, plY, plZ);
                                        System.out.println(planet1);
                                        break;
                                    case 3:
                                        pl = 3;
                                        Planet planet2 = Generator.generatePlanet();
                                        System.out.println(planet2);
                                        break;
                                }
                            }
                        }
                    case 2:
                        number = 2;
                        System.out.println("1 - создать галактику (по умолчанию),\n2 - создать галактику" +
                                " чекез конструктор\n");

                    case 3:
                        number = 3;
                }
            } else {
                System.out.println("Неверный ввод. Перезапустите программу и попробуйте снова!");
            }
        }



        /*Planet pl1 = new Planet("qwen", 123, 10,20,30);
        System.out.println(pl1.getTitle());
        pl1.setTitle("P122");
        System.out.println(pl1.getTitle());*/


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

        /*Universe u1 = new Universe();
        u1.behavior();*/

        /*System.out.println(u1.getGalaxies().get(0).getPlanets());
        System.out.println(u1.getGalaxies());*/

    }
}
