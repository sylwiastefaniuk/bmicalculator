package pl.kodu.akademia.model;

public class Person {
    private int id;
    private double growth;
    private double weight;
    private String gender;
    private double bmi;



    public Person(int id, double growth, double weight, String gender, double bmi){
this.id = id;
this.growth = growth;
this.weight = weight;
this.gender = gender;
this.bmi = bmi;
}

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrowth() {
        return growth;
    }

    public void setGrowth(double growth) {
        this.growth = growth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getBmi() {
    return bmi;
    }

    public void setBmi(double bmi){
    this.bmi = bmi;
    }
}

