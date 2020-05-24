package model;

import designpattern_final.Singleton;
import java.util.ArrayList;


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

    public void edit(String name) {
        this.name = name;
        updateEdit(0);
    }

    public void remove() {

        //remove childs from parent
        if (parent != null) {
            ArrayList<CaseType> parentRelation = parent.getRelation();
            parentRelation.remove(this);
            parent.setRelation(parentRelation);
            instance.allType.set(instance.allType.indexOf(parent), parent);
        }
        updateRemove(0);

    }

    // change type in case when casetype got Remove
    public void updateRemove(int depth) {

        System.out.println("    Remove:" + name );
        for (int i = 0; i < instance.allCase.size(); i++) {
            CaseData t = (CaseData) instance.allCase.get(i);
            if (t.getType().id == this.id) {
                t.setType((CaseType) instance.allType.get(0));
                instance.allCase.set(instance.allCase.indexOf(t), t);
                 System.out.println("       - Update case:" + t.getId());
            }
        }
        for (CaseType child : relation) {
            child.updateRemove(depth + 1);
        }

    }
     // change type in case when casetype got update
        public void updateEdit(int depth) {

        for (int i = 0; i < instance.allCase.size(); i++) {
            CaseData t = (CaseData) instance.allCase.get(i);
            if (t.getType().id == this.id) {
                t.setType(this);
                instance.allCase.set(instance.allCase.indexOf(t), t);
                System.out.println("    Update case:" + t.getId());
            }
        }
        for (CaseType child : relation) {
            child.updateEdit(depth + 1);
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
