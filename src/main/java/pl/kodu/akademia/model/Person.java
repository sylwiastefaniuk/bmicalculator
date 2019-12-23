package pl.kodu.akademia.model;

import javax.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private double growth;
    private double weight;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Sex sex;
    private double bmi;

    public Person(int id, double growth, double weight, Sex sex, double bmi) {
        this.id = id;
        this.growth = growth;
        this.weight = weight;
        this.sex = sex;
        this.bmi = bmi;
    }

    public Person(){
}

    public int getId() {
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}

