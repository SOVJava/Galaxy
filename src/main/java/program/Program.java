package program;

import model.Galaxy;
import model.Planet;
import model.Universe;
import util.Generator;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Galaxy galaxy2 = null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Вас приветствует Виртуальный помошник.\n" +
                    "Нажмите 1 чтоб войти в панель планет,\n" + "нажмите 2 чтоб войти в панель галактик,\n" +
                    "нажмите 3 для входа в панель вселенной.\nВаш выбор: ");
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                switch (number) {
                    case 1:
                        label:
                        {
                            while (true) {
                                System.out.println("1 - создать планету (по умолчанию),\n" +
                                        "2 - создать планету со случайными параметрами,\n" +
                                        "3 - создать планету через конструктор,\n" +
                                        "4 - выход из меню планеты");
                                int pl = sc.nextInt();
                                if (pl > 0 && pl <= 4) {
                                    switch (pl) {
                                        case 1:
                                            System.out.println("Планета без параметров: ");
                                            Planet planet = new Planet();
                                            System.out.println(planet);
                                            break;
                                        case 2:
                                            Planet planet2 = Generator.generatePlanet();
                                            System.out.println(planet2);
                                            break;
                                        case 3:
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
                                        case 4:
                                            break label;
                                    }

                                }
                            }
                        }
                        break;
                    case 2:
                        label1:
                        {
                            while (true) {
                                System.out.println("1 - Создать галактику\n" +
                                        "2 - Добавить планету в галактику\n" +
                                        "3 - Найти планету\n" +
                                        "4 - Удалить планету\n" +
                                        "5 - Список планет в галактике\n" +
                                        "6 - Выход из меню галактики\n");
                                int ga = sc.nextInt();
                                if (ga > 0 && ga <= 6) {
                                    switch (ga) {
                                        case 1:
                                            Galaxy galaxy1 = new Galaxy();
                                            System.out.println("Галактика создана!");
                                            galaxy2 = galaxy1;
                                            break;
                                        case 2:
                                            if (galaxy2 == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {

                                                System.out.println("1 - Добавить планету (по умолчанию)\n" +
                                                        "2 - Добавить случайную планету\n" +
                                                        "3 - Добавить планету через конструктор\n");
                                                int add = sc.nextInt();
                                                switch (add) {
                                                    case 1:
                                                        Planet planet = new Planet();
                                                        galaxy2.addPlanet(planet);
                                                        System.out.println("Планета по умолчанию создана");
                                                        break;
                                                    case 2:
                                                        galaxy2.addPlanet(Generator.generatePlanet());
                                                        System.out.println("Случайная планета добавлена");
                                                        break;
                                                    case 3:
                                                        System.out.println("Имя планеты");
                                                        String ti = sc.next();
                                                        System.out.println("Масса планеты");
                                                        int we = sc.nextInt();
                                                        System.out.println("Х координата");
                                                        int xx = sc.nextInt();
                                                        System.out.println("У координата");
                                                        int yy = sc.nextInt();
                                                        System.out.println("Z координата");
                                                        int zz = sc.nextInt();
                                                        galaxy2.addPlanet(new Planet(ti,we,xx,yy,zz));
                                                        break;
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (galaxy2 == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                System.out.println("Введите имя искомой планеты");
                                                String ser = sc.next();
                                                int res = galaxy2.searchPlanet(ser);
                                                if (res == -1) {
                                                    System.out.println("Планета не найдена");
                                                    break;
                                                }
                                                System.out.println("Индекс исомой планеты: " + res);
                                                break;
                                            }
                                        case 4:
                                            if (galaxy2 == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                System.out.println("Введите имя удаляемой планеты");
                                                String del = sc.next();
                                                boolean de = galaxy2.removePlanet(del);
                                                if (!de) {
                                                    System.out.println("Ошибка, такой планеты нет");
                                                    break;
                                                }
                                                System.out.println("Планета удалена");
                                                break;
                                            }
                                        case 5:
                                            if (galaxy2 == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                System.out.println("Список планет галактики:");
                                                System.out.println(galaxy2.getPlanets());
                                                break;
                                            }
                                        case 6:
                                            break label1;
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        label2:
                        {
                            while (true){




                            }
                        }
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
