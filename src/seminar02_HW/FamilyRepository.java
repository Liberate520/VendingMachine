package seminar02_HW;

public class FamilyRepository {

    private Family family;
    private static int id;

    public FamilyRepository(Family family){
        id = 0;
        this.family = family;
    }

    public static int getId() {
        return id;
    }



    public void addHuman(){
        Human human = new Human(id++, Human human);
        family.addHuman(human);
    }
}
