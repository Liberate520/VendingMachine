import java.util.ArrayList;
import java.util.List;

public class Human {
    int id;
    String firstName;
    String lastName;
    Gender gender;

//    Human partner; // супруг, супруга
    private Human father; // папа
    private Human mother; // мама
    List<Human> childs; // дети

    public Human(int id, String firstName, String lastName, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.childs = new ArrayList<>();
    }

//    public void linkPartner(Human partner) {
//        this.partner = partner;
//        this.partner.partner = this;
//    }

//    public void linkChild(Human child) {
//        child.father = this;
//        child.mother = this.partner;
//        this.childs.add(child);
//        this.partner.childs.add(child);
//    }

    public void setFather(Human father) {
        if (father.gender == Gender.man) {
            this.father = father;
            this.father.childs.add(this);
        } else {
            System.out.println("Введено некорректное значение");
        }
    }

    public void setMother(Human mother) {
        if (mother.gender == Gender.woman) {
            this.mother = mother;
            this.mother.childs.add(this);
        } else {
            System.out.println("Введено некорректное значение");
        }
    }

    static public void showTreeChilds(Human human) {
        System.out.printf("Потомки %s %s\n",human.firstName, human.lastName);
        for (Human child : human.childs) {
            treeChilds(child, "");
        }
        System.out.println("------");
    }

    static private void treeChilds(Human root, String spaces) {
        if (root == null) {
            return;
        }
        System.out.printf("%s %s %s\n", spaces, root.firstName, root.lastName);
        spaces += "  ";
        for (Human child : root.childs) {
            treeChilds(child, spaces);
        }
    }

    static public void showTreeParents(Human human) {
        System.out.printf("Предки %s %s\n",human.firstName, human.lastName);
        treeParents(human.father, "");
        treeParents(human.mother, "");
        System.out.println("------");
    }

    static private void treeParents(Human human, String spaces) {
        if (human == null) {
            return;
        }
        System.out.printf("%s %s %s\n", spaces, human.firstName, human.lastName);
        spaces += "  ";
        treeParents(human.father, spaces);
        treeParents(human.mother, spaces);

    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s %s, gender: %s", this.id, this.firstName, this.lastName, this.gender);
    }

//    public void showPartner() {
//        if (this.partner == null) {
//            System.out.printf("У %s %s нет супруга/супруги\n", this.firstName, this.lastName);
//        } else {
//            System.out.printf("У %s %s супруг / супрга – %s %s\n", this.firstName, this.lastName, this.partner.firstName, this.partner.lastName);
//        }
//    }
    public void showChilds() {
        if (childs.size() == 0) {
            System.out.printf("У %s %s нет детей\n", this.firstName, this.lastName);
        } else {
            System.out.println("------");
            System.out.printf("Дети %s %s\n", this.firstName, this.lastName);
            for (Human child : childs) {
                System.out.println(child);
            }
            System.out.println("------");
        }
    }
}
