
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static FamilyTree familyTree = new FamilyTree();

    // print menu of choices
    public static String getMainMenu() {
        String textMenu = "Choose operation: \n " +
                "1. Add person \n " +
                "2. Show the full list of persons in the tree \n " +
                "3. Find persons by first name \n " +
                "4. Add child to person \n " +
                "5. Get children of person \n" +
                "6. Get parents of person \n" +
                "7. Write family tree to the file.txt \n" +
                "8. Read file.txt \n" +
                "9. Finish your work with tree";

        System.out.println(textMenu);
        System.out.println("Your choice is (enter the number): ");
        String choice = scanner.next();
        scanner.nextLine();
        return choice;
    }

    public static String[] getName() {
        System.out.println("Write full name in order with space: 1) first name 2) second name 3)father name: ");
        String fullName = scanner.nextLine();
        String[] result = fullName.split(" ");
        return result;
    }

    // choose option
    public static void startUserInteraction(SerializableFileHandler fileHandler) {
        while (true) {
            String choice = getMainMenu();
            if (choice.equals("1")) {
                String[] result = getName();
                Person person = new Person(result[0], result[1], result[2]);
                familyTree.addPerson(person);
            } else if (choice.equals("2")) {
                familyTree.getAllPersons();
            } else if (choice.equals("3")) {
                System.out.println("Write first name to search in tree: ");
                String firstName = scanner.nextLine();
                familyTree.getPersonsByFirstName(firstName);
            } else if (choice.equals("4")) {
                System.out.println("Add child to person");
                familyTree.getAllPersons();

                System.out.println("Who is child?");
                String[] childName = getName();

                Person child = familyTree.getPersonsByFullName(childName[0], childName[1], childName[2]);
                if (child == null) {
                    child = new Person(childName[0], childName[1], childName[2]);
                    familyTree.addPerson(child);
                }

                System.out.println("Who is parent?");
                String[] parentName = getName();

                Person parent = familyTree.getPersonsByFullName(parentName[0], parentName[1], parentName[2]);
                if (parent == null) {
                    parent = new Person(parentName[0], parentName[1], parentName[2]);
                    familyTree.addPerson(parent);
                }

                parent.addChild(child);
                child.addParent(parent);

                // return;
            } else if (choice.equals("5")) {
                String[] parentName = getName();
                Person parent = familyTree.getPersonsByFullName(parentName[0], parentName[1], parentName[2]);
                System.out.println("Children are: " + parent.getChildren());
            } else if (choice.equals("6")) {
                String[] childName = getName();
                Person child = familyTree.getPersonsByFullName(childName[0], childName[1], childName[2]);
                System.out.println("Parents are: " + child.getParents());
            } else if (choice.equals("7")) {
                try {
                    fileHandler.write(familyTree);
                } catch (IOException e) {
                    System.out.println("Faied to write a file");
                }
            } else if (choice.equals("8")) {
                try {
                    fileHandler.read();
                } catch (Exception e) {
                    System.out.println("Faied to read a file");
                }
            } else if (choice.equals("9")) {
                System.out.println("End of work");
                break;
            }
        }
    }

    public static void main(String[] args) {
        SerializableFileHandler fileHandler = new SerializableFileHandler("data.txt");

        familyTree.addPerson(new Person("Anton", "Antonov", "Antonovich"));
        familyTree.addPerson(new Person("Semen", "Antonov", "Antonovich"));
        familyTree.addPerson(new Person("Kirill", "Antonov", "Antonovich"));
        familyTree.addPerson(new Person("Ruslan", "Antonov", "Semenovich"));
        startUserInteraction(fileHandler);

        for (Person person : familyTree) {
            System.out.println(person);
        }

        System.out.println();

        familyTree.sortByName();
        for (Person person : familyTree) {
            System.out.println(person);
        }

        System.out.println();
    }
}
