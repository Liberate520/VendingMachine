public class Main {
    public static void main(String[] args) {
        // объект — это экземпляр (конкретный Хуман) с собственным состоянием свойств из класса (переменные и методы) - атрибутами
        // создаем новый экземпляр Хумана
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Иван 1", "мужчина", null, null));
        tree.add(new Human("Мария 1", "женщина", null, null));
        tree.add(new Human("Иван 2", "мужчина", "Иван 1", "Мария 1"));
        tree.add(new Human("Юлия 1", "женщина", "Иван 1", "Мария 1"));
        tree.add(new Human("Егор 1", "мужчина", "Иван 1", "Мария 1"));





        System.out.println(tree.getName());
    }    
}
