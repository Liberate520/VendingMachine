package seminar02_HW;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator implements Iterator<Human> {
        int index;
        private List<Human> humanList;

    public FamilyIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
