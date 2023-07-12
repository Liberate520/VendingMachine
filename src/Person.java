import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String first_name;
    private String second_name;
    private String father_name;
    private ArrayList<Person> parents;
    private ArrayList<Person> children;
    private Person in_marriage_with;

    public Person(String first_name, String second_name, String father_name) {

        this.first_name = first_name;
        this.second_name = second_name;
        this.father_name = father_name;
        this.in_marriage_with = null;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getFirstName() {
        return first_name;
    }

    public String getSecondName() {
        return second_name;
    }

    public String getFatherName() {
        return father_name;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public ArrayList<Person> getParents() {
        return parents;
    }

    public void addParent(Person parent) {
        parents.add(parent);
    }

    public void setParents(Person parent1, Person parent2) {
        parents.add(parent1);
        parents.add(parent2);
    }

    public Person getIn_marriage_with() {
        return in_marriage_with;
    }

    public void setIn_marriage_with(Person in_marriage_with) {
        this.in_marriage_with = in_marriage_with;
    }

    @Override
    public String toString() {
        return first_name.toString() + " " + second_name.toString() + " " + father_name.toString();
    }

}
