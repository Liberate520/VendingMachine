package model;

import java.util.ArrayList;
import java.util.List;

public class Family {
    List<Human> humans;

    public Family(){
        humans = new ArrayList<>();
        addHuman(new Father("dad"));
    }

    public void addHuman(Human tmp){
        humans.add(tmp);
    }

    public Human findHuman(String name){
        for (int i = 0; i < humans.size(); i++) {
            if(humans.get(i).name == name){
                return humans.get(i);
            }
        }
        return null;
    }
    public String whatDo(Human myHuman){
        if(myHuman instanceof Father){
            return ((Father)myHuman).Job();
        }
        else if(myHuman instanceof Mother){
            return ((Mother)myHuman).Job();
        }
        else if (myHuman instanceof Child){
            return((Child)myHuman).Job();
        }
        return null;
    }
}
