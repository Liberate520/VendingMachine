package seminar02_HW;

import java.util.ArrayList;
import java.util.List;


public class FamilyCommunication {

    private Human human;
    private TypeOfCommunication typeOfCommunication;

    public FamilyCommunication(Human human, TypeOfCommunication typeOfCommunication) {
        this.human = human;
        this.typeOfCommunication = typeOfCommunication;
    }

    public Human getHuman() {
        return human;
    }

    public TypeOfCommunication getTypeOfCommunication() {
        return typeOfCommunication;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public void setTypeOfCommunication(TypeOfCommunication typeOfCommunication) {
        this.typeOfCommunication = typeOfCommunication;
    }
}