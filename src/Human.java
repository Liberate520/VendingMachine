import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Human {
    int id;
    String firstName;
    String lastName;
    Gender gender;

    private Human father;
    private Human mother;
    List<Human> childs;

    public Human(int id, String firstName, String lastName, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.childs = new ArrayList<>();
    }
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
            showChilds(child, "");
        }
        System.out.println("------");
    }

    static public void showChilds(Human human, String spaces) {
        if (human == null) {
            return;
        }
        System.out.printf("%s %s %s\n", spaces, human.firstName, human.lastName);
        spaces += "  ";
        for (Human child : human.childs) {
            showChilds(child, spaces);
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

    public void showBrothersSister() {
        HashSet<Human> result = new HashSet<>();
        if (this.father != null && this.mother != null) {
            result.addAll(this.father.childs);
            result.addAll(this.mother.childs);
            result.remove(this);
        }
        if (result.size() < 1) {
            System.out.printf("У %s %s нет братьев или сестер", this.firstName, this.lastName);
        } else {
            System.out.println(result);
        }
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s %s, gender: %s", this.id, this.firstName, this.lastName, this.gender);
    }

    @Override
    public boolean equals(Object human) {
        return this.id == ((Human) human).id;
    }

    public void showPartner() {
        Human child = null;
        if (this.childs.size() > 0) {
            child = this.childs.get(0);
        }

        if (this.gender == Gender.man && child != null) {
            System.out.printf("Супругой %s %s является %s %s\n", this.firstName, this.lastName, child.mother.firstName, child.mother.lastName);
        } else if (this.gender == Gender.woman && child != null) {
            System.out.printf("Супругом %s %s является %s %s\n", this.firstName, this.lastName, child.father.firstName, child.father.lastName);
        } else {
            System.out.printf("У %s %s нет партнера\n", this.firstName, this.lastName);
        }
    }
}
