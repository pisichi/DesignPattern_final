package designpattern_final;

import java.util.ArrayList;
import model.CaseData;
import model.CaseType;

public class Singleton {

   private static Singleton instance = null;
   


   public ArrayList allCase;
   
   public ArrayList allType;
   

   private Singleton() {
      allType = new ArrayList<CaseType>();
      allCase = new ArrayList<CaseData>();
   }

   public static Singleton getInstance() {
      if(instance == null) {
         instance = new Singleton();
      }
      
      return instance;
   }
}