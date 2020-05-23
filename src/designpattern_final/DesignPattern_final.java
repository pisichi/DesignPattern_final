package designpattern_final;

import java.util.Arrays;
import controller.CaseTypeController;
import controller.CaseController;

public class DesignPattern_final {

    static CaseTypeController type = new CaseTypeController();
    static CaseController _case = new CaseController();

    public static void main(String[] args) {

        testset();

        type.print(0);

        System.out.println(Arrays.toString(Singleton.getInstance().allCase.toArray()));


        _case.printParent(1);
        _case.printParent(2);
        _case.printParent(3);
        _case.printParent(4);
        _case.printParent(5);
        _case.printParent(6);

    }

    
    
    
    
    public static void testset() {
        type.AddType(0, "all type");
        type.AddType(1, "travel");
        type.AddType(2, "asia");
        type.AddType(3, "europe");
        type.AddType(4, "china");
        type.AddType(5, "sweden");
        type.AddType(6, "In country");
        type.AddType(7, "bangkok");
        type.AddType(8, "kmitl");

        type.AddChild(0, 1);
        type.AddChild(0, 6);

        type.AddChild(1, 2);
        type.AddChild(1, 3);

        type.AddChild(2, 4);
        type.AddChild(3, 5);

        type.AddChild(6, 7);
        type.AddChild(7, 8);

        _case.AddCase(1, 20, "M", "10/25/78", "bangkok", 0, 5);
        _case.AddCase(2, 25, "F", "10/25/78", "bangkok", 1, 4);
        _case.AddCase(3, 90, "M", "10/25/78", "payao", 1, 8);
        _case.AddCase(4, 90, "M", "10/25/78", "sumarttra", 3, 7);
        _case.AddCase(5, 90, "M", "10/25/78", "sumarttra", 3, 7);
        _case.AddCase(6, 90, "M", "10/25/78", "sumarttra", 3, 7);
    }

}
