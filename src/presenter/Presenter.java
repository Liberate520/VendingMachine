package presenter;

import java.util.List;

import model.FamilyTree;
import model.Person;
import ui.UIHandler;

public class Presenter {
    UIHandler view;
    FamilyTree<Person> model;
    // SerializableFileHandler fileHandler = new
    // SerializableFileHandler("data.out");

    public Presenter(UIHandler view, FamilyTree<Person> model) {
        this.view = view;
        this.model = model;
        this.view.setPresenter(this);
    }

    public void startApp() {
        System.out.println("startApp function");
        this.model.addPerson(new Person("Anton", "Antonov", "Antonovich"));
        this.model.addPerson(new Person("Semen", "Antonov", "Antonovich"));
        this.model.addPerson(new Person("Kirill", "Antonov", "Antonovich"));
        this.model.addPerson(new Person("Ruslan", "Antonov", "Semenovich"));

        this.view.startUserInteraction();
    }

    public void addPerson(Person person) {
        this.model.addPerson(person);
    }

    public List<Person> getAllPersons() {
        return this.model.getAllPersons();
    }

    public List<Person> getPersonsByFirstName(String firstName) {
        return this.model.getPersonsByFirstName(firstName);
    }

    public Person getPersonsByFullName(String first_name, String second_name, String father_name) {
        return this.model.getPersonsByFullName(first_name, second_name, father_name);
    }

    public void writeData() {
        this.model.writeData();
    }

    public void readData() {
        this.model.readData();
    }

}
