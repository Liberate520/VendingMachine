import java.util.Iterator;
import java.util.List;

public class PersonIterator<T extends Person> implements Iterator<T> {

    private int index;
    private List<T> persons;

    public PersonIterator(List<T> persons2) {
        this.persons = persons2;
    }

    @Override
    public boolean hasNext() {
        return persons.size() > index;
    }

    @Override
    public T next() {
        return persons.get(index++);
    }
}
