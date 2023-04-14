import java.time.LocalDate;
import java.time.Period;

public class Human {
    private Gender gender;
    private String name;
    private LocalDate birthday;
    private Human father;
    private Human mother;
    private Integer generate;


    public Human(String name, LocalDate birthday, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.generate = Math.max((father == null)? 0: father.generate, (mother == null)? 0: mother.generate) + 1;
    }

    @Override
    public String toString() {
        String father;
        String mother;
        if (this.father == null) father = "not found";
        else father = this.father.name;
        if (this.mother == null) mother = "not found";
        else mother = this.mother.name;
        return name + " Gender: " + gender + " Age: " + ageOfHuman() + "\n\t\tFather: " + father + "\n\t\tMother: " + mother + "";
        //return String.join(" ", name, birthday.toString(), father, mother);
    }

    public Integer getGenerate() {
        return generate;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public String getName() {
        return name;
    }

    public int ageOfHuman() {
        return Period.between(this.birthday, LocalDate.now()).getYears();
    }
}
