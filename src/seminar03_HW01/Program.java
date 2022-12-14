package seminar03_HW01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Создать метод, который принимает массив int и сортирует его по последней цифре.
 * Используйте метод Arrays.sort. для его работы создайте свой компаратор.
 * Имеется в виду последняя цифра в записи числа, например в числе 123, последння цифра 3.
 * Надо сделать сортировку, которая учитывает только эту последнюю цифру в числе.
 */


public class Program {
    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>();

        arr.add(53453);
        arr.add(756852);
        arr.add(3249);
        arr.add(234);

        Collections.sort(arr, new ComparatorLastDigit());

        System.out.println(arr.toString());
//
//
//        for (Integer element : arr) {
//            System.out.println(element);
//        }
    }
}