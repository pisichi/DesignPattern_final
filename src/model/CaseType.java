package model;

import designpattern_final.Singleton;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author User
 */
public class CaseType {

    Singleton instance = Singleton.getInstance();
    ArrayList<CaseType> relation;
    CaseType parent;
    String name;
    int id;

    public CaseType() {
        relation = new ArrayList<CaseType>();
        name = "";
    }

// <editor-fold desc="getter-setter">
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CaseType getParent() {
        return parent;
    }

    public void setParent(CaseType parent) {
        this.parent = parent;
    }

    public ArrayList<CaseType> getRelation() {
        return relation;
    }

    public void setRelation(ArrayList<CaseType> relation) {
        this.relation = relation;
    }

// </editor-fold>
    public void printChild(int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print(" | ");
        }
        System.out.println(" | id:" + id + " name:" + name);

        for (CaseType child : relation) {
            child.printChild(depth + 1);
        }
    }

    public void addChild(CaseType child) {

        child.setParent(this);
        relation.add(child);
    }

    public void remove() {

        if (parent != null) {
            ArrayList<CaseType> parentRelation = parent.getRelation();
            parentRelation.remove(this);
            parent.setRelation(parentRelation);
            instance.allType.set(parent.id, parent);
        }
    }

    public void edit(int id, String name) {
        this.id = id;
        this.name = name;
        update(0);
    }

    public void update(int depth) {

        System.out.println(name);
        for (CaseType child : relation) {
            child.update(depth + 1);
        }

    }

    public void add() {
        instance.allType.add(this);
    }

    @Override
    public String toString() {

        String str = null;
        if (parent != null) {
            str = "| id = " + id + " name = " + name + " |" + " parent =  " + parent.name + "\n";
        } else {
            str = "| id = " + id + " name = " + name + " |" + "\n";
        }
        return str;
    }

}
