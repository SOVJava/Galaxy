package model;

import com.google.gson.Gson;
import util.Generator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class Universe{

    private String title;
    private ArrayList<Galaxy> galaxies = new ArrayList<>();

    public Universe() {
        this.title = "";
    }

    public Universe(String title) {
        this.title = title;
    }

    public Universe(String title, Galaxy galaxies) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public ArrayList<Galaxy> getGalaxies() {
        return new ArrayList<>(galaxies);
    }

    public void addGalaxy(Galaxy galaxy){
        this.galaxies.add(galaxy);
    }

    public int searchGalaxy(Galaxy galaxy) {
        for (int i = 0; i < galaxies.size(); i++) {
            if (galaxy.equals(galaxies.get(i)))
                return i;
        }
        return -1;
    }

    public int searchGalaxy(String title){
        for (int i = 0; i <galaxies.size() ; i++) {
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

    public int[] searchPlanet(String title){
        for (int i = 0; i < galaxies.size(); i++) {
            int j = galaxies.get(i).searchPlanet(title);
            if (j!=-1)
                return new int[]{i,j};
        }
        return null;
    }

    public boolean removeGalaxy (String title){
        int x = searchGalaxy(title);
        if (x==-1)
            return false;
        return galaxies.remove(x) != null;
    }

    public void behavior(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (int i = 0; i < ((int)(5 + Math.random()*(6))); i++) {
                    addGalaxy(Generator.generateGalaxy());
                }
            }
        }, 0, 30 * 1000);
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
