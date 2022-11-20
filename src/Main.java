//Реализовать, с учетом ооп подхода, приложение.
// Для проведения исследований с генеалогическим древом.
// Идея: описать некоторое количество компонент, например:

// модель человека
// компонента хранения связей и отношений между людьми: родитель, ребёнок - классика, но можно подумать и про отношение,
// брат, свекровь, сестра и т. д.

// компонент для проведения исследований
// дополнительные компоненты, например отвечающие за вывод данных в консоль, загрузку и сохранения в файл,
// получение\построение отдельных моделей человека
// Под “проведением исследования” можно понимать получение всех детей выбранного человека.

public class Main {
    public static void main(String[] args) {
        int id = 1;

        Human NikitaIvanov = new Human(id++, "Nikita", "Ivanov", Gender.man);

        Human IvanIvanov = new Human(id++, "Ivan", "Ivanov", Gender.man);
        Human IrinaIvanova = new Human(id++, "Irina", "Ivanova", Gender.woman);
        Human AlexeyKazanskiy = new Human(id++, "Alexey", "Kazanskiy", Gender.man);

        Human PetrIvanov = new Human(id++, "Petr", "Ivanov", Gender.man);
        Human MariaAndroonova = new Human(id++, "Maria", "Androonova", Gender.woman);
        Human KonstantinKazanskiy = new Human(id++, "Konstantin", "Kazanskiy", Gender.man);
        Human SvetlanaGagarina = new Human(id++, "Svetlana", "Gagarina", Gender.woman);


        NikitaIvanov.setFather(IvanIvanov);
        NikitaIvanov.setMother(IrinaIvanova);

        IvanIvanov.setFather(PetrIvanov);
        IvanIvanov.setMother(MariaAndroonova);
        IrinaIvanova.setFather(KonstantinKazanskiy);
        IrinaIvanova.setMother(SvetlanaGagarina);
        AlexeyKazanskiy.setFather(KonstantinKazanskiy);
        AlexeyKazanskiy.setMother(SvetlanaGagarina);


        //                        Nikita Ivanov
        //                  /                     \
        //         Ivan Ivanov                      Irina Ivanova     - Alexey Kazanskiy
        //         /          \                /                  \
        // PetrIvanov   MariaAndroonova   Konstantin Kazanskiy   Svetlana Gagarina


//        AlexeyKazanskiy.showBrothersSister();

        IrinaIvanova.showPartner();

        Human.showTreeChilds(SvetlanaGagarina);
        Human.showTreeParents(NikitaIvanov);

    }
}
