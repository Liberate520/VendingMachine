import java.util.Objects;

public class FamilyTree { // Программа для поиска потомка

    static int N = 10; // Максимальное количество детей

    static class Node
    {
        String val;
        Node[] child = new Node[N];

        Node(String Pip)
        {
            val = Pip;
            for (int i = 0; i < N; i++)
                child[i] = null;
        }
    }

    static void printChild(Node root, String Pip, int chain) // Обход заданного дерева до указанного значения
    {
        // Если Pip текущий корень
        if (Objects.equals(root.val, String.valueOf(Pip)))
        {
            if (root.child[chain - 1] == null)
                System.out.print("Ошибка: Данных не существует\n");
            else
                System.out.print(root.child[chain - 1].val + "\n");
        }

        // Если Pip лежит в поддереве
        for (int i = 0; i < N; i++)
            if (root.child[i] != null)
                printChild(root.child[i], Pip, chain);
    }

    public static void main(String[] args)
    {
        Node root = new Node("Андрей");
        root.child[0] = new Node("Виктор");
        root.child[1] = new Node("Светлана");
        root.child[2] = new Node("Дмитрий");
        root.child[3] = new Node("Евгения");
        root.child[0].child[0] = new Node("Федор");
        root.child[0].child[1] = new Node("Георгий");
        root.child[2].child[0] = new Node("Наталья");
        root.child[0].child[0].child[0] = new Node("Игорь");
        root.child[0].child[0].child[1] = new Node("Юлия");
        root.child[0].child[0].child[2] = new Node("Кирилл");
        root.child[2].child[0].child[0] = new Node("Любовь");
        root.child[2].child[0].child[1] = new Node("Мария");

        String Pip = "Федор";
        System.out.print("Второй ребёнок Федора: ");
        printChild(root, Pip, 2);

        Pip = "Андрей";
        System.out.print("Третий ребёнок Андрея: ");
        printChild(root, Pip, 3);

        Pip = "Андрей";
        System.out.println("Седьмой ребенок Андрея: ");
        printChild(root, Pip, 7);
    }
}