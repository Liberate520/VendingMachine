import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human IvanovII = new Human("Ivanov Ivan Ivanovich", LocalDate.of( 1979 , 1 , 10 ), Gender.Male, null, null);
        Human IvanovaMD = new Human("Ivanova Mary Dmitrievna", LocalDate.of( 1979 , 1 , 24 ), Gender.Female, null, null);
        Human ShamsAS = new Human("Shamsutdinova Alyona Sergeevna", LocalDate.of(2001, 04, 28), Gender.Female, IvanovII, IvanovaMD);
        Human ShamsSS = new Human("Shamsutdinov Sergey Salavatovich", LocalDate.of(2002, 04, 11), Gender.Male, IvanovII, null);
        Human ShamsES = new Human("Shamsutdinova Elizaveta Sergeevna", LocalDate.of(2020, 04, 28), Gender.Female, null, ShamsAS);
        Tree tree = new Tree();
        tree.addToTree(IvanovaMD);
        tree.addToTree(IvanovII);
        tree.addToTree(ShamsAS);
        tree.addToTree(ShamsES);
        tree.addToTree(ShamsSS);
        tree.OutOfListOfHuman();
        System.out.println();
        tree.ChildrenOfHuman(IvanovII);
        tree.ChildrenOfHuman(IvanovaMD);
    }
}
