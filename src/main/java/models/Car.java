package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "my_Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "model_brand")
    private String model;
    @Enumerated(EnumType.STRING)
    private Type type;
    private int power;
    private double price;
    private int year;


    public Car(String model, Type type, int power, double price, int year) {
        this.model = model;
        this.type = type;
        this.power = power;
        this.price = price;
        this.year = year;
    }
}
//Створити клас Car з полями:
//id
//        model,
//Type (ENUM)
//power,
//price,
//year.