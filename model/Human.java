package model;

import java.util.ArrayList;
import java.util.List;

public class Human<E> implements Ijob{

    private E father; 
    private E mother;
    public List<Human> children;
    public String name;
    private String job;

    public Human(String name, E father, E mother){
        this.children = new ArrayList<Human>();
        this.name = name;
        this.father = father;
        this.mother = mother;
        
        if(father instanceof Human){
            ((Human) father).AddChild(this);
        }
        if(mother instanceof Human){
            ((Human) mother).AddChild(this);
        }
        //SetParents(father, mother);
    }

    public void SetJob(String job){
        this.job = job;
    }

    private void SetParents(E father, E mother){
        
    }

    public List<Human> GetAllChild(){
        return children;
    }

    public Human GetOneChild(int index){
        if(index < children.size()){
            return children.get(index);
        }
        else return null;
    }

    private void AddChild(Human child){
        children.add(child);
    }

    @Override
    public String WhatDo() {
        return job;
    }
}
