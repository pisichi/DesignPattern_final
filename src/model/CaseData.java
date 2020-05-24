
package model;

import designpattern_final.Singleton;


public class CaseData {

    Singleton instance = Singleton.getInstance();

    private int id;

    private int age;

    private String gender;

    private String date;

    private String province;

    private int cid;

    private CaseType type;

// <editor-fold desc="getter-setter">
    public String getProvince() {
        return province;
    }

    public void setProvince(String Province) {
        this.province = Province;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public CaseType getType() {
        return type;
    }

    public void setType(CaseType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    // </editor-fold>
    
    
    public void add(){
    instance.allCase.add(this);
    }
    
    public void remove(){
    instance.allCase.remove(this);
    }

    @Override
    public String toString() {
        return "| id:" + id + " age:" + age + 
               " gender:" + gender + " date:" + date + 
               " province:" + province + " cause:"+ cid + " type:" +type.name + " |" + "\n";
    }

}
