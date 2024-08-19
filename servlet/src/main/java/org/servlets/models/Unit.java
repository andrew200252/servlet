package org.servlets.models;

public class Unit {
    private int id;
    private String name;
    private int parentId;
    private int population;
    private double area;
    private int foundation;

    public Unit(int id, String name, int parentId,
                int population, double area, int foundation) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.population = population;
        this.area = area;
        this.foundation = foundation;
    }

    public Unit() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }
}
