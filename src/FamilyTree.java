import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Person> persons;

    public FamilyTree() {
        this.persons = new ArrayList<>();
    }

    // add person to the tree
    public void addPerson(Person person) {
        this.persons.add(person);
    }

    public List<Person> getAllPersons() {
        List<Person> res = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
        return res;
    }

    // find all matches by the first name
    public List<Person> getPersonsByFirstName(String first_name) {
        List<Person> res = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getFirstName().equals(first_name)) {
                res.add(persons.get(i));
                System.out.println("Found persons: " + persons.get(i));
            }
        }
        return res;
    }

    // find person by full name
    public Person getPersonsByFullName(String first_name, String second_name, String father_name) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getFirstName().equals(first_name) && persons.get(i).getSecondName().equals(second_name)
                    && persons.get(i).getFatherName().equals(father_name)) {
                System.out.println("Person is found " + persons.get(i));
                return persons.get(i);
            }
        }
        return null;
    }
}
