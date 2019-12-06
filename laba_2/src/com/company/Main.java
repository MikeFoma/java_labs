/*Описать 4 класса (базовый и 3 потомка), описывающих некоторых хищных животных (один из потомков), всеядных (второй потомок) и травоядных (третий потомок). Определить в базовом классе абстрактный метод для расчета количества и типа пищи, необходимого для пропитания животного в зоопарке. Затем:
        Упорядочить всю последовательность животных по убыванию количества пищи. При совпадении значений – упорядочивать данные по алфавиту по имени. Вывести идентификатор животного, имя, тип и количество потребляемой пищи для всех элементов списка.
        Вывести первые 5 имен животных из полученного в пункте а) списка.
        Вывести последние 3 идентификатора животных из полученного в пункте а) списка.
        Организовать запись и чтение коллекции в/из файл.
        Организовать обработку некорректного формата входного файла.*/


        package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Sort_by_food implements Comparator<Animal>
{
    public String take_name(Animal animal)
    {
        if (animal instanceof Predator)
            return ((Predator) animal).animal_name;
        if (animal instanceof Omnivorous)
            return ((Omnivorous) animal).animal_name;
        return ((Herbivores) animal).animal_name;
    }
    // Used for sorting in ascending order of
    // roll number
    public int compare(Animal a, Animal b)
    {
        if(a.daily_ration != b.daily_ration)
            return a.daily_ration - b.daily_ration;

        return take_name(a).codePointAt(0) - take_name(b).codePointAt(0);
    }
}

public class Main
{

    public static void main(String[] args) {
        // write your code here

        

        ArrayList<Animal> animal_list = new ArrayList<Animal>();

        try (FileReader fr = new FileReader("animals_in.txt")) {
            animal_list = file_to_list(fr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        animal_list.add(new Predator("Wolf"));
        animal_list.add(new Omnivorous("Bear"));
        animal_list.add(new Herbivores("Horse"));
        animal_list.add(new Predator("Cheetah"));
        animal_list.add(new Predator("Lion"));
        animal_list.add(new Omnivorous("Raccoon"));

        //all list
        System.out.println();
        System.out.println("All list");
        for ( Animal animal : animal_list) {
            animal.print_animal();
        }

        //all list
        System.out.println();
        System.out.println("Sorted list");
        animal_list.sort(new Sort_by_food());
        for ( Animal animal : animal_list) {
            animal.print_animal();
        }

        //first five names
        System.out.println();
        System.out.println("First five names");
        for ( Animal animal : animal_list.subList(0, 5)) {
            animal.print_animal_name();
        }

        //last three type
        System.out.println();
        System.out.println("Last three type");
        for ( Animal animal : animal_list.subList(animal_list.size()-3, animal_list.size())) {
            animal.print_animal_type();
        }

        list_to_file("animals_out.txt", animal_list);
    }

    private static void list_to_file(String path, ArrayList<Animal> animal_list) {

        StringBuilder stringBuilder = new StringBuilder();
        for ( Animal animal : animal_list) {
            if (animal instanceof Predator)
                stringBuilder.append("Predator").append(" ").append(((Predator) animal).animal_name).append("\n");
            if (animal instanceof Omnivorous)
                stringBuilder.append("Omnivorous").append(" ").append(((Omnivorous) animal).animal_name).append("\n");
            if (animal instanceof Herbivores)
                stringBuilder.append("Herbivores").append(" ").append(((Herbivores) animal).animal_name).append("\n");
        }

        try (FileWriter fileWriter = new FileWriter(path)) {
            fileWriter.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Animal> file_to_list(FileReader fr) {
        ArrayList<Animal> animals_list = new ArrayList<Animal>();
        Scanner scanner = new Scanner(fr);

        while (scanner.hasNext()) {
            String[] animal = scanner.nextLine().split(" ");

            switch (animal[0]) {
                case "Predator": {
                    animals_list.add(new Predator(animal[1].toString()));
                    break;
                }
                case "Omnivorous": {
                    animals_list.add(new Omnivorous(animal[1].toString()));
                    break;
                }
                case "Herbivores": {
                    animals_list.add(new Herbivores(animal[1].toString()));
                    break;
                }

                default: {
                    throw new IllegalArgumentException("ERROR! BAD DATA!");
                }
            }
        }

        return animals_list;
    }
}
