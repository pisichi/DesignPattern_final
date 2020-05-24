package designpattern_final;

import java.util.Arrays;
import controller.CaseTypeController;
import controller.CaseController;
import java.util.Scanner;

public class DesignPattern_final {

    static CaseTypeController _type = new CaseTypeController();
    static CaseController _case = new CaseController();

    public static void main(String[] args) {

        testset();

        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println(" _____           _ _   _     _        __   _____ \n"
                + "/  __ \\         (_) | (_)   | |      /  | |  _  |\n"
                + "| /  \\/_ __ __ _ _| |_ _  __| |______`| | | |_| |\n"
                + "| |   | '__/ _` | | __| |/ _` |______|| | \\____ |\n"
                + "| \\__/\\ | | (_| | | |_| | (_| |      _| |_.___/ /\n"
                + " \\____/_|  \\__,_|_|\\__|_|\\__,_|      \\___/\\____/ \n"
                + "                                                 \n"
                + "by Pisitchai Siriratanachaikul 60050223 \n");
        while (true) {
            printBox(0);
            System.out.print("𝙎𝙚𝙡𝙚𝙘𝙩 𝙖𝙣 𝙤𝙥𝙩𝙞𝙤𝙣 \n"
                    + "1:view data \n"
                    + "2:add data \n"
                    + "3:remove data \n"
                    + "4:update/edit data \n"
                    + "0:exit program \n"
                    + "--->: ");
            option = sc.nextInt();

            switch (option) {
                case 0:
                    return;
                case 1:
                    printBox(1);
                    System.out.print("View option \n"
                            + "1:view case data \n"
                            + "2:view type data \n"
                            + "--->: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            viewCaseData();
                            break;
                        case 2:
                            viewTypeData();
                            break;
                    }
                    break;
                case 2:
                    printBox(1);
                    System.out.print("Add option \n"
                            + "1:case \n"
                            + "2:type \n"
                            + "--->: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            addCaseData();
                            break;
                        case 2:
                            addTypeData();
                            break;
                    }
                    break;
                case 3:
                    printBox(1);
                    System.out.print("Remove option \n"
                            + "1:case \n"
                            + "2:type \n"
                            + "--->: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            removeCaseData();
                            break;
                        case 2:
                            removeTypeData();
                            break;
                    }

                    break;
                case 4:
                    printBox(1);
                    System.out.print("Update option \n"
                            + "1:case \n"
                            + "2:type \n"
                            + "--->: ");
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            editCaseData();
                            break;
                        case 2:
                            editTypeData();
                            break;
                    }
                    break;
                default:
            }
        }

    }

    public static void viewCaseData() {
        Scanner sc = new Scanner(System.in);
        int option;
        int id;

        _case.print();

        System.out.print("view case \n"
                + "1:view by type \n"
                + "2:view infection line \n"
                + "--->: ");
        option = sc.nextInt();
        switch (option) {
            case 1:
                _type.printChild(0);
                System.out.print("enter type Id: ");
                id = sc.nextInt();
                _case.SearchType(id);
                break;
            case 2:
                System.out.print("enter Id: ");
                id = sc.nextInt();
                _case.printParent(id);
                break;
            default:

        }

    }

    public static void viewTypeData() {
        Scanner sc = new Scanner(System.in);
        int option;
        int id;

        _type.printChild(0);
        System.out.print("view type \n"
                + "1:view child \n"
                + "2:view parent \n"
                + "--->: ");
        option = sc.nextInt();
        System.out.print("enter type Id: ");
        id = sc.nextInt();
        switch (option) {
            case 1:
                _type.printChild(id);
                break;
            case 2:
                _type.printParent(id);
                break;
            default:
        }

    }

    public static void addCaseData() {

        Scanner sc = new Scanner(System.in);
        int id;
        int age;
        String gender;
        String date;
        String province;
        int cid;
        int typeId;

        System.out.println("+-- add case --+");
        System.out.print("enter Id: ");
        id = sc.nextInt();
        System.out.print("enter age: ");
        age = sc.nextInt();
        System.out.print("enter gender: ");
        gender = sc.next();
        System.out.print("enter date: ");
        date = sc.next();
        System.out.print("enter province: ");
        province = sc.next();
        System.out.print("enter cause: ");
        cid = sc.nextInt();
        System.out.print("enter typeId: ");
        typeId = sc.nextInt();
        _case.AddCase(id, age, gender, date, province, cid, typeId);
        _case.print();

    }

    public static void addTypeData() {
        int id;
        String name;
        int pid;
        Scanner sc = new Scanner(System.in);
        System.out.print("+-- add type --+");
        System.out.print("enter Id: ");
        id = sc.nextInt();
        System.out.print("enter name: ");
        name = sc.next();
        _type.AddType(id, name);
        System.out.print("set parent: ");
        pid = sc.nextInt();
        _type.AddChild(pid, id);
    }

    public static void removeCaseData() {
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("+-- remove case --+");
        _case.print();
        System.out.print("enter Id: ");
        id = sc.nextInt();
        _case.RemoveCase(id);

    }

    public static void removeTypeData() {
        Scanner sc = new Scanner(System.in);
        int id;
        System.out.println("+-- remove type --+");
        _type.printChild(0);
        System.out.print("enter Id: ");
        id = sc.nextInt();
        _type.RemoveType(id);

    }

    public static void editCaseData() {

    }

    public static void editTypeData() {
        Scanner sc = new Scanner(System.in);
        String name;
        int id;
        System.out.println("+-- edit type --+");
        _type.printChild(0);
        System.out.print("enter Id: ");
        id = sc.nextInt();
        System.out.print("enter new name: ");
        name = sc.next();
        _type.EditType(id, name);

    }

    static void printBox(int n) {

        switch (n) {
            case 0:
                System.out.println("                                                                 \n"
                        + " ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___  ___ \n"
                        + "(___)(___)(___)(___)(___)(___)(___)(___)(___)(___)(___)(___)(___)\n"
                        + "                                                                 ");
                break;
            case 1:
                System.out.println(
                        "_____ _____ _____ _____ _____ _____ _____ _____ _____ _____ _____ _____ _____ \n");
                break;
        }

    }

    public static void testset() {
        _type.AddType(0, "infected");
        _type.AddType(1, "travel");
        _type.AddType(2, "asia");
        _type.AddType(3, "europe");
        _type.AddType(4, "china");
        _type.AddType(5, "sweden");
        _type.AddType(6, "In country");
        _type.AddType(7, "bangkok");
        _type.AddType(8, "university");
        _type.AddType(9, "airport");
        _type.AddType(10, "suvannaphom");
        _type.AddType(11, "kmitl");

        _type.AddChild(0, 1);
        _type.AddChild(0, 6);

        _type.AddChild(1, 2);
        _type.AddChild(1, 3);

        _type.AddChild(2, 4);
        _type.AddChild(3, 5);

        _type.AddChild(6, 7);
        _type.AddChild(7, 8);

        _type.AddChild(7, 9);
        _type.AddChild(9, 10);

        _type.AddChild(8, 11);

        _case.AddCase(1, 20, "M", "10/25/78", "bangkok", 0, 5);
        _case.AddCase(2, 25, "F", "10/25/78", "bangkok", 1, 4);
        _case.AddCase(3, 90, "M", "10/25/78", "payao", 1, 8);
        _case.AddCase(4, 90, "M", "10/25/78", "sumarttra", 3, 7);
        _case.AddCase(5, 90, "M", "10/25/78", "sumarttra", 3, 7);
        _case.AddCase(6, 90, "M", "10/25/78", "sumarttra", 3, 7);
    }

}
