package seminar02_HW;

import java.awt.event.HierarchyBoundsAdapter;

/**
 * Переписываю заданию с учетом замечаний по 1 семинару
 *
 * Замечания ниже
 * 1. Вы можете использовать в качестве типов данных ваши собственные классы, это зачастую намного удобней,
 * например вы можете хранить ссылку на отца не в типе String, а в типе Human.
 * Так вы сможете легко получить отца и узнать более подробную информацию о нем при необходимости
 *
 * 2. Не стоит делать такие классы как сын и отец в данном проекте.
 * Ведь человек может быть одновременно и тем и другим и как тогда его описывать?
 * Поэтому рекомендую эти классы убрать, а в классе Human добавить поля для хранения родителей (обоих) и для хранения детей (List<Human>)
 *
 * 3. Стоит описать класс семейного дерева, который бы хранил список членов семьи.
 * Также описать в этом классе методы для работы с деревом,
 * например добавление новой записи или поиск человека по имени или вывод родственников определенного человека
 */

public class Program {
    public static void main(String[] args) {
        Family family = new Family();
        FamilyRepository familyRepository = new FamilyRepository(family);

        Human human1 = new Human("Александр", "Пелевин", "16.11.1989");
        familyRepository.addHuman(human1);

        Human human2 = new Human("Анна", "Пелевина", "08.10.1989");
        familyRepository.addHuman(human2);
        familyTreeRepository.addCommunication(human1, TypeOfCommunication.Husband);

        Human human3 = new Human("Федор", "Пелевин", "10.02.2015");
        familyRepository.addHuman(human3);
        familyTreeRepository.addCommunication(human1, TypeOfCommunication.Husband);


        }
}
