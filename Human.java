import java.util.ArrayList;
import java.util.List;

public class Human {
    Human gender;
    Human father;
    Human mother;
    List<Human> children;
    String fullName;
    int birthYear;

    public Human(Human gender, Human father, Human mother, String fullName, int birthYear) {
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<Human>();
        this.fullName = fullName;
        this.birthYear = birthYear;

        
    }

    @Override
    public String toString() {
        return String.format("Full name : %s %d\n", this.fullName, this.birthYear);
    }

    public Human getFather(){
        return father;

    }
    public Human getMother(){
        return mother;

    }
    public List<Human> getChildren(){
        return children;

    }
    public Human getGender() {
        return gender;
    }
    public String getFullName(){
        return fullName;
    }
    public int getBirthYear(){
        return birthYear;
    }

}