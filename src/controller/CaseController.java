package controller;

import designpattern_final.Singleton;
import model.CaseData;
import model.CaseType;

public class CaseController {

    Singleton instance = Singleton.getInstance();
    CaseTypeController _type = new CaseTypeController();

    public void AddCase(int id, int age, String gender, String date, String province, int cid, int typeId) {
        CaseData t = new CaseData();
        CaseType type = _type.SearchType(typeId);
        t.setId(id);
        t.setAge(age);
        t.setGender(gender);
        t.setDate(date);
        t.setProvince(province);
        t.setCid(cid);
        t.setType(type);
        t.add();
    }

    public void EditCase(int id, int age, String gender, String date, String province, int cid, int typeId) {
        CaseData t = SearchCase(id);
        CaseType type = _type.SearchType(typeId);
        t.setId(id);
        t.setAge(age);
        t.setGender(gender);
        t.setDate(date);
        t.setProvince(province);
        t.setCid(cid);
        t.setType(type);
        instance.allCase.set(instance.allCase.indexOf(t), t);
    }

    public void RemoveCase(int id) {
        CaseData t = SearchCase(id);
        for (int i = 0; i < instance.allCase.size(); i++) {
            CaseData n = (CaseData) instance.allCase.get(i);
            if (n.getCid() == t.getId()) {
                n.setCid(0);
                instance.allCase.set(instance.allCase.indexOf(n), n);
            }
        }
        t.remove();
    }

    public CaseData SearchType(int typeId) {

        for (int i = 0; i < instance.allCase.size(); i++) {
            CaseData t = (CaseData) instance.allCase.get(i);
            if (t.getType().getId() == typeId) {
                System.out.println(t.toString());
            }
        }
        return null;
    }

    public CaseData SearchCase(int caseId) {

        for (int i = 0; i < instance.allCase.size(); i++) {
            CaseData t = (CaseData) instance.allCase.get(i);
            if (t.getId() == caseId) {
                return t;
            }
        }
        return null;
    }

    public void edit(int caseId, int typeId) {
        CaseData t = SearchCase(caseId);
        CaseType type = _type.SearchType(typeId);
        t.remove();
        t.setType(type);
        t.add();

    }

    //print all case
    public void print() {

        for (int i = 0; i < instance.allCase.size(); i++) {
            CaseData t = (CaseData) instance.allCase.get(i);
            System.out.println(t.toString());
        }

    }

    public void printParent(int caseId) {
        CaseData t = SearchCase(caseId);
        System.out.print(" Case id:" + t.getId());
        while (t.getCid() != 0) {
            t = SearchCase(t.getCid());
            System.out.print(" <- " + " id:" + t.getId());
        }
        System.out.println("");
    }

}
