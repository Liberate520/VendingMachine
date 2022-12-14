package seminar03_HW01;

import java.util.Comparator;

public class ComparatorLastDigit implements Comparator<Integer> {

    @Override
    public int compare(Integer i, Integer j) {
        if (i % 10 > j % 10)
            return 1;
        else if (i % 10 < j % 10)
            return -1;
        else return 0;
      }
}
