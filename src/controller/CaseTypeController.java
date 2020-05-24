
package controller;

import designpattern_final.Singleton;
import java.util.ArrayList;
import model.CaseType;

public class CaseTypeController {

    Singleton instance = Singleton.getInstance();

    public void AddType(int id, String name) {
        CaseType t = new CaseType();
        t.setId(id);
        t.setName(name);
        t.add();
    }

    public void RemoveType(int id) {
        CaseType t = SearchType(id);
        t.remove();
    }

    public void EditType (int id,String name) {
        CaseType t = SearchType(id);
        t.edit(name);
    }

    public void AddChild(int momId, int childId) {

        CaseType mom = SearchType(momId);
        CaseType child = SearchType(childId);
        mom.addChild(child);
        instance.allType.set(instance.allType.indexOf(mom), mom);
        instance.allType.set(instance.allType.indexOf(child), child);
    }

    public void RemoveChild(int momId, int childId) {

        CaseType mom = SearchType(momId);
        ArrayList<CaseType> relation = mom.getRelation();
        relation.remove(SearchType(childId));
        instance.allType.set(momId, mom);
    }

    public CaseType SearchType(int id) {

        for (int i = 0; i < instance.allType.size(); i++) {
            CaseType t = (CaseType) instance.allType.get(i);
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    public void printChild(int id) {
        CaseType type = SearchType(id);
        type.printChild(0);

    }

    public void printParent(int id) {
        CaseType type = SearchType(id);
        System.out.print(" Case id:" + type.getId());
        while (type.getParent().getId() != 0) {
            type = SearchType(type.getParent().getId());
            System.out.print(" <- " + " id:" + type.getId());
        }
        System.out.println("");

    }

}
