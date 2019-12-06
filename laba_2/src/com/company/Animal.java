package com.company;

public class Animal {

    String food_type = "none";
    Integer daily_ration = 0;

    public Animal() {
        this.daily_ration = daily_ration;
        if (this instanceof Predator) {
            this.daily_ration = 20;
            this.food_type = "Meat";
        }
        if (this instanceof Omnivorous) {
            this.daily_ration = 30;
            this.food_type = "Feed";
        }
        if (this instanceof Herbivores) {
            this.daily_ration = 40;
            this.food_type = "Hay";
        }
    }

    public void print_animal() {
        if (this instanceof Predator)
            System.out.println("Type: Predator Name: " + ((Predator) this).animal_name +
                    " Food Type: " + food_type + " Ration: " + daily_ration);
        if (this instanceof Omnivorous)
            System.out.println("Type: Omnivorous Name: " + ((Omnivorous) this).animal_name +
                    " Food Type: " + food_type + " Ration: " + daily_ration);
        if (this instanceof Herbivores)
            System.out.println("Type: Herbivores Name: " + ((Herbivores) this).animal_name +
                    " Food Type: " + food_type + " Ration: " + daily_ration);
    }

    public void print_animal_name() {
        if (this instanceof Predator)
            System.out.println("Name: " + ((Predator) this).animal_name);
        if (this instanceof Omnivorous)
            System.out.println("Name: " + ((Omnivorous) this).animal_name);
        if (this instanceof Herbivores)
            System.out.println("Name: " + ((Herbivores) this).animal_name);
    }

    public void print_animal_type() {
        if (this instanceof Predator)
            System.out.println("Type: Predator");
        if (this instanceof Omnivorous)
            System.out.println("Type: Omnivorous");
        if (this instanceof Herbivores)
            System.out.println("Type: Herbivores");
    }
}
