package seminar02_HW;

import java.util.ArrayList;

public class FamilyTree {
    List<FamilyCommunication> familyCommunicationList;

    public FamilyTree(){
        familyCommunicationList = new ArrayList<>();
    }

    public List<FamilyCommunication> getFamilyCommunicationList() {
        return familyCommunicationList;
    }



    public void addCommunication(FamilyCommunication familyCommunication) {
        familyCommunicationList.add(familyCommunication);
    }
}
