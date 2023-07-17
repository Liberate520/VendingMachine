import model.FamilyTree;
import model.Person;
import presenter.Presenter;
import ui.UIHandler;

public class Main {
    public static void runApplication() {
        UIHandler console = new UIHandler();
        FamilyTree<Person> familyTree = new FamilyTree<>();
        Presenter presenter = new Presenter(console, familyTree);

        presenter.startApp();
    }

    public static void main(String[] args) {
        runApplication();
    }
}
