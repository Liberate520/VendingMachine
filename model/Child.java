package model;

public class Child extends Human implements IJob {

    public Child(String name) {
        super(name);
    }

    @Override
    public String Job() {
        return "Ребенок делает уроки";
    }
    
}
