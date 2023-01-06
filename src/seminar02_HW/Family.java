package seminar02_HW;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Family implements Iterable<Human> {

    public List<Human> humanList;

    public Family() {
        humanList = new ArrayList<>();
    }

    public List<Human> getHumanList() {
        return humanList;
    }


    public void addHuman(Human human) {
        humanList.add(human);
    }


    @Override
    public Iterator<Human> iterator() {
        return new FamilyIterator(getHumanList());
    }
}