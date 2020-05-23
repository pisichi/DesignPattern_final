/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public void AddChild(int momId, int childId) {
        
        CaseType mom = SearchType(momId);
        CaseType child = SearchType(childId);
        mom.addChild(child);
        instance.allType.set(momId, mom);
        instance.allType.set(childId, child);
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
    
    
    public void print(int id){
        CaseType type = SearchType(id);
        type.print(0);
    }

}
