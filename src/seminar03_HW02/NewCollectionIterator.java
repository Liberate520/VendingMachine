package seminar03_HW02;

import java.util.Iterator;
import java.util.List;

public class NewCollectionIterator implements Iterator<Object>{
    int index;
    private List<Object> objectList;

    public NewCollectionIterator(List<Object> objectList) {
        this.objectList = objectList;
        }


        @Override
        public boolean hasNext() {
            return index < objectList.size();
        }

        @Override
        public Object next() {
            return objectList.get(index++);
    }
}
