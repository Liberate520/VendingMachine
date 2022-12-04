package model;

public class Father extends Human implements IJob {

    public Father(String name) {
        super(name);
    }

    @Override
    public String Job() {
        return "Папа работает.";
    }
    
}
