package com.example.litearula.models;

public class Author {
    private String name;
    private int birthYear;
    private int deathYear;

    public Author(String name, int birthYear, int deathYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public Author() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public String toString() {
        return "nameAuthor= '" + name + '\'' +
               ", birthYear= " + birthYear +
               ", deathYear= " + deathYear;
    }
}
