import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractPerson {
    private static int count;
    protected final int id;
    protected String firstName;
    protected Gender gender;

    protected AbstractPerson father;
    protected AbstractPerson mother;
    protected List<AbstractPerson> children;

    static {
        count = 1;
    }

    public AbstractPerson(String firstName, Gender gender) {
        this.id = count++;
        this.setFirstName(firstName);
        this.setGender(gender);
        this.initChildren();
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void initChildren() {
        this.children = new ArrayList<>();
    }
    public void addChild(AbstractPerson child) {
        this.children.add(child);
    }
    public void setFather(AbstractPerson father) {
        if (father.gender == Gender.man) {
            this.father = father;
            this.father.addChild(this);
        } else {
            System.out.println("Введено некорректное значение");
        }
    }

    public void setMother(AbstractPerson mother) {
        if (mother.gender == Gender.woman) {
            this.mother = mother;
            this.mother.addChild(this);
        } else {
            System.out.println("Введено некорректное значение");
        }
    }
    public int getId() { return this.id; }
    public Gender getGender() {
        return this.gender;
    }
    public List<AbstractPerson> getChildren() {
        if (this.children.size() == 0) {
            return null;
        }
        return this.children;
    }
    public void showChilds() {
        List<AbstractPerson> children = this.getChildren();
        if (children == null) {
//            System.out.printf("У %s, нет детей\n", this.firstName);
            System.out.printf("У %s нет детей\n", this);
        } else {
            System.out.printf("Дети %s:\n", this);
            for (AbstractPerson child : children) {
//                System.out.printf("%s %s %s\n", child.firstName, child.lastName, child.gender);
                System.out.println(child);
            }
            System.out.print("-------\n");
        }
    }
    public AbstractPerson getFather() {
        return this.father;
    }

    public AbstractPerson getMother() {
        return this.mother;
    }

    public List<AbstractPerson> getParents() {
        List<AbstractPerson> result = new ArrayList<>();
        AbstractPerson father = this.getFather();
        AbstractPerson mother = this.getMother();
        if (father != null) {
            result.add(father);
        }
        if (mother != null) {
            result.add(mother);
        }
        if (father == null && mother == null) {
            result = null;
        }
        return result;
    }
    public void showParents() {
        List<AbstractPerson> parents = this.getParents();
        if (parents == null) {
            System.out.printf("Родители %s %s  неизвестны\n", this.firstName, this.lastName);
        } else {
            System.out.printf("Родители %s %s: \n", this.firstName, this.lastName);
            for (AbstractPerson parent : parents) {
                System.out.printf("%s %s %s\n", parent.firstName, parent.lastName, parent.gender);
            }
            System.out.printf("------\n");
        }
    }

    public AbstractPerson getSpouse() {
        if (this.getChilds() == null) {
            return null;
        }

        AbstractPerson child = this.getChilds().get(0);
        if (this.getGender() == Gender.man) {
            return child.getMother();
        }
        if (this.getGender() == Gender.woman) {
            return child.getFather();
        }
        return null;
    }

    public void showSpouse() {
        AbstractPerson spouse = this.getSpouse();
        if (spouse == null) {
            System.out.printf("У %s %s нет супруги / супруга\n", this.firstName, this.lastName);
            return;
        }

        if (this.gender == Gender.man) {
            System.out.printf("Супругой %s %s является %s %s\n", this.firstName, this.lastName, spouse.firstName, spouse.lastName);
        } else if (this.gender == Gender.woman) {
            System.out.printf("Супругом %s %s является %s %s\n", this.firstName, this.lastName, spouse.firstName, spouse.lastName);
        }
    }
    public HashSet<AbstractPerson> getSiblings(Gender gender) {
        HashSet<AbstractPerson> result = new HashSet<>();
        AbstractPerson father = this.getFather();
        AbstractPerson mother = this.getMother();
        result.addAll(father.getChilds());
        result.addAll(mother.getChilds());
        result.remove(this);
        result.removeIf(human -> human.getGender() != gender);

        if (result.size() < 1) {
            return null;
        }
        return result;
    }
    public void showSiblibgs(Gender gender) {
        HashSet<AbstractPerson> result = this.getSiblings(gender);
        if (result == null) {
            System.out.printf("У %s %s нет братьев / сестер", this.firstName, this.lastName);
            return;
        }

        System.out.printf("Братья / сестры %s %s: \n", this.firstName, this.lastName);
        for (AbstractPerson human : result ) {
            System.out.printf("%s %s %s\n", human.firstName, human.lastName, human.gender);
        }
        System.out.printf("------\n");
    }

    public void showTreeParents() {
        if (this.getParents() == null) {
            System.out.printf("Предки %s %s неизвестны\n",this.firstName, this.lastName);
            return;
        }
        System.out.print("Все предки");
        this.generateTreeParents(this, "");
        System.out.println("------");
    }
    private void generateTreeParents(AbstractPerson human, String spaces) {
        if (human == null) {
            return;
        }
        System.out.printf("%s %s %s\n", spaces, human.firstName, human.lastName);
        spaces += "  ";
        generateTreeParents(human.father, spaces);
        generateTreeParents(human.mother, spaces);
    }
    public void showTreeDescendants() {
        if (this.getChilds() == null) {
            System.out.printf("Потомки %s %s неизвестны\n",this.firstName, this.lastName);
            return;
        }
        System.out.printf("Все потомки");
        this.generateTreeDescendants(this, "");
        System.out.println("------");
    }
    private void generateTreeDescendants(AbstractPerson human, String spaces) {
        if (human == null) {
            return;
        }
        System.out.printf("%s %s %s\n", spaces, human.firstName, human.lastName);
        spaces += "  ";
        for (AbstractPerson child : human.childs) {
            generateTreeDescendants(child, spaces);
        }

    }
    public HashSet<AbstractPerson> getUnclesAunts(Gender gender) {
        HashSet<AbstractPerson> result = new HashSet<>();
        HashSet<AbstractPerson> motherBrothersSisters = this.getMother().getSiblings(gender);
        HashSet<AbstractPerson> fatherBrothersSisters = this.getFather().getSiblings(gender);

        if (motherBrothersSisters != null) {
            result.addAll(motherBrothersSisters);
        }
        if (fatherBrothersSisters != null) {
            result.addAll(fatherBrothersSisters);
        }

        if (result.size() < 1) {
            return null;
        }
        return result;
    }
    public void showUnclesAunts(Gender gender) {
        HashSet<AbstractPerson> unclesAunts = this.getUnclesAunts(gender);
        if (unclesAunts.size() < 1) {
            System.out.printf("У %s %s нет дяди / тети\n", this.firstName, this.lastName);
            return;
        }
        System.out.printf("Дяди / тети %s %s:\n", this.firstName, this.lastName);
        for (AbstractPerson uncleAunt : unclesAunts) {
            System.out.printf("%s %s %s\n", uncleAunt.firstName, uncleAunt.lastName, uncleAunt.gender);
        }
        System.out.println("-------");
    }
    @Override
    public String toString() {
        return String.format("id: %d, name: %s %s, gender: %s", this.id, this.firstName, this.lastName, this.gender);
    }
    @Override
    public boolean equals(Object human) {
        return this.id == ((AbstractPerson) human).id;
    }
}
