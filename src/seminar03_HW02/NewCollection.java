package seminar03_HW02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class NewCollection implements Iterable<Object> {

    public static List<Object> col;

    // TODO разобраться еще раз со static (static предложила IntelliJidea)

    public NewCollection(){
        col = new ArrayList<>();
    }

    public static List<Object> getCol() {
        return col;
    }

    public static void setCol(List<Object> col) {
        NewCollection.col = col;
    }


    static Collection addCollection(Object object) {
        col.add(object);
        return col;
    }


    @Override
    public Iterator<Object> iterator() {
        return new NewCollectionIterator(col);
    }
}
