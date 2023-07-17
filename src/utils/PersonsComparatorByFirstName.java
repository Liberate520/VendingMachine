package utils;
import java.util.Comparator;

import model.Person;

public class PersonsComparatorByFirstName<T extends Person> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
