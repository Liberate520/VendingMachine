package seminar01_HW;

import java.util.ArrayList;
import java.util.List;

/**
 * Выполнение домашнего задания 1 семинар по ООП
 * Попытка создания экземпляра класса Human
 */
public class Program {

    public static void main(String[] args) {
        List<Human> persons = new ArrayList<>();

        Human person1 = new Father("Alexander", "Pelevin", "16.11.1985", "Father");
        Human person2 = new Son("Fedor", "Pelevin", "10.02.2015", "Son");

        persons.add(person1);
        persons.add(person2);

        System.out.println(person1.toString());
        System.out.println(person2.toString());
    }
}
