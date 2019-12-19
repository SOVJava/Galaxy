package program;

import model.Galaxy;
import model.Planet;
import model.Universe;
import util.Generator;

import java.util.Arrays;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Planet planet = null;
        Galaxy galaxy = null;
        Universe universe = null;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("Вас приветствует Виртуальный помошник.\n" +
                    "Нажмите 1 чтоб войти в панель планет,\n" + "нажмите 2 чтоб войти в панель галактик,\n" +
                    "нажмите 3 для входа в панель вселенной.\nнажмите 4 для выхода из программы.\nВаш выбор: ");
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
                                        "4 - операции над планетой:\n" +
                                        "5 - выход из меню планеты");
                                int pl = sc.nextInt();
                                if (pl > 0 && pl <= 4) {
                                    switch (pl) {
                                        case 1:
                                            System.out.println("Планета без параметров: ");
                                            Planet planet1 = new Planet();
                                            System.out.println(planet1);
                                            planet=planet1;
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
                                            Planet planet3 = new Planet(plTitle, plWeight, plX, plY, plZ);
                                            System.out.println(planet3);
                                            break;
                                        case 4:
                                            System.out.println("1 - behavior\n" +
                                                    "2 - equals\n" +
                                                    "3 - назад");
                                            int operPl = sc.nextInt();
                                            if (operPl>0 && operPl<=3){
                                                switch (operPl){
                                                    case 1:
                                                        if (planet == null) {
                                                            System.out.println("Галактики нет. Создайте планету!");
                                                            break;
                                                        } else {
                                                            planet.behavior();
                                                            System.out.println(planet);
                                                            break;
                                                        }
                                                    case 2:
                                                        break;

                                                }
                                            }
                                            break;
                                        case 5:
                                            break label;
                                    }

                                }
                            }
                        }
                        break;
                    case 2:
                        label2:
                        {
                            while (true) {
                                System.out.println(" ");
                                System.out.println("1 - Создать галактику\n" +
                                        "2 - Добавить планету в галактику\n" +
                                        "3 - Найти планету\n" +
                                        "4 - Удалить планету\n" +
                                        "5 - behavior" +
                                        "6 - Список планет в галактике\n" +
                                        "7 - Выход из меню галактики\n");
                                int ga = sc.nextInt();
                                if (ga > 0 && ga <= 6) {
                                    switch (ga) {
                                        case 1:
                                            System.out.println("Введите имя Галактики");
                                            String titleG = sc.next();
                                            Galaxy galaxy1 = new Galaxy(titleG);
                                            System.out.println("Галактика создана!");
                                            galaxy = galaxy1;
                                            break;
                                        case 2:
                                            if (galaxy == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                System.out.println(" ");
                                                System.out.println("1 - Добавить планету (по умолчанию)\n" +
                                                        "2 - Добавить случайную планету\n" +
                                                        "3 - Добавить планету через конструктор\n" +
                                                        "4 - назад");
                                                int add = sc.nextInt();
                                                if (add > 0 && add <= 3) {
                                                    switch (add) {
                                                        case 1:
                                                            Planet planet2 = new Planet();
                                                            galaxy.addPlanet(planet2);
                                                            System.out.println("Планета по умолчанию создана");
                                                            break;
                                                        case 2:
                                                            galaxy.addPlanet(Generator.generatePlanet());
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
                                                            galaxy.addPlanet(new Planet(ti, we, xx, yy, zz));
                                                            break;
                                                        case 4:
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 3:
                                            if (galaxy == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                System.out.println("Введите имя искомой планеты");
                                                String ser = sc.next();
                                                int res = galaxy.searchPlanet(ser);
                                                if (res == -1) {
                                                    System.out.println("Планета не найдена");
                                                    break;
                                                } else {
                                                    System.out.println("Индекс исомой планеты: " + res);
                                                    break;
                                                }
                                            }
                                        case 4:
                                            if (galaxy == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                System.out.println("Введите имя удаляемой планеты");
                                                String del = sc.next();
                                                boolean de = galaxy.removePlanet(del);
                                                if (!de) {
                                                    System.out.println("Ошибка, такой планеты нет");
                                                    break;
                                                } else {
                                                    System.out.println("Планета удалена");
                                                    break;
                                                }
                                            }
                                        case 5:
                                            if (galaxy == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                galaxy.behavior();
                                                System.out.println("Behavior выполнен");
                                            }
                                        case 6:
                                            if (galaxy == null) {
                                                System.out.println("Галактики нет. Создайте галактику!");
                                                break;
                                            } else {
                                                System.out.println("Список планет галактики:");
                                                System.out.println(galaxy.getPlanets());
                                                break;
                                            }
                                        case 7:
                                            break label2;
                                    }
                                }
                            }
                        }
                        break;
                    case 3:
                        label3:
                        {
                            while (true) {
                                System.out.println(" ");
                                System.out.println("Панель управления вселенной:\n" +
                                        "1 - создать вселенную\n" +
                                        "2 - запуск генерации вселенной\n" +
                                        "3 - добавить галактику\n" +
                                        "4 - найти: \n" +
                                        "5 - удалить:\n" +
                                        "6 - список галактик во вселенной\n" +
                                        "7 - выход из меню вселенной");
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
                                                        "3 - добавить галактику через конструктор\n" +
                                                        "4 - назад");
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
                                                        case 4:
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
                                                        "2 - поиск планеты\n" +
                                                        "3 - назад");
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
                                                    case 3:
                                                        break;
                                                }
                                            }
                                            break;
                                        case 5:
                                            if (universe == null) {
                                            System.out.println("Вселенной нет. Создайте вселеннуюю");
                                            break;
                                        } else {
                                                System.out.println("1 - удаление галактики\n" +
                                                        "2 - удаление планеты");
                                                int search = sc.nextInt();
                                                switch (search) {
                                                    case 1:
                                                        System.out.println("Введите имя галактики:");
                                                        String titleGal = sc.next();
                                                        boolean gr = universe.removeGalaxy(titleGal);
                                                        if (!gr) {
                                                            System.out.println("Такой галактики нет");
                                                            break;
                                                        } else {
                                                            System.out.println("Галактика удалена");
                                                            break;
                                                        }
                                                    case 2:

                                                }

                                        }
                                        case 6:
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
                                        case 7:
                                            break label3;
                                    }
                                }
                            }
                        }
                        break;
                    case 4:
                        return;
                }
            } else {
                System.out.println("Неверный ввод. Перезапустите программу и попробуйте снова!");
            }
        }
    }
}
