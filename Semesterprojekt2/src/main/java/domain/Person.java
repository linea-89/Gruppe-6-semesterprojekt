package domain;

import java.util.ArrayList;

//toString-metoder for at sende information til databasen.

public abstract class Person {

    private String name;
    private String role;
    private ArrayList<Production> productions = new ArrayList<>();

    public Person(String name){
        this.name = name;
    }

    public Person(String name, String role){
        this.name = name;
        this.role = role;
    }

    public Person(String name, String role, Production production) {
        this.name = name;
        this.role = role;
        this.productions.add(production);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<Production> getProductions() {
        return productions;
    }

    public void addProduction(Production production){
        this.productions.add(production);
    }

    public void setProductions(ArrayList<Production> productions) {
        this.productions = productions;
    }

    //En rættighedsmetode for hver change
    public void changeProduction(){ if(this instanceof Producer || this instanceof Administrator){

        }
    }

    @Override
    public String toString() {
        return name + "," + role + "," + productions;
    }
}