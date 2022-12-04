package model;

public class Mother extends Human implements IJob {

    public Mother(String name) {
        super(name);
    }



    @Override
    public String Job() {
        return "Мама готовит ужин";
    }
    
}
