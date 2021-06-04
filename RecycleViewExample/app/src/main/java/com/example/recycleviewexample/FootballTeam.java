package com.example.recycleviewexample;

public class FootballTeam {
    String Name,Leage;
    int Year;

    public FootballTeam() {
    }

    public FootballTeam(String name, String leage, int year) {
        Name = name;
        Leage = leage;
        Year = year;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLeage() {
        return Leage;
    }

    public void setLeage(String leage) {
        Leage = leage;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }
}
