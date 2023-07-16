package ui;

import java.util.Arrays;
import java.util.Scanner;

import model.Person;
import presenter.Presenter;

public class UIHandler {
    private Scanner scanner = new Scanner(System.in);
    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    // print menu of choices
    public String getMainMenu() {
        String textMenu = "Choose operation: \n " +
                "1. Add person \n " +
                "2. Show the full list of persons in the tree \n " +
                "3. Find persons by first name \n " +
                "4. Add child to person \n " +
                "5. Get children of person \n" +
                "6. Get parents of person \n" +
                "7. Write family tree to the file.out \n" +
                "8. Read file.out \n" +
                "9. Finish your work with tree";

        System.out.println(textMenu);
        System.out.println("Your choice is (enter the number): ");
        String choice = scanner.next();
        scanner.nextLine();
        return choice;
    }

    public String[] getName() {
        System.out.println("Write full name in order with space: 1) first name 2) second name 3)father name: ");
        String fullName = scanner.nextLine();
        String[] result = fullName.split(" ");
        return result;
    }

    // choose option
    public void startUserInteraction() {
        while (true) {
            String choice = getMainMenu();
            if (choice.equals("1")) {
                String[] result = getName();
                Person person = new Person(result[0], result[1], result[2]);
                this.presenter.addPerson(person);
            } else if (choice.equals("2")) {
                this.presenter.getAllPersons();
                System.out.println(Arrays.toString(this.presenter.getAllPersons().toArray()));
            } else if (choice.equals("3")) {
                System.out.println("Write first name to search in tree: ");
                String firstName = scanner.nextLine();
                this.presenter.getPersonsByFirstName(firstName);
            } else if (choice.equals("4")) {
                System.out.println("Add child to person");
                System.out.println(Arrays.toString(this.presenter.getAllPersons().toArray()));
                System.out.println("Who is child?");
                String[] childName = getName();
                Person child = this.presenter.getPersonsByFullName(childName[0], childName[1], childName[2]);
                if (child == null) {
                    child = new Person(childName[0], childName[1], childName[2]);
                    this.presenter.addPerson(child);
                }

                System.out.println("Who is parent?");
                String[] parentName = getName();

                Person parent = presenter.getPersonsByFullName(parentName[0], parentName[1], parentName[2]);
                if (parent == null) {
                    parent = new Person(parentName[0], parentName[1], parentName[2]);
                    presenter.addPerson(parent);
                }
                parent.addChild(child);
                child.addParent(parent);
            } else if (choice.equals("5")) {
                String[] parentName = getName();
                Person parent = presenter.getPersonsByFullName(parentName[0], parentName[1], parentName[2]);
                System.out.println("Children are: " + parent.getChildren());
            } else if (choice.equals("6")) {
                String[] childName = getName();
                Person child = presenter.getPersonsByFullName(childName[0], childName[1], childName[2]);
                System.out.println("Parents are: " + child.getParents());
            } else if (choice.equals("7")) {
                presenter.writeData();
            } else if (choice.equals("8")) {
                presenter.readData();
            } else if (choice.equals("9")) {
                System.out.println("End of work");
                break;
            }
        }
    }

}
