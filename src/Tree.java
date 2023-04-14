import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<Human> tree;

    public Tree() {
        this.tree = new ArrayList<>();
    }

    public void addToTree(Human newHuman) {
        if (!tree.contains(newHuman)) {
            tree.add(newHuman);
        }
    }

    public List<Human> getHumansInCertainGenerate(int generate) {
        List<Human> generateOfHuman = new ArrayList<>();
        for (Human human : tree) {
            if (generate == human.getGenerate()) {
                if (!generateOfHuman.contains(human)) {
                    generateOfHuman.add(human);
                }
            }
        }
        return generateOfHuman;
    }

    public int maxGenerate() {
        int maxOfGenerate = 0;
        for (Human human : tree) {
            if (maxOfGenerate < human.getGenerate()) {
                maxOfGenerate = human.getGenerate();
            }
        }
        return maxOfGenerate;
    }

    public void OutOfCertainGenerateOfHuman(int generate) {
        for (Human human : getHumansInCertainGenerate(generate)) {
            System.out.println(human.toString());
        }
    }

    public void OutOfListOfHuman() {
        for (int i = maxGenerate(); i >= 1; i--) {
            System.out.println("\nNUMBER OF GENERATE " + i);
            OutOfCertainGenerateOfHuman(i);
        }
    }
    public void ChildrenOfHuman(Human parent){
        System.out.printf("Children of %s\n", parent.getName());
        for (Human human : tree) {
            if (human.getFather() == parent | human.getMother() == parent){
                System.out.println("\t" + human.toString());
            }
        }
    }
}
