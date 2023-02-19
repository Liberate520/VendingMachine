public class Main {
    public static void main(String[] args) {
        // объект — это экземпляр (конкретный Хуман) с собственным состоянием свойств из класса (переменные и методы) - атрибутами
        // создаем новый экземпляр Хумана
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Иван 1", "мужчина", null, null));
        tree.add(new Human("Мария 1", "женщина", null, null));
        tree.add(new Human("Иван 2", "мужчина", tree.getByName("Иван 1"), tree.getByName("Мария 1")));
        tree.add(new Human("Юлия 1", "женщина", tree.getByName("Иван 1"), tree.getByName("Мария 1")));
        tree.add(new Human("Егор 1", "мужчина", tree.getByName("Иван 1"), tree.getByName("Мария 1")));
        tree.add(new Human("Елизавета 1", "женщина", null, null));
        tree.add(new Human("Иван 3", "мужчина", tree.getByName("Иван 2"), tree.getByName("Елизавета 1")));





        System.out.println(tree);
        System.out.println("+++++++++");

        System.out.println(tree.getInfoTree());
        System.out.println("+++++++++");
        
        System.out.println(tree.getByName("Иван 1"));
        System.out.println("+++++++++");

        System.out.println(tree.getByGender("мужской"));

    }    
}
