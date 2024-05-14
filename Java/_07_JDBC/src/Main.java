import controller.CoderController;
import database.ConfigDB;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CoderController objCoderController = new CoderController();

        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    MENU
                    1. List Coders
                    2. Insert Coder
                    3. Update Coder
                    4. Delete Coder
                    5. Get By name
                    6. Exit
                    Choose an option:
                    """);
            switch (option){
                case "1": //List all coders
                    objCoderController.getAll();
                    break;
                case "2":
                    objCoderController.insert();
                    break;
                case "3":
                    objCoderController.update();
                    break;
                case "4":
                    objCoderController.delete();
                    break;
                case "5":
                    objCoderController.getByN();
                    break;
            }
        }while (!option.equals("6"));
    }
}