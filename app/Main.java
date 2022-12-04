package app;
import java.util.ArrayList;
import java.util.List;

import model.Family;
import model.Father;
import model.Human;
import model.Mother;
import model.Child;

public class Main {

    public static void main(String[] args) {
        Family myFamily = new Family();
        myFamily.addHuman(new Father("Dad"));
        myFamily.addHuman(new Mother("Mom"));
        myFamily.addHuman(new Child("Child 1"));
        myFamily.addHuman(new Child("Child 2"));
        myFamily.addHuman(new Child("Child 3"));

        Human tmp = myFamily.findHuman("Mom");
        if(tmp instanceof Father){
            System.out.println(tmp.getName() + "\r\n" + myFamily.whatDo(tmp));
        }
        else if(tmp instanceof Mother){
            System.out.println(tmp.getName() + "\r\n" + myFamily.whatDo(tmp));
        }
        else if (tmp instanceof Child){
            System.out.println(tmp.getName() + "\r\n" + myFamily.whatDo(tmp));
        }
    }
}
