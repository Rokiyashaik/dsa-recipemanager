/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reciepemanager;

import java.util.Scanner;

public class Recipe {
    String Title;
    String Ingredients;
    String Procedure = "";

    void addTitle(Scanner input) {
        System.out.print("Title: ");
        Title = input.nextLine();
    }

    void addIngredients(Scanner input) {
        System.out.print("Ingredients: ");
        Ingredients = input.nextLine();
    }

    void addProcedure(Scanner input) {
        boolean end = true;
        int counter = 1;
        while (counter < 3) {
            String steps = "Step " + counter + ": ";
            System.out.print(steps);
            Procedure = Procedure + steps + input.nextLine() + "\n";
            ++counter;
        }
    }

    public String getTitle() {
        return Title;
    }

    public String getIngredients() {
        return Ingredients;
    }

    public String getProcedure() {
        return Procedure;
    }

    public String recipeToString() {
        return "Title: " + Title + "\n" + "Ingredients: " + Ingredients + "\n" + "Procedure\n" + Procedure;
    }
}
