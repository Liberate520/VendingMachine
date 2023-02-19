import java.util.ArrayList;
import java.util.Date;

// класс ("чертеж" Хумана) - описание того, какими свойствами и поведением (переменные и функции=методы) будет обладать объект
public class Human {
    // объявление полей (переменные)
    private String name;
    private String gender;
    private Date dateBorn;
    private Date dateDeath;
    private Human father;
    private Human mother;
    private List<Human> children;


    // метод конструктор
    public Human(String name, String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    // метод выдачи имени
    public void getName() {
        return name;
    }





    public void setName(String name) {
        // обращение к собственному атрибуту через this
        this.name = name;
    }
}
