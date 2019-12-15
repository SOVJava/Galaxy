package program;

import model.Galaxy;
import model.Planet;
import model.Universe;
import util.Generator;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Galaxy galaxy2 = null;
        Universe universe = null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" ");
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
                                System.out.println(" ");
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
                                System.out.println(" ");
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
                                                System.out.println(" ");
                                                System.out.println("1 - Добавить планету (по умолчанию)\n" +
                                                        "2 - Добавить случайную планету\n" +
                                                        "3 - Добавить планету через конструктор\n");
                                                int add = sc.nextInt();
                                                if (add > 0 && add <= 3) {
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
                                                            galaxy2.addPlanet(new Planet(ti, we, xx, yy, zz));
                                                            break;
                                                    }
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
                                                } else {
                                                    System.out.println("Индекс исомой планеты: " + res);
                                                    break;
                                                }
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
                                                } else {
                                                    System.out.println("Планета удалена");
                                                    break;
                                                }
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
                            while (true) {
                                System.out.println(" ");
                                System.out.println("Панель управления вселенной:\n" +
                                        "1 - создать вселенную\n" +
                                        "2 - запуск генерации вселенной\n" +
                                        "3 - добавить галактику\n" +
                                        "4 - найти: \n" +
                                        "5 - список галактик во вселенной\n" +
                                        "6 - выход из меню вселенной");
                                int univ = sc.nextInt();
                                if (univ > 0 && univ <= 6) {
                                    switch (univ) {
                                        case 1:
                                            Universe universe2 = new Universe();
                                            System.out.println("Галактика создана");
                                            universe = universe2;
                                            break;
                                        case 2:
                                            if (universe == null) {
                                                System.out.println("Вселенной нет. Создайте вселеннуюю");
                                                break;
                                            } else {
                                                System.out.println("Генерация запущена");
                                                universe.behavior();
                                                break;
                                            }
                                        case 3:
                                            if (universe == null) {
                                            System.out.println("Вселенной нет. Создайте вселеннуюю");
                                            break;
                                        } else {
                                                System.out.println(" ");
                                                System.out.println("1 - добавить галактику(по умолчанию)\n" +
                                                        "2 - добавить сгенерированую галактику\n" +
                                                        "3 - добавить галактику через конструктор");
                                                int addG = sc.nextInt();
                                                if (addG > 0 && addG <= 3) {
                                                    switch (addG) {
                                                        case 1:
                                                            Galaxy galaxy3 = new Galaxy();
                                                            universe.addGalaxy(galaxy3);
                                                            System.out.println("Галактика по умолчанию добавлена");
                                                            break;
                                                        case 2:
                                                            universe.addGalaxy(Generator.generateGalaxy());
                                                            System.out.println("Сгенерированая галактика добавлена");
                                                            break;
                                                        case 3:
                                                            System.out.println("Введите имя создаваемой галактики: ");
                                                            String titleG = sc.next();
                                                            Galaxy galaxy4 = new Galaxy(titleG);
                                                            System.out.println("Галактика создана");
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 4:
                                            if (universe == null) {
                                                System.out.println("Вселенной нет. Создайте вселеннуюю");
                                                break;
                                            } else {
                                                System.out.println("1 - Поиск галактики\n" +
                                                        "2 - поиск планеты");
                                                int search = sc.nextInt();
                                                switch (search) {
                                                    case 1:
                                                        System.out.println("Введите имя галактики");
                                                        String titleGalaxy = sc.next();
                                                        int indGal = universe.searchGalaxy(titleGalaxy);
                                                        if (indGal == -1) {
                                                            System.out.println("Галактика не найдена");
                                                            break;
                                                        } else {
                                                            System.out.println("Найденная галактика имеет индекс: "
                                                                    + indGal);
                                                            break;
                                                        }
                                                    case 2:
                                                        System.out.println("Введите имя планеты");
                                                        String titlePlanet = sc.next();
                                                        int[] indPla = universe.searchPlanet(titlePlanet);
                                                        if (indPla == null) {
                                                            System.out.println("Планета не найдена");
                                                            break;
                                                        } else {
                                                            System.out.println("Найденная планета находится: " +
                                                                    Arrays.toString(indPla));
                                                            break;
                                                        }
                                                }
                                            }
                                            break;
                                        case 5:
                                            if (universe == null) {
                                                System.out.println("Вселенной нет. Создайте вселеннуюю");
                                                break;
                                            } else {
                                                for (int i = 0; i < universe.getGalaxies().size(); i++) {
                                                    System.out.println(universe.getGalaxies().get(i).getTitle());
                                                    for (int j = 0; j < universe.getGalaxies().get(i).getPlanets().
                                                            size(); j++) {
                                                        System.out.println(universe.getGalaxies().get(i).getPlanets().
                                                                get(j));
                                                    }
                                                }
                                            }
                                            break;
                                        case 6:
                                            break label2;
                                    }
                                }
                            }
                        }
                }
            } else {
                System.out.println("Неверный ввод. Перезапустите программу и попробуйте снова!");
            }
        }
    }
}
