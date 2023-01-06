package seminar02_HW;

public class FamilyTreeRepository {
    private FamilyCommunication;
    private static int id;

    public FamilyTreeRepository (FamilyCommunication familyCommunication){
        id = 0;
        this.familyCommunication = familyCommunication;
    }



    public void addCommunication(Human human, TypeOfCommunication typeOfCommunication) {
        addCommunication(new FamilyCommunication(human, typeOfCommunication));
        // TODO Если устанавливается связь муж - жена, то установить (хотя бы попробовать и обратную связь жена - муж в автомате???
    }
}
