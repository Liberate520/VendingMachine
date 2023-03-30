import java.lang.reflect.Array;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Human h1 = new Human ("Иванов Иван Иванович", Gender.male, 1990);
        Human h2 = new Human ("Иванова Мария Ивановна", Gender.female, 1991);
        Human h3 = new Human ("Петрова Елена Владимировна", Gender.female,1992);
        Human h4 = new Human ("Иванов Петр Иванович", Gender.male, 2023 );
        Human h5 = new Human ("Петров Вадим Сергеевич",Gender.male, 1989);
        Human h6 = new Human ("Морозова Марина Андреевна",Gender.male, 2023 );
        Human h7 = new Human ("Петров  Александ Вадимович",Gender.male, 2013 );
        Human h8 = new Human ("Морозов Мартин Андреевич",Gender.male, 2022 );
        ArrayList<Human> humans = new ArrayList<Human>(Array.aList(h1,h2,h3,h4,h5,h6,h7,h8));


        FamilyTree familyTree = new FamilyTree();
        for (Human human : humans) {
            familyTree.addHuman(human);

        }
        System.out.println(familyTree);
        familyTree.printChildren();


    }

}