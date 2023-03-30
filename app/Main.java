package app;
import model.Human;

public class Main {

    public static void main(String[] args) {
        Human<String> mainMother = new Human<String>("Main mom", "None", "None");
        Human<String> mainFather = new Human<String>("Main Dad", "None", "None");
        
        new Human<>("Child1", mainFather, mainMother); 
        new Human<>("Child2", mainFather, mainMother); 
        new Human<>("Child3", mainFather, mainMother); 
        Human<Human> rndChild = new Human<>("Child4", mainFather, mainMother); 

        new Human<>("Child Child1", rndChild, "None");
        print("213123123123");

    }
}
