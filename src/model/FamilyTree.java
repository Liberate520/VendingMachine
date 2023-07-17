package model;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import utils.PersonIterator;
import utils.PersonsComparatorByFirstName;
import utils.SerializableFileHandler;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T> {

    private List<T> persons;
    SerializableFileHandler fileHandler = new SerializableFileHandler("data.out");

    public FamilyTree() {
        this.persons = new ArrayList<>();
    }

    // add T to the tree
    public void addPerson(T T) {
        this.persons.add(T);
    }

    public List<T> getAllPersons() {
        return this.persons;
    }

    // find all matches by the first name
    public List<T> getPersonsByFirstName(String first_name) {
        List<T> res = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getFirstName().equals(first_name)) {
                res.add(persons.get(i));
                System.out.println("Found persons: " + persons.get(i));
            }
        }
        return res;
    }

    // find T by full name
    public T getPersonsByFullName(String first_name, String second_name, String father_name) {
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getFirstName().equals(first_name) && persons.get(i).getSecondName().equals(second_name)
                    && persons.get(i).getFatherName().equals(father_name)) {
                System.out.println("T is found " + persons.get(i));
                return persons.get(i);
            }
        }
        return null;
    }

    public void sortByName() {
        persons.sort(new PersonsComparatorByFirstName<T>());
    }

    @Override
    public Iterator<T> iterator() {
        return new PersonIterator<T>(persons);
    }

    public void writeData() {
        try {
            fileHandler.write(this);
        } catch (IOException e) {
            System.out.println("Faied to write a file");
        }
    }

    public void readData() {
        try {
            fileHandler.read();
        } catch (Exception e) {
            System.out.println("Faied to read a file");
        }
    }

}
